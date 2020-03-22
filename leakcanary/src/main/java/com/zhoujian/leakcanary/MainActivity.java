package com.zhoujian.leakcanary;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btStatic;
    private Button btStack;
    private Button btThread;
    private Button btApplication;
    private Button btDump;

    public static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.requestPermission(this);
        initViews();
        clickEvent();
        mContext = this;
    }

    private void initViews() {
        btStatic = (Button) findViewById(R.id.bt_static);
        btStack = (Button) findViewById(R.id.bt_stack);
        btThread = (Button) findViewById(R.id.bt_thread);
        btApplication = (Button) findViewById(R.id.bt_application);
        btDump = (Button) findViewById(R.id.bt_dump);
    }

    private void clickEvent() {
        btStatic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.leakViews.add(v);
            }
        });
        btStack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MethodStack.startWithTarget(v);
            }
        });
        btThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((MyApplication)getApplication()).lackedViews.add(v);

            }
        });
        btDump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
