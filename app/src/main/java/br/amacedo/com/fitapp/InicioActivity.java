package br.amacedo.com.fitapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.amacedo.com.fitapp.db.UsuarioDAO;
import br.amacedo.com.fitapp.models.Usuario;

/**
 * The type Inicio activity.
 */
public class InicioActivity extends AppCompatActivity {

    /**
     * The constant listaUsuarios.
     */
    public static List<Usuario> listaUsuarios = new ArrayList<>();
    /**
     * The constant currentUsuario.
     */
    public static Usuario currentUsuario;

    /**
     * The Result user id.
     */
    static final int RESULT_USER_ID = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
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


    /**
     * Atualiza tela inicial com as informações do usuario selecionado
     */
    @Override
    protected void onResume()
    {
        listaUsuarios = new UsuarioDAO(getApplicationContext()).listar();

        if(!listaUsuarios.isEmpty())
        {
            TextView txtvw =(TextView) findViewById(R.id.txtvwWlcm);
            TextView txtvwIdade = (TextView) findViewById(R.id.txtvwIdade);
            TextView txtvwPeso = (TextView) findViewById(R.id.txtvwPeso);
            TextView txtvwAltura = (TextView) findViewById(R.id.txtvwAltura);
            TextView txtvwIMC = (TextView) findViewById(R.id.txtvwIMC);
            Button btnNovaRef = (Button) findViewById(R.id.btnNovaRef);
            Button btnVerRefs = (Button)findViewById(R.id.btnVerRefs);

            if(currentUsuario != null) {
                txtvw.setText("Bem vindo \n " + currentUsuario);
                txtvwIdade.setText("Idade : \n" + currentUsuario.getIdade());
                txtvwPeso.setText("Peso : \n" + currentUsuario.getPeso());
                txtvwAltura.setText("Altura : \n" + currentUsuario.getAltura());
                txtvwIMC.setText("IMC : \n" + currentUsuario.getIMC());

                btnNovaRef.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        Intent intent = new Intent(getApplicationContext(), NovaRefeicao.class);
                        intent.putExtra("usuario_id", currentUsuario.getId());
                        startActivity(intent);
                    }
                });

                btnVerRefs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        Intent intent = new Intent(getApplicationContext(), RefeicaoActivity.class);
                        intent.putExtra("usuario_id", currentUsuario.getId());
                        startActivity(intent);
                    }
                });

                btnNovaRef.setVisibility(View.VISIBLE);
                btnVerRefs.setVisibility(View.VISIBLE);
                txtvwAltura.setVisibility(View.VISIBLE);
                txtvwIdade.setVisibility(View.VISIBLE);
                txtvwPeso.setVisibility(View.VISIBLE);
                txtvwIMC.setVisibility(View.VISIBLE);
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

        //noinspection SimplifiableIfStatements
        switch (id){
            case R.id.novo_usuario:

                Intent intentNovoUsuario = new Intent(this, NovoUsuario.class);
                startActivityForResult(intentNovoUsuario, RESULT_USER_ID);
                return true;
            default:
                updateUsuario(id);
                break;
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

    /**
     * Seleciona usuário na lista estática e atualiza a referência do usuario selecionado
     * @param id
     */
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
