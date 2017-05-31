package br.amacedo.com.fitapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;

import java.text.ParseException;
import java.util.ArrayList;

import br.amacedo.com.fitapp.models.Refeicao;

/**
 * Created by AndersonMacedo on 16/05/2017.
 */
public class RefeicaoDAO extends GenericDAO
{
    /**
     * The constant NOME_TABELA.
     */
    public static final String NOME_TABELA = "refeicao";
    /**
     * The constant COLUNA_ID.
     */
    public static final String COLUNA_ID = "refeicao_id";
    /**
     * The constant DATA_REFEICAO.
     */
    public static final String DATA_REFEICAO = "ref_data";
    /**
     * The constant TIPO_REFEICAO.
     */
    public static final String TIPO_REFEICAO = "ref_tipo";

    /**
     * Instantiates a new Refeicao dao.
     *
     * @param context the context
     */
    public RefeicaoDAO(Context context){super(context);}

    /**
     * The Df.
     */
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * The Refeicoes.
     */
    ArrayList<Refeicao> refeicoes = new ArrayList<>();

    /**
     * Insere uma refeicao no banco
     *
     * @param refeicao  the refeicao
     * @param usuarioID the usuario id
     * @return id da refeição
     */
    public long inserir(Refeicao refeicao, int usuarioID)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ContentValues values  = new ContentValues();
        values.put(TIPO_REFEICAO, refeicao.getTipo());
        values.put(DATA_REFEICAO, df.format(refeicao.getDataHora()));
        values.put(UsuarioDAO.COLUNA_ID, usuarioID);

        //values.put(COLUNA_ID, usuario.getId());

        return getDB().insert(NOME_TABELA,  null, values);
    }

    /**
     * Lista a refeições do banco
     *
     * @param usuarioID the usuario id
     * @return ArrayList<Refeicao>  array list
     * @throws ParseException the parse exception
     */
    public ArrayList<Refeicao> listar(int usuarioID) throws ParseException {
        //String[] colums = new String[]{COLUNA_ID, COLUNA_NOME, COLUNA_SOBRENOME, COLUNA_IDADE, COLUNA_ALTURA, COLUNA_PESO};
        String query = "select * from " + NOME_TABELA + " r inner join " + UsuarioDAO.NOME_TABELA + " u " +
                        "on r." + UsuarioDAO.COLUNA_ID + " = u." + UsuarioDAO.COLUNA_ID + " where r." +
                        UsuarioDAO.COLUNA_ID + " = ?";
        Cursor cursor = getDB().rawQuery(query, new String []{String.valueOf(usuarioID)});



        while(cursor.moveToNext())
        {

            Refeicao refeicao = new Refeicao();
            refeicao.setDataHora(df.parse(cursor.getString(cursor.getColumnIndex(DATA_REFEICAO))));
            refeicao.setTipo(cursor.getString(cursor.getColumnIndex(TIPO_REFEICAO)));
            refeicao.setId(cursor.getInt(cursor.getColumnIndex(COLUNA_ID)));

            refeicoes.add(refeicao);
        }
        cursor.close();
        return refeicoes;
    }

    /**
     * Gets refeicao.
     *
     * @param refeicao_id the refeicao id
     * @return the refeicao
     * @throws ParseException the parse exception
     */
    public Refeicao getRefeicao(int refeicao_id) throws ParseException
    {
        String[] colums = new String[]{COLUNA_ID, DATA_REFEICAO, TIPO_REFEICAO};
        Cursor cursor = getDB().query(NOME_TABELA, colums, COLUNA_ID + "=?", new String[]{String.valueOf(refeicao_id)}, null, null, null);

        while(cursor.moveToNext())
        {
            Refeicao refeicao = new Refeicao();
            refeicao.setDataHora(df.parse(cursor.getString(cursor.getColumnIndex(DATA_REFEICAO))));
            refeicao.setTipo(cursor.getString(cursor.getColumnIndex(TIPO_REFEICAO)));
            refeicao.setId(cursor.getInt(cursor.getColumnIndex(COLUNA_ID)));

            cursor.close();
            return refeicao;
        }
        return null;
    }
}
