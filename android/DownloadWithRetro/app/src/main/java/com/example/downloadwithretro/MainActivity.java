package com.example.downloadwithretro;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RetrofitInterface retrofitInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final FileDownloadService downloadService = ServiceGenerator.createService(FileDownloadService.class);



        Retrofit  retrofit = new Retrofit.Builder()
        .baseUrl("http://ai-rebornsoft.asuscomm.com:22011/")
        //.baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        Post post = new Post("userName", "fileName");

        Call<Post> call = retrofitInterface.getPosts(post);


        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){

                    Post result = response.body();
                    Log.d(TAG,"onResponse: 성공, 결과\n"+ result.toString());
                } else {
                    Log.d(TAG,"onResponse: 실패");
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                // 통신 실패
                Log.d(TAG,"onFailureL: " + t.getMessage());
            }
        });



        
    }
}