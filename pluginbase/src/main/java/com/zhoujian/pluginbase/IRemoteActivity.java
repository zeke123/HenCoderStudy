package com.zhoujian.pluginbase;

import android.app.Activity;
import android.os.Bundle;

public interface IRemoteActivity {

    void attach(Activity activity);

    void setContentView(int layoutResID);

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onDestroy();
}
