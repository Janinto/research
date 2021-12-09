package com.example.downloadwithretro;

import com.google.gson.annotations.SerializedName;

public class Post {

    String userName;
    String fileName;
    String dir;
    boolean status;

    public Post(String userName, String fileName) {
        this.userName = userName;
        this.fileName = fileName;

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getDir() { return dir; }

    public void setDir(String dir) { this.dir = dir; }

    public boolean getStatus() { return status; }

    public void setStatus(boolean status) { this.status = status; }
}
