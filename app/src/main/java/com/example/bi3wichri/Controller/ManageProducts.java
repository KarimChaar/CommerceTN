package com.example.bi3wichri.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bi3wichri.DBHandler;
import com.example.bi3wichri.Models.Produit;
import com.example.bi3wichri.Models.User;

import java.util.ArrayList;
import java.util.List;

public class ManageProducts extends DBHandler {
    private SQLiteDatabase ManageTProducts;

    public ManageProducts(Context context) {
        super(context);
    }

    SQLiteDatabase open(){
        ManageTProducts = this.getWritableDatabase();
        return ManageTProducts;
    }

    public void close(){
        ManageTProducts.close();
    }

    /*public long addUser(Users users ){
        ManageTProducts=this.open();
        ContentValues v=new ContentValues();
        v.put("nom_U",users.getNom_U());
        v.put("prenom_U",users.getPrenom_U());
        v.put("tel_U",users.getTel_U());
        v.put("login",users.getLogin());
        v.put("mdp",users.getMdp());
        long i=ManageTUsers.insert("users",null,v);
        ManageTUsers.close();
        return i;
    }*/
    public void addProduct(){
        ManageTProducts=this.open();
            ContentValues v=new ContentValues();
            v.put("nom_P", "Table");
            v.put("prix_P", 200);
            v.put("description", "salon et table à vendre dispo à l'aouina .veuillez contacter le 54 836 046");
            v.put("cat_P","Immobilier");
            ManageTProducts.insert("produits",null,v);
        ManageTProducts.close();
    }
    public List<Produit> getAllProductsIm(){
        ManageTProducts=this.getReadableDatabase();
        String query="select * from produits where cat_P='Immobilier';";
        Cursor cursor= ManageTProducts.rawQuery(query,null);
        if(cursor.getCount()==0){
            return null;
        }
        List<Produit> produits = new ArrayList<Produit>();

        if (cursor.moveToFirst()){
            do{
                Produit prod= new Produit();
                prod.setNom_P(cursor.getString(1));
                prod.setPrix_P(cursor.getDouble(2));
                prod.setDescription_P(cursor.getString(3));
                prod.setCategorie_P(cursor.getString(4));
                produits.add(prod);
            }while(cursor.moveToNext());
        }
        cursor.close();
        ManageTProducts.close();
        return produits;
    }
/*
    public void delete(Users u){
        ManageTUsers=this.open();
        ManageTUsers.delete("users","id",new String[]{String.valueOf(u.getId_U())});
        ManageTUsers.close();
    }

    public Users verifAuthentification(String login,String mdp){

        ManageTUsers=this.getReadableDatabase();
        String query="Select * from users where login=? and mdp=? ;";
        Cursor cursor=ManageTUsers.rawQuery(query,new String[] {login,mdp});

        if (cursor.getColumnCount()==0) {
            return null;
        }


        ManageTUsers=this.open();
        ContentValues v=new ContentValues();
        v.put("nom_U","immobilier");
        ManageTUsers.insert("categories",null,v);


        Users u1= new Users();

        if(cursor.moveToFirst()){
            u1.setId_U(cursor.getInt(0));
            u1.setNom_U(cursor.getString(1));
            u1.setPrenom_U(cursor.getString(2));
            u1.setTel_U(cursor.getString(3));
            u1.setLogin(cursor.getString(4));
            u1.setMdp(cursor.getString(5));
        }
        cursor.close();
        ManageTUsers.close();
        return  u1;
    }
*/
}
