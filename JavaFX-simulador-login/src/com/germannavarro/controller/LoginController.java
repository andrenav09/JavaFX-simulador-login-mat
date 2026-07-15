/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.germannavarro.controller;

import com.germannavarro.model.Usuario;
import com.germannavarro.view.LoginView;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author informatica
 */
public class LoginController {

    private final LoginView LOGIN_VIEW;
    private Button btnIniciarSesion;
    private Button btnCerrar;
    private double xOffset = 0;
    private double yOffset = 0;
    private Stage escenario = SceneManager.getInstanciaSceneManager().getEscenarioPrincipal();

    public LoginController(LoginView loginView) {
        this.LOGIN_VIEW = loginView;
        this.authSistema = new AuthSistema();

        construirAcciones();

    }

    public void construirAcciones() {
        configurarBotonCerrar();
        configurarArrastre();
        configurarInicioSesion();

    }

    private void configurarBotonCerrar() {
        this.LOGIN_VIEW.getBtnCerrarVentana().setOnMouseClicked(
                (evento) -> {
                    System.exit(0);
                }
        );
    }

    private void configurarInicioSesion() {
        this.LOGIN_VIEW.getBtnIniciarSesion().setOnMouseClicked(
                (evento) -> {
                    iniciarSesion();
                });
    }

    private void configurarArrastre() {
        LOGIN_VIEW.setOnMousePressed(
                (evento) -> {
                    xOffset = evento.getSceneX();
                    yOffset = evento.getSceneY();
                    System.out.println("X" + xOffset);
                    System.out.println("Y" + yOffset);

                });

        LOGIN_VIEW.setOnMouseDragged(
                (evento) -> {
                    double xVentanaDesplazamiento = evento.getScreenX();
                    double yVentanaDesplazamiento = evento.getScreenY();

                    System.out.println("Desplazamiento total X " + (xVentanaDesplazamiento - xOffset));
                    System.out.println("Desplazamiento total Y " + (yVentanaDesplazamiento - yOffset));

                    escenario.setX(xVentanaDesplazamiento - xOffset);
                    escenario.setY(yVentanaDesplazamiento - xOffset);

                });
    }

    private AuthSistema authSistema = new AuthSistema();

    public void iniciarSesion() {
        String userName = this.LOGIN_VIEW.getTxtNombreUsuario().getText().trim();
        String passcode = this.LOGIN_VIEW.getPwdClave().getText().trim();

        if (userName.isEmpty()) {
            
            JOptionPane.showMessageDialog(null,
                    "No dejar el campo de usurio vacio");
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().add("empty");
            
        } else if (passcode.isEmpty()) {
            
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().remove("empty");
            this.LOGIN_VIEW.getPwdClave().getStyleClass().add("empty");
            
            JOptionPane.showMessageDialog(null, "No deje el campo contraseña vacio");
        } else {
            this.LOGIN_VIEW.getPwdClave().getStyleClass().remove("empty");
            
            Usuario usuario = authSistema.login(userName, passcode);
            if (usuario == null) {                
                JOptionPane.showMessageDialog(null, "VALIDAR CREDENCIALES");
            } else {
                JOptionPane.showMessageDialog(null, "BIENVENIDO");
            }

        }
    }
}
