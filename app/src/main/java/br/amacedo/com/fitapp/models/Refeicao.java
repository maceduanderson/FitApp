package br.amacedo.com.fitapp.models;

import android.icu.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Anderson Macedo on 20/04/2017.
 * <p>
 * Bean : Refeicao
 */
public class Refeicao
{
    private int id;
    private Date dataHora;
    private String tipo;
    private List<Alimento> alimentos;

    /**
     * Gets data hora.
     *
     * @return the data hora
     */
    public Date getDataHora() {
        return dataHora;
    }

    /**
     * Sets data hora.
     *
     * @param dataHora the data hora
     */
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Gets tipo.
     *
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets tipo.
     *
     * @param tipo the tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Gets alimentos.
     *
     * @return the alimentos
     */
    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets alimentos.
     *
     * @param alimentos the alimentos
     */
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
