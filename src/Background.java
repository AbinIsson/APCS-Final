import java.io.File;
import java.io.FileInputStream;

import javax.print.DocFlavor.URL;

//import sun.audio.*;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
//import sun.audio.AudioData;
//import sun.audio.AudioStream;
 
public class Background extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    
    public void start(Stage primaryStage) 
    {
    
        StackPane root = new StackPane();
        
     //   btn.setOnAction(new EventHandler<ActionEvent>() {
 
           /* @Override
            public void handle(ActionEvent event) {
                System.out.println("Start Game!");
            }*/
       // });
        
      //Basic set up of Start Page
      
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();
        
        Canvas canvas = new Canvas( 700, 700 );
        root.getChildren().add( canvas );
             
        GraphicsContext gc = canvas.getGraphicsContext2D();
      
        
        //Background Image
        Image ball = new Image(ResourceLoader.load("Basketball-Players-Shooting.png"), 700, 700, false, false);
        gc.drawImage(ball, 0, 0);
        
       
        //Ball On Stites Title
        gc.setFill(Color.ORANGERED);
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(3);
        Font theFont = Font.font( "Verdana", FontWeight.BOLD, 77 );
        gc.setFont( theFont );
        gc.fillText( "Ball On Stites!", 60, 90 );
        gc.strokeText( "Ball On Stites!", 60, 90 );
        
        
        //Disable maximize option on program
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        
      //Title and Start Game button
        primaryStage.setTitle("Ball On Stites");
        Button btn = new Button();
        btn.setText("Start Game");
        btn.setLayoutX(200);
        btn.setLayoutY(200);
        root.getChildren().add(btn);
        
        Directions instructions = new Directions();
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event)
            {
            	Stage primaryStage = new Stage();
                instructions.start(primaryStage);
                
            
                Stage stage = (Stage) btn.getScene().getWindow();
                stage.close();
            }
        });
        
      //Play Song
     
        playAudio();
        
       
        
        
        
       /* ImageView iv = new ImageView();
        iv.setImage(image);
        
       root.getChildren().add(iv);*/
        primaryStage.show();
    
    }
    
    public void playAudio()
    {
    	File path = new File(("src/Blindside - TSA State Edition.mp3"));
    	Media m = new Media(path.toURI().toString());
    	MediaPlayer song = new MediaPlayer(m);
    	MediaView mv = new MediaView(song);
    	
    	mv.setMediaPlayer(song);
    	
    	song.autoPlayProperty();
    	song.setCycleCount(MediaPlayer.INDEFINITE);
    	song.play();
 
    }
   
}