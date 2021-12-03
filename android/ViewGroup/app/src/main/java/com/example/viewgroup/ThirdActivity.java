package com.example.viewgroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ThirdActivity extends AppCompatActivity {
    public static final String STATE_SCORE = "playerScore";
    public static final String STATE_LEVEL = "playerLevel";
    private TextView mLevelText;
    private TextView mScoreText;

    private int mLevel = 0;
    private int mScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("LifeCycle");
        actionBar.setDisplayHomeAsUpEnabled(true);


        mLevelText = findViewById(R.id.level_text);
        mScoreText = findViewById(R.id.score_text);

        // 복원하는 코드
//        if (savedInstanceState == null) {
//
//        } else {
//           mLevel = savedInstanceState.getInt(STATE_LEVEL);
//           mScore = savedInstanceState.getInt(STATE_SCORE);
//           mLevelText.setText("레벨 : " + mLevel);
//           mScoreText.setText("점수 : " + mScore);
//        }
    }

    public void onLevelUp(View view) {
        mLevel ++;
        mLevelText.setText("레벨 : " + mLevel);
    }

    public void onScoreUp(View view) {
        mScore ++;
        mScoreText.setText("점수 : " + mScore);
    }

    // 화면이 회전하기 전에 상태를 저장하는 콜백
    // 저장하는 코드
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE, mScore);
        outState.putInt(STATE_LEVEL, mLevel);

        super.onSaveInstanceState(outState);
    }

    // 복원할 코드가 있을 떄만 아래 코드가 실행됨 그래서 savedInstanceState값에 null체크를 안해도됨
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mLevel = savedInstanceState.getInt(STATE_LEVEL);
        mScore = savedInstanceState.getInt(STATE_SCORE);
        mLevelText.setText("레벨 : " + mLevel);
        mScoreText.setText("점수 : " + mScore);
    }
}