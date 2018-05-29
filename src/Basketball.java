import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.TimerTask;

import com.sun.glass.ui.Timer;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.paint.Color;

import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.QuadCurveTo;
import javafx.stage.Stage;

import javafx.util.Duration;

public class Basketball extends Background 
{

	@Override

	public void start(Stage primaryStage)  
	{
		//Animation  - Gets the ball image and sets location
		ImageView ball = new ImageView();
		ball.setImage(new Image("file:Ball.png",100, 100, false, false));
		ball.setX(475);
		
		ball.setY(600);

		//Getting a random path animation
		//PathElement[] path = Animation.getRandomAnimation((int) (Math.random()*5+1));
		PathElement[] path = Animation.getRandomAnimation(3);


		//Adding location of the path for animation
		Path road = new Path();
		road.setStroke(Color.TRANSPARENT); //Making the color invisible
		road.getElements().addAll(path);

		PathTransition anim = new PathTransition();
		anim.setNode(ball);
		anim.setPath(road);
		anim.setDuration(new Duration(1500));
		anim.setCycleCount(Timeline.INDEFINITE);





		StackPane root = new StackPane();
		Background back = new Background();


		//Basic set up of Start Page
		primaryStage.setScene(new Scene(root, 1700, 1000));
		primaryStage.show();


		//Basketball    
		Canvas canvas = new Canvas( 1700, 1000 );
		root.getChildren().add( canvas );
		root.getChildren().addAll(road,ball);



		GraphicsContext gc = canvas.getGraphicsContext2D();


		//Background Image
		Image court = new Image("file:Basketball Court.jpg", 1700, 1000, false, false);
		gc.drawImage(court, 0, 0);





		//PLAY ANIMATION COMMAND
		anim.play();









		//Disable maximize option on program
		primaryStage.resizableProperty().setValue(Boolean.FALSE);



	}

}

