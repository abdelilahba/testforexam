package com.example.efm2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class alladehsion extends AppCompatActivity {
    ListView lst;
    connexion cn;
    ArrayList<adehion> aad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alladehsion);
        cn=new connexion(this);
        aad=connexion.getall(cn.getReadableDatabase());
        ArrayList<HashMap<String,Object>> hs =new ArrayList<>();
        for(adehion ads :aad){
            HashMap<String,Object> ha=new HashMap<>();
            ha.put("nom",ads.getNom());
            ha.put("tele",ads.getTele());
            hs.add(ha);
        }
        String [] from={"nom","tele"};
        int[] to={R.id.txtnom,R.id.txttele};
        SimpleAdapter s =new SimpleAdapter(this,hs,R.layout.nom_tele,from,to);
        lst.setAdapter(s);
    }
}