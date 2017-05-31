package br.amacedo.com.fitapp.models;

import java.util.Date;
import java.util.List;

/**
 * Created by Anderson Macedo on 20/04/2017.
 * Bean : Dieta
 */
public class Dieta
{
    private Date inicio;
    private Date fim;
    private int pesoInicio;
    private int pesoDesejado;
    private List<Refeicao> refeicoes;
    private String Meta;

    /**
     * Gets meta.
     *
     * @return the meta
     */
    public String getMeta() {
        return Meta;
    }

    /**
     * Sets meta.
     *
     * @param meta the meta
     */
    public void setMeta(String meta) {
        Meta = meta;
    }

    /**
     * Gets inicio.
     *
     * @return the inicio
     */
    public Date getInicio() {
        return inicio;
    }

    /**
     * Sets inicio.
     *
     * @param inicio the inicio
     */
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    /**
     * Gets fim.
     *
     * @return the fim
     */
    public Date getFim() {
        return fim;
    }

    /**
     * Sets fim.
     *
     * @param fim the fim
     */
    public void setFim(Date fim) {
        this.fim = fim;
    }

    /**
     * Gets peso inicio.
     *
     * @return the peso inicio
     */
    public int getPesoInicio() {
        return pesoInicio;
    }

    /**
     * Sets peso inicio.
     *
     * @param pesoInicio the peso inicio
     */
    public void setPesoInicio(int pesoInicio) {
        this.pesoInicio = pesoInicio;
    }

    /**
     * Gets peso desejado.
     *
     * @return the peso desejado
     */
    public int getPesoDesejado() {
        return pesoDesejado;
    }

    /**
     * Sets peso desejado.
     *
     * @param pesoDesejado the peso desejado
     */
    public void setPesoDesejado(int pesoDesejado) {
        this.pesoDesejado = pesoDesejado;
    }

    /**
     * Gets refeicoes.
     *
     * @return the refeicoes
     */
    public List<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    /**
     * Sets refeicoes.
     *
     * @param refeicoes the refeicoes
     */
    public void setRefeicoes(List<Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }


}
