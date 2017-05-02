package br.amacedo.com.fitapp.db;

import android.content.ContentValues;
import android.content.Context;

import br.amacedo.com.fitapp.models.Dieta;

/**
 * Created by Anderson Macedo on 24/04/2017.
 */

public class DietaDAO extends GenericDAO
{
    static final String NOME_TABELA = "dieta";
    static final String COLUNA_ID = "dieta_id";
    static final String COLUNA_DINICIO = "data_inicio";
    static final String COLUNA_DFIM = "data_fim";
    static final String COLUNA_PINICIO = "peso_inicio";
    static final String COLUNA_PFIM = "peso_fim";
    static final String COLUNA_FIDUSUARIO = "usuario_id";


    public DietaDAO(Context context)
    {
        super(context);
    }



    public long inserir(Dieta dieta, int userID)
    {
        ContentValues values = new ContentValues();

        values.put(COLUNA_DINICIO, dieta.getInicio().getTime());
        values.put(COLUNA_DFIM, dieta.getFim().getTime());
        values.put(COLUNA_PINICIO, dieta.getPesoInicio());
        values.put(COLUNA_PFIM, dieta.getPesoDesejado());
        values.put(COLUNA_FIDUSUARIO, userID);

        return getDB().insert(NOME_TABELA,  null, values);
    }

}
