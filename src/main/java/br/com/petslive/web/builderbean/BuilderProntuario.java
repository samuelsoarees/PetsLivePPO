/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.web.builderbean;

import br.com.petslive.model.entidades.Animal;
import br.com.petslive.model.entidades.Cliente;
import br.com.petslive.model.entidades.Medico;
import br.com.petslive.model.entidades.Mensagem;
import br.com.petslive.model.entidades.Prontuario;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Carlos Eduardo
 */
@ManagedBean (name = "bProntuario")
@RequestScoped
public class BuilderProntuario {
    
    private int id_prontuario;
    private List<Mensagem> mensagem;
    private Animal animal;
    private Timestamp data;
    
    @Deprecated
    public BuilderProntuario(){
        this.animal = new Animal();
    }

    public int getId_prontuario() {
        return id_prontuario;
    }

    public void setId_prontuario(int id_prontuario) {
        this.id_prontuario = id_prontuario;
    }
    
    
      public List<Mensagem> getMensagem() {
        return mensagem;
    }

    public void setMensagem(List<Mensagem> mensagem) {
        this.mensagem = mensagem;
        
    }
    
      public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
        
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }
    
    
    public Prontuario builderProntuario(){
        return new Prontuario(id_prontuario, mensagem, animal, data);
    }
    
}
