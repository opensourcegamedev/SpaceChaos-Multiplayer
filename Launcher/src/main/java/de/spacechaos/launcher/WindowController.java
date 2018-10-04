package de.spacechaos.launcher;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class WindowController {

    @FXML
    private Pane contentPane;

    @FXML
    public void initialize(){
        try {
            // TODO show content of welcome page according to properties
            contentPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/profile_overview.fxml")).load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
