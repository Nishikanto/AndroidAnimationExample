package com.pas.animationtesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    Activity_Animation001_Layout activity_animation001_layout;
    //Activity_Animation_Layout activity_animation_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //activity_animation_layout = new Activity_Animation_Layout(this);
        //setContentView(activity_animation_layout);

        activity_animation001_layout = new Activity_Animation001_Layout(this);
        setContentView(activity_animation001_layout);

    }

    @Override
    protected void onPause() {
        super.onPause();
        activity_animation001_layout.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        activity_animation001_layout.resume();
    }
}
