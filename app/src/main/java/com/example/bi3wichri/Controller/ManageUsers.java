package com.example.bi3wichri.Controller;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bi3wichri.DBHandler;
import com.example.bi3wichri.Models.User;

import java.util.ArrayList;
import java.util.List;

public class ManageUsers extends DBHandler {
    private SQLiteDatabase ManageTUsers;

    public ManageUsers(Context context) {
        super(context);
    }

    SQLiteDatabase open(){
        ManageTUsers = this.getWritableDatabase();
        return ManageTUsers;
    }

public void close(){
        ManageTUsers.close();
}

    public long addUser(User user){
      ManageTUsers=this.open();
        ContentValues v=new ContentValues();
        v.put("nom_U", user.getNom_U());
        v.put("prenom_U", user.getPrenom_U());
        v.put("tel_U", user.getTel_U());
        v.put("login", user.getLogin());
        v.put("mdp", user.getMdp());
        long i=ManageTUsers.insert("users",null,v);
        ManageTUsers.close();
        return i;
    }

    public List<User> getAllUsers(){
        ManageTUsers=this.getReadableDatabase();
        String query="select * from users;";
        Cursor cursor= ManageTUsers.rawQuery(query,null);
        if(cursor.getCount()==0){
            return null;
        }
        List<User> users = new ArrayList<User>();

        if (cursor.moveToFirst()){
            do{
                User u= new User();
                u.setNom_U(cursor.getString(1));
                u.setPrenom_U(cursor.getString(2));
                u.setTel_U(cursor.getString(3));
                u.setLogin(cursor.getString(4));
                u.setMdp(cursor.getString(5));
                users.add(u);
            }while(cursor.moveToNext());
        }
        cursor.close();
        ManageTUsers.close();
        return users;
    }

    public void delete(User u){
            ManageTUsers=this.open();
            ManageTUsers.delete("users","id",new String[]{String.valueOf(u.getId_U())});
            ManageTUsers.close();
    }

    public String getPhoneNumber(int id){

        ManageTUsers=this.getReadableDatabase();
        String query="select * from users where id_U = ? ;";
        Cursor cursor=ManageTUsers.rawQuery(query,new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()){
           return cursor.getString(3);
        }
        return null;
    }


    public User getUser(String login){
        User u = new User();
        ManageTUsers=this.getReadableDatabase();
        String query="select * from users where login = ? ;";
        Cursor cursor=ManageTUsers.rawQuery(query,new String[]{login});
        if (cursor.moveToFirst()){
            u.setId_U(cursor.getInt(0));
            u.setNom_U(cursor.getString(1));
            u.setPrenom_U(cursor.getString(2));
            u.setTel_U(cursor.getString(3));
            u.setLogin(cursor.getString(4));
            u.setMdp(cursor.getString(5));
        }
        cursor.close();
        ManageTUsers.close();
        return  u;
    }

    public User verifAuthentification(String login, String mdp){

        ManageTUsers=this.getReadableDatabase();
        String query="Select * from users where login=? and mdp=? ;";
        Cursor cursor=ManageTUsers.rawQuery(query,new String[] {login,mdp});

        if (cursor.getColumnCount()==0) {
            return null;
        }

        User u1= new User();

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

}
