package br.amacedo.com.fitapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

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

//        db.execSQL("Create table " + DietaDAO.NOME_TABELA + " (" +
//                DietaDAO.COLUNA_ID + " integer primary key autoincrement," +
//                DietaDAO.COLUNA_DINICIO + " integer not null, " +
//                DietaDAO.COLUNA_DFIM + " integer not null, " +
//                DietaDAO.COLUNA_PINICIO + " integer not null, " +
//                DietaDAO.COLUNA_PFIM + " integer not null, " +
//                DietaDAO.COLUNA_FIDUSUARIO + " integer not null, "+
//                "foreign key (" + DietaDAO.COLUNA_FIDUSUARIO + ") " +
//                "references "+ UsuarioDAO.NOME_TABELA +
//                "(" + UsuarioDAO.COLUNA_ID + ") " +  ");"

        db.execSQL("Create table " + RefeicaoDAO.NOME_TABELA + " (" +
                    RefeicaoDAO.COLUNA_ID + " integer primary key autoincrement," +
                    RefeicaoDAO.TIPO_REFEICAO + " text not null, "+
                    RefeicaoDAO.DATA_REFEICAO + " text not null, "+
                    UsuarioDAO.COLUNA_ID + " integer not null, " +
                    "foreign key (" + UsuarioDAO.COLUNA_ID + ") "+
                    "references "+ UsuarioDAO.NOME_TABELA +
                    "("+ UsuarioDAO.COLUNA_ID + ") " + ");" );

        db.execSQL("Create table " + AlimentoDAO.NOME_TABELA + " (" +
                AlimentoDAO.COLUNA_ID + " integer primary key autoincrement," +
                AlimentoDAO.NOME_ALIMENTO + " text not null, "+
                AlimentoDAO.TIPO_ALIMENTO + " text not null, "+
                AlimentoDAO.CALORIA_ALIMENTO + " integer not null, " +
                RefeicaoDAO.COLUNA_ID + " integer not null, " +
                "foreign key (" + RefeicaoDAO.COLUNA_ID + ") "+
                "references "+ RefeicaoDAO.NOME_TABELA +
                "("+ RefeicaoDAO.COLUNA_ID + ") " + ");" );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS TABLE_NAME");
        onCreate(db);
    }
}
