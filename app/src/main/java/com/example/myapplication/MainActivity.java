package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Configurar ícone de navegação (ícone de voltar)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_person_40);
    }
//
//        Button goToProfileButton = findViewById(R.id.buttonMenu);
//        goToProfileButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Profile.class);
//                startActivity(intent);
//            }
//        });

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // verifica se o selecionado tem um ID igual ao ID do item de menu de navegação
        // (ícone de voltar) fornecido pelo sistema Android, que é android.R.id.home
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(MainActivity.this, Profile.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
