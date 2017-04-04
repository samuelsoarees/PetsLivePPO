/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.controladores;

import br.com.petslive.dao.RepositorioGenerico;
import br.com.petslive.model.FabricaRepositorio;
import br.com.petslive.model.entidades.Animal;
import br.com.petslive.model.entidades.Prontuario;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Carlos Eduardo
 */
@ManagedBean (name = "controleProntuario")
@SessionScoped
public class ControladorProntuario {
    
    private RepositorioGenerico<Prontuario, Integer> repositorioPront = null;
    private RepositorioGenerico<Animal, Integer> repositorioAnimal = null; 
    private Prontuario selectedProntuario = null; 
    private ArrayList<Prontuario> prontuario; 
    
    
    public ControladorProntuario(){
        this.repositorioPront = FabricaRepositorio.criarRepositorio(FabricaRepositorio.PRONTUARIO, FabricaRepositorio.DB);
       this.repositorioAnimal = FabricaRepositorio.criarRepositorio(FabricaRepositorio.ANIMAL, FabricaRepositorio.DB);
        prontuario = new ArrayList<Prontuario>();
    }
    
    
    
      public String inserirProntuario(Animal a) throws Exception{
          Calendar cal = Calendar.getInstance();
          Timestamp data = new Timestamp(cal.getTimeInMillis());
          
          
          Prontuario p= new Prontuario();
          
          p.setAnimal(a);
          p.setData(data);
          a.getProntuario().add(p);
          this.repositorioPront.inserir(p);
          this.repositorioAnimal.alterar(a);
          
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage ( "O Prontuario foi criado com sucesso!", ""));
          
          return "prontuarioMedico.xhtml";
    }
    public String alterarProntuario(Prontuario p) throws Exception {
        
        this.repositorioPront.alterar(p);
      
        return "index.xhtml";
    }
    public  Prontuario recuperarProntuario(Integer id){
        return this.repositorioPront.recuperar(id);
    }
    public void deletarProntuario(Prontuario p){
        this.repositorioPront.deletar(p);
        
    }
    public List<Prontuario> listarTodos(){
        return this.repositorioPront.listarTodos();    
    }
    public Prontuario getSelectedProntuario(){
        return selectedProntuario;
    }
    public void setSelectedProntuario(Prontuario selectedProntuario){
        this.selectedProntuario = selectedProntuario;
    }
     
}
