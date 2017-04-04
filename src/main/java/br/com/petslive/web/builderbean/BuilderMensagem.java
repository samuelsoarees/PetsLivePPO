/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.web.builderbean;

import br.com.petslive.model.entidades.Medico;
import br.com.petslive.model.entidades.Mensagem;
import br.com.petslive.model.entidades.Prontuario;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Carlos Eduardo
 */

@ManagedBean (name="bMensagem")
@RequestScoped
public class BuilderMensagem {
        
        private int id_msg;
        private String mensagem;
        private Timestamp hora;
        private Medico medico;
        private Prontuario prontuario;
    
    @Deprecated
    public BuilderMensagem(){
        this.medico = new Medico();
        this.prontuario = new Prontuario();
    }

     public int getId_msg() {
        return id_msg;
    }

    public void setId_msg(int id_msg) {
        this.id_msg = id_msg;
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Timestamp getHora() {
        return hora;
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

   

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
    
    
    
    public Mensagem builderMensagem(){
        return new Mensagem(id_msg, mensagem, hora, medico, prontuario);
    }   
    
    
}
