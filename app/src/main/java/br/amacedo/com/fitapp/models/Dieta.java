package br.amacedo.com.fitapp.models;

import java.util.Date;
import java.util.List;

/**
 * Created by Anderson Macedo on 20/04/2017.
 */

public class Dieta
{
    private Date inicio;
    private Date fim;
    private int pesoInicio;
    private int pesoDesejado;
    private List<Refeicao> refeicoes;
    private String Meta;

    public String getMeta() {
        return Meta;
    }

    public void setMeta(String meta) {
        Meta = meta;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public int getPesoInicio() {
        return pesoInicio;
    }

    public void setPesoInicio(int pesoInicio) {
        this.pesoInicio = pesoInicio;
    }

    public int getPesoDesejado() {
        return pesoDesejado;
    }

    public void setPesoDesejado(int pesoDesejado) {
        this.pesoDesejado = pesoDesejado;
    }

    public List<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(List<Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }


}
