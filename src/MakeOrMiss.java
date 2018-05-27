import java.io.FileInputStream;

import javax.print.DocFlavor.URL;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;

//import sun.audio.*;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
//import sun.audio.AudioData;
//import sun.audio.AudioStream;

public class MakeOrMiss extends Basketball
{
	/*private String playerAns;
	
	public MakeOrMiss(String playerAns)
	{
		this.playerAns = playerAns;
	}
	*/
	
	
	
	
	/*
	 * Plays the animation by calling the graphics class associated with 
	 * the JavaFx's graphics platform.
	 */

/*	@Override
	public void start(Stage primaryStage)
	{
		StackPane root = new StackPane();
		
		primaryStage.setScene(new Scene(root, 1700, 1000));
		primaryStage.show();

		Canvas canvas = new Canvas( 1700, 1000 );
		root.getChildren().add( canvas );

		GraphicsContext gc = canvas.getGraphicsContext2D();
	   
       //Draw Ball and animate it 
        
        ImageView iv = new ImageView();
        Image ball = new Image("file:Ball.png", 200, 200, false, false);
	      iv.setImage(ball);

	      FadeTransition ft = new FadeTransition();
	      ft.setNode(iv);
	      ft.setDuration(new Duration(2000));
	      ft.setFromValue(1.0);
	      ft.setToValue(0.0);
	      ft.setCycleCount(6);
	      ft.setAutoReverse(true);
       
        
        iv.setOnMouseClicked(me -> ft.play());

        Group root2 = new Group();
        root2.getChildren().add(iv);
        Scene scene = new Scene(root2, ball.getWidth(), ball.getHeight());

        primaryStage.setTitle("FadeTransition Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}*/
	@Override
	public void start(Stage stage) {
    	Pane canvas = new Pane();
    	Scene scene = new Scene(canvas, 300, 300);
    	Circle ball = new Circle(10, Color.RED);
        ball.relocate(0, 10);
        
        canvas.getChildren().add(ball);
        
        stage.setTitle("Moving Ball");
        stage.setScene(scene);
        stage.show();
        
        Bounds bounds = canvas.getBoundsInLocal();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), 
                new KeyValue(ball.layoutXProperty(), bounds.getMaxX()-ball.getRadius())));
        timeline.setCycleCount(2);
        timeline.play();
    }
	
	public static void main(String[] args) {
        launch(args);
    }
    
}
