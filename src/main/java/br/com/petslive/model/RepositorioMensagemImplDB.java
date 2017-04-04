/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.model;

import br.com.petslive.dao.DaoManagerHiber;
import br.com.petslive.dao.RepositorioGenerico;
import br.com.petslive.model.entidades.Mensagem;
import java.util.List;

/**
 *
 * @author Carlos Eduardo
 */
public class RepositorioMensagemImplDB implements RepositorioGenerico<Mensagem, Integer>{

         DaoManagerHiber dao = DaoManagerHiber.getInstance();

    @Override
    public void inserir(Mensagem m) {
        
        dao.persist(m);
    }

    @Override
    public void alterar(Mensagem m) throws Exception {
        dao.update(m);
    }

    @Override
    public Mensagem recuperar(Integer g) {
      try{
        return ((Mensagem)dao.recover("from Mensagem where id_msg="+g).get(0));
        }catch(IndexOutOfBoundsException  ex){
            return null;
        }
    }

    
    @Override
    public void deletar(Mensagem m) {
        dao.delete(m);
    }

    @Override
    public List<Mensagem> listarTodos() {
            return dao.recover("from Mensagem");
    }
 
    
}
