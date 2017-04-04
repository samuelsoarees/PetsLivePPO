/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.web.builderbean;

import br.com.petslive.model.entidades.Animal;
import br.com.petslive.model.entidades.Cliente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Carlos Eduardo
 */
@ManagedBean (name="bCliente")
@RequestScoped
public class BuilderCliente {
    
    private int id_cliente;
    private String nome_cliente;
    private long cpf;
    private String endereco;
    private String telefone_fixo;
    private String celular;
    private char genero;
    private String email;
    private String senha;
    private List<Animal> animais;
    
    @Deprecated
    public BuilderCliente(){}
    
     public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
        
    }
    
    public String getNome_cliente(){
        return nome_cliente;
    }
    
    public void setNome_cliente(String nome_cliente){
        this.nome_cliente = nome_cliente;
        
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
    
    public String getTelefone_fixo(){
        return telefone_fixo;
    }
    
    public void setTelefone_fixo(String telefone_fixo){
        this.telefone_fixo = telefone_fixo;
    
    }
    
    public String getCelular(){
        return celular;
    }
    
    public void setCelular(String celular){
        this.celular = celular;
        
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
    
    
     public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
        
    }
            
     public Cliente builderCliente(){
        return new Cliente(id_cliente, nome_cliente, cpf, endereco, telefone_fixo, celular, genero, email, senha, animais);
    }



}
