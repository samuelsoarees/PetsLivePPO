/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.model.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Carlos Eduardo
 */

@Entity
@Table (name = "Animal")
public class Animal {
    
     @Id
    @GeneratedValue
    @Column (name = "id_animal",nullable = false)
    private int id_animal;
    @Column (name = "nome_animal", nullable = false, length = 50)
    private String nome_animal;
    @Column (name = "especie", length = 50)
    private String especie;
    @Column (name = "raca", length = 50)
    private String raca;
    @Column (name = "idade") 
    private int idade;
    @Column (name = "sexo")
    private char sexo;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente dono;
    @OneToMany (mappedBy = "animal", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL )
    private List<Prontuario> prontuario;
    
    public Animal(int id_animal, String nome, String especie, String raca, int idade, char sexo, Cliente dono, List<Prontuario> prontuario){
        this.id_animal = id_animal;
        this.nome_animal = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
        this.dono = dono;
        this.prontuario = prontuario;
    }
    @Deprecated
    public Animal(){
    this.prontuario = new ArrayList<Prontuario>();
    }
    
    
    
    
    
    /**
     * @return the id_animal
     */
    public int getId_animal() {
        return id_animal;
    }

    /**
     * @param id_animal the id_animal to set
     */
    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    /**
     * @return the nome_animal
     */
    public String getNome_animal() {
        return nome_animal;
    }

    /**
     * @param nome_animal the nome_animal to set
     */
    public void setNome_animal(String nome_animal) {
        this.nome_animal = nome_animal;
    }

    /**
     * @return the especie
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * @return the raca
     */
    public String getRaca() {
        return raca;
    }

    /**
     * @param raca the raca to set
     */
    public void setRaca(String raca) {
        this.raca = raca;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the dono
     */
    public Cliente getDono() {
        return dono;
    }

    /**
     * @param dono the dono to set
     */
    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public List<Prontuario> getProntuario() {
        return prontuario;
    }

    public void setProntuario(List<Prontuario> prontuario) {
        this.prontuario = prontuario;
    }
    
    
    

}
