package com.zhoujian.pluginnable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.load_plugin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadPlugin();
            }
        });

    }


    private void loadPlugin() {
        Intent intent = new Intent(this, ProxyActivity.class);
        intent.putExtra("className", "com.zhoujian.pluginnable_plugin.MainActivity");
        startActivity(intent);

    }
}