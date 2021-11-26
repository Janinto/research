package com.company.soundcrowd.lottieanimationbutton;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {


    // 로띠 애니메이션뷰 선언
    LottieAnimationView songLikeAnimButton;



    // 좋아요 클릭 여부 확인용 텍스트뷰 선언
    TextView isSongLikeAnimButtonClickedTextView;

    // 좋아요 클릭 여부
    boolean isSongLikedClicked = false;



    // 액티비티가 생성될 때
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 로띠 애니메이션뷰 리소스 아이디연결
        songLikeAnimButton = (LottieAnimationView)findViewById(R.id.button_song_like_animation);

        // 텍스트뷰 리소스 아이디 연결
        isSongLikeAnimButtonClickedTextView = (TextView)findViewById(R.id.text_is_song_like_clicked);


        // 애니메이션에 클릭 리스너를 붙인다.
        songLikeAnimButton.setOnClickListener(new View.OnClickListener() {
            // 버튼이 클릭되었을 때
            @Override
            public void onClick(View v) {

                // 애니메이션을 발동시킨다.
                if(toggleSongLikeAnimButton()){
                    // 좋아요 상태이면
                    isSongLikeAnimButtonClickedTextView.setText("좋아요가 클릭되었다!");
                }
                else {
                    // 좋아요 상태가 아니면
                    isSongLikeAnimButtonClickedTextView.setText("좋아요 상태가 아니다...");
                }
            }
        });





    } // onCreate 메소드


    // 좋아요 로띠 애니메이션을 실행 시키는 메소드
    private boolean toggleSongLikeAnimButton(){
        if(!isSongLikedClicked){
            // 애니메이션을 한번 실행시킨다.
            // Custom animation speed or duration.
            // ofFloat(시작 시간, 종료 시간).setDuration(지속시간)
            ValueAnimator animator = ValueAnimator.ofFloat(0f, 0.5f).setDuration(1000);

            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    songLikeAnimButton.setProgress((Float) animation.getAnimatedValue());
                }
            });
            animator.start();

            isSongLikedClicked = true;

        }
        else {
            // 애니메이션을 한번 실행시킨다.
            // Custom animation speed or duration.
            // ofFloat(시작 시간, 종료 시간).setDuration(지속시간)
            ValueAnimator animator = ValueAnimator.ofFloat(0.5f, 1f).setDuration(1000);

            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    songLikeAnimButton.setProgress((Float) animation.getAnimatedValue());
                }
            });
            animator.start();

            isSongLikedClicked = false;

        }

        return isSongLikedClicked;

    }








} // MainActivity 클래스
