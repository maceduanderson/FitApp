package br.amacedo.com.fitapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.amacedo.com.fitapp.db.UsuarioDAO;
import br.amacedo.com.fitapp.models.Usuario;

public class InicioActivity extends AppCompatActivity {

    public static List<Usuario> listaUsuarios = new ArrayList<>();
    public static Usuario currentUsuario;

    static final int RESULT_USER_ID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(!listaUsuarios.isEmpty())
        {
            for (Usuario usuario : listaUsuarios)
            {
                menu.add(0, usuario.getId(), 0, usuario.getNome());
            }
        }
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return true;
    }



    @Override
    protected void onResume()
    {
        listaUsuarios = new UsuarioDAO(getApplicationContext()).listar();

        if(!listaUsuarios.isEmpty())
        {
            TextView txtvw =(TextView) findViewById(R.id.tmpTxtVw);
            if(currentUsuario != null) {
                txtvw.setText("Bem vindo \n " +
                        currentUsuario.getNome() + " " +
                        currentUsuario.getSobreNome());
            }

        }
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.novo_usuario)
        {
            Intent intent = new Intent(this, NovoUsuario.class);
            startActivityForResult(intent, RESULT_USER_ID);
            return true;
        }else
        {
            updateUsuario(id);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
       if(requestCode == RESULT_USER_ID)
       {
           if(resultCode == RESULT_OK)
           {
                listaUsuarios = new UsuarioDAO(getApplicationContext()).listar();
                updateUsuario(data.getIntExtra("usuario_id", 0));

           }
       }

    }

    private void updateUsuario(int id)
    {
        if(!listaUsuarios.isEmpty())
        {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getId() == id) {
                    currentUsuario = usuario;
                    break;
                }
            }
            this.onResume();

        }

    }


}
