/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.model;


import br.com.petslive.dao.DaoManagerHiber;
import br.com.petslive.dao.RepositorioGenerico;
import br.com.petslive.model.entidades.Cliente;
import br.com.petslive.web.builderbean.BuilderCliente;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Carlos Eduardo
 */
public class RepositorioClienteImplDB implements RepositorioGenerico<Cliente, Integer>{

    DaoManagerHiber dao = DaoManagerHiber.getInstance();
   
    
    @Override
    public void inserir(Cliente c) {
        dao.persist(c);
    }

    @Override
    public void alterar(Cliente c) throws Exception {
        dao.update(c);
    }

    @Override
    public Cliente recuperar(Integer g) {
       try{
        return ((Cliente)dao.recover("from Cliente where id_cliente="+g).get(0));
        }catch(IndexOutOfBoundsException  ex){
            return null;
        }
    }

    @Override
    public void deletar(Cliente c) {
        dao.delete(c);
    }

    @Override
    public List<Cliente> listarTodos() {
        return dao.recover("from Cliente");
    }
    
    public Cliente buscaNome(String nome_cliente){
        String sql="from Cliente where nome_ciente"+nome_cliente;
        
        return (Cliente) dao.recoverSQL(sql);
    }
    
    public boolean validaEmailIgual(String email){
 
        boolean verifica = true;
        
        String sql = "select email from Cliente";
        String sql1 = "select email from Medico";
        
      
        
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
    
    public Cliente validaLoginC(String email, String senha){
        
        String sql = "from Cliente where email ='" +email + "' and senha = '" + senha +"'";
        
        
        try{
        return ((List<Cliente>)dao.recover(sql)).get(0);
        }catch(IndexOutOfBoundsException  ex){
            return null;
        }
    }
    
}
