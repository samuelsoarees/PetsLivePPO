/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.web.builderbean;

import br.com.petslive.model.entidades.Medico;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Carlos Eduardo
 */
@ManagedBean (name="bMedico")
@RequestScoped
public class BuilderMedico {

    private int id_medico;
    private String nome_medico;
    private long cpf;
    private String endereco;
    private char genero;
    private String email;
    private String senha;
    
    @Deprecated
    public BuilderMedico(){}
        
    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
        
    }
    
    public String getNome_medico(){
        return nome_medico;
    }
    
    public void setNome_medico(String nome_medico){
        this.nome_medico = nome_medico;
    }
    
    public long getCpf(){
        return cpf;
    }
    
    public void setCpf(long cpf){
        this.cpf = cpf;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public char getGenero(){
        return genero;
    }
    
    public void setGenero(char genero){
        this.genero = genero;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public Medico builderMedico(){
        return new Medico(id_medico, nome_medico, cpf, endereco, genero, email, senha);
    }
}
