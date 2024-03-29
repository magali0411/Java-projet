package interfaceCalcu;
	
import javafx.application.Application;
import javafx.scene.Scene;
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
