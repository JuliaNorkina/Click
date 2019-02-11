package com.example.click;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvClick;
    private MyHandlerThread handlerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvClick = findViewById(R.id.tvClick);
        findViewById(R.id.bClick).setOnClickListener(this);

        handlerThread = new MyHandlerThread("thread");
        handlerThread.start();
        handlerThread.prepareHandler();
    }

    @Override
    public void onClick(View v) {

    }


    private class MyHandlerThread extends HandlerThread {

        Handler handler;

        public MyHandlerThread(String name) {
            super(name);
        }

        public void postTask(Runnable task){
            handler.post(task);
        }

        public void prepareHandler() {
            handler = new Handler(getLooper());
        }
    }
}
