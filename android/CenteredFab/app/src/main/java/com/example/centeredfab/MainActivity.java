package com.example.centeredfab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        SeekBar seekBar = findViewById(R.id.seekBar);

        final  AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int nMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int nCurrentVolume = audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);

        seekBar.setMax(nMax);
        seekBar.setProgress(nCurrentVolume);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                        progress, 0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                textView.setText(String.format("선택 값은 %d 입니다.", seekBar.getProgress()));
            }
        });



    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        AudioManager mAudioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP :
                mAudioManager.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                mAudioManager.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
                return true;
            case KeyEvent.KEYCODE_BACK:
                return true;
        }
        return false;
    }




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