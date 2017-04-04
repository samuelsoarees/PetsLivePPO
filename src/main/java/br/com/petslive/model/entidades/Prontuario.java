/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.model.entidades;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Carlos Eduardo
 */
@Entity
@Table(name ="Prontuario")
public class Prontuario {
    
    @Id
    @GeneratedValue
    @Column (name = "id_prontuario",nullable = false)
    private int id_prontuario;
    @OneToMany (mappedBy = "prontuario", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL )
    private List<Mensagem>mensagem;
    @ManyToOne
    @JoinColumn (name="id_animal")
    private Animal animal;
    @Column (name="data")
    private Timestamp data;
    
    @Deprecated
    public Prontuario(){
        this.mensagem = new ArrayList<Mensagem>();
    }
 
    public Prontuario(int id_prontuario, List<Mensagem> mensagem,  Animal animal, Timestamp data){
        this.id_prontuario = id_prontuario;
        this.mensagem = mensagem;
        this.animal = animal;
        this.data = data;
    }
    
    
    
    /**
     * @return the id_prontuario
     */
    public int getId_prontuario() {
        return id_prontuario;
    }

    /**
     * @param id_prontuario the id_prontuario to set
     */
    public void setId_prontuario(int id_prontuario) {
        this.id_prontuario = id_prontuario;
        
    }
    
    /**
     * @return the mensagem
     */
    public List<Mensagem> getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(List<Mensagem> mensagem) {
        this.mensagem = mensagem;
    }
    
    /**
     * @return the animal
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * @param animal the animal to set
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Timestamp  getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    
}
