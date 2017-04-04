/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petslive.model;

import br.com.petslive.dao.RepositorioGenerico;



/**
 *
 * @author Carlos Eduardo
 */
public class FabricaRepositorio {
    
      public static final int DB = 1;
    public static final int ANIMAL = 1;
    public static final int CLIENTE = 2;
    public static final int MEDICO = 3;
    public static final int PRONTUARIO = 4;
    public static final int MENSAGEM = 5;
    public static final int ADM = 6;
    
    public static RepositorioGenerico criarRepositorio (int tipoNegocio, int tipoPersistencia){
        
        if(tipoNegocio == ANIMAL){
            if(tipoPersistencia == DB){
                return new RepositorioAnimalImplDB();
            }
        }
        if(tipoNegocio == CLIENTE){
            if(tipoPersistencia == DB){
               return new RepositorioClienteImplDB();
            }
        }
        
        if(tipoNegocio == MEDICO){
            if(tipoPersistencia == DB){
                return new RepositorioMedicoImplDB();
            }
        }
        if(tipoNegocio == PRONTUARIO){
            if(tipoPersistencia == DB){
                return new RepositorioProntuImplDB();
            }
        }
     
            if(tipoNegocio == MENSAGEM){
            if(tipoPersistencia == DB){
                return new RepositorioMensagemImplDB();
            }
        }
     
            if(tipoNegocio == ADM){
                if(tipoPersistencia == DB){
                    return new RepositorioAdmImplDB();
                }
            }
        
            return null;
    }
    
  
    
}
