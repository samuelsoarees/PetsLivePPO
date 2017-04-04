/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.controladores;

import br.com.petslive.model.RepositorioClienteImplDB;
import br.com.petslive.model.RepositorioMedicoImplDB;
import br.com.petslive.model.entidades.Cliente;
import br.com.petslive.model.entidades.Medico;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Carlos Eduardo
 */
@ManagedBean (name="controleLogin")
@SessionScoped 
public class ControladorLogin {

    private String email;
    private String senha;
    private RepositorioClienteImplDB rc;
    private RepositorioMedicoImplDB rm;
    
    @PostConstruct
    public void construir(){
        this.rc = new RepositorioClienteImplDB();
        this.rm = new RepositorioMedicoImplDB();
    }
    
    public String fazerLogin(){
       
        
        Cliente c =this.rc.validaLoginC(email, senha);
        
         String ret="";
    
         if(c != null){
            this.setClienteLogado(c);
            ret="indexCliente.xhtml";
        }else{
            
            Medico m = this.rm.validaLoginM(email, senha);
            
            if(m != null){
                this.setMedicoLogado(m);
                ret="index.xhtml";
            }else{
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Falha no Login","Email ou senha invalidos"));
            }
        }
        
        
        return ret;
    }
      
    public String fazerLogout(){
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
         return "loginPetsLive.xhtml";
    
    }
    
    
    
    
    
    private void setClienteLogado(Cliente c){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ClienteLogado", c);
    }
    
    private void setMedicoLogado(Medico m){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("MedicoLogado", m);
    }
    
    
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

  
    
}
