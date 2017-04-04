/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.model;

import br.com.petslive.dao.DaoManagerHiber;
import br.com.petslive.dao.RepositorioGenerico;
import br.com.petslive.model.entidades.Prontuario;
import java.util.List;

/**
 *
 * @author Carlos Eduardo
 */
public class RepositorioProntuImplDB implements RepositorioGenerico<Prontuario, Integer>{

     DaoManagerHiber dao = DaoManagerHiber.getInstance();

    @Override
    public void inserir(Prontuario p) {
        
        dao.persist(p);
    }

    @Override
    public void alterar(Prontuario p) throws Exception {
        dao.update(p);
    }

    @Override
    public Prontuario recuperar(Integer g) {
        try{
        return ((Prontuario)dao.recover("from Prontuario where id_prontuario="+g).get(0));
        }catch(IndexOutOfBoundsException  ex){
            return null;
        }
    }
    
    

    @Override
    public void deletar(Prontuario p) {
        dao.delete();
    }

    @Override
    public List<Prontuario> listarTodos() {
         return dao.recover("from Prontuario");
    }
    
}