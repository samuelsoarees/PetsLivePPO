/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.web.builderbean;


import br.com.petslive.model.entidades.Administrador;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Carlos Eduardo
 */
@ManagedBean (name="bAdm")
@RequestScoped
public class BuilderAdm {
    
    private int id_adm;
    private String nome_adm;
    private String cpf;
    private String email;
    private String senha;
    
    @Deprecated
    public BuilderAdm(){}

    public int getId_adm() {
        return id_adm;
    }

    public void setId_adm(int id_adm) {
        this.id_adm = id_adm;
    }

    public String getNome_adm() {
        return nome_adm;
    }

    public void setNome_adm(String nome_adm) {
        this.nome_adm = nome_adm;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Administrador builderAdm(){
        return new Administrador(nome_adm, cpf, email, senha);
    }
}
