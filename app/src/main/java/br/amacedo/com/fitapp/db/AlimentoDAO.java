package br.amacedo.com.fitapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.amacedo.com.fitapp.models.Alimento;
import br.amacedo.com.fitapp.models.Refeicao;

import static br.amacedo.com.fitapp.db.RefeicaoDAO.DATA_REFEICAO;
import static br.amacedo.com.fitapp.db.RefeicaoDAO.TIPO_REFEICAO;

/**
 * Created by AndersonMacedo on 18/05/2017.
 */

public class AlimentoDAO extends GenericDAO
{

    public static final String NOME_TABELA = "alimento";
    public static final String COLUNA_ID = "alimento_id";
    public static final String TIPO_ALIMENTO = "tipo";
    public static final String NOME_ALIMENTO = "nome";
    public static final String CALORIA_ALIMENTO = "calorias";

    ArrayList<Alimento> alimentos = new ArrayList<>();

    public AlimentoDAO(Context context)
    {
        super(context);
    }
    public long inserir(Alimento alimento, int refeicaoID)
    {
        ContentValues values  = new ContentValues();
        values.put(TIPO_ALIMENTO, alimento.getTipo());
        values.put(NOME_ALIMENTO, alimento.getNome());
        values.put(CALORIA_ALIMENTO, alimento.getCalorias());
        values.put(RefeicaoDAO.COLUNA_ID, refeicaoID);

        //values.put(COLUNA_ID, usuario.getId());

        return getDB().insert(NOME_TABELA,  null, values);
    }

    public ArrayList<Alimento> listar(int refeicaoID) throws ParseException {
        //String[] colums = new String[]{COLUNA_ID, COLUNA_NOME, COLUNA_SOBRENOME, COLUNA_IDADE, COLUNA_ALTURA, COLUNA_PESO};
        String query = "select * from " + NOME_TABELA + " r inner join " + RefeicaoDAO.NOME_TABELA + " u " +
                "on r." + RefeicaoDAO.COLUNA_ID + " = u." + RefeicaoDAO.COLUNA_ID + " where r." +
                RefeicaoDAO.COLUNA_ID + " = ?";
        Cursor cursor = getDB().rawQuery(query, new String []{String.valueOf(refeicaoID)});



        while(cursor.moveToNext())
        {

            Alimento alimento = new Alimento();

            alimento.setCalorias(cursor.getInt(cursor.getColumnIndex(CALORIA_ALIMENTO)));
            alimento.setNome(cursor.getString(cursor.getColumnIndex(NOME_ALIMENTO)));
            alimento.setTipo(cursor.getString(cursor.getColumnIndex(TIPO_ALIMENTO)));
            alimento.setId(cursor.getInt(cursor.getColumnIndex(COLUNA_ID)));

            alimentos.add(alimento);
        }
        cursor.close();
        return alimentos;
    }

    public Alimento getAlimento(int alimentoid) throws ParseException
    {
        String[] colums = new String[]{COLUNA_ID, NOME_ALIMENTO, CALORIA_ALIMENTO, TIPO_ALIMENTO};
        Cursor cursor = getDB().query(NOME_TABELA, colums, COLUNA_ID + "=?", new String[]{String.valueOf(alimentoid)}, null, null, null);

        while(cursor.moveToNext())
        {
            Alimento alimento = new Alimento();

            alimento.setCalorias(cursor.getInt(cursor.getColumnIndex(CALORIA_ALIMENTO)));
            alimento.setNome(cursor.getString(cursor.getColumnIndex(NOME_ALIMENTO)));
            alimento.setTipo(cursor.getString(cursor.getColumnIndex(TIPO_ALIMENTO)));
            alimento.setId(cursor.getInt(cursor.getColumnIndex(COLUNA_ID)));

            cursor.close();
            return alimento;
        }
        return null;
    }



}
