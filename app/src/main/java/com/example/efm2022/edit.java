package com.example.efm2022;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class edit extends AppCompatActivity {
    connexion cn;
    EditText e1,e2;
    Spinner sp;
    ArrayList<adehion> ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        cn=new connexion(this);
        ad=connexion.getall(cn.getReadableDatabase());
        ArrayList<String> s=new ArrayList<>();
        for(adehion ade :ad){
            s.add(String.valueOf(ade.getCode()));
        }
        ArrayAdapter dr=new ArrayAdapter(this,R.layout.activity_edit,s);
        sp.setAdapter(dr);



        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adehion b=ad.get(i);
                e1.setText(b.getNom());
                e2.setText(b.getTele());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void edit(View view) {
        AlertDialog.Builder a =new AlertDialog.Builder(edit.this);
        a.setTitle("modofication ");
        a.setMessage("vous voulez update");
        a.setPositiveButton("modfier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                adehion ad=new adehion();
                ad.setCode(Integer.valueOf( sp.getSelectedItem().toString()));
                ad.setNom(e1.getText().toString());
                ad.setTele(e2.getText().toString());
                if(connexion.update_adehesion(cn.getWritableDatabase(),ad)==-1){
                    Toast.makeText(edit.this, "echoue", Toast.LENGTH_SHORT).show();
                }

            }
        });
        a.setNegativeButton("annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(edit.this, "anuuler", Toast.LENGTH_SHORT).show();

            }
        });
        a.show();

    }

    public void sup(View view) {
        AlertDialog.Builder a =new AlertDialog.Builder(edit.this);
        a.setTitle("suppresin");
        a.setMessage("vous voulez vraiment supprime");
        a.setPositiveButton("suppriime", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int a =Integer.valueOf(sp.getSelectedItem().toString()) ;
                connexion.remove(cn.getWritableDatabase(),a);


            }

        });
        a.setNegativeButton("anuuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(edit.this, "anuuler", Toast.LENGTH_SHORT).show();
            }
        });
        a.show();
    }
}