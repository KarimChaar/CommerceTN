package com.example.bi3wichri;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="DBBi3wIchri3";

    private SQLiteDatabase manageDB;


    public DBHandler (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table users " +
                "(id_U integer primary key autoincrement," +
                "nom_U text not null," +
                "prenom_U text not null," +
                "tel_U text not null," +
                "login text not null unique," +
                "mdp text not null)"
        );

        sqLiteDatabase.execSQL("create table produits" +
                "(id_P integer primary key autoincrement," +
                "nom_P text not null," +
                "prix_P text not null," +
                "description text not null,"+
                "cat_P text not null,"+
                "id_user  integer,"+
                "FOREIGN KEY(id_user) references user(id_U) on delete cascade on update no action);"
        );

        sqLiteDatabase.execSQL("create table photos" +
                "(id_Pho integer primary key autoincrement," +
                "nom_Pho" +
                "photo_Pho Blob not null," +
                "id_P integer," +
                "foreign key(id_P) references produits(id_P) on delete cascade on update no action)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists photos");
        sqLiteDatabase.execSQL("drop table if exists produits");
        sqLiteDatabase.execSQL("drop table if exists users");
        sqLiteDatabase.execSQL("drop table if exists categories");
        sqLiteDatabase.execSQL("create table users " +
                "(id_U integer primary key autoincrement," +
                "nom_U text not null," +
                "prenom_U text not null," +
                "tel_U text not null," +
                "login text not null unique," +
                "mdp text not null);");

        sqLiteDatabase.execSQL("create table produits" +
                "(id_P integer primary key autoincrement," +
                "nom_P text not null," +
                "prix_P real not null," +
                "description text not null,"+
                "cat_P text not null,"+
                "id_user  integer,"+
                "FOREIGN KEY(id_user) references user(id_U) on delete cascade on update no action);");

        sqLiteDatabase.execSQL("create table photos" +
                "(id_Pho integer primary key autoincrement," +
                "nom_Pho" +
                "photo_Pho Blob not null," +
                "id_P integer," +
                "foreign key(id_P) references produits(id_P) on delete cascade on update no action)");
        onCreate(sqLiteDatabase);
    }
}
