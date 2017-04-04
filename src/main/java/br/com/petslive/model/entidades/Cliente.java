/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.model.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Carlos Eduardo
 */

@Entity
@Table (name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue
    @Column (name = "id_cliente", nullable = false)
    private int id_cliente;
    @Column (name = "nome_cliente", nullable = false, length = 100)
    private String nome_cliente;
    @Column (name = "cpf", nullable = false)
    private long cpf;
    @Column (name = "endereco", nullable = false, length = 100)
    private String endereco;
    @Column (name = "telefone_fixo", length = 20)
    private String telefone_fixo;
    @Column (name = "celular",  length = 50)
    private String celular;
    @Column (name = "genero", length = 1)
    private char genero;
    @Column (name = "email", unique = true,  length = 50)
    private String email;
    @Column (name = "senha", length = 8)
    private String senha;
    @OneToMany (mappedBy = "dono", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Animal> animais;
    

    @Deprecated
    public Cliente(){
   
        this.animais = new ArrayList<Animal>();
    }

    public Cliente(int id_cliente, String nome_cliente, long cpf, String endereco, String telefone_fixo, String celular, char genero, String email, String senha, List<Animal> animais) {
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone_fixo = telefone_fixo;
        this.celular = celular;
        this.genero = genero;
        this.email = email;
        this.senha = senha;
        this.animais = animais;
    }


    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the nome_cliente
     */
    public String getNome_cliente() {
        return nome_cliente;
    }

    /**
     * @param nome_cliente the nome_cliente to set
     */
    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    /**
     * @return the cpf
     */
    public long getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefone_fixo
     */
    public String getTelefone_fixo() {
        return telefone_fixo;
    }

    /**
     * @param telefone_fixo the telefone_fixo to set
     */
    public void setTelefone_fixo(String telefone_fixo) {
        this.telefone_fixo = telefone_fixo;
    }

    /**
     * @return the genero
     */
    public char getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * @return the animais
     */
    public List<Animal> getAnimais() {
        return animais;
    }

    /**
     * @param animais the animais to set
     */
    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
