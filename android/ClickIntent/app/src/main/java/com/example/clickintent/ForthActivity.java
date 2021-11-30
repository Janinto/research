package com.example.clickintent;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ForthActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 화면에 보여질 내용물 뷰를 설정
        setContentView(R.layout.activity_forth);
        // 제목줄 (ActionBar) 객체를 얻어옴
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("스낵 바");
        actionBar.setDisplayHomeAsUpEnabled(true);



    }
}
