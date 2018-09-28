package de.spacechaos.launcher;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JavaFXApplication extends Application {

    private Stage stage;
    @FXML
    private Pane contentPane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("SpaceChaos Multiplayer");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/window.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1500.0, 1500.0*9/16);
        primaryStage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        showRegister();
    }

    private void showRegister(){

    }
}
