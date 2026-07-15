/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.germannavarro.controller;

import com.germannavarro.model.Rol;
import java.util.ArrayList;
import com.germannavarro.model.Usuario;
import com.germannavarro.model.Usuario;

/**
 *
 * @author RM20
 */
public class AuthSistema {
    
    private ArrayList<Usuario> usuarios;
    
    public AuthSistema(){
        usuarios = new ArrayList<>();
        cargarUsuarios();
    }
    
    private void cargarUsuarios(){
        usuarios.add(new Usuario("Andre",
                "2023575",
                "German Andre",
                Rol.ADMIN));
        
        usuarios.add(new Usuario("Pablo",
                "2023129",
                "Pablo Raul",
                Rol.USER));
        
        usuarios.add(new Usuario("Ximena",
                "131208",
                "Ximena Ada Belén",
                Rol.ADMIN));
        
        usuarios.add(new Usuario("Andy",
                "2023049",
                "Andy Noé",
                Rol.USER));
    }
    
    public Usuario login(String user, String pass){
        for(Usuario usuario : usuarios){
            if(usuario.getUserName().equals(user) && usuario.getPasscode().equals(pass)){
                return usuario;
            }
        }
        return null;
        
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
