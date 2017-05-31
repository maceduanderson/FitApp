package br.amacedo.com.fitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import br.amacedo.com.fitapp.db.AlimentoDAO;
import br.amacedo.com.fitapp.db.RefeicaoDAO;
import br.amacedo.com.fitapp.models.Alimento;
import br.amacedo.com.fitapp.models.Refeicao;

/**
 * The type Refeicao edit.
 */
public class RefeicaoEdit extends AppCompatActivity {

    /**
     * The Txtvw tipo.
     */
    TextView txtvwTipo;
    /**
     * The Txtvw data.
     */
    TextView txtvwData;
    /**
     * The Txtvw alimento info.
     */
    TextView txtvwAlimentoInfo;
    /**
     * The Btn novo alimento.
     */
    Button btnNovoAlimento;
    /**
     * The Alimentos.
     */
    List<Alimento> alimentos;
    /**
     * The Calorias.
     */
    int calorias = 0;
    /**
     * The Refeicao id.
     */
    int refeicao_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refeicao_edit);

        refeicao_id = getIntent().getIntExtra("refeicao_id", 0);
        Refeicao refeicao = new Refeicao();

        String format = "dd/MM/yy";
        android.icu.text.SimpleDateFormat sdf = new android.icu.text.SimpleDateFormat(format, Locale.US);

        try {
            refeicao = new RefeicaoDAO(getApplicationContext()).getRefeicao(refeicao_id);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        txtvwTipo = (TextView) findViewById(R.id.txtvwTipoRefEdti);
        txtvwData = (TextView) findViewById(R.id.txtvwDataRefEdit);

        txtvwData.setText(sdf.format(refeicao.getDataHora()));
        txtvwTipo.setText(refeicao.getTipo());

        txtvwAlimentoInfo = (TextView) findViewById(R.id.txtvwInfoAlim);
        try {
            updateAlimentosInfo(txtvwAlimentoInfo, refeicao_id);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        btnNovoAlimento = (Button)findViewById(R.id.btnNovoAlimento);
        btnNovoAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlimentoActivity.class);
                intent.putExtra("refeicao_id", refeicao_id);
                startActivity(intent);
            }
        });


    }

    /**
     * Atualiza a tela com os alimentos inseridos
     *
     * @param txtvw       the txtvw
     * @param refeicao_id the refeicao id
     * @throws ParseException the parse exception
     */
    void updateAlimentosInfo(TextView txtvw, int refeicao_id) throws ParseException {
        int calorias = 0;
        String aux = "";
        List<Alimento> alimentos = new ArrayList<Alimento>();
        AlimentoDAO alimentoDAO = new AlimentoDAO(getApplicationContext());

        alimentos = alimentoDAO.listar(refeicao_id);

        for (Alimento alimento: alimentos)
        {
            calorias += alimento.getCalorias();
            aux = aux + ("Nome : " + alimento.getNome() + "\n" +
                       "Tipo : " + alimento.getTipo() + "\n" +
                       "Calorias : " + alimento.getCalorias() + "\n");
            aux = aux +  android.text.TextUtils.join("", Collections.nCopies(txtvw.getLineHeight(), "-"));
            aux += "\n";
        }

        if(calorias > 0)
        {
            txtvw.setText("Total de Calorias : " + String.valueOf(calorias) + "\n\n" + aux );
        }else txtvw.setText(aux);
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            updateAlimentosInfo(txtvwAlimentoInfo, refeicao_id);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
