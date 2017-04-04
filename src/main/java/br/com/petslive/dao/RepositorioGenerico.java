/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.dao;

import java.util.List;

/**
 *
 * @author Carlos Eduardo
 */
public interface RepositorioGenerico <T,G> {
    
    public void inserir(T t);
    public void alterar(T t) throws Exception;
    public T recuperar(G g);
    public void deletar(T t);
    public List<T> listarTodos();
    
    
}
