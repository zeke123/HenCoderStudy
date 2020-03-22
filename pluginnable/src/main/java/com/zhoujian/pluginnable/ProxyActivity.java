package com.zhoujian.pluginnable;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.zhoujian.pluginbase.IRemoteActivity;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public class ProxyActivity extends Activity {

    private String className;
    private IRemoteActivity remoteActivity;
    private AssetManager mAssetManager;
    private Resources mResources;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            className = getIntent().getStringExtra("className");

            File apkFile = new File(getCacheDir() + "/pluginnable-plugin-debug.apk");
            try (Source source = Okio.source(getAssets().open("apk/pluginnable-plugin-debug.apk"));
                 BufferedSink sink = Okio.buffer(Okio.sink(apkFile))) {
                sink.writeAll(source);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String dexApkPath = apkFile.getPath();

            loadResources(dexApkPath);

            DexClassLoader dexClassLoader = new DexClassLoader(dexApkPath, getCacheDir().getPath(), null, getClassLoader());
            Class activityClass = dexClassLoader.loadClass(className);
            Constructor<?> localConstructor = activityClass.getConstructor(new Class[]{});
            Object instance = localConstructor.newInstance(new Object[]{});
            remoteActivity = (IRemoteActivity) instance;
            remoteActivity.attach(this);
            Bundle bundle = new Bundle();
            remoteActivity.onCreate(bundle);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (null != remoteActivity) {
            remoteActivity.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (null != remoteActivity) {
            remoteActivity.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != remoteActivity) {
            remoteActivity.onDestroy();
        }
    }


    protected void loadResources(String dexApkPath) {
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, dexApkPath);
            mAssetManager = assetManager;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Resources superRes = super.getResources();
        mResources = new Resources(mAssetManager, superRes.getDisplayMetrics(), superRes.getConfiguration());
    }


    @Override
    public AssetManager getAssets() {
        return mAssetManager == null ? super.getAssets() : mAssetManager;
    }

    @Override
    public Resources getResources() {
        return mResources == null ? super.getResources() : mResources;
    }
}
