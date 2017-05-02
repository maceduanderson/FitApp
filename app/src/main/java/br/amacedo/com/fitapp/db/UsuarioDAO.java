package br.amacedo.com.fitapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.amacedo.com.fitapp.models.Usuario;

/**
 * Created by MACEDO on 22/04/2017.
 */

public class UsuarioDAO extends GenericDAO
{
    public static final String NOME_TABELA = "usuarios";
    public static final String COLUNA_ID = "usuario_id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_SOBRENOME = "sobrenome";
    public static final String COLUNA_IDADE = "idade";
    public static final String COLUNA_PESO = "peso";
    public static final String COLUNA_ALTURA = "altura";



    public UsuarioDAO(Context context)
    {
        super(context);
    }

    public long inserir(Usuario usuario)
    {
        ContentValues values  = new ContentValues();
        values.put(COLUNA_NOME, usuario.getNome());
        values.put(COLUNA_SOBRENOME, usuario.getSobreNome());
        values.put(COLUNA_IDADE, usuario.getIdade());
        values.put(COLUNA_ALTURA, usuario.getAltura());
        values.put(COLUNA_PESO, usuario.getPeso());
        //values.put(COLUNA_ID, usuario.getId());

        return getDB().insert(NOME_TABELA,  null, values);
    }
    public ArrayList<Usuario> listar()
    {
        String[] colums = new String[]{COLUNA_ID, COLUNA_NOME, COLUNA_SOBRENOME, COLUNA_IDADE, COLUNA_ALTURA, COLUNA_PESO};
        Cursor cursor = getDB().query(NOME_TABELA, colums, null, null, null, null, null);
        ArrayList<Usuario> usuarios = new ArrayList<>();

        while(cursor.moveToNext())
        {
            Usuario usuario = new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNome(cursor.getString(1));
            usuario.setSobreNome(cursor.getString(2));
            usuario.setIdade(cursor.getInt(3));
            usuario.setAltura(cursor.getFloat(4));
            usuario.setPeso(cursor.getInt(5));
            usuarios.add(usuario);
        }
        cursor.close();
        return usuarios;
    }

}
