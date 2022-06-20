package com.example.efm2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void intent(View view) {
        Intent a =null;
        switch (view.getId()){
            case R.id.btn1:a=new Intent(Menu.this,ajouter.class);break;
            case R.id.btn2:a=new Intent(Menu.this,edit.class);
        }
        startActivity(a);
    }
}