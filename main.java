package application;

import java.io.OutputStream;
import java.io.PrintStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 * Contains the scene builder and JavaFx display code. Output is a GUI of a single window with text display, similar to the console display
 * @author Randy Edward Penird
 * @version 1.1
 * @since 1.0
*/
public class main extends Application {
	public static void main(String[] args) {
	    launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
	    primaryStage.setTitle("Penird - Word Occurance");
	    StackPane root = new StackPane();
	TextArea intro = new TextArea("Welcome to Word Occurance!\n\nClick the Button Below to display the top 20 words in Edgar Allan Poe's:\nTHE RAVEN");
	intro.setWrapText(true);
	intro.setFont(Font.font("verdana", 15));
	Button btn_start = new Button();
	btn_start.setText("Click Here for Top 20 Words");
	        btn_start.setOnAction(new EventHandler<ActionEvent>() {
	 
	          
					public void handle(ActionEvent event) {
					    fileHandler.openFile();
					    root.getChildren().removeAll(intro,btn_start);
					    TextArea consoleout = new TextArea();
					    fileHandler.countWords();
					    consoleout.appendText("Top 20 Words, and their Frequency:\n");
					   for(int x = 1 ; x < 21; x++) {
					            consoleout.appendText(fileHandler.finalcount.get(x) + " = " + fileHandler.finalarray.get(x) + "\n");
					    }
						root.getChildren().add(consoleout);
						primaryStage.sizeToScene();
						primaryStage.show();
					}

	            });
	        
	        root.getChildren().addAll(intro,btn_start);
	        primaryStage.setScene(new Scene(root, 600, 400));
	        primaryStage.show();
	       
	    }
}
