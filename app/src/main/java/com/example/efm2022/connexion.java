package com.example.efm2022;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class connexion extends SQLiteOpenHelper {
     static String DATA_BASE="livre.db";
    static String TB_NAME="adehesion.db";
    public static String COL1="num";
     static   String COL2="nom";
    static   String COL3="TELE";
    public connexion(Context c){
        super(c,  DATA_BASE,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String ch="Create Table "+TB_NAME+"("+COL1+"Integer primary key autoincrement,"+COL2+"text,"+COL3+"text)";
        String ligne1="insert into "+TB_NAME+"(abdu)";
        String ligne2="insert into "+TB_NAME+"(hassan)";
        sqLiteDatabase.execSQL(ch);
        sqLiteDatabase.insert(TB_NAME,ligne1,null);
        sqLiteDatabase.insert(TB_NAME,ligne2,null);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public  static  long add_adehesion(SQLiteDatabase sqLiteDatabase ,adehion a){
        ContentValues c =new ContentValues();
        c.put(COL2,a.getNom());
        c.put(COL3,a.getTele());
        return sqLiteDatabase.insert(TB_NAME,null,c);
    }
    public static long update_adehesion(SQLiteDatabase sqLiteDatabase,adehion a ){
        ContentValues c =new ContentValues();
        c.put(COL2,a.getNom());
        c.put(COL3,a.getTele());
      return   sqLiteDatabase.update(TB_NAME,c,"num="+a.getCode(),null);

    }

    public  static  long remove(SQLiteDatabase sqLiteDatabase,int i){
        return  sqLiteDatabase.delete(TB_NAME,"code"+i,null);
    }
    public  static ArrayList<adehion> getall(SQLiteDatabase sqLiteDatabase){
        ArrayList<adehion> a =new ArrayList<>();
        Cursor c =sqLiteDatabase.rawQuery("select * from "+TB_NAME,null);
        while (c.moveToNext()){
            adehion an=new adehion();
            an.setCode(c.getInt(0));
            an.setNom(c.getString(1));
            an.setTele(c.getString(2));
            a.add(an);
        }
        return a;
    }
}
