package com.example.app_fichas_rpg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_fichas_rpg.adapters.FichaAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListarFichaActivity extends AppCompatActivity {

    public ArrayList<Ficha> fichas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_ficha);

        DataBase db = new DataBase(this.getApplicationContext());

        fichas = db.Listar();

        RecyclerView recyclerView = findViewById(R.id.fichas_lista);
        FichaAdapter adapter = new FichaAdapter(fichas, (Activity)this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        recyclerView.addItemDecoration( new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
    @Override
    public void onBackPressed(){
        this.finish();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}
