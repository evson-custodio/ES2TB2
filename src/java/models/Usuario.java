/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author evson
 */
public class Usuario {
    private Integer ID;
    private String nome;
    private String senha;
    private String dataNascimento;

    public Usuario() {
    }
    
    public Usuario(String nome, String senha, String dataNascimento) {
        this.ID = null;
        this.nome = nome;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public Usuario(Integer ID, String nome, String senha, String dataNascimento) {
        this.ID = ID;
        this.nome = nome;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "ID: " + this.ID + " Nome: " + this.nome + " Senha: " + this.senha + " Data de Nascimento: " + this.dataNascimento;
    }
}
