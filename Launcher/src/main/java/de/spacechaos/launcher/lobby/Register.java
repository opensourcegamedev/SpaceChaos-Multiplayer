package de.spacechaos.launcher.lobby;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class Register {

    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirm;

    @FXML
    private Button register;

    @FXML
    private Label nameError;

    @FXML
    private Label emailError;

    @FXML
    private Label passwordError;

    @FXML
    private Label confirmError;

    /**
     * This method is activated by clicking the 'Register'-Button.
     * It reads the values of the different fields, validates them and uses them to create a new account.
     */
    @FXML
    private void startRegistration(){
        //validate username TODO check precisely
        if("".equals(name.getText())){
            nameError.setText("Please enter a username.");
        }else{
            nameError.setText("");
        }
        //validate email TODO check precisely
        if("".equals(email.getText())){
            emailError.setText("Please enter your email.");
        }else if(!email.getText().contains("@")){
            emailError.setText("Not a valid email.");
        }else{
            emailError.setText("");
        }
        //validate password TODO check precisely
        if("".equals(password.getText())){
            passwordError.setText("Please enter a password.");
        }else{
            passwordError.setText("");
        }
        //validate confirmation TODO check precisely
        if("".equals(confirm.getText())){
            confirmError.setText("Please enter your password again.");
        }else if(!confirm.getText().equals(password.getText())){
            confirmError.setText("Passwords are not the same.");
        }else{
            confirmError.setText("");
        }
        // TODO register new player
    }

    /**
     * The initialization method adds an EventHandler to the 'Register'-Button so when it is focused and you press Enter, the registration process is started
     */
    @FXML
    private void initialize(){
        register.setOnKeyPressed(e -> {
            if(e.getCode().equals(KeyCode.ENTER)){
                startRegistration();
            }
        });
    }
}
