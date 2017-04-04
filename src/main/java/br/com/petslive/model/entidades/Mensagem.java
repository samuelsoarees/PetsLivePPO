/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.model.entidades;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;



/**
 *
 * @author Carlos Eduardo
 */

@Entity
@Table (name = "Mensagem")
public class Mensagem {
     
    @Id
    @GeneratedValue
    @Column (name = "id_msg", nullable = false)
    private int id_msg;
    @Column (name = "mensagem")
    private String mensagem;
    @Column (name = "hora")
    private Timestamp hora;
    @OneToOne 
    @JoinColumn(name="id_medico")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "id_prontuario")
    private Prontuario prontuario;
    
    @Deprecated
    public Mensagem(){}
    
    public Mensagem(int id_msg, String mensagem, Timestamp hora, Medico medico,Prontuario prontuario){
        
        this.id_msg = id_msg;
        this.mensagem = mensagem;
        this.hora = hora;
        this.medico = medico;
        this.prontuario = prontuario;
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
    
    
}
