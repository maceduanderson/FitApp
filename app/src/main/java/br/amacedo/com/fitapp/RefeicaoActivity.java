package br.amacedo.com.fitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.amacedo.com.fitapp.db.RefeicaoDAO;
import br.amacedo.com.fitapp.models.Refeicao;

/**
 * The type Refeicao activity.
 */
public class RefeicaoActivity extends Activity
{

    /**
     * The Lstvw refs.
     */
    ListView lstvwRefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refeicao);

        int userid = getIntent().getIntExtra("usuario_id", 0);
        List<Refeicao> refeicoes = new ArrayList<>();
        ArrayAdapter<Refeicao> refsAdapter;
        RefeicaoDAO refDAO = new RefeicaoDAO(getApplicationContext());

        try {
            refeicoes = refDAO.listar(userid);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lstvwRefs = (ListView) findViewById(R.id.lstvwRefs);
        refsAdapter = new ArrayAdapter<Refeicao>(this, android.R.layout.simple_list_item_1, refeicoes);
        lstvwRefs.setAdapter(refsAdapter);
        lstvwRefs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Refeicao refeicao = (Refeicao)adapterView.getItemAtPosition(i);
                Intent intent = new Intent(getApplicationContext(), RefeicaoEdit.class);
                intent.putExtra("refeicao_id", refeicao.getId());
                startActivity(intent);
            }
        });

    }

}
