package com.example.app_fichas_rpg;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DataBase extends Activity {

    public Ficha _ficha = null;

    public DataBase(Ficha ficha){
        _ficha = ficha;
    }

    public void Salvar(Ficha ficha){

        //Apaga o banco de dadados
        //getApplicationContext().deleteDatabase("db_rpg");

        try {
            SQLiteDatabase bancoDeDados = getApplicationContext().openOrCreateDatabase("db_rpg", Context.MODE_PRIVATE, null);

            bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS Ficha(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(40), classe VARCHAR(40), raca VARCHAR(40), vidaTotal DOUBLE, vidaAtual DOUBLE, dano INT, forca INT, forcaExtra INT, inteligencia INT, inteligenciaExtra INT, agilidade INT, agilidadeExtra INT, desvio INT, desvioExtra INT, defesa INT, defesaExtra INT, deslocamento INT, deslocamentoExtra INT, conhecimento INT, conhecimentoExtra INT, carisma INT, carismaExtra INT, precisao INT, precisaoExtra INT, percepcao INT, percepcaoExtra INT, sorte INT, sorteExtra INT, furtividade INT, furtividadeExtra INT) ");

            String insert = "INSERT INTO Ficha " +
                    "(nome, classe, raca, vidaTotal, vidaAtual, dano, forca, forcaExtra, inteligencia, inteligenciaExtra, agilidade, agilidadeExtra, desvio, desvioExtra, defesa, defesaExtra, deslocamento, deslocamentoExtra, conhecimento, conhecimentoExtra, carisma, carismaExtra, precisao, precisaoExtra, percepcao, percepcaoExtra, sorte, sorteExtra, furtividade, furtividadeExtra) VALUES " +
                    "('" + ficha.getNome() + "',''" + ficha.getClasse() + "',''" + ficha.getRaca() + "',''" + ficha.getNivel() + "',''" + ficha.getVidaTotal() +
                    "',''" + ficha.getVidaAtual() + "',''" + ficha.getDano() + "',''" + ficha.getForca() + "',''" + ficha.getForcaExtra() + "',''" + ficha.getInteligencia() +
                    "',''" + ficha.getInteligenciaExtra() + "',''" + ficha.getAgilidade() + "',''" + ficha.getAgilidadeExtra() + "',''" + ficha.getDesvio() + "',''" + ficha.getDesvioExtra() +
                    "',''" + ficha.getDefesa() + "',''" + ficha.getDefesaExtra() + "',''" + ficha.getDeslocamento() + "',''" + ficha.getDeslocamentoExtra() + "',''" + ficha.getConhecimento() +
                    "',''" + ficha.getConhecimentoExtra() + "',''" + ficha.getCarisma() + "',''" + ficha.getCarismaExtra() + "',''" + ficha.getPrecisao() + "',''" + ficha.getPrecisaoExtra() +
                    "',''" + ficha.getPercepcao() + "',''" + ficha.getPercepcaoExtra() + "',''" + ficha.getSorte() + "',''" + ficha.getSorteExtra() + "',''" + ficha.getFurtividade() +
                    "',''" + ficha.getFurtividadeExtra() + "')";

            //inserir dados na tabela
            bancoDeDados.execSQL(insert);

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public boolean Delete(Ficha ficha){
        return true;
    }

    public void Alterar(Ficha ficha){

    }

    public Ficha Pesquisar(){
        return null;
    }

}
