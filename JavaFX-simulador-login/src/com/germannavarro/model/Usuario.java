/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.germannavarro.model;

/**
 *
 * @author RM20
 */
public class Usuario {

    public static void add(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //Atributos
    private String userName;
    private String passcode;
    private String nombreCompleto;
    private Rol rol; //Se divide en ADMIN, USER

    //CONSTRUCTORES
    /**
     * Constructor vacio
     */
    public Usuario() {

    }

    public Usuario(String userName, String passcode, String nombreCompleto, Rol rol) {
        this.userName = userName;
        this.passcode = passcode;
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}

    


