package com.example.bi3wichri;

import androidx.annotation.NonNull;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.Toast;





import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class ajout_pdt extends AppCompatActivity {

    ImageButton annuler_btn,camera_btn;
    EditText nom_pdt,prix_pdt;
    Spinner category_lst;
    ImageView img_preview;
    Button ajouter_btn,gallery_btn;

    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private static final int CAMERA_REQUEST = 1888;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_pdt);

        nom_pdt= findViewById(R.id.nom_pdt);
        prix_pdt= findViewById(R.id.prix_pdt);
        category_lst= findViewById(R.id.category_lst);
        img_preview= findViewById(R.id.img_preview);
        gallery_btn= findViewById(R.id.gallery_btn);
        camera_btn= findViewById(R.id.camera_btn);
        ajouter_btn= findViewById(R.id.ajouter_btn);
        annuler_btn=findViewById(R.id.annuler_btn);

        String [] category = new String[]{"vehicules","emplois","multimedia","entreprises"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,category);
        category_lst.setAdapter(adapter);

        gallery_btn.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) { pickFromGallery(); }

        });

        camera_btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                }
                else
                {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });

        ajouter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomP = nom_pdt.getText().toString().trim();
                String prixP = prix_pdt.getText().toString().trim();
                String catP = category_lst.getSelectedItem().toString().trim();
                //GET IMG
                //...

                //PUSH TO DB
                //...
            }
        });

        annuler_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nom_pdt.setText("");
                prix_pdt.setText("");
                img_preview.setImageURI(null);
                startActivity(new Intent(ajout_pdt.this,HomePage.class));

            }
        });

    }

    void pickFromGallery(){
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Picture"), 200);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // if gal
        if (resultCode == RESULT_OK) {
            if (requestCode == 200) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    img_preview.setImageURI(selectedImageUri);
                }
            }
        }

        //if cam
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            img_preview.setImageBitmap(photo);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
            else
            {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

}
