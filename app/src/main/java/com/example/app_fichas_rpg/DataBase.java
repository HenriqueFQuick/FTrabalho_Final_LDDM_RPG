package com.example.app_fichas_rpg;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.UnicodeSetSpanner;
import android.provider.ContactsContract;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends Activity {

    public Ficha _ficha = null;
    public Context _context;

    public DataBase(Ficha ficha, Context context){
        _ficha = ficha;
        _context = context;
    }
    public DataBase(Context context){
        _context = context;
    }
    public DataBase(){}

    public void Salvar(Ficha ficha){

        //Apaga o banco de dadados
        //_context.deleteDatabase("db_rpg");
        try {
            SQLiteDatabase bancoDeDados = _context.openOrCreateDatabase("db_rpg", Context.MODE_PRIVATE, null);

            bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS Ficha(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(40), classe VARCHAR(40), raca VARCHAR(40), nivel INT, vidaTotal DOUBLE, vidaAtual DOUBLE, dano DOUBLE, forca INT, forcaExtra INT, inteligencia INT, inteligenciaExtra INT, agilidade INT, agilidadeExtra INT, desvio INT, desvioExtra INT, defesa INT, defesaExtra INT, deslocamento INT, deslocamentoExtra INT, conhecimento INT, conhecimentoExtra INT, carisma INT, carismaExtra INT, precisao INT, precisaoExtra INT, percepcao INT, percepcaoExtra INT, sorte INT, sorteExtra INT, furtividade INT, furtividadeExtra INT) ");

            String insert = "INSERT INTO Ficha " +
                    "(nome, classe, raca, nivel, vidaTotal, vidaAtual, dano, forca, forcaExtra, inteligencia, inteligenciaExtra, agilidade, agilidadeExtra, desvio, desvioExtra, defesa, defesaExtra, deslocamento, deslocamentoExtra, conhecimento, conhecimentoExtra, carisma, carismaExtra, precisao, precisaoExtra, percepcao, percepcaoExtra, sorte, sorteExtra, furtividade, furtividadeExtra) VALUES " +
                    "('" + ficha.getNome() + "','" + ficha.getClasse() + "','" + ficha.getRaca() + "','" + ficha.getNivel() + "','" + ficha.getVidaTotal() +
                    "','" + ficha.getVidaAtual() + "','" + ficha.getDano() + "','" + ficha.getForca() + "','" + ficha.getForcaExtra() + "','" + ficha.getInteligencia() +
                    "','" + ficha.getInteligenciaExtra() + "','" + ficha.getAgilidade() + "','" + ficha.getAgilidadeExtra() + "','" + ficha.getDesvio() + "','" + ficha.getDesvioExtra() +
                    "','" + ficha.getDefesa() + "','" + ficha.getDefesaExtra() + "','" + ficha.getDeslocamento() + "','" + ficha.getDeslocamentoExtra() + "','" + ficha.getConhecimento() +
                    "','" + ficha.getConhecimentoExtra() + "','" + ficha.getCarisma() + "','" + ficha.getCarismaExtra() + "','" + ficha.getPrecisao() + "','" + ficha.getPrecisaoExtra() +
                    "','" + ficha.getPercepcao() + "','" + ficha.getPercepcaoExtra() + "','" + ficha.getSorte() + "','" + ficha.getSorteExtra() + "','" + ficha.getFurtividade() +
                    "','" + ficha.getFurtividadeExtra() + "')";

            //inserir dados na tabela
            bancoDeDados.execSQL(insert);
            Toast.makeText(_context, "Inserido com sucesso", Toast.LENGTH_LONG).show();

        }catch (Exception e){
            Toast.makeText(_context, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public void Delete(Ficha ficha) {
        try {
            SQLiteDatabase bancoDeDados = _context.openOrCreateDatabase("db_rpg", Context.MODE_PRIVATE, null);
            System.out.println("ID DA FICHA " + ficha.getId());
            String delete = "DELETE FROM Ficha " +
                    "WHERE id = '" + ficha.getId() + "'";

            bancoDeDados.execSQL(delete);
            Toast.makeText(_context, "Deletado com sucesso", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(_context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    public void Atualizar(Ficha ficha){
        try{
            SQLiteDatabase bancoDeDados = _context.openOrCreateDatabase("db_rpg", Context.MODE_PRIVATE, null);
            //TODO ATUALIZAR FICHA
        }catch (Exception e){
            Toast.makeText(_context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public ArrayList<Ficha> Listar(){

        Ficha ficha;
        ArrayList<Ficha> fichas = new ArrayList<Ficha>();

        try{
            SQLiteDatabase bancoDeDados = _context.openOrCreateDatabase("db_rpg", Context.MODE_PRIVATE, null);
            //recuperar dados da tabela
            Cursor cursor = bancoDeDados.rawQuery("SELECT id, nome, classe, raca, nivel, vidaTotal, vidaAtual, dano, forca, forcaExtra, inteligencia, inteligenciaExtra, agilidade, agilidadeExtra, desvio, desvioExtra, defesa, defesaExtra, deslocamento, deslocamentoExtra, conhecimento, conhecimentoExtra, carisma, carismaExtra, precisao, precisaoExtra, percepcao, percepcaoExtra, sorte, sorteExtra, furtividade, furtividadeExtra FROM Ficha", null);

            int id = cursor.getColumnIndex("id");
            int nome = cursor.getColumnIndex("nome");
            int classe = cursor.getColumnIndex("classe");
            int raca = cursor.getColumnIndex("raca");
            int nivel = cursor.getColumnIndex("nivel");
            int vidaTotal = cursor.getColumnIndex("vidaTotal");
            int vidaAtual = cursor.getColumnIndex("vidaAtual");
            int dano = cursor.getColumnIndex("dano");
            int forca = cursor.getColumnIndex("forca");
            int forcaExtra = cursor.getColumnIndex("forcaExtra");
            int inteligencia = cursor.getColumnIndex("inteligencia");
            int inteligenciaExtra = cursor.getColumnIndex("inteligenciaExtra");
            int agilidade = cursor.getColumnIndex("agilidade");
            int agilidadeExtra = cursor.getColumnIndex("agilidadeExtra");
            int desvio = cursor.getColumnIndex("desvio");
            int desvioExtra = cursor.getColumnIndex("desvioExtra");
            int defesa = cursor.getColumnIndex("defesa");
            int defesaExtra = cursor.getColumnIndex("defesaExtra");
            int deslocamento = cursor.getColumnIndex("deslocamento");
            int deslocamentoExtra = cursor.getColumnIndex("deslocamentoExtra");
            int conhecimento = cursor.getColumnIndex("conhecimento");
            int conhecimentoExtra = cursor.getColumnIndex("conhecimentoExtra");
            int carisma = cursor.getColumnIndex("carisma");
            int carismaExtra = cursor.getColumnIndex("carismaExtra");
            int precisao = cursor.getColumnIndex("precisao");
            int precisaoExtra = cursor.getColumnIndex("precisaoExtra");
            int percepcao = cursor.getColumnIndex("percepcao");
            int percepcaoExtra = cursor.getColumnIndex("percepcaoExtra");
            int sorte = cursor.getColumnIndex("sorte");
            int sorteExtra = cursor.getColumnIndex("sorteExtra");
            int furtividade = cursor.getColumnIndex("furtividade");
            int furtividadeExtra = cursor.getColumnIndex("furtividadeExtra");

            cursor.moveToFirst();
            do{
                ficha = new Ficha ( Integer.parseInt(cursor.getString(id)), cursor.getString(nome), cursor.getString(classe),
                                    cursor.getString(raca), Integer.parseInt(cursor.getString(nivel)), Double.parseDouble(cursor.getString(vidaTotal)), Double.parseDouble(cursor.getString(vidaAtual)),
                                    Double.parseDouble(cursor.getString(dano)), Integer.parseInt(cursor.getString(forca)), Integer.parseInt(cursor.getString(forcaExtra)),
                                    Integer.parseInt(cursor.getString(inteligencia)), Integer.parseInt(cursor.getString(inteligenciaExtra)), Integer.parseInt(cursor.getString(agilidade)),
                                    Integer.parseInt(cursor.getString(agilidadeExtra)), Integer.parseInt(cursor.getString(desvio)), Integer.parseInt(cursor.getString(desvioExtra)),
                                    Integer.parseInt(cursor.getString(defesa)), Integer.parseInt(cursor.getString(defesaExtra)), Integer.parseInt(cursor.getString(deslocamento)),
                                    Integer.parseInt(cursor.getString(deslocamentoExtra)), Integer.parseInt(cursor.getString(conhecimento)), Integer.parseInt(cursor.getString(conhecimentoExtra)),
                                    Integer.parseInt(cursor.getString(carisma)), Integer.parseInt(cursor.getString(carismaExtra)), Integer.parseInt(cursor.getString(precisao)),
                                    Integer.parseInt(cursor.getString(precisaoExtra)), Integer.parseInt(cursor.getString(percepcao)), Integer.parseInt(cursor.getString(percepcaoExtra)),
                                    Integer.parseInt(cursor.getString(sorte)), Integer.parseInt(cursor.getString(sorteExtra)), Integer.parseInt(cursor.getString(furtividade)),
                                    Integer.parseInt(cursor.getString(furtividadeExtra)) );
                ficha.setId(Integer.parseInt(cursor.getString(id)));
                fichas.add(ficha);
                ficha = null;
                //move para o próximo registro
            }while(cursor.moveToNext());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return fichas;
    }

}
