package com.example.app_fichas_rpg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class RecuperarFichaActivity extends AppCompatActivity implements View.OnClickListener{
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

    public Button btnAtualizar;
    public Button btnVoltar;
    public Button btnDelete;

    public Ficha _ficha;

    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_ficha);
        _ficha = (Ficha)getIntent().getSerializableExtra("ficha");
        _ficha.setId(getIntent().getExtras().getInt("id", 0));
        Inicializar();
        PreencherTela();
        Listeners();


        btnAtualizar.setOnClickListener(this);
        btnVoltar.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onBackPressed(){
        this.finish();
        Intent intent = new Intent(getApplicationContext(), ListarFichaActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btn_Atualizar:
                if(Atualizar()) {
                    this.finish();
                    intent = new Intent(getApplicationContext(), ListarFichaActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.btn_back_Recuperar_Main:
                this.finish();
                intent = new Intent(getApplicationContext(), ListarFichaActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_Delete:
                DataBase db = new DataBase(RecuperarFichaActivity.this);
                PreencherFicha();
                db.Delete(ficha);
                this.finish();
                intent = new Intent(getApplicationContext(), ListarFichaActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    public boolean Atualizar(){
        boolean dadosvalidos = DadosValidos();
        if(dadosvalidos) {
            PreencherFicha();
            DataBase db = new DataBase(ficha, this.getApplicationContext());
            db.Atualizar(ficha);
        }
        return dadosvalidos;
    }
    //region Preencher dados
    public void PreencherFicha(){

        ficha = new Ficha();

        ficha.setId(_ficha.getId());
        ficha.setNome(edt_Nome.getText().toString());
        ficha.setClasse(edt_Classe.getText().toString());
        ficha.setNivel(Integer.parseInt(edt_Nivel.getText().toString()));
        ficha.setRaca(edt_Raca.getText().toString());
        ficha.setVidaTotal(Double.parseDouble(edt_HP_Total.getText().toString()));
        ficha.setVidaAtual(Double.parseDouble(edt_HP_Atual.getText().toString()));
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

        if(     (edt_Nome.getText() == null || edt_Nome.getText().toString().isEmpty())        ||
                (edt_Classe.getText() == null || edt_Classe.getText().toString().isEmpty())    ||
                (edt_Nivel.getText() == null || edt_Nivel.getText().toString().isEmpty())      ||
                (edt_Raca.getText() == null || edt_Raca.getText().toString().isEmpty())        ||
                (edt_HP_Total.getText()== null || edt_HP_Total.getText().toString().isEmpty() )||
                (edt_Dano.getText() == null || edt_Dano.getText().toString().isEmpty())
        ){
            Toast.makeText(getApplicationContext(), "Preencha todos os dados", Toast.LENGTH_LONG).show();
            return false;
        }
        if(Double.parseDouble(edt_HP_Atual.getText().toString()) > Double.parseDouble(edt_HP_Total.getText().toString())){
            edt_HP_Atual.setText(edt_HP_Atual.getText().toString());
            Toast.makeText(getApplicationContext(), "A vida atual nao pode ser maior que a vida total", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
    //endregion

    //region Preenchendo dados na tela
    public void PreencherTela(){
        edt_Nome.setText(_ficha.getNome());
        edt_Classe.setText(_ficha.getClasse());
        edt_Nivel.setText(String.valueOf(_ficha.getNivel()));
        edt_Raca.setText(_ficha.getRaca());
        edt_HP_Atual.setText(String.valueOf(_ficha.getVidaAtual()));
        edt_HP_Total.setText(String.valueOf(_ficha.getVidaTotal()));
        edt_Dano.setText(String.valueOf(_ficha.getDano()));

        Handler seekBarhandler = new Handler();

        txt_num_Forca.setText(String.valueOf(_ficha.getForca()));
        seekBarhandler.post(new Runnable() {@Override public void run() {seekBar_forca.setProgress(_ficha.getForca()+ seekBar_forca.getMax()/2); }});

        txt_num_Inteligencia.setText(String.valueOf(_ficha.getInteligencia()));
        seekBarhandler.post(new Runnable() {@Override public void run() {seekBar_Inteligencia.setProgress(_ficha.getInteligencia()+ seekBar_forca.getMax()/2); }});

        txt_num_Agilidade.setText(String.valueOf(_ficha.getAgilidade()));
        seekBarhandler.post(new Runnable() {@Override public void run() {seekBar_Agilidade.setProgress(_ficha.getAgilidade()+ seekBar_forca.getMax()/2); }});

        txt_num_Desvio.setText(String.valueOf(_ficha.getDesvio()));
        seekBarhandler.post(new Runnable() {@Override public void run() {seekBar_Desvio.setProgress(_ficha.getDesvio()+ seekBar_forca.getMax()/2); }});

        txt_num_Defesa.setText(String.valueOf(_ficha.getDefesa()));
        seekBarhandler.post(new Runnable() {@Override public void run() {seekBar_Defesa.setProgress(_ficha.getDefesa()+ seekBar_forca.getMax()/2); }});

        txt_num_Deslocamento.setText(String.valueOf(_ficha.getDeslocamento()));
        seekBarhandler.post(new Runnable() {@Override public void run() {seekBar_Deslocamento.setProgress(_ficha.getDeslocamento()+ seekBar_forca.getMax()/2); }});

        txt_num_Conhecimento.setText(String.valueOf(_ficha.getConhecimento()));
        seekBarhandler.post(new Runnable() {@Override public void run() {seekBar_Conhecimento.setProgress(_ficha.getConhecimento()+ seekBar_forca.getMax()/2); }});

        txt_num_Carisma.setText(String.valueOf(_ficha.getCarisma()));
        seekBarhandler.post(new Runnable() {@Override public void run() {seekBar_Carisma.setProgress(_ficha.getCarisma()+ seekBar_forca.getMax()/2); }});

        txt_num_Precisao.setText(String.valueOf(_ficha.getPrecisao()));
        seekBarhandler.post(new Runnable() {@Override public void run() {seekBar_Precisao.setProgress(_ficha.getPrecisao()+ seekBar_forca.getMax()/2); }});

        txt_num_Percepcao.setText(String.valueOf(_ficha.getPercepcao()));
        seekBarhandler.post(new Runnable() {@Override public void run() {seekBar_Percepcao.setProgress(_ficha.getPercepcao()+ seekBar_forca.getMax()/2); }});

        txt_num_Sorte.setText(String.valueOf(_ficha.getSorte()));
        seekBarhandler.post(new Runnable() {@Override public void run() {seekBar_Sorte.setProgress(_ficha.getSorte()+ seekBar_forca.getMax()/2); }});

        txt_num_Furtividade.setText(String.valueOf(_ficha.getFurtividade()));
        seekBarhandler.post(new Runnable() {@Override public void run() {seekBar_Furtividade.setProgress(_ficha.getFurtividade()+ seekBar_forca.getMax()/2); }});

        txt_num_Forca_Extra.setText(String.valueOf(_ficha.getForcaExtra()));
        txt_num_Inteligencia_Extra.setText(String.valueOf(_ficha.getInteligenciaExtra()));
        txt_num_Agilidade_Extra.setText(String.valueOf(_ficha.getAgilidadeExtra()));
        txt_num_Desvio_Extra.setText(String.valueOf(_ficha.getDesvioExtra()));
        txt_num_Defesa_Extra.setText(String.valueOf(_ficha.getDefesaExtra()));
        txt_num_Deslocamento_Extra.setText(String.valueOf(_ficha.getDeslocamentoExtra()));
        txt_num_Conhecimento_Extra.setText(String.valueOf(_ficha.getConhecimentoExtra()));
        txt_num_Carisma_Extra.setText(String.valueOf(_ficha.getCarismaExtra()));
        txt_num_Precisao_Extra.setText(String.valueOf(_ficha.getPrecisaoExtra()));
        txt_num_Percepcao_Extra.setText(String.valueOf(_ficha.getPercepcaoExtra()));
        txt_num_Sorte_Extra.setText(String.valueOf(_ficha.getSorteExtra()));
        txt_num_Furtividade_Extra.setText(String.valueOf(_ficha.getFurtividadeExtra()));

        }
    //endregion

    //region Inicializando atributos ( findViewById())
    public void Inicializar(){

        btnAtualizar = findViewById(R.id.btn_Atualizar);
        btnVoltar = findViewById(R.id.btn_back_Recuperar_Main);
        btnDelete = findViewById(R.id.btn_Delete);
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
