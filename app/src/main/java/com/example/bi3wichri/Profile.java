package com.example.bi3wichri;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.bi3wichri.Controller.ManageProducts;
import com.example.bi3wichri.Controller.ManageUsers;
import com.example.bi3wichri.Controller.SessionManager;
import com.example.bi3wichri.Models.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
@@ -13,13 +52,81 @@

public class Profile extends AppCompatActivity {

    EditText nom,prenom,numero;
    ImageButton add;
    SessionManager sessionManager;
    ManageUsers manageUsers;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        sessionManager = new SessionManager(getApplicationContext());
        nom=findViewById(R.id.nom);
        prenom=findViewById(R.id.prenom);
        numero=findViewById(R.id.numero);
        manageUsers=new ManageUsers(this);
        User userInfo= (User) manageUsers.getUser(sessionManager.getLogin_U());

        nom.setText(""+userInfo.getNom_U());
        prenom.setText(""+userInfo.getPrenom_U());
        numero.setText(""+userInfo.getTel_U());

        add=findViewById(R.id.add_btn);

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View View){
                startActivity(new Intent(getApplicationContext(), ajout_pdt.class));
            }
        });

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home_page_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home_page_nav:
                        startActivity(new Intent(getApplicationContext(),HomePage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile_nav:
                        return true;
                    case R.id.logout_nav:
                        AlertDialog.Builder builder=new AlertDialog.Builder(Profile.this);
                        builder.setTitle("Log out");
                        builder.setMessage("Are you sure to log out?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                sessionManager.setLogin(false);
                                sessionManager.setName_U("");
                                sessionManager.setID_U(0);
                                sessionManager.setLogin_U("");
                                startActivity(new Intent(getApplicationContext(), Login.class));
                                finish();
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        AlertDialog alertDialog= builder.create();
                        alertDialog.show();
                        return true;
                }
                return false;
            }
        });

    }



} 
