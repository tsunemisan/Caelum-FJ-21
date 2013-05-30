package br.com.caelum.jdbc.modelo;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Thiago
 * Date: 5/26/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Contato {
    private Integer id;
    private String nome;
    private String email;
    private String endereco;
    private Calendar dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
