package Interface;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class GUI implements IView {

	private Clavier clv;// vue clavier  
	private Group root; // groupe
	private Scene scene; //scene

	
	public Scene createScene() {

		clv = new Clavier();
		
		//new Affichage();
				
		// création des noeuds 
		GridPane grille = clv.createGrid();
		VBox vb = clv.createAffichage();

		root = new Group();
		
		scene = new Scene(root, 500, 600, Color.MINTCREAM);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
        // Placement dans la fenêtre parent  
        root.getChildren().add(vb);
        root.getChildren().add(grille);
        //root.getChildren().add(box);
        
       return scene;
	
	}

	public Stage createPrimaryScene() {
		
		 //definir la scene principale
		Stage primaryStage = new Stage();
        primaryStage.getIcons().add(new Image("Images/calculette.jpg"));
        primaryStage.setTitle("Calculatrice");
        primaryStage.setOpacity(0.9);
        primaryStage.setWidth(500);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        
        Alert a = new Alert(AlertType.NONE); 

    	primaryStage.setOnCloseRequest(event ->
        {
        	a.setAlertType(AlertType.WARNING); 
        	a.setContentText("Vous quittez la calculatrice.");
            a.show(); 
            System.out.println("Application stopped.");
            
        });
    	
    	return primaryStage;	
		
	}

}
