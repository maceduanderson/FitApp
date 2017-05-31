package br.amacedo.com.fitapp.models;

/**
 * Created by Anderson Macedo on 20/04/2017.
 * <p>
 * Bean : Alimento
 */
public class Alimento
{
    private int id;
    private String nome;
    private String tipo;
    private int calorias;

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
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * Gets calorias.
     *
     * @return the calorias
     */
    public int getCalorias() {
        return calorias;
    }

    /**
     * Sets calorias.
     *
     * @param calorias the calorias
     */
    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return this.nome + "\n " +
                "Tipo : " + this.tipo + "\n " +
                "Calorias : " + String.valueOf(this.calorias);
    }
}
