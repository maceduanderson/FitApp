package br.amacedo.com.fitapp.models;

import android.icu.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Anderson Macedo on 20/04/2017.
 */

public class Refeicao
{
    private int id;
    private Date dataHora;
    private String tipo;
    private List<Alimento> alimentos;

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    @Override
    public String toString() {
        String format = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);

        return tipo + " de (" + sdf.format(this.dataHora) + ")";
    }
}
