package com.example.viewgroup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ForthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("asd");
        actionBar.setDisplayHomeAsUpEnabled(true);












    }
}