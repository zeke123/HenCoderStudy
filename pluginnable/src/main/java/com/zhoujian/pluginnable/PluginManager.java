package com.zhoujian.pluginnable;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class PluginManager {

    private static PluginManager instance = new PluginManager();

    public static PluginManager getInstance() {
        return instance;
    }

    private Context context;
    private String activityPath;
    private Resources resources;
    private DexClassLoader dexClassLoader;

    public void setContext(Context context) {
        this.context = context.getApplicationContext();
    }

    public void loadPath(String path) {
        setActivityPath(path);
        setClassLoader(path);
        setResources(path);
    }

    private void setActivityPath(String path) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageArchiveInfo(path, PackageManager.GET_ACTIVITIES);
        activityPath = packageInfo.activities[0].name;
    }

    public String getActivityPath() {
        return activityPath;
    }

    private void setClassLoader(String path) {
        dexClassLoader = new DexClassLoader(path, context.getCacheDir().getPath(), null, context.getClassLoader());

    }

    public DexClassLoader getDexClassLoader() {
        return dexClassLoader;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(String path) {
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPath = AssetManager.class.getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, path);
            resources = new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
        } catch (Exception e) {
        }
    }
}
