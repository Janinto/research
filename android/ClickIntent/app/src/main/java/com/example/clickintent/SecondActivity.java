package com.example.clickintent;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
        // 생성자가 끝나면 자동으로 onCreate실행함
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //화면에 보여질내용물 뷰를 설정함
        setContentView(R.layout.activity_second);

        //제목줄(ActionBar) 객체를 얻어오기
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("로티 애니메이션");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
