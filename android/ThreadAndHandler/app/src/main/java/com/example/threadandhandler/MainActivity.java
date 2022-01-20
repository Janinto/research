package com.example.threadandhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_stop, btn_next;
    Thread thread;
    boolean isThread = false;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 스레드 시작
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isThread = true;
                thread = new Thread(){
                  public void run() {
                      while (isThread) {
                          try {
                              sleep(3000);
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }

                          //핸들러에 0이라는 메시지를 보냄
                          handler.sendEmptyMessage(0);


                      }
                  }
                };
                thread.start();
            }
        });


        // 스레드 종료
        btn_stop = (Button)findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isThread = false;

            }
        });



        btn_next = (Button)findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               startActivity(new Intent(this, MainActivity2.class));
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    private Handler handler = new Handler(){

      @Override
        public void handleMessage(Message msg){
          Toast.makeText(getApplicationContext(),"리본소프트", Toast.LENGTH_SHORT).show();
      }

    };



}