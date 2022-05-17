package com.example.bi3wichri;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


public class Profile extends AppCompatActivity {

    EditText nom,prenom,numero;
    ImageButton add;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        /*nom=findViewById(R.id.nom);
        prenom=findViewById(R.id.prenom);
        numero=findViewById(R.id.numero);
        nom.setText("TEST");
        prenom.setText("TEST");
        numero.setText("06552643");
        add=findViewById(R.id.add_btn);*/

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View View){
            startActivity(new Intent(Profile.this, ajout_pdt.class));
        }
        });

    }



}
