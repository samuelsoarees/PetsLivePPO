/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.model.entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table ( name= "Medico")
public class Medico {
    
    @Id
    @GeneratedValue
    @Column (name = "id_medico", nullable = false)
    private int id_medico;
    @Column (name = "nome_medico", nullable = false, length = 100)
    private String nome_medico;
    @Column (name = "cpf", nullable = false)
    private long cpf;
    @Column (name = "endereco", nullable = false, length = 100)
    private String endereco;
    @Column (name = "genero", length = 1)
    private char genero;
    @Column (name = "email", length = 50)
    private String email;
    @Column (name = "senha", length = 8)
    private String senha;
    
    @Deprecated
    public Medico(){}

    public Medico(int id_medico, String nome_medico, long cpf, String endereco,char genero, String email, String senha) {
        this.id_medico = id_medico;
        this.nome_medico = nome_medico;
        this.cpf = cpf;
        this.endereco = endereco;
        this.genero = genero;
        this.email = email;
        this.senha = senha;
        
    }

    /**
     * @return the id_medico
     */
    public int getId_medico() {
        return id_medico;
    }

    /**
     * @param id_medico the id_medico to set
     */
    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    /**
     * @return the nome_medico
     */
    public String getNome_medico() {
        return nome_medico;
    }

    /**
     * @param nome_medico the nome_medico to set
     */
    public void setNome_medico(String nome_medico) {
        this.nome_medico = nome_medico;
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
