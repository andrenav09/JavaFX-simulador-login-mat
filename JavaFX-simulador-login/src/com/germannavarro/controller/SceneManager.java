/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.germannavarro.controller;

import com.germannavarro.model.Usuario;
import com.germannavarro.view.BienvenidaView;
import com.germannavarro.view.LoginView;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

public class SceneManager {
 
    private static SceneManager instanciaSceneManager;
    private Stage escenarioPrincipal;
    private Stage escenarioSecundario;
    private Scene escenaPrincipal;
 
    private SceneManager() {
 
    }
 
    public void cambiarEscenaPrincipal(Pane panel, int ancho, int alto) {
        try {
            escenaPrincipal = new Scene(panel, ancho, alto);//Instanciar la escena
            escenarioPrincipal.setScene(escenaPrincipal);//El metodo para cambiar la escena
            escenarioPrincipal.sizeToScene();
            escenarioPrincipal.show();
        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: Cambiar Escena");
            objetoNulo.printStackTrace();//Imprime toso el camino al error
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error padre: Cambiar Escena Principal");
            errorPadre.printStackTrace();
        }
 
    }
 
    public void ventanaLogin() {
        try {
//            Metodo que oculta las opciones de ventana por defecto
            this.escenarioPrincipal.initStyle(StageStyle.TRANSPARENT);
//            Se envia la vista que creamos en LoginView
//             Se llama a vista, se le nombrea, es igual al tipo de variable llamando al singleton
            LoginView login = LoginView.getInstanciaLoginView();
            cambiarEscenaPrincipal(login, 500, 500);
            this.escenaPrincipal.setFill(Color.TRANSPARENT);
            new LoginController(login);
            
        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: Ventana Login");
            objetoNulo.printStackTrace();//Imprime toso el camino al error
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error padre: Ventana Login");
            errorPadre.printStackTrace();
        }
    }
 
/**
     * Cierra la ventana de Login y abre una nueva ventana pequeña de
     * bienvenida, mostrando el nombre y el rol del usuario autenticado.
     *
     * @param usuario usuario que inició sesión correctamente
     */
    public void ventanaBienvenida(Usuario usuario) {
        try {
            //Crear el nuevo escenario de bienvenida
            this.escenarioSecundario = new Stage();
            this.escenarioSecundario.initStyle(StageStyle.TRANSPARENT);

            BienvenidaView bienvenida = new BienvenidaView(usuario);
            bienvenida.getStylesheets().add("/com/germannavarro/styles/LoginStyles.css");

            Scene escenaBienvenida = new Scene(bienvenida, 300, 230);
            escenaBienvenida.setFill(Color.TRANSPARENT);

            this.escenarioSecundario.setScene(escenaBienvenida);

            bienvenida.getBtnCerrar().setOnMouseClicked(evento -> escenarioSecundario.close());

            //Mostrar PRIMERO la nueva ventana...
            this.escenarioSecundario.show();

            //...y HASTA AHORA cerrar el login. Si se cierra antes de mostrar
            //la nueva ventana, JavaFX se queda sin ventanas visibles y apaga
            //el toolkit (implicitExit=true), provocando un error al hacer show().
            this.escenarioPrincipal.close();

        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: Ventana Bienvenida");
            objetoNulo.printStackTrace();
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error padre: Ventana Bienvenida");
            errorPadre.printStackTrace();
        }
    }

    public static SceneManager getInstanciaSceneManager() {
        if (instanciaSceneManager == null) {
            instanciaSceneManager = new SceneManager();
        }
        return instanciaSceneManager;
    }
    
    
 
    public static void setInstanciaSceneManager(SceneManager instanciaSceneManager) {
        SceneManager.instanciaSceneManager = instanciaSceneManager;
    }
 
    public Stage getEscenarioPrincipal() {
        return escenarioPrincipal;
    }
 
    public void setEscenarioPrincipal(Stage escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
 
    public Stage getEscenarioSecundario() {
        return escenarioSecundario;
    }
 
    public void setEscenarioSecundario(Stage escenarioSecundario) {
        this.escenarioSecundario = escenarioSecundario;
    }
 
    public Scene getEscenaPrincipal() {
        return escenaPrincipal;
    }
 
    public void setEscenaPrincipal(Scene escenaPrincipal) {
        this.escenaPrincipal = escenaPrincipal;
    }
 
}