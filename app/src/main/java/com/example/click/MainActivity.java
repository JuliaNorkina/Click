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
        handlerThread.postTask(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tvClick.post(new Runnable() {
                    @Override
                    public void run() {
                        tvClick.append("Click_");
                    }
                });
            }
        });
    }


    private class MyHandlerThread extends HandlerThread {

        Handler handler;

        MyHandlerThread(String name) {
            super(name);
        }

        void postTask(Runnable task) {
            handler.post(task);
        }

        void prepareHandler() {
            handler = new Handler(getLooper());
        }
    }
}
