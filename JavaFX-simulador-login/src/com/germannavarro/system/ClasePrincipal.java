/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.germannavarro.system;


import com.germannavarro.controller.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;
 
 
 
public class ClasePrincipal extends Application {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start (Stage escenarioRaiz){
        //Sirve para setear o agregar la ventana principal 
        SceneManager.getInstanciaSceneManager().setEscenarioPrincipal(escenarioRaiz);
        //Cargar la primer vista qeu quiero ver, en este fcaso le ventanaLogin
        SceneManager.getInstanciaSceneManager().ventanaLogin();
    }
}