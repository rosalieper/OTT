package com.example.perside.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by perside on 11/6/17.
 */

public class Documentations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentations);

        Intent intent = getIntent();
        String index = intent.getStringExtra("ListIndex3");

        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(index);
    }
}
