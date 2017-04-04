/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.model;

import br.com.petslive.dao.DaoManagerHiber;
import br.com.petslive.dao.RepositorioGenerico;
import br.com.petslive.model.entidades.Animal;
import java.util.List;

/**
 *
 * @author Carlos Eduardo
 */
public class RepositorioAnimalImplDB implements RepositorioGenerico<Animal, Integer>{

    DaoManagerHiber dao = DaoManagerHiber.getInstance();
    
    @Override
    public void inserir(Animal a) {
       
        if(a.getDono().getNome_cliente()!= null){
            RepositorioClienteImplDB repCli = new RepositorioClienteImplDB();
            a.setDono(repCli.buscaNome(a.getDono().getNome_cliente()));
        }
        
        dao.persist(a);
       
    }

    @Override
    public void alterar(Animal a) throws Exception {
        dao.update(a);
    }

    @Override
    public Animal recuperar(Integer g) {
         try{
        return ((Animal)dao.recover("from Animal where id_animal="+g).get(0));
        }catch(IndexOutOfBoundsException  ex){
            return null;
        }
    }

    @Override
    public void deletar(Animal a) {
        dao.delete(a);
    }

    @Override
    public List<Animal> listarTodos() {
        return dao.recover("from Animal");
    }
    
}
