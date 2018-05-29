import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
 
public class Directions extends Background 
{
    
    @Override
    
    public void start(Stage primaryStage) 
    {
    
        StackPane root = new StackPane();
        
        Background back = new Background();
      //Basic set up of Start Page
      
        primaryStage.setScene(new Scene(root, 1700, 1000));
        primaryStage.show();
        
        Canvas canvas = new Canvas( 1700, 1000 );
        root.getChildren().add( canvas );
             
        GraphicsContext gc = canvas.getGraphicsContext2D();
      
        
        //Background Image
        Image ball = new Image("file:Basketball Court.jpg", 1700, 1000, false, false);
        gc.drawImage(ball, 0, 0);
        
       //Direction Page Layout
        gc.setFill(Color.ORANGERED);
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(3);
        Font theFont = Font.font( "Verdana", FontWeight.BOLD, 63 );
        gc.setFont( theFont );
        
        gc.fillText( "Directions", 670, 90 );
        gc.strokeText( "Directions", 670, 90 );
        
        
        theFont = Font.font( "Verdana", FontWeight.BOLD, 32 );
        gc.setFont(theFont);
        
        
        //Overall Directions
        gc.fillText("1. Take turns for each question starting \nwith Player 1 and then Player 2  ", 470, 700);
        gc.strokeText( "1. Take turns for each question starting \nwith Player 1 and then Player 2", 470, 700 );
        
        gc.fillText("2. Either click or highlight using the arrrows on the \nkeyboard and press the respective buttons shown \non the screen ", 470, 800);
        gc.strokeText( "2. Either click or highlight using the arrrows on the \nkeyboard and press the respective buttons shown \non the screen", 470, 800 );
       
        gc.fillText("3. The less time you take to answer a \nquestion the more points you earn ", 470, 940);
        gc.strokeText( "3. The less time you take to answer a \nquestion the more points you earn ", 470, 940 );
        
        
        //Directions For Player 1
        gc.fillText( "Player 1", 160, 190 );
        gc.strokeText( "Player 1", 160, 190 );
        
        gc.fillText("Q = Answer Choice A", 60, 290);
        gc.strokeText( "Q = Answer Choice A", 60, 290 );
        
        gc.fillText("W = Answer Choice B", 60, 390);
        gc.strokeText( "W = Answer Choice B", 60, 390 );
        
        gc.fillText("E = Answer Choice C", 60, 490);
        gc.strokeText( "E = Answer Choice C", 60, 490 );
        
        gc.fillText("R = Answer Choice D", 60, 590);
        gc.strokeText( "R = Answer Choice D", 60, 590 );
        
        
        //Directions For Player 2
        gc.fillText("Player 2", 1370, 190);
        gc.strokeText( "Player 2", 1370, 190 );
        
        gc.fillText("U = Answer Choice A", 1270, 290);
        gc.strokeText( "U = Answer Choice A", 1270, 290 );
        
        gc.fillText("I = Answer Choice B", 1270, 390);
        gc.strokeText( "I = Answer Choice B", 1270, 390 );
    
        gc.fillText("O = Answer Choice C", 1270, 490);
        gc.strokeText( "O = Answer Choice C", 1270, 490 );
        
        
        gc.fillText("P = Answer Choice D", 1270, 590);
        gc.strokeText( "P = Answer Choice D", 1270, 590 );
        
        //Button to Go To Game
        primaryStage.setTitle("Ball On Stites");
        Button btn = new Button();
        btn.setText("Start Game");
        btn.setLayoutX(200);
        btn.setLayoutY(200);
        root.getChildren().add(btn);
        
        Basketball basket = new Basketball();
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event)
            {
            	Stage primaryStage = new Stage();
                basket.start(primaryStage);
                Stage stage = (Stage) btn.getScene().getWindow();
                stage.close();
            }
        });
       
        //Disable maximize option on program
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        
        
    }
   
}