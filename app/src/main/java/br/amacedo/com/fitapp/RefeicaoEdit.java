package br.amacedo.com.fitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import br.amacedo.com.fitapp.db.RefeicaoDAO;
import br.amacedo.com.fitapp.models.Refeicao;

public class RefeicaoEdit extends AppCompatActivity {

    TextView txtvwTipo;
    TextView txtvwData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refeicao_edit);

        int refeicao_id = getIntent().getIntExtra("refeicao_id", 0);
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

    }
}
