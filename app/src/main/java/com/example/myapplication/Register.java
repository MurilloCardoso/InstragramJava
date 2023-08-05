package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.ImageView;



public class Register extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        ImageButton selectImageButton = findViewById(R.id.fotoPerfil);
        Button goToProfileButton = findViewById(R.id.btnLogin);
        Button goToProfileButtonCadastro= findViewById(R.id.btnCadastrar);
        selectImageButton.setOnClickListener(view -> openGallery());
        goToProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, LoginPage.class);
                startActivity(intent);
            }
        });
        goToProfileButtonCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Aqui você pode obter a URI da imagem selecionada

            Uri selectedImageUri = data.getData();
            ImageView selectImageButton = findViewById(R.id.fotoPerfil);
            selectImageButton.setImageURI(selectedImageUri);
        }
    }
}

