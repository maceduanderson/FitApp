package br.amacedo.com.fitapp.models;

import java.util.List;

/**
 * Created by Anderson Macedo on 20/04/2017.
 */

public class Usuario
{
    private int id;
    private String nome;
    private String sobreNome;
    private int idade;
    private int peso;
    private float altura;
    private Dieta dieta;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

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

    public float getIMC()
    {
        return (float)this.peso/(this.altura * this.altura);
    }

    @Override
    public String toString() {
        return this.nome + " " + this.getSobreNome();
    }
}
