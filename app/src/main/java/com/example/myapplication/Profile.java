package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.widget.ImageView;

public class Profile extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        Button selectImageButton = findViewById(R.id.select_image_button);
        Button selectSair = findViewById(R.id.SairApp);


        setSupportActionBar(toolbar);
        // Configurar ícone de navegação (ícone de voltar)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_ios_24);

        selectImageButton.setOnClickListener(view -> openGallery());
        selectSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, LoginPage.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // verifica se o selecionado tem um ID igual ao ID do item de menu de navegação
        // (ícone de voltar) fornecido pelo sistema Android, que é android.R.id.home
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Chamando o método de retorno padrão do Android
            return true;
        }
        return super.onOptionsItemSelected(item);
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
