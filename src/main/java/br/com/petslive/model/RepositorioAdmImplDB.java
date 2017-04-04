/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.model;

import br.com.petslive.dao.DaoManagerHiber;
import br.com.petslive.dao.RepositorioGenerico;
import br.com.petslive.model.entidades.Administrador;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Carlos Eduardo
 */
public class RepositorioAdmImplDB implements RepositorioGenerico<Administrador, Integer> {

    DaoManagerHiber dao = DaoManagerHiber.getInstance();
    
    @Override
    public void inserir(Administrador t) {
        dao.persist(t);
    }

    @Override
    public void alterar(Administrador t) throws Exception {
        dao.update(t);
    }

    @Override
    public Administrador recuperar(Integer g) {
        try{
        return ((Administrador)dao.recover("from Administrador where id_adm="+g).get(0));
        }catch(IndexOutOfBoundsException  ex){
            return null;
        }
    }

    @Override
    public void deletar(Administrador t) {
       dao.delete(t);
    }

    @Override
    public List<Administrador> listarTodos() {
        return dao.recover("from Administrador");
    }
    
      public boolean validaEmail(String email){
          boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
    
    public Administrador validaLoginA(String email, String senha){
       
        String sql = "from Administrador where email = '" +email+ "' and senha = '" +senha+ "'";
        
       try{
           return ((List<Administrador>)dao.recover(sql)).get(0);
         }catch(IndexOutOfBoundsException  ex){
            return null;
        }
    }
    
    
}
