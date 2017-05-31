package br.amacedo.com.fitapp.models;

import java.util.List;

/**
 * Created by Anderson Macedo on 20/04/2017.
 * <p>
 * Bean : Usuario
 */
public class Usuario
{
    private int id;
    private String nome;
    private String sobreNome;
    private int idade;
    private int peso;
    private float altura;
    private List<Refeicao> refeicao;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id)
    {
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
     * Gets sobre nome.
     *
     * @return the sobre nome
     */
    public String getSobreNome() {
        return sobreNome;
    }

    /**
     * Sets sobre nome.
     *
     * @param sobreNome the sobre nome
     */
    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    /**
     * Gets idade.
     *
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Sets idade.
     *
     * @param idade the idade
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Gets peso.
     *
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Sets peso.
     *
     * @param peso the peso
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Gets altura.
     *
     * @return the altura
     */
    public float getAltura() {
        return altura;
    }

    /**
     * Sets altura.
     *
     * @param altura the altura
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }

    /**
     * Gets imc.
     *
     * @return the imc
     */
    public float getIMC()
    {
        return (float)this.peso/(this.altura * this.altura);
    }

    /**
     * Gets refeicao.
     *
     * @return the refeicao
     */
    public List<Refeicao> getRefeicao() {
        return refeicao;
    }

    /**
     * Sets refeicao.
     *
     * @param refeicao the refeicao
     */
    public void setRefeicao(List<Refeicao> refeicao) {
        this.refeicao = refeicao;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.getSobreNome();
    }
}
