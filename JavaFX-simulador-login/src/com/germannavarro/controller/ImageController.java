/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.germannavarro.controller;

import javafx.scene.image.Image;

/**
 *
 * @author informatica
 */
public class ImageController {
    private final String RUTA_IMAGENES = "/com/germannavarro/resources/";
    
    /**
     * Metodo que utiliza el patron FACTORY para crear distintas imagenes
     * 
     * @param nombreImagen
     * @return imagen a mostrar 
     */
    public Image getImageLogin( String nombreImagen ) {
        Image imagenAMostrar;
        
        switch (nombreImagen) {
            case "logo":
                imagenAMostrar = new Image(RUTA_IMAGENES + "login-logo.png");
                break;
            default:
                imagenAMostrar = new Image(RUTA_IMAGENES + "login-logo.png");
        } 
        return imagenAMostrar;
    }
}
