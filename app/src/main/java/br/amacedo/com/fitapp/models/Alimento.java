package br.amacedo.com.fitapp.models;

/**
 * Created by Anderson Macedo on 20/04/2017.
 */

public class Alimento
{
    private int id;
    private String nome;
    private String tipo;
    private int calorias;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCalorias() {
        return calorias;
    }

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
