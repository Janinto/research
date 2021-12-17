package com.example.downloadwithretro;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final int REQUEST_GALLERY = 200;
    private long downloadId;

    TextView file_name;
    String file_path=null;
    Button upload;
    ProgressBar progressBar;



    private static final String TAG = "MainActivity";
    private RetrofitInterface retrofitInterface;
    String url = "http://ai-rebornsoft.asuscomm.com:22011/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Retrofit  retrofit = new Retrofit.Builder()
        .baseUrl(url+"m/download/video/")
        //.baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);



        Post post = new Post("some_value", "some_value_20211130171900.mp4");

        Call<Post> call = retrofitInterface.getPosts(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){

                    Post result = response.body();
                    Boolean status = result.getStatus();
                    String dir = result.getDir();

                    registerReceiver(onDownloadComplete,new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                    Button download=findViewById(R.id.download);
                    download.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            beginDownload(url + dir);
                            //beginDownload("http://ai-rebornsoft.asuscomm.com:22011/m/download/video/");
                        }
                    });


                    Button upload_file=findViewById(R.id.upload_file);
                    upload_file.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //check permission greater than equal to marshmeellow we used run time permission
                            if(Build.VERSION.SDK_INT>=23){
                                if(checkPermission()){
                                    filePicker();
                                }
                                else{
                                    requestPermission();
                                }
                            }
                            else{
                                filePicker();
                            }
                        }
                    });

                    progressBar=findViewById(R.id.progress);
                    upload=findViewById(R.id.upload);
                    file_name=findViewById(R.id.filename);

                    upload.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(file_path!=null){
                                UploadFile();
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Please Select File First", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    Log.d(TAG,"onResponse: 성공, 결과\n"+ result.toString());
                    if (status == true && !dir.equals("")) {

                    }
                } else {
                    Log.d(TAG,"onResponse: 실패");
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                // 통신 실패
                Log.d(TAG,"onFailure: 연결시간이 초과되었습니다." + t.getMessage());
            }
        });






    }

    private void UploadFile() {
        UploadTask uploadTask=new UploadTask();
        uploadTask.execute(new String[]{file_path});
    }

    private void beginDownload(String file_link){
        // 파일 저장 경로
        File file=new File(getExternalFilesDir(null),"reborn.mp4");
     

        //checking if android version is equal and greater than noughat

        //now if download complete file not visible now lets show it
        DownloadManager.Request request=null;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            request=new DownloadManager.Request(Uri.parse(file_link))
                    // 노티피케이션에 보이는 타이틀
                    .setTitle("reborn.mp4")
                    // 노티피케이션에 보이는 디스크립션
                    .setDescription("Downloading")

                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)

                    // 파일이 저장될 위치의 URI
                    .setDestinationUri(Uri.fromFile(file))

                    // True로 설정되면, 단말이 충전중일 때만 다운로드합니다.
                    .setRequiresCharging(false)
                    // True로 설정되면, 모바일 네트워크가 연결되었을 때도 다운로드 합니다.
                    .setAllowedOverMetered(true)
                    // True로 설정되면, 로밍네트워크가 연결되었을 떄도 다운로드 합니다.
                    .setAllowedOverRoaming(true);
        }
        else{
            request=new DownloadManager.Request(Uri.parse(file_link))

                    .setTitle("reborn.mp4")
                    .setDescription("Downloading")
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    .setDestinationUri(Uri.fromFile(file))
                    .setAllowedOverRoaming(true);
        }

        // enqueue는 downloadid를 리턴하고 이 id는 다운로드 상태를 알거나 결과를 확인하기 위해 필요.
        DownloadManager downloadManager=(DownloadManager)getSystemService(DOWNLOAD_SERVICE);
        downloadId=downloadManager.enqueue(request);


    }

    private void filePicker(){

        //.Now Permission Working
        Toast.makeText(MainActivity.this, "File Picker Call", Toast.LENGTH_SHORT).show();
        //Let's Pick File
        Intent opengallery=new Intent(Intent.ACTION_PICK);
        opengallery.setType("*/*");
        startActivityForResult(opengallery,REQUEST_GALLERY);
    }

    //now checking if download complete

    // 다운로드가 되자마자 사용자가 직접 다운로드한 파일을 볼 수 있음
    private BroadcastReceiver onDownloadComplete=new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            long id=intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1);
            if(downloadId==id){
                Toast.makeText(MainActivity.this, "Download Completed", Toast.LENGTH_SHORT).show();

            }

        }

    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(onDownloadComplete);
    }

    private void requestPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            Toast.makeText(MainActivity.this, "Please Give Permission to Upload File", Toast.LENGTH_SHORT).show();
        }
        else{
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},PERMISSION_REQUEST_CODE);
        }
    }

    private boolean checkPermission(){
        int result= ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(result== PackageManager.PERMISSION_GRANTED){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_REQUEST_CODE:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this, "Permission Successfull", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Permission Failed", Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_GALLERY && resultCode== Activity.RESULT_OK){
            String filePath=getRealPathFromUri(data.getData(),MainActivity.this);
            Log.d("File Path : "," "+filePath);
            //now we will upload the file
            //lets import okhttp first
            this.file_path=filePath;

            File file=new File(filePath);
            file_name.setText(file.getName());

        }
    }

    public String getRealPathFromUri(Uri uri,Activity activity){
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor=activity.getContentResolver().query(uri,proj,null,null,null);
        if(cursor==null){
            return uri.getPath();
        }
        else{
            cursor.moveToFirst();
            int id=cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(id);
        }
    }

    // 업로드 비동기처리.
    public class UploadTask extends AsyncTask<String,String,String> {

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);
            if(s.equalsIgnoreCase("true")){
                Toast.makeText(MainActivity.this, "File uploaded", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this, "Failed Upload", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            if(uploadFile(strings[0])){
                return "true";
            }
            else{
                return "failed";
            }
        }

        private boolean uploadFile(String path){
            File file=new File(path);
            try{
                RequestBody requestBody=new MultipartBody.Builder().setType(MultipartBody.FORM)
                        .addFormDataPart("file",file.getName(),RequestBody.create(MediaType.parse("image/*"),file))
                        .addFormDataPart("userName","some_value")
                        //.addFormDataPart("submit","submit")

                        .build();

                Request request=new Request.Builder()
                        .url("http://ai-rebornsoft.asuscomm.com:22011/m/upload/video")
                        .post(requestBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new okhttp3.Callback() {
                    @Override
                    public void onFailure(okhttp3.Call call, IOException e) {

                        e.getMessage();
                    }

                    @Override
                    public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {


                    }
                });
                return true;
            }
            catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
    }





}