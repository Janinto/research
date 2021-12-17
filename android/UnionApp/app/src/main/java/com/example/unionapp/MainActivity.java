package com.example.unionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    private String TAG = "메인";

    Fragment fragment1, fragment2, fragment3, fragment4, fragment5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragment1 = new HomeFragment();
        fragment2 = new MeasureFragment();
        fragment3 = new BlankFragment();
        fragment4 = new BlankFragment2();
        fragment5 = new SettingFragment();

        FloatingActionButton floatingActionButton=(FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.coordinator, fragment1).commitAllowingStateLoss();
            }
        });



        //바텀 네비게이션
        bottomNavigationView = findViewById(R.id.bottom_nav_view);

        getSupportFragmentManager().beginTransaction().replace(R.id.coordinator, fragment1).commitAllowingStateLoss();

        bottomNavigationView = findViewById(R.id.bottom_nav_view);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.i(TAG, "바텀 네비게이션 클릭");

                switch (item.getItemId()){
                    case R.id.action_measure:
                        Log.i(TAG, "measure 들어옴");
                        getSupportFragmentManager().beginTransaction() .replace(R.id.coordinator, fragment2).commitAllowingStateLoss();
                        return true;
                    case R.id.action_record:
                        Log.i(TAG, "record 들어옴");
                        getSupportFragmentManager().beginTransaction() .replace(R.id.coordinator, fragment3).commitAllowingStateLoss();
                        return true;
                    case R.id.action_manage:
                        Log.i(TAG, "manage 들어옴");
                        getSupportFragmentManager().beginTransaction() .replace(R.id.coordinator, fragment4).commitAllowingStateLoss();
                        return true;
                    case R.id.action_setting:
                        Log.i(TAG, "setting 들어옴");
                        getSupportFragmentManager().beginTransaction() .replace(R.id.coordinator,fragment5).commitAllowingStateLoss();
                        return true;
                }
                return true;
            }
        });






    }
}