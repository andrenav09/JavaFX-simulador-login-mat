/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.germannavarro.controller;

import com.germannavarro.model.Usuario;
import com.germannavarro.view.LoginView;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author informatica
 */
public class LoginController {

    private final LoginView LOGIN_VIEW;
    private final AuthSistema authSistema;
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
                });

        LOGIN_VIEW.setOnMouseDragged(
                (evento) -> {
                    double xVentanaDesplazamiento = evento.getScreenX();
                    double yVentanaDesplazamiento = evento.getScreenY();

                    escenario.setX(xVentanaDesplazamiento - xOffset);
                    escenario.setY(yVentanaDesplazamiento - yOffset);
                });
    }

    public void iniciarSesion() {
        String userName = this.LOGIN_VIEW.getTxtNombreUsuario().getText().trim();
        String passcode = this.LOGIN_VIEW.getPwdClave().getText().trim();

        limpiarEstilosDeError();

        if (userName.isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "No dejar el campo de usurio vacio");
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().add("empty");

        } else if (passcode.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No deje el campo contraseña vacio");
            this.LOGIN_VIEW.getPwdClave().getStyleClass().add("empty");

        } else {

            Usuario usuario = authSistema.login(userName, passcode);

            if (usuario == null) {
                //Feedback visual: borde rojo en usuario y contraseña
                this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().add("error");
                this.LOGIN_VIEW.getPwdClave().getStyleClass().add("error");

                JOptionPane.showMessageDialog(null, "VALIDAR CREDENCIALES");
            } else {
                //Login exitoso: cerrar el login y abrir la ventana de bienvenida
                SceneManager.getInstanciaSceneManager().ventanaBienvenida(usuario);
            }
        }
    }

    /**
     * Quita los estilos de error/vacío antes de volver a validar, para que no
     * se acumulen clases CSS entre intentos.
     */
    private void limpiarEstilosDeError() {
        this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().removeAll("empty", "error");
        this.LOGIN_VIEW.getPwdClave().getStyleClass().removeAll("empty", "error");
    }
}
