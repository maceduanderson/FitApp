package br.amacedo.com.fitapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.ParseException;
import java.util.Locale;

import br.amacedo.com.fitapp.db.RefeicaoDAO;
import br.amacedo.com.fitapp.models.Refeicao;

/**
 * The type Nova refeicao.
 */
public class NovaRefeicao extends Activity
{

    /**
     * The Edttxt date ref.
     */
    EditText edttxtDateRef;
    /**
     * The Tipo.
     */
    Spinner tipo;
    /**
     * The Btn save.
     */
    Button btnSave;

    /**
     * The Format.
     */
    String format = "dd/MM/yy";
    /**
     * The Sdf.
     */
    SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);

    /**
     * The Calendar.
     */
    final Calendar calendar = Calendar.getInstance();
    /**
     * The Date.
     */
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(year, month, dayOfMonth);
        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_refeicao);


        edttxtDateRef = (EditText)findViewById(R.id.edttxtdateRef);
        tipo = (Spinner) findViewById(R.id.spnTipo);
        btnSave = (Button) findViewById(R.id.btnRefeicaoSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    salvar();
                    finish();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        edttxtDateRef.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(NovaRefeicao.this, date,
                                     calendar.get(Calendar.YEAR),
                                     calendar.get(Calendar.MONTH),
                                     calendar.get(Calendar.DAY_OF_MONTH)).show();
                updateLabel(edttxtDateRef);
            }
        });

    }

    /**
     * Seta uma data devidamente formatada em um EditText
     *
     * @param edtTxt the edt txt
     */
    void updateLabel(EditText edtTxt)
    {
        edtTxt.setText(sdf.format(calendar.getTime()));
    }

    /**
     * Insere refeição no banco
     *
     * @throws ParseException the parse exception
     */
    void salvar() throws ParseException {

        int userid = getIntent().getIntExtra("usuario_id", 0);

        Refeicao refeicao = new Refeicao();

        refeicao.setDataHora(sdf.parse(edttxtDateRef.getText().toString()));
        refeicao.setTipo(tipo.getSelectedItem().toString());
        RefeicaoDAO refDao = new RefeicaoDAO(getApplicationContext());

        refDao.inserir(refeicao, userid);
    }
}
