package com.example.perside.login.vod;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.perside.login.R;


/**
 * Created by perside on 11/16/17.
 */

public class CartoonFr extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoonfr);

        Intent intent = getIntent();
        String index = intent.getStringExtra("Listvod3");

        TextView textView = (TextView) findViewById(R.id.cartoonfr);
        textView.setText(index);
    }
}
