
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.controladores;

import br.com.petslive.dao.RepositorioGenerico;
import br.com.petslive.model.FabricaRepositorio;
import br.com.petslive.model.RepositorioMedicoImplDB;
import br.com.petslive.model.entidades.Medico;
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
@ManagedBean (name="controleMedico")
@SessionScoped
public class ControladorMedico {
    
    private RepositorioGenerico<Medico, Integer> repositorioMedico = null;
    private RepositorioMedicoImplDB rm = null;
    private Medico selectedMedico = null;
    private ArrayList<Medico> medico;
    
    public ControladorMedico(){
        this.rm = new RepositorioMedicoImplDB();
        this.repositorioMedico = FabricaRepositorio.criarRepositorio(FabricaRepositorio.MEDICO, FabricaRepositorio.DB);
        medico = new ArrayList<Medico>();
        
    }
    
    
    public String inserirMedico(Medico m){
        
        boolean a = true;
        
        if(!rm.validaEmail(m.getEmail())){
            a = false;
             FacesContext.getCurrentInstance().addMessage("formularioDeMedico:email",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Email deve ser preenchido corretamente"));
        }
        
        if(!rm.validaEmailIgual(m.getEmail())){
            a = false;
            FacesContext.getCurrentInstance().addMessage("formularioDeMedico:email",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Este email já foi cadastrado"));
            
        }
        
        if(a){
        this.repositorioMedico.inserir(m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage (  "Medico cadastrado!"));
        return "index.xhtml";
        }
    
        return null;
    }
    
    public String alterarMedico (Medico m){
        try{
            this.repositorioMedico.alterar(m);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Medico alterado com sucesso!"));
        }catch(Exception ex){
            Logger.getLogger(ControladorMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "listaMedico.xhtml";
        
    }
    
    public Medico recuperarMedicoId(Integer id){
        return this.repositorioMedico.recuperar(id);
    }
    public void deletarMedico(Medico m){
        this.repositorioMedico.deletar(m);
    }
    public List<Medico> listarTodos(){
        return this.repositorioMedico.listarTodos();
    }
    public Medico getSelectedMedico(){
        return selectedMedico;
    }
    public void setSelectedMedico(Medico selectedMedico){
        this.selectedMedico = selectedMedico;
    }
   
}
