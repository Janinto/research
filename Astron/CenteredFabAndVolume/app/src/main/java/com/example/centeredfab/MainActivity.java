package com.example.centeredfab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //TextView textView, textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AudioManager audioManage3 = (AudioManager) getSystemService(AUDIO_SERVICE);

        Button btnAdd = (Button) findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                audioManage3.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);

            }
        });

        Button btnMinus = (Button) findViewById(R.id.btn_minus);
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                audioManage3.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI); ;

            }
        });





        //textView = findViewById(R.id.textView);

        SeekBar seekBar = findViewById(R.id.seekBar);

        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int nMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int nCurrentVolume = audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);

        seekBar.setMax(nMax);
        seekBar.setProgress(nCurrentVolume);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                        progress, AudioManager.FLAG_SHOW_UI);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                //textView.setText(String.format("미디어 선택 값은 %d 입니다.", seekBar.getProgress()));
            }
        });

        //textView1 = findViewById(R.id.textView1);

        SeekBar seekBar1 = findViewById(R.id.seekBar1);

        AudioManager audioManager1 = (AudioManager) getSystemService(AUDIO_SERVICE);
        int nMax1 = audioManager1.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION);
        int nCurrentVolume1 = audioManager1
                .getStreamVolume(AudioManager.STREAM_NOTIFICATION);

        seekBar1.setMax(nMax1);
        seekBar1.setProgress(nCurrentVolume1);


        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar1, int progress1, boolean fromUser1) {

                audioManager1.setStreamVolume(AudioManager.STREAM_NOTIFICATION,
                        progress1, AudioManager.FLAG_SHOW_UI);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar1) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar1) {

                //textView1.setText(String.format("알림 선택 값은 %d 입니다.", seekBar1.getProgress()));
            }
        });









    }
    // 액티비티에 원하는 볼륨 종류를 정해서 키로 조절가능한 기능
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        AudioManager mAudioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_VOLUME_UP :
//                mAudioManager.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
//                return true;
//            case KeyEvent.KEYCODE_VOLUME_DOWN:
//                mAudioManager.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
//                return true;
//            case KeyEvent.KEYCODE_BACK:
//                return true;
//        }
//        return false;
//    }




//    public boolean onKeyUp(int keyCode, KeyEvent event) {
//        AudioManager mAudioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_VOLUME_UP :
//                mAudioManager.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_SAME, AudioManager.FLAG_SHOW_UI);
//                return true;
//            case KeyEvent.KEYCODE_VOLUME_DOWN:
//                mAudioManager.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_SAME, AudioManager.FLAG_SHOW_UI);
//                return true;
//            case KeyEvent.KEYCODE_BACK:
//                this.finish();
//                return true;
//        }
//        return false;
//    }


}