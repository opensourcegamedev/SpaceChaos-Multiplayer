package de.spacechaos.launcher.lobby;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Register {

    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password2;

    @FXML
    private Button register;

    @FXML
    private void startRegistration(){
        System.out.println("Registrierung nicht erfolgt. Username: " + name.getText() + ", E-Mail: " + email.getText());
    }
}
