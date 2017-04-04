/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.controladores;

import br.com.petslive.dao.RepositorioGenerico;
import br.com.petslive.model.entidades.Administrador;
import br.com.petslive.model.FabricaRepositorio;
import br.com.petslive.model.RepositorioAdmImplDB;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Carlos Eduardo
 */
@ManagedBean (name="controleAdm")
@SessionScoped
public class ControladorAdm {
    
    private RepositorioGenerico<Administrador, Integer> repositorioAdm = null;
    private RepositorioAdmImplDB ra = null;
    private Administrador selectedAdm = null;
    
    public ControladorAdm(){
        this.repositorioAdm = FabricaRepositorio.criarRepositorio(FabricaRepositorio.ADM, FabricaRepositorio.DB);
        this.ra = new RepositorioAdmImplDB();
    }
    
    public void inserirAdm(Administrador ad){}
    
    public String alterarAdm (Administrador ad){
       
        boolean a = true;
        
        /*if(!ra.validaEmail(ad.getEmail)){
            a = false;
             FacesContext.getCurrentInstance().addMessage("formularioAlteraMedico:email",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Email deve ser preenchido corretamente"));
        }*/
        
//        if(a){
//        
//            try{
//            this.repositorioMedico.alterar(m);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Medico alterado com sucesso!"));
//        }catch(Exception ex){
//            Logger.getLogger(ControladorMedico.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return "listaMedico.xhtml";
//        }
        return null;
    }
    
    public Administrador recuperarAdmId(Integer id){
        return this.repositorioAdm.recuperar(id);
    }
    public void deletarAdm(Administrador ad){
        this.repositorioAdm.deletar(ad);
    }
    public List<Administrador> listarTodos(){
        return this.repositorioAdm.listarTodos();
    }
    public Administrador getSelectedAdm(){
        return selectedAdm;
    }
    public void setSelectedAdm(Administrador selectedAdm){
        this.selectedAdm = selectedAdm;
    }
   
    
}
