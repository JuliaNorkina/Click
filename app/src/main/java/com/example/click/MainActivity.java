package com.example.click;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvClick = findViewById(R.id.tvClick);
        findViewById(R.id.bClick).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
