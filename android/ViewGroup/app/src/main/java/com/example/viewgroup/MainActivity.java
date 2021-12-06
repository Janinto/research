package com.example.viewgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View view) {

        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    public void clickBtn1(View view) {

        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }

    public void clickBtn2(View view) {

        Intent intent = new Intent(this,ForthActivity.class);
        startActivity(intent);
    }


}