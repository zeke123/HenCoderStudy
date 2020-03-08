package com.zhoujian.pluginnable_plugin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import dalvik.system.PathClassLoader;

public class MainActivity extends BaseActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        PathClassLoader
        setContentView(R.layout.activity_main_plugin);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null == activity) {
                    Toast.makeText(MainActivity.this, "按钮点击了", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(activity, "按钮点击了", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
