package br.amacedo.com.fitapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.amacedo.com.fitapp.db.AlimentoDAO;
import br.amacedo.com.fitapp.models.Alimento;
import br.amacedo.com.fitapp.models.Refeicao;

/**
 * The type Alimento activity.
 */
public class AlimentoActivity extends AppCompatActivity {

    /**
     * The Lstvw alimentos.
     */
    ListView lstvwAlimentos;
    /**
     * The Alimentos.
     */
    List<Alimento> alimentos;

    private int refeicaoID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimento);

        AlimentoHttp alimentoHttp = new AlimentoHttp();
        List<Alimento> alimentos;
        ArrayAdapter<Alimento> alimentoArrayAdapter;
        lstvwAlimentos = (ListView)findViewById(R.id.lstvwAlimento);

        refeicaoID = getIntent().getIntExtra("refeicao_id", 0);

        BaixarAlimentos baixarAlimentos = new BaixarAlimentos(this);

        try {
            baixarAlimentos.execute( getApplicationContext()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if(this.alimentos == null)
        {
            finish();
        }else
        {
            alimentoArrayAdapter = new ArrayAdapter<Alimento>(this, android.R.layout.simple_list_item_1, this.alimentos);
            lstvwAlimentos.setAdapter(alimentoArrayAdapter);
            lstvwAlimentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Alimento alimento  = (Alimento)adapterView.getItemAtPosition(i);
                    AlimentoDAO alimentoDAO = new AlimentoDAO(getApplicationContext());
                    alimentoDAO.inserir(alimento, refeicaoID);
                    finish();
                }
            });
        }


    }

    /**
     * Sets alimentos.
     *
     * @param alimentos the alimentos
     */
    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }
}
