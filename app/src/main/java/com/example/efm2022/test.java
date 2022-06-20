package com.example.efm2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        float a=0;

    }
    public void rotate(int angle1,int angle2){
        RotateAnimation a =new RotateAnimation(angle1,angle2, Animation.RELATIVE_TO_PARENT,0.7f,Animation.RELATIVE_TO_SELF,0.5f);


    }
    public void rotate(View view) {
    }
}