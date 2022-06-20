package com.example.efm2022;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ajouter extends AppCompatActivity {
    EditText e1,e2;
    connexion cn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);
        cn=new connexion(this);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
    }

    public void ajouter(View view) {
        adehion a =new adehion();
        a.setNom(e1.getText().toString());
        a.setTele(e2.getText().toString());
     if(   connexion.add_adehesion(cn.getWritableDatabase(),a)==-1){
         Toast.makeText(this, "echoue", Toast.LENGTH_SHORT).show();
     }
    }

    public void supprime(View view) {
        AlertDialog.Builder a =new AlertDialog.Builder(ajouter.this);
        a.setTitle("suppresin");
        a.setMessage("vous voulez vraiment supprime");
        a.setPositiveButton("suppriime", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


            }
        });
    }
}