package br.amacedo.com.fitapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MACEDO on 23/04/2017.
 */

public class DBHelper extends SQLiteOpenHelper
{
    protected static final String BD = "FITAPP";
    protected static final int VERSION = 1;

    public DBHelper(Context context) {
        super(context, BD, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("Create table " + UsuarioDAO.NOME_TABELA + " (" +
                UsuarioDAO.COLUNA_ID + " integer primary key autoincrement," +
                UsuarioDAO.COLUNA_NOME + " text not null, " +
                UsuarioDAO.COLUNA_SOBRENOME + " text not null, " +
                UsuarioDAO.COLUNA_ALTURA + " real not null, " +
                UsuarioDAO.COLUNA_PESO + " integer not null, " +
                UsuarioDAO.COLUNA_IDADE + " integer not null);" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}