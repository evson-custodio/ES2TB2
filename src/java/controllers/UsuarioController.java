/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.UsuarioDAO;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import models.Usuario;

/**
 *
 * @author evson
 */
@ManagedBean(name = "usuarioController")
@ApplicationScoped
public class UsuarioController {
    private String nome;
    private String senha;
    private String dataNascimento;
    private UsuarioDAO dao = new UsuarioDAO();
    private Usuario usuario;

    public UsuarioController() {
        
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

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public Integer getUsuarioID() {
        return this.usuario.getID();
    }
    
    public String getUsuarioNome() {
        return this.usuario.getNome();
    }
    
    public String getUsuarioSenha() {
        return this.usuario.getSenha();
    }
    
    public String getUsuarioDataNascimento() {
        return this.usuario.getDataNascimento();
    }
    
    public String logar() {
        List<Usuario> usuarios = dao.read(new Usuario(nome, null, null));
        
        this.usuario = (usuarios != null && usuarios.size() > 0) ? usuarios.get(0) : null;
        
        if(this.usuario != null && this.usuario.getSenha().equals(senha)) {
            return "listar";
        }
        
        return null;
    }
    
    public String cadastrar() {
        this.usuario = new Usuario(nome, senha, dataNascimento);
        
        dao.create(usuario);
        
        return "index";
    }
    
    public String alterar() {
        this.usuario.setNome(nome);
        this.usuario.setSenha(senha);
        this.usuario.setDataNascimento(dataNascimento);
        
        dao.update(usuario);
        
        return "listar";
    }
}
