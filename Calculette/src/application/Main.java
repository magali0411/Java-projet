package application;
	

import com.sun.glass.ui.View;

import Interface.GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
	
    @Override
    public void start(Stage primaryStage) {
        GUI vue = new GUI();
        Scene sc = vue.createScene();
        primaryStage = vue.createPrimaryScene();
        primaryStage.setScene(sc);	
        primaryStage.show();

    }
    
	
	public static void main(String[] args) {
		launch(args);
	}
}
