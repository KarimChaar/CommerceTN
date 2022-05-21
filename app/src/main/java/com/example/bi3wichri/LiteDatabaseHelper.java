package com.example.bi3wichri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bi3wichri.Models.Produit;

import java.util.ArrayList;
import java.util.List;

public class LiteDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cartLiteDatabase";
    private static final String TABLE_PRODS = "produits";
    private static final String TABLE_USER = "users";
    private static final String TABLE_photo = "photo";


    // rest of tables

    // cols -- products
    private static final String KEY_ID_PDT = "id";
    private static final String KEY_NOM_PDT = "nom";
    private static final String KEY_PRIX = "prix";
    private static final String KEY_DESC = "description";
    private static final String KEY_CAT = "category";

    //cols -- users
    private static final String KEY_ID_USR= "id_U";
    private static final String KEY_NOM_USR = "nom_U";
    private static final String KEY_PRENOM_USR = "prenom_U";
    private static final String TEL = "tel";
    private static final String LOGIN = "login";
    private static final String MDP = "mdp";

    //cols -- photo
    private static final String KEY_ID_PHOTO ="id_photo";
    private static final String KEY_NOM_PHOTO ="nom_photo";

    //rest of cols

    public LiteDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODS + "(" +
                KEY_ID_PDT + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_NOM_PDT + " TEXT," +
                KEY_CAT + " TEXT," +
                KEY_DESC + " TEXT," +
                KEY_PRIX + " TEXT)";
               // KEY_ID_USR + "Integer," +
                //"FOREIGN KEY("+KEY_ID_USR+") references user(id_P) on delete cascade on update no action)";
        db.execSQL(CREATE_PRODUCTS_TABLE);

        /*String CREATE_USER_TABLE= "create table " +  TABLE_USER  + "(" +
                KEY_ID_USR + " INTERGER PRIMARY KEY AUTOINCREMENT," +
                KEY_NOM_USR + "TEXT," +
                KEY_PRENOM_USR + "TEXT," +
                TEL + "TEXT," +
                LOGIN + "TEXT not null unique," +
                MDP + "TEXT not null)";
        db.execSQL(CREATE_USER_TABLE);

        String create_PHOTOS_TABLE= "create table " + TABLE_photo + "(" +
                KEY_ID_PHOTO + "integer primary key autoincrement," +
                KEY_NOM_PHOTO + "TEXT," +
                "photo_Pho Blob not null," +
                "id_P integer," +
                "foreign key(id_P) references produits(id_P) on delete cascade on update no action)";
        db.execSQL(create_PHOTOS_TABLE);*/
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODS);

        // Create tables again
        onCreate(db);
    }

    public void insertProd(String n, String p, String c, String d){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_NOM_PDT, n);
        cv.put(KEY_CAT, c);
        cv.put(KEY_DESC, d);
        cv.put(KEY_PRIX, p);
        db.insert(TABLE_PRODS, null, cv);
        db.close();
    }

    public List<Produit> fetchAllProds(){
        List<Produit> prdList = new ArrayList<Produit>();
        String selectQuery = "SELECT  * FROM " + TABLE_PRODS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Produit produit = new Produit();
                produit.setId_P(Integer.parseInt(cursor.getString(0)));
                produit.setNom_P(cursor.getString(1));
                produit.setCategorie_P(cursor.getString(2));
                produit.setDescription_P(cursor.getString(3));
                produit.setPrix_P(cursor.getString(4));
                // Adding contact to list
                prdList.add(produit);
            } while (cursor.moveToNext());
        }
        return prdList;
    }

    public List<Produit> fetchAllProdsByCat(String category){
        List<Produit> prdList = new ArrayList<Produit>();
        String selectQuery = "SELECT  * FROM " + TABLE_PRODS+" where category ="+category;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Produit produit = new Produit();
                produit.setId_P(Integer.parseInt(cursor.getString(0)));
                produit.setNom_P(cursor.getString(1));
                produit.setCategorie_P(cursor.getString(2));
                produit.setDescription_P(cursor.getString(3));
                produit.setPrix_P(cursor.getString(4));
                // Adding contact to list
                prdList.add(produit);
            } while (cursor.moveToNext());
        }
        return prdList;
    }

    public void deleteProd(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRODS, KEY_ID_PDT + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

}