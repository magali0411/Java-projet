package Interface;


import javafx.scene.Scene;
import javafx.stage.Stage;


public interface IView {
	
	
	/**
	 * createPrimaryScene la scène finale 
	 * 
	 * @return scene
	 */
	public Stage createPrimaryScene();

	
	/**
	 * create scene intialise une scene avec tous ses composants 
	 * 
	 * @return scene
	 */
	public Scene createScene();
	



}
