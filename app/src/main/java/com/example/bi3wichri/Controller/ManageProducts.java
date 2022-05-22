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


    public Long addProduct(Produit prod,User u){
            ManageTProducts=this.getWritableDatabase();
            ContentValues v=new ContentValues();
            System.out.println(prod.getNom_P());
            v.put("nom_P", prod.getNom_P());
            v.put("prix_P", prod.getPrix_P());
            v.put("description", prod.getDescription_P());
            v.put("cat_P",prod.getCategorie_P());
            v.put("id_user",u.getId_U());
            long i=ManageTProducts.insert("produits",null,v);
        ManageTProducts.close();
        return i;
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
                prod.setPrix_P(cursor.getString(2));
                prod.setDescription_P(cursor.getString(3));
                prod.setCategorie_P(cursor.getString(4));
                prod.setId_user(cursor.getInt(5));
                produits.add(prod);
            }while(cursor.moveToNext());
        }
        cursor.close();
        ManageTProducts.close();
        return produits;
    }

    public List<Produit> getAllProductMultimedia(){

        ManageTProducts=this.getReadableDatabase();
        String query="select * from produits where cat_P='Multimedia';";
        Cursor cursor= ManageTProducts.rawQuery(query,null);
        if(cursor.getCount()==0){
            return null;
        }
        List<Produit> produits = new ArrayList<Produit>();
        if (cursor.moveToFirst()){
            do{
                Produit prod= new Produit();
                prod.setNom_P(cursor.getString(1));
                prod.setPrix_P(cursor.getString(2));
                prod.setDescription_P(cursor.getString(3));
                prod.setCategorie_P(cursor.getString(4));
                produits.add(prod);
            }while(cursor.moveToNext());
        }
        cursor.close();
        ManageTProducts.close();
        return produits;
    }

    public List<Produit> getAllProductVehicule(){

        ManageTProducts=this.getReadableDatabase();
        String query="select * from produits where cat_P='Vehicule';";
        Cursor cursor= ManageTProducts.rawQuery(query,null);
        if(cursor.getCount()==0){
            return null;
        }
        List<Produit> produits = new ArrayList<Produit>();
        if (cursor.moveToFirst()){
            do{
                Produit prod= new Produit();
                prod.setNom_P(cursor.getString(1));
                prod.setPrix_P(cursor.getString(2));
                prod.setDescription_P(cursor.getString(3));
                prod.setCategorie_P(cursor.getString(4));
                produits.add(prod);
            }while(cursor.moveToNext());
        }
        cursor.close();
        ManageTProducts.close();
        return produits;
    }

    public List<Produit> getAllProductEmplois(){

        ManageTProducts=this.getReadableDatabase();
        String query="select * from produits where cat_P='Emplois';";
        Cursor cursor= ManageTProducts.rawQuery(query,null);
        if(cursor.getCount()==0){
            return null;
        }
        List<Produit> produits = new ArrayList<Produit>();
        if (cursor.moveToFirst()){
            do{
                Produit prod= new Produit();
                prod.setNom_P(cursor.getString(1));
                prod.setPrix_P(cursor.getString(2));
                prod.setDescription_P(cursor.getString(3));
                prod.setCategorie_P(cursor.getString(4));
                produits.add(prod);
            }while(cursor.moveToNext());
        }
        cursor.close();
        ManageTProducts.close();
        return produits;
    }

    public List<Produit> fetchAllProds(User u){
        ManageTProducts=this.getReadableDatabase();
        List<Produit> prdList = new ArrayList<Produit>();
        String selectQuery = "SELECT * FROM produits where id_user ="+u.getId_U() ;
        Cursor cursor = ManageTProducts.rawQuery(selectQuery, null);

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
        cursor.close();
        ManageTProducts.close();
        return prdList;
    }

    public void deleteProd(Produit p) {
        ManageTProducts=this.open();

        ManageTProducts.delete("produits", "id_P" + " = ?",
                new String[] { String.valueOf(p.getId_P()) });
        ManageTProducts.close();
    }


    public Produit getProduit(String p){
        ManageTProducts=this.getReadableDatabase();
        String query="select * from produits where nom_P = ?";
        Cursor cursor = ManageTProducts.rawQuery(query, new String[]{p});
        Produit produit = new Produit();
        if (cursor.moveToFirst()) {
                produit.setId_P(Integer.parseInt(cursor.getString(0)));
                produit.setNom_P(cursor.getString(1));
                produit.setCategorie_P(cursor.getString(2));
                produit.setDescription_P(cursor.getString(3));
                produit.setPrix_P(cursor.getString(4));
        }
        return produit;
    }


    public long updateProduct(Produit prod)
    {

        ManageTProducts=this.open();
        ContentValues v=new ContentValues();
        v.put("nom_P", prod.getNom_P());
        v.put("prix_P", prod.getPrix_P());
        v.put("cat_P", prod.getCategorie_P());
        v.put("description", prod.getDescription_P());
         return ManageTProducts.update("produits",v,"id_P= ?",new String[]{String.valueOf(prod.getId_P())});

    }

}
