/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author evson
 */
public interface SQL {
    public static final String USUARIO_LAST_ID = "select last_insert_id() as last_id from Usuario;";
    public static final String USUARIO_CREATE = "insert into Usuario(nome, senha, dataNascimento) values(?, ?, ?);";
    public static final String USUARIO_READ_FOR_NOME = "select * from Usuario where nome = ?;";
    public static final String USUARIO_UPDATE_FOR_ID = "update Usuario set nome = ?, senha = ?, dataNascimento = ? where idUsuario = ?;";
    public static final String USUARIO_DELETE_FOR_ID = "delete from Usuario where idUsuario = ?;";
}
