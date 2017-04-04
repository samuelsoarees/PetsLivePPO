/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.controladores;

import br.com.petslive.dao.RepositorioGenerico;
import br.com.petslive.model.FabricaRepositorio;
import br.com.petslive.model.entidades.Mensagem;
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
@ManagedBean (name="controleMensagem")
@SessionScoped
public class ControladorMensagem {


    private RepositorioGenerico<Mensagem, Integer> repositorioMsg = null;
    private RepositorioGenerico<Prontuario, Integer> repositorioProntuario = null;
    private Mensagem selectedMensagem = null; 
    private ArrayList<Mensagem> mensagem; 
    
    public ControladorMensagem(){
        this.repositorioMsg = FabricaRepositorio.criarRepositorio(FabricaRepositorio.MENSAGEM, FabricaRepositorio.DB);
       this.repositorioProntuario = FabricaRepositorio.criarRepositorio(FabricaRepositorio.PRONTUARIO, FabricaRepositorio.DB);
        mensagem = new ArrayList<Mensagem>();
    }
    
    
      public void inserirMensagem(Mensagem m) throws Exception{
        
          Calendar cal = Calendar.getInstance();
          Timestamp hora = new Timestamp(cal.getTimeInMillis());
          
          m.setHora(hora);
          
          Prontuario p = repositorioProntuario.recuperar(m.getProntuario().getId_prontuario());
          p.getMensagem().add(m);
          this.repositorioMsg.inserir(m);
          this.repositorioProntuario.alterar(p);
         
    }
    public void alterarMensagem(Mensagem m) throws Exception {
        this.repositorioMsg.alterar(m);
    }
    
    public  Mensagem recuperarMensagem(Integer id){
        return this.repositorioMsg.recuperar(id);
    }
    
    public void deletarMensagem(Mensagem m){
        this.repositorioMsg.deletar(m);
        
    }
    public List<Mensagem> listarTodos(){
        return this.repositorioMsg.listarTodos();    
    }
    public Mensagem getSelectedMensagem(){
        return selectedMensagem;
    }
    public void setSelectedMensagem(Mensagem selectedMensagem){
        this.selectedMensagem = selectedMensagem;
    }
        
}
