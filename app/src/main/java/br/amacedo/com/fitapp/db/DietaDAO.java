package br.amacedo.com.fitapp.db;

import android.content.Context;

/**
 * Created by Anderson Macedo on 24/04/2017.
 */

public class DietaDAO extends GenericDAO
{
    static final String NOME_TABELA = "dieta";
    static final String COLUNA_ID = "id";
    static final String COLUNA_DINICIO = "data_inicio";
    static final String COLUNA_DFIM = "data_fim";
    static final String COLUNA_DATUAL = "data_atual";
    static final String COLUNA_PINICIO = "peso_inicio";
    static final String COLUNA_PFIM = "peso_fim";
    static final String COLUNA_PATUAL = "peso_atual";
    static final String COLUNA_FIDUSUARIO = "usuario_id";


    public DietaDAO(Context context)
    {
        super(context);
    }


}
