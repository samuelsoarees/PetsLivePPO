/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.controladores;

import br.com.petslive.dao.RepositorioGenerico;
import br.com.petslive.model.FabricaRepositorio;
import br.com.petslive.model.RepositorioClienteImplDB;
import br.com.petslive.model.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Carlos Eduardo
 */

@ManagedBean (name="controleCliente")
@SessionScoped 
public class ControladorCliente {
 
    private RepositorioGenerico<Cliente, Integer> repositorioCliente = null;
    private RepositorioClienteImplDB rc = null;
    private Cliente selectedCliente = null;
    private ArrayList<Cliente> cliente;
    
    public ControladorCliente(){
        this.rc = new RepositorioClienteImplDB();
        this.repositorioCliente = FabricaRepositorio.criarRepositorio(FabricaRepositorio.CLIENTE, FabricaRepositorio.DB);
        cliente = new ArrayList<Cliente>();
        
    }
    
    
    public String inserirCliente(Cliente c){
        
        boolean a = true;
        
         if (!rc.validaEmail(c.getEmail())) {
            a = false;
            FacesContext.getCurrentInstance().addMessage("formularioDeCliente:email",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Email deve ser preenchido corretamente"));
        }
        
         if(!rc.validaEmailIgual(c.getEmail())){
            
             a = false;
             
            FacesContext.getCurrentInstance().addMessage("formularioDeCliente:email",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Este email já foi cadastrado"));
             
         }
         
      
        if(a){        
        
        this.repositorioCliente.inserir(c);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage (  "Cliente cadastrado!"));
        return "cadastroAnimal.xhtml";
        }
        return null;
    }
    
    public String alterarCliente (Cliente c){
        try{
            this.repositorioCliente.alterar(c);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente alterado com sucesso!"));
        }catch(Exception ex){
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "listaCliente.xhtml";
        
    }
    
    public Cliente recuperarClienteId(Integer id){
        return this.repositorioCliente.recuperar(id);
    }
    public void deletarCliente(Cliente c){
        this.repositorioCliente.deletar(c);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage (  "Cliente excluido!"));
    }
    public List<Cliente> listarTodos(){
        return this.repositorioCliente.listarTodos();
    }
    public Cliente getSelectedCliente(){
        return selectedCliente;
    }
    public void setSelectedCliente(Cliente selectedCliente){
        this.selectedCliente = selectedCliente;
    }
    
    
    
}
