package br.amacedo.com.fitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.amacedo.com.fitapp.db.UsuarioDAO;
import br.amacedo.com.fitapp.models.Usuario;

/**
 * The type Novo usuario.
 */
public class NovoUsuario extends AppCompatActivity {

    private EditText nome;
    private EditText sobrenome;
    private EditText peso;
    private EditText altura;
    private EditText idade;
    private Button cadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);

        nome = (EditText)findViewById(R.id.nomeEdtTxt);
        sobrenome = (EditText)findViewById(R.id.sobrenomeEdtTxt);
        peso = (EditText)findViewById(R.id.pesoEdtTxt);
        altura = (EditText)findViewById(R.id.alturaEdtTxt);
        idade = (EditText)findViewById(R.id.idadeEdtTxt);


        cadastrar = (Button)findViewById(R.id.cadastrarBtn);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cadastrar();
            }
        });

    }

    /**
     * Insere usuario no banco
     */
    public void Cadastrar()
    {
        Usuario usuario = new Usuario();
        if(!checkNullOrEmpty(nome)) return;
        if(!checkNullOrEmpty(sobrenome)) return;
        if(!checkNullOrEmpty(idade)) return;
        if(!checkNullOrEmpty(peso)) return;
        if(!checkNullOrEmpty(altura)) return;

        usuario.setNome(extractStr(nome));
        usuario.setSobreNome(extractStr(sobrenome));
        usuario.setPeso( Integer.valueOf(extractStr(peso)));
        usuario.setAltura( Float.valueOf(extractStr(altura)));
        usuario.setIdade( Integer.valueOf(extractStr(idade)));

        UsuarioDAO usuarioDAO = new UsuarioDAO(getApplicationContext());
        usuario.setId((int)usuarioDAO.inserir(usuario));

        Intent intent = new Intent();
        intent.putExtra("usuario_id", usuario.getId());
        setResult(InicioActivity.RESULT_USER_ID, intent);

        finish();


    }

    /**
     * Verifica se o EditText foi preenchido, e avisa o usuário da obrigatoriedade
     *
     * @param edttxt the edttxt
     * @return boolean boolean
     */
    public  boolean checkNullOrEmpty(EditText edttxt)
    {
        if(edttxt.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext() , "Campo (" +edttxt.getHint().toString()+ ") obrigatório", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    /**
     * Extrai a string do EditText
     *
     * @param edttxt the edttxt
     * @return string string
     */
    public  String extractStr(EditText edttxt)
    {
        return edttxt.getText().toString();
    }
}
