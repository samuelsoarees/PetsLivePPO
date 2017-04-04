/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.model;


import br.com.petslive.dao.DaoManagerHiber;
import br.com.petslive.dao.RepositorioGenerico;
import br.com.petslive.model.entidades.Medico;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Carlos Eduardo
 */
public class RepositorioMedicoImplDB implements RepositorioGenerico<Medico, Integer> {

    DaoManagerHiber dao = DaoManagerHiber.getInstance();
  
    
    @Override
    public void inserir(Medico t) {
        dao.persist(t);
    }

    @Override
    public void alterar(Medico t) throws Exception {
        dao.update(t);
    }

    @Override
    public Medico recuperar(Integer g) {
         try{
        return ((Medico)dao.recover("from Medico where id_medico="+g).get(0));
        }catch(IndexOutOfBoundsException  ex){
            return null;
        }
    }

    @Override
    public void deletar(Medico t) {
        dao.delete(t);
    }

    @Override
    public List<Medico> listarTodos() {
        return dao.recover("from Medico");
    }
    
  public boolean validaEmailIgual(String email){
        boolean verifica = true;
        
        String sql = "select email from Medico";
        String sql1 = "select email from Cliente";
        
      
        
           if( dao.recover(sql).contains(email) ){
            verifica = false;
            }else if(dao.recover(sql1).contains(email)){
                verifica = false;
            }
                    
        return verifica;
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
    
  
    public Medico validaLoginM(String email, String senha){
       
        String sql = "from Medico where email = '" +email+ "' and senha = '" +senha+ "'";
        
       try{
           return ((List<Medico>)dao.recover(sql)).get(0);
         }catch(IndexOutOfBoundsException  ex){
            return null;
        }
    }
    
}
