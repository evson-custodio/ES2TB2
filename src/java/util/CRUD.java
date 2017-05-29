/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;

/**
 *
 * @author evson
 * @param <T>
 */
public interface CRUD<T> {
    public void create(T crud);
    public List<T> read(T crud);
    public void update(T crud);
    public void delete(T crud);
}
