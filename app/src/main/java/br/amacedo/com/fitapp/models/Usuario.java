package br.amacedo.com.fitapp.models;

import java.util.List;

/**
 * Created by Anderson Macedo on 20/04/2017.
 */

public class Usuario
{
    private String nome;
    private String sobreNome;
    private int idade;
    private int peso;
    private float altura;
    private List<Dieta> dieta;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public List<Dieta> getDieta() {
        return dieta;
    }

    public void setDieta(List<Dieta> dieta) {
        this.dieta = dieta;
    }
}
