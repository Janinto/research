package com.example.viewpropertyanimator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


// 트윈 애니메이션 : 커졌다 작아졌다하는 애니메이션
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //버튼 참조
        Button scaleButton = findViewById(R.id.scaleButton);
        //버튼 리스너
        scaleButton.setOnClickListener(new View.OnClickListener(){


            // 버튼이 눌렸을 때
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.scale);
                view.startAnimation(anim);
            }
        });
    }
}