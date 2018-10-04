package de.spacechaos.launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("SpaceChaos Multiplayer");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/window.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1500.0, 1500.0*9/16);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
