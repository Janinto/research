package com.example.viewpropertyanimator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// 트윈 애니메이션 : 커졌다 작아졌다하는 애니메이션
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
// rotate 돌아가는 애니메이션
        Button las = findViewById(R.id.las);

        las.setOnClickListener(new View.OnClickListener(){


            @Override
            public  void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.rotate);
                view.startAnimation(anim);
            }

        });
// 점점 사라지는 애니메이션
        Button laa = findViewById(R.id.laa);

        laa.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.alpha);
                view.startAnimation(anim);
            }
        });



    }
}