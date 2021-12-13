package com.example.fragmentstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ColorListFragment.OnColorSelectedListener {

    private ColorFragment mColorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 캐스팅해줘야함
        mColorFragment = (ColorFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_color);

        // 처음화면을 빨간색으로 설정.
        //mColorFragment.setColor(Color.RED);
    }


    // 콜백 발생.
    @Override
    public void onColorSelected(int color) {
        mColorFragment.setColor(color);

    }
}