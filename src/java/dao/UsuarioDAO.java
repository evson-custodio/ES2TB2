/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.SQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.CRUD;
import util.JDBC;
import models.Usuario;

/**
 *
 * @author evson
 */
public class UsuarioDAO extends JDBC implements CRUD<Usuario> {

    @Override
    public void create(Usuario usuario) {
        if(usuario != null) {
            try {
                connection.setAutoCommit(false);
                PreparedStatement pst = connection.prepareStatement(SQL.USUARIO_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
                ResultSet rs;

                pst.setString(1, usuario.getNome());
                pst.setString(2, usuario.getSenha());
                pst.setString(3, usuario.getDataNascimento());

                pst.executeUpdate();

                rs = pst.getGeneratedKeys();

                while(rs.next()) {
                    usuario.setID(rs.getInt(1));
                    System.out.println(usuario.getID());
                }

                rs.close();
                pst.close();

                connection.commit();
                connection.setAutoCommit(true);

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

                try {
                    connection.rollback();
                    connection.setAutoCommit(true);
                } catch (SQLException ex1) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }

    @Override
    public List<Usuario> read(Usuario usuario) {
        if(usuario != null) {
            try {
                PreparedStatement pst = connection.prepareStatement(SQL.USUARIO_READ_FOR_NOME);
                ResultSet rs;
                ArrayList<Usuario> usuarios = new ArrayList<>();

                pst.setString(1, usuario.getNome());

                rs = pst.executeQuery();

                while(rs.next()) {
                    usuarios.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                }

                rs.close();
                pst.close();

                return usuarios;

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return null;
    }

    @Override
    public void update(Usuario usuario) {
        if(usuario != null && usuario.getID() != null) {
            try {
                connection.setAutoCommit(false);
                PreparedStatement pst = connection.prepareStatement(SQL.USUARIO_UPDATE_FOR_ID);

                pst.setString(1, usuario.getNome());
                pst.setString(2, usuario.getSenha());
                pst.setString(3, usuario.getDataNascimento());
                pst.setInt(4, usuario.getID());

                pst.executeUpdate();

                pst.close();

                connection.commit();
                connection.setAutoCommit(true);

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

                try {
                    connection.rollback();
                    connection.setAutoCommit(true);
                } catch (SQLException ex1) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }

    @Override
    public void delete(Usuario usuario) {
        if(usuario != null && usuario.getID() != null) {
            try {
                connection.setAutoCommit(false);
                PreparedStatement pst = connection.prepareStatement(SQL.USUARIO_DELETE_FOR_ID);

                pst.setInt(1, usuario.getID());

                pst.executeUpdate();

                pst.close();

                connection.commit();
                connection.setAutoCommit(true);

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

                try {
                    connection.rollback();
                    connection.setAutoCommit(true);
                } catch (SQLException ex1) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }
    
}
