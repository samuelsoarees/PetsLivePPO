/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.web.builderbean;

import br.com.petslive.model.entidades.Animal;
import br.com.petslive.model.entidades.Cliente;
import br.com.petslive.model.entidades.Prontuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Carlos Eduardo
 */
@ManagedBean (name = "bAnimal")
@RequestScoped
public class BuilderAnimal {
    
     private int id_animal;
    private String nome_animal;
    private String especie;
    private String raca;
    private int idade;
    private char sexo;
    private Cliente dono;
    private List<Prontuario> prontuario;
    
    @Deprecated
    public BuilderAnimal(){
    this.dono = new Cliente();
    }
    
     public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
        
    }
    
    public String getNome_animal(){
        return nome_animal;
    }
    
    public void setNome_animal(String nome_animal){
        this.nome_animal = nome_animal;
        
    }
    
    public String getEspecie(){
        return especie;
    }
    
    public void setEspecie(String especie){
        this.especie = especie;
        
    }
    
    public String getRaca(){
        return raca;
    }
    
    public void setRaca(String raca){
        this.raca = raca;
        
    }
    
    public int getIdade(){
        return idade;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
        
    }
    
    public char getSexo(){
        return sexo;
    }
    
    public void setSexo(char sexo){
        this.sexo = sexo;
        
    }
    
    public Cliente getDono(){
        return dono;
    }
    
    public void setDono(Cliente dono){
        this.dono = dono;
        
    }

    public List<Prontuario> getProntuario() {
        return prontuario;
    }

    public void setProntuario(List<Prontuario> prontuario) {
        this.prontuario = prontuario;
    }
    
    
    public Animal builderAnimal() throws Exception{
        return new Animal(id_animal, nome_animal, especie, raca, idade, sexo, dono, prontuario);
    }
    
    
    
    
    
    
}
