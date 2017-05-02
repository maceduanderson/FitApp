package br.amacedo.com.fitapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.util.Locale;

import br.amacedo.com.fitapp.db.DietaDAO;
import br.amacedo.com.fitapp.models.Dieta;

public class NovaDieta extends Activity {

    EditText edttxtDateNow, edttxtDateEnd, edttxtPesoInicio, edttxtPesoFim;
    Spinner meta;
    Button btnSave;

    final Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(year, month, dayOfMonth);
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_dieta);
        edttxtDateNow = (EditText)findViewById(R.id.edttxtDateNow);
        edttxtDateEnd = (EditText)findViewById(R.id.edttxtDateEnd);
        edttxtPesoInicio = (EditText)findViewById(R.id.edttxtPesoAtual);
        edttxtPesoFim = (EditText)findViewById(R.id.edttxtPesoDesejado);

        meta = (Spinner) findViewById(R.id.spnMeta);
        btnSave = (Button) findViewById(R.id.btnDietaSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });

        edttxtDateNow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(NovaDieta.this, date,
                                     calendar.get(Calendar.YEAR),
                                     calendar.get(Calendar.MONTH),
                                     calendar.get(Calendar.DAY_OF_MONTH)).show();
                updateLabel(edttxtDateNow);
            }
        });
        edttxtDateEnd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(NovaDieta.this, date,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
                updateLabel(edttxtDateEnd);
            }
        });

    }
    public void cadastrar()
    {
        String format = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        String stdDate;
        Dieta dieta = new Dieta();


        if(checkNullOrEmpty(edttxtDateEnd)) return;
        if(checkNullOrEmpty(edttxtDateNow)) return;
        if(checkNullOrEmpty(edttxtPesoFim)) return;
        if(checkNullOrEmpty(edttxtPesoInicio)) return;

        dieta.setMeta(meta.getSelectedItem().toString());

        try {
            stdDate = edttxtDateNow.getText().toString();
            dieta.setInicio(sdf.parse(stdDate));
            stdDate = edttxtDateEnd.getText().toString();
            dieta.setFim(sdf.parse(stdDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dieta.setPesoDesejado(Integer.valueOf(extractStr(edttxtPesoFim)));
        dieta.setPesoInicio(Integer.valueOf(extractStr(edttxtPesoInicio)));

        Intent intent = new Intent();
        Bundle bundle = intent.getExtras();
        int userId = (int)bundle.get("usuario_id");

        DietaDAO dietaDAO = new DietaDAO(getApplicationContext());
        int dietaId = (int) dietaDAO.inserir(dieta, userId);

        intent.putExtra("dieta_id", dietaId);
        setResult(InicioActivity.RESULT_DIETA_ID, intent);

        finish();
    }
    public  boolean checkNullOrEmpty(EditText edttxt)
    {
        if(edttxt.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext() , "Campo (" +edttxt.getHint().toString()+ ") obrigatório", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    public  String extractStr(EditText edttxt)
    {
        return edttxt.getText().toString();
    }

    void updateLabel(EditText edtTxt)
    {
        String format = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        edtTxt.setText(sdf.format(calendar.getTime()));
    }

}
