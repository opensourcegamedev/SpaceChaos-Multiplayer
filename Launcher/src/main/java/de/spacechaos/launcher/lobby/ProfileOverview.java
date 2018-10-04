package de.spacechaos.launcher.lobby;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class ProfileOverview {

    @FXML
    private TextField displayedName;

    @FXML
    private Button saveNameButton;

    @FXML
    private Label nameErrorLabel;

    @FXML
    private Label ageLabel;

    @FXML
    private Label playedLabel;

    @FXML
    private Label wonLabel;

    @FXML
    private Label wlRatioLabel;

    @FXML
    private Label killsLabel;

    @FXML
    private Label deathsLabel;

    @FXML
    private Label kdRatioLabel;

    @FXML
    private void initialize(){
        // TODO load info
        saveNameButton.setOnKeyPressed(e->{
            if(e.getCode().equals(KeyCode.ENTER)){
                saveName();
            }
        });
    }

    @FXML
    private void saveName(){
        if("".equals(displayedName.getText())){
            nameErrorLabel.setText("Please enter a display name.");
        }else{
            nameErrorLabel.setText("");
        }
        System.out.println(displayedName.getText());
        // TODO save entered name
    }
}
