package br.amacedo.com.fitapp.models;

import java.util.Date;
import java.util.List;

/**
 * Created by Anderson Macedo on 20/04/2017.
 */

public class Refeicao
{
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

    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }
}
