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
    private Date atual;
    private int pesoInicio;
    private int pesoDesejado;
    private int pesoAtual;
    private List<Refeicao> refeicoes;
    protected static String META[] ={"Ganhar Peso", "Perder Peso", "Ganhar Massa Muscular", "Perder Massa Muscular"};

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

    public Date getAtual() {
        return atual;
    }

    public void setAtual(Date atual) {
        this.atual = atual;
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

    public int getPesoAtual() {
        return pesoAtual;
    }

    public void setPesoAtual(int pesoAtual) {
        this.pesoAtual = pesoAtual;
    }

    public List<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(List<Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }

    public static String[] getMETA() {
        return META;
    }

    public static void setMETA(String[] META) {
        Dieta.META = META;
    }
}
