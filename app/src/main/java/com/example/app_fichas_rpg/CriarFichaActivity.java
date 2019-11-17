package com.example.app_fichas_rpg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class CriarFichaActivity extends AppCompatActivity {

    public SeekBar seekBar_forca;
    public TextView txt_num_Forca;

    public SeekBar seekBar_Inteligencia;
    public TextView txt_num_Inteligencia;

    public SeekBar seekBar_Agilidade;
    public TextView txt_num_Agilidade;

    public SeekBar seekBar_Desvio;
    public TextView txt_num_Desvio;

    public SeekBar seekBar_Defesa;
    public TextView txt_num_Defesa;

    public SeekBar seekBar_Deslocamento;
    public TextView txt_num_Deslocamento;

    public SeekBar seekBar_Conhecimento;
    public TextView txt_num_Conhecimento;

    public SeekBar seekBar_Carisma;
    public TextView txt_num_Carisma;

    public SeekBar seekBar_Precisao;
    public TextView txt_num_Precisao;

    public SeekBar seekBar_Percepcao;
    public TextView txt_num_Percepcao;

    public SeekBar seekBar_Sorte;
    public TextView txt_num_Sorte;

    public SeekBar seekBar_Furtividade;
    public TextView txt_num_Furtividade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_ficha);
        Inicializar();
        Listeners();


    }





    public void Inicializar(){
        seekBar_forca = findViewById(R.id.seekBar_Forca);
        txt_num_Forca = findViewById(R.id.txt_num_Forca);

        seekBar_Inteligencia = findViewById(R.id.seekBar_Inteligencia);
        txt_num_Inteligencia = findViewById(R.id.txt_num_Inteligencia);

        seekBar_Agilidade = findViewById(R.id.seekBar_Agilidade);
        txt_num_Agilidade = findViewById(R.id.txt_num_Agilidade);

        seekBar_Desvio = findViewById(R.id.seekBar_Desvio);
        txt_num_Desvio = findViewById(R.id.txt_num_Desvio);

        seekBar_Defesa = findViewById(R.id.seekBar_Defesa);
        txt_num_Defesa = findViewById(R.id.txt_num_Defesa);

        seekBar_Deslocamento = findViewById(R.id.seekBar_Deslocamento);
        txt_num_Deslocamento = findViewById(R.id.txt_num_Deslocamento);

        seekBar_Conhecimento = findViewById(R.id.seekBar_Conhecimento);
        txt_num_Conhecimento = findViewById(R.id.txt_num_Conhecimento);

        seekBar_Carisma = findViewById(R.id.seekBar_Carisma);
        txt_num_Carisma = findViewById(R.id.txt_num_Carisma);

        seekBar_Precisao = findViewById(R.id.seekBar_Precisao);
        txt_num_Precisao = findViewById(R.id.txt_num_Precisao);

        seekBar_Percepcao = findViewById(R.id.seekBar_Percepcao);
        txt_num_Percepcao = findViewById(R.id.txt_num_Percepcao);

        seekBar_Sorte= findViewById(R.id.seekBar_Sorte);
        txt_num_Sorte = findViewById(R.id.txt_num_Sorte);

        seekBar_Furtividade = findViewById(R.id.seekBar_Furtividade);
        txt_num_Furtividade = findViewById(R.id.txt_num_Furtividade);
    }
    public void Listeners(){
        seekBar_forca.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int a = seekBar_forca.getProgress() - seekBar_forca.getMax()/2;
                txt_num_Forca.setText(a+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar_Inteligencia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int a = seekBar_Inteligencia.getProgress() - seekBar_Inteligencia.getMax()/2;
                txt_num_Inteligencia.setText(a+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar_Agilidade.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int a = seekBar_Agilidade.getProgress() - seekBar_Agilidade.getMax()/2;
                txt_num_Agilidade.setText(a+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar_Desvio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int a = seekBar_Desvio.getProgress() - seekBar_Desvio.getMax()/2;
                txt_num_Desvio.setText(a+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar_Defesa.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int a = seekBar_Defesa.getProgress() - seekBar_Defesa.getMax()/2;
                txt_num_Defesa.setText(a+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar_Deslocamento.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int a = seekBar_Deslocamento.getProgress() - seekBar_Deslocamento.getMax()/2;
                txt_num_Deslocamento.setText(a+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar_Conhecimento.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int a = seekBar_Conhecimento.getProgress() - seekBar_Conhecimento.getMax()/2;
                txt_num_Conhecimento.setText(a+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar_Carisma.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int a = seekBar_Carisma.getProgress() - seekBar_Carisma.getMax()/2;
                txt_num_Carisma.setText(a+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar_Precisao.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int a = seekBar_Precisao.getProgress() - seekBar_Precisao.getMax()/2;
                txt_num_Precisao.setText(a+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar_Percepcao.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int a = seekBar_Percepcao.getProgress() - seekBar_Percepcao.getMax()/2;
                txt_num_Percepcao.setText(a+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar_Sorte.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int a = seekBar_Sorte.getProgress() - seekBar_Sorte.getMax()/2;
                txt_num_Sorte.setText(a+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar_Furtividade.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int a = seekBar_Furtividade.getProgress() - seekBar_Furtividade.getMax()/2;
                txt_num_Furtividade.setText(a+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
