package com.example.app_fichas_rpg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class CriarFichaActivity extends AppCompatActivity implements View.OnClickListener {

    //region Atributos
    public EditText edt_Nome;
    public EditText edt_Classe;
    public EditText edt_Nivel;
    public EditText edt_Raca;
    public EditText edt_HP_Atual;
    public EditText edt_HP_Total;
    public EditText edt_Dano;

    public SeekBar seekBar_forca;
    public TextView txt_num_Forca;
    public TextView txt_num_Forca_Extra;

    public SeekBar seekBar_Inteligencia;
    public TextView txt_num_Inteligencia;
    public TextView txt_num_Inteligencia_Extra;

    public SeekBar seekBar_Agilidade;
    public TextView txt_num_Agilidade;
    public TextView txt_num_Agilidade_Extra;

    public SeekBar seekBar_Desvio;
    public TextView txt_num_Desvio;
    public TextView txt_num_Desvio_Extra;

    public SeekBar seekBar_Defesa;
    public TextView txt_num_Defesa;
    public TextView txt_num_Defesa_Extra;

    public SeekBar seekBar_Deslocamento;
    public TextView txt_num_Deslocamento;
    public TextView txt_num_Deslocamento_Extra;

    public SeekBar seekBar_Conhecimento;
    public TextView txt_num_Conhecimento;
    public TextView txt_num_Conhecimento_Extra;

    public SeekBar seekBar_Carisma;
    public TextView txt_num_Carisma;
    public TextView txt_num_Carisma_Extra;

    public SeekBar seekBar_Precisao;
    public TextView txt_num_Precisao;
    public TextView txt_num_Precisao_Extra;

    public SeekBar seekBar_Percepcao;
    public TextView txt_num_Percepcao;
    public TextView txt_num_Percepcao_Extra;

    public SeekBar seekBar_Sorte;
    public TextView txt_num_Sorte;
    public TextView txt_num_Sorte_Extra;

    public SeekBar seekBar_Furtividade;
    public TextView txt_num_Furtividade;
    public TextView txt_num_Furtividade_Extra;

    public Ficha ficha = null;

    public Button btnConfirm;
    public Button btnVoltar;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_ficha);
        Inicializar();
        Listeners();

        btnVoltar.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_Confirm:
                Toast.makeText(getApplicationContext(), "AAAAAAAAAA", Toast.LENGTH_SHORT).show();
                 SalvarDados();
                break;
            case R.id.btn_back_Criar_Main:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void SalvarDados(){
        if(DadosValidos()) {
            PreencherFicha();
            Toast.makeText(getApplicationContext(), "EntrouSalvar1", Toast.LENGTH_SHORT).show();
            DataBase db = new DataBase(ficha);
            Toast.makeText(getApplicationContext(), "Criou", Toast.LENGTH_SHORT).show();
            db.Salvar(ficha);
            Toast.makeText(getApplicationContext(), "Saiu", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Preencha todos os dados", Toast.LENGTH_LONG).show();
        }
    }

    //region Preencher dados
    public void PreencherFicha(){

        ficha = new Ficha();

        ficha.setNome(edt_Nome.getText().toString());
        ficha.setClasse(edt_Classe.getText().toString());
        ficha.setNivel(Integer.parseInt(edt_Nivel.getText().toString()));
        ficha.setRaca(edt_Raca.getText().toString());
        ficha.setVidaTotal(Integer.parseInt(edt_HP_Total.getText().toString()));
        ficha.setVidaAtual(Integer.parseInt(edt_HP_Total.getText().toString()));
        ficha.setDano(Double.parseDouble(edt_Dano.getText().toString()));

        ficha.setForca(Integer.parseInt(txt_num_Forca.getText().toString()));
        ficha.setInteligencia(Integer.parseInt(txt_num_Inteligencia.getText().toString()));
        ficha.setAgilidade(Integer.parseInt(txt_num_Agilidade.getText().toString()));
        ficha.setDesvio(Integer.parseInt(txt_num_Desvio.getText().toString()));
        ficha.setDefesa(Integer.parseInt(txt_num_Defesa.getText().toString()));
        ficha.setDeslocamento(Integer.parseInt(txt_num_Deslocamento.getText().toString()));
        ficha.setConhecimento(Integer.parseInt(txt_num_Conhecimento.getText().toString()));
        ficha.setCarisma(Integer.parseInt(txt_num_Carisma.getText().toString()));
        ficha.setPrecisao(Integer.parseInt(txt_num_Precisao.getText().toString()));
        ficha.setPercepcao(Integer.parseInt(txt_num_Percepcao.getText().toString()));
        ficha.setSorte(Integer.parseInt(txt_num_Sorte.getText().toString()));
        ficha.setFurtividade(Integer.parseInt(txt_num_Furtividade.getText().toString()));

        ficha.setForcaExtra((txt_num_Forca_Extra.getText()!=null) ? Integer.parseInt(txt_num_Forca_Extra.getText().toString()) :0);
        ficha.setInteligenciaExtra((txt_num_Inteligencia_Extra.getText()!=null) ? Integer.parseInt(txt_num_Inteligencia_Extra.getText().toString()) : 0);
        ficha.setAgilidadeExtra((txt_num_Agilidade_Extra.getText()!=null) ? Integer.parseInt(txt_num_Agilidade_Extra.getText().toString()) : 0);
        ficha.setDesvioExtra((txt_num_Desvio_Extra.getText()!=null) ? Integer.parseInt(txt_num_Desvio_Extra.getText().toString()) : 0);
        ficha.setDefesaExtra((txt_num_Defesa_Extra.getText()!=null) ?Integer.parseInt(txt_num_Defesa_Extra.getText().toString()) : 0);
        ficha.setDeslocamentoExtra((txt_num_Deslocamento_Extra.getText()!=null) ? Integer.parseInt(txt_num_Deslocamento_Extra.getText().toString()) : 0);
        ficha.setConhecimentoExtra((txt_num_Conhecimento_Extra.getText()!=null) ? Integer.parseInt(txt_num_Conhecimento_Extra.getText().toString()) : 0);
        ficha.setCarismaExtra((txt_num_Carisma_Extra.getText()!=null) ? Integer.parseInt(txt_num_Carisma_Extra.getText().toString()) : 0);
        ficha.setPrecisaoExtra((txt_num_Precisao_Extra.getText()!=null) ? Integer.parseInt(txt_num_Precisao_Extra.getText().toString()) : 0);
        ficha.setPercepcaoExtra((txt_num_Percepcao_Extra.getText()!=null) ? Integer.parseInt(txt_num_Percepcao_Extra.getText().toString()) : 0);
        ficha.setSorteExtra((txt_num_Sorte_Extra.getText()!=null) ? Integer.parseInt(txt_num_Sorte_Extra.getText().toString()) : 0);
        ficha.setFurtividadeExtra((txt_num_Furtividade_Extra.getText()!=null) ? Integer.parseInt(txt_num_Furtividade_Extra.getText().toString()) : 0);
    }
    //endregion
    //region Validando dados
    public boolean DadosValidos(){
        boolean dadosValidos = true;

        if(     (edt_Nome.getText().length() == 0)     ||
                (edt_Classe.getText().length() == 0)   ||
                (edt_Nivel.getText().length() == 0)    ||
                (edt_Raca.getText().length() == 0)     ||
                (edt_HP_Total.getText().length() == 0) ||
                (edt_Dano.getText().length() == 0)
        ){
            dadosValidos = false;
        }

        return dadosValidos;
    }
    //endregion
    //region Inicializando atributos ( findViewById())
    public void Inicializar(){

        btnConfirm = findViewById(R.id.btn_Confirm);
        btnVoltar = findViewById(R.id.btn_back_Criar_Main);
        edt_Nome = findViewById(R.id.edt_Nome);
        edt_Classe = findViewById(R.id.edt_Classe);
        edt_Nivel = findViewById(R.id.edt_Nivel);
        edt_Raca = findViewById(R.id.edt_Raca);
        edt_HP_Atual = findViewById(R.id.edt_HP_Atual);
        edt_HP_Total = findViewById(R.id.edt_HP_Total);
        edt_Dano = findViewById(R.id.edt_Dano);

        seekBar_forca = findViewById(R.id.seekBar_Forca);
        txt_num_Forca = findViewById(R.id.txt_num_Forca);
        txt_num_Forca_Extra = findViewById(R.id.txt_num_Forca_Extra);

        seekBar_Inteligencia = findViewById(R.id.seekBar_Inteligencia);
        txt_num_Inteligencia = findViewById(R.id.txt_num_Inteligencia);
        txt_num_Inteligencia_Extra = findViewById(R.id.txt_num_Inteligencia_Extra);

        seekBar_Agilidade = findViewById(R.id.seekBar_Agilidade);
        txt_num_Agilidade = findViewById(R.id.txt_num_Agilidade);
        txt_num_Agilidade_Extra = findViewById(R.id.txt_num_Agilidade_Extra);

        seekBar_Desvio = findViewById(R.id.seekBar_Desvio);
        txt_num_Desvio = findViewById(R.id.txt_num_Desvio);
        txt_num_Desvio_Extra = findViewById(R.id.txt_num_Desvio_Extra);

        seekBar_Defesa = findViewById(R.id.seekBar_Defesa);
        txt_num_Defesa = findViewById(R.id.txt_num_Defesa);
        txt_num_Defesa_Extra = findViewById(R.id.txt_num_Defesa_Extra);

        seekBar_Deslocamento = findViewById(R.id.seekBar_Deslocamento);
        txt_num_Deslocamento = findViewById(R.id.txt_num_Deslocamento);
        txt_num_Deslocamento_Extra = findViewById(R.id.txt_num_Deslocamento_Extra);

        seekBar_Conhecimento = findViewById(R.id.seekBar_Conhecimento);
        txt_num_Conhecimento = findViewById(R.id.txt_num_Conhecimento);
        txt_num_Conhecimento_Extra = findViewById(R.id.txt_num_Conhecimento_Extra);

        seekBar_Carisma = findViewById(R.id.seekBar_Carisma);
        txt_num_Carisma = findViewById(R.id.txt_num_Carisma);
        txt_num_Carisma_Extra = findViewById(R.id.txt_num_Carisma_Extra);

        seekBar_Precisao = findViewById(R.id.seekBar_Precisao);
        txt_num_Precisao = findViewById(R.id.txt_num_Precisao);
        txt_num_Precisao_Extra = findViewById(R.id.txt_num_Precisao_Extra);

        seekBar_Percepcao = findViewById(R.id.seekBar_Percepcao);
        txt_num_Percepcao = findViewById(R.id.txt_num_Percepcao);
        txt_num_Percepcao_Extra = findViewById(R.id.txt_num_Percepcao_Extra);

        seekBar_Sorte = findViewById(R.id.seekBar_Sorte);
        txt_num_Sorte = findViewById(R.id.txt_num_Sorte);
        txt_num_Sorte_Extra = findViewById(R.id.txt_num_Sorte_Extra);

        seekBar_Furtividade = findViewById(R.id.seekBar_Furtividade);
        txt_num_Furtividade = findViewById(R.id.txt_num_Furtividade);
        txt_num_Furtividade_Extra = findViewById(R.id.txt_num_Furtividade_Extra);
    }
    //endregion
    //region Setando Listeners para cara seekBar para setar valor em um textview
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
    //endregion


}
