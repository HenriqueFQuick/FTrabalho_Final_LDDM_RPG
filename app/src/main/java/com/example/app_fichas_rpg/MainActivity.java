     package com.example.app_fichas_rpg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

     public class MainActivity extends AppCompatActivity {

    public Button btngo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngo = findViewById(R.id.btn_go);

        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CriarFichaActivity.class);
                startActivity(intent);
            }
        });
    }
}
