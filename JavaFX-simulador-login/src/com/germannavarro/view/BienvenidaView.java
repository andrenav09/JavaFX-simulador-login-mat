/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.germannavarro.view;

import com.germannavarro.model.Usuario;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 * Ventana pequeña que se muestra tras un login exitoso. Muestra el nombre
 * completo y el rol (ADMIN/USER) del usuario autenticado.
 *
 * @author informatica
 */
public class BienvenidaView extends VBox {

    private Label lblBienvenida;
    private Label lblRol;
    private Button btnCerrar;

    public BienvenidaView(Usuario usuario) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(15);
        this.setPadding(new Insets(30));

        this.setBackground(new Background(
                new BackgroundFill(Paint.valueOf("#9EEAC7"),
                        new CornerRadii(25),
                        Insets.EMPTY)));

        lblBienvenida = new Label("Bienvenido, " + usuario.getNombreCompleto());
        lblBienvenida.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #1C2A6B;");
        lblBienvenida.setWrapText(true);
        lblBienvenida.setAlignment(Pos.CENTER);

        lblRol = new Label("Rol: " + usuario.getRol().name());
        lblRol.getStyleClass().add("badge-rol");
        //Color distinto segun el rol asignado
        if (usuario.getRol() == com.germannavarro.model.Rol.ADMIN) {
            lblRol.getStyleClass().add("badge-admin");
        } else {
            lblRol.getStyleClass().add("badge-user");
        }

        btnCerrar = new Button("Cerrar");
        btnCerrar.getStyleClass().add("btn-ingresar");

        this.getChildren().addAll(lblBienvenida, lblRol, btnCerrar);
    }

    public Label getLblBienvenida() {
        return lblBienvenida;
    }

    public Label getLblRol() {
        return lblRol;
    }

    public Button getBtnCerrar() {
        return btnCerrar;
    }
}