package de.spacechaos.launcher.lobby;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;

public class Login {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label nameError;

    @FXML
    private Label passwordError;

    @FXML
    private CheckBox persistence;

    @FXML
    private Button loginButton;

    /**
     * This method is activated by clicking the 'Login'-Button.
     * It reads the values of the different fields, validates them and uses them to log into an existing account.
     */
    @FXML
    private void login(){
        //validate username
        if("".equals(username.getText())){
            nameError.setText("Please enter your name.");
        }
        //validate password
        if("".equals(password.getText())){
            passwordError.setText("Please enter your password.");
        }
        // TODO login
        boolean stayLoggedIn = persistence.isSelected();
    }

    /**
     * The initialization method adds an EventHandler to the 'Login'-Button so when it is focused and you press Enter, the login process is started
     */
    @FXML
    private void initialize(){
        loginButton.setOnKeyPressed(e->{
            if(e.getCode().equals(KeyCode.ENTER)){
                login();
            }
        });
    }
}
