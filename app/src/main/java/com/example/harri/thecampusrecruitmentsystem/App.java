package com.example.harri.thecampusrecruitmentsystem;

import android.app.Application;

import com.bumptech.glide.request.target.ViewTarget;

/**
 * Created by harri on 7/17/2017.
 */

 public class App extends Application {

    @Override public void onCreate() {
        super.onCreate();
        ViewTarget.setTagId(R.id.glide_tag);
    }
}
