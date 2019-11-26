     package com.example.app_fichas_rpg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.zip.DataFormatException;

     public class MainActivity extends AppCompatActivity {

    public Button btnCriar;
    public Button btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getApplicationContext().deleteDatabase("db_rpg");

        btnCriar = findViewById(R.id.btn_criar);
        btnListar = findViewById(R.id.btn_listar);

        btnCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CriarFichaActivity.class);
                startActivity(intent);
            }
        });
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListarFichaActivity.class);
                startActivity(intent);
            }
        });
    }
}
