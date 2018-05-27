import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.TimerTask;

import com.sun.glass.ui.Timer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
 
public class Basketball extends Background 
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
        
        
        
        
        //Read File
      try {
		QuestionBoardDatabase();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
      //Font
      gc.setFill(Color.ORANGERED);
      gc.setStroke( Color.BLACK );
      gc.setLineWidth(3);
      Font theFont = Font.font( "Verdana", FontWeight.BOLD, 63 );
      gc.setFont( theFont );
     
      theFont = Font.font( "Verdana", FontWeight.BOLD, 48 );
      gc.setFont(theFont);
      
      // Question displayed
      String question = Questions.getRandomQuestion();
      gc.fillText(question, 400, 700);
      gc.strokeText( question, 400,700);
      gc.setTextAlign(TextAlignment.CENTER);
      gc.setTextBaseline(VPos.CENTER);
      
    //Answer Choices Displayed
      int num = Questions.getRandomNumber();
      
        //A
        primaryStage.setTitle("Ball On Stites");
        Button btnA = new Button();
        btnA.setText("A. " + AnswerArrays.getCorrect(num));
        btnA.setTranslateX(-400);
        btnA.setTranslateY(318);
        btnA.setMinSize(900,119);
        
        btnA.setOnKeyPressed(
        		event -> {
        			switch(event.getCode())
        			{
        				case Q  : 
        				{
        					System.out.println(AnswerArrays.getCorrect(num));	
        					break;
        				}
        				case U : 
        				{
	        				System.out.println(AnswerArrays.getCorrect(num));
	        				break;
	        			}
        			
        		
        			}
        		}
        	);
        
        Directions instructions = new Directions();
        btnA.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event)
            {
            	/*Stage primaryStage = new Stage();
                instructions.start(primaryStage);
                Stage stage = (Stage) btnA.getScene().getWindow();*/
                System.out.println(AnswerArrays.getCorrect(num));
               // stage.close();
            }
        });
        root.getChildren().add(btnA);
      
        //B
        Button btnB = new Button();
        btnB.setText("B. " + AnswerArrays.getChoiceB(num));
        btnB.setTranslateX(-400);
        btnB.setTranslateY(439);
        btnB.setMinSize(900,119);
        
        btnB.setOnKeyPressed(
        		event -> {
        			switch(event.getCode())
        			{
        				case I : 
        				{
        					System.out.println(AnswerArrays.getChoiceB(num));	
        					break;
        				}
        				case W : 
        				{
	        				System.out.println(AnswerArrays.getChoiceB(num));
	        				break;
	        			}
        			
        		
        			}
        		}
        	);
      
      
        btnB.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event)
            {
            	/*Stage primaryStage = new Stage();
                instructions.start(primaryStage);
                Stage stage = (Stage) btnB.getScene().getWindow();
                stage.close();*/
            	
            	System.out.println(AnswerArrays.getChoiceB(num));
            }
        });
        
        root.getChildren().add(btnB);
        
      //C
        Button btnC = new Button();
        btnC.setText("C. " + AnswerArrays.getChoiceC(num));
        btnC.setTranslateX(500);
        btnC.setTranslateY(318);
        btnC.setMinSize(900,119);
        
        btnC.setOnKeyPressed(
        		event -> {
        			switch(event.getCode())
        			{
        				case E : 
        				{
        					System.out.println(AnswerArrays.getChoiceC(num));	
        					break;
        				}
        				case O : 
        				{
	        				System.out.println(AnswerArrays.getChoiceC(num));
	        				break;
	        			}
        			
        		
        			}
        		}
        	);
        
       
        btnC.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event)
            {
            	/*Stage primaryStage = new Stage();
                instructions.start(primaryStage);
                Stage stage = (Stage) btnC.getScene().getWindow();
                stage.close();*/
            	System.out.println(AnswerArrays.getChoiceC(num));
            }
        });
      
        root.getChildren().add(btnC);
        
      //D
        Button btnD = new Button();
        btnD.setText("D. " + AnswerArrays.getChoiceD(num));
        btnD.setTranslateX(500);
        btnD.setTranslateY(439);
        btnD.setMinSize(900,119);
        
        btnD.setOnKeyPressed(
        		event -> {
        			switch(event.getCode())
        			{
        				case R : 
        				{
        					System.out.println(AnswerArrays.getChoiceD(num));	
        					break;
        				}
        				case P : 
        				{
	        				System.out.println(AnswerArrays.getChoiceD(num));
	        				break;
	        			}
        			
        		
        			}
        		}
        	);
      
        
            btnD.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event)
            {
            	/*Stage primaryStage = new Stage();
                instructions.start(primaryStage);
                Stage stage = (Stage) btn.getScene().getWindow();
                stage.close();*/
            	System.out.println(AnswerArrays.getChoiceD(num));
            }
        });
        root.getChildren().add(btnD);
       
        //Disable maximize option on program
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        
       
        
    }
   
    public static void QuestionBoardDatabase() throws FileNotFoundException
    {
    	//Answers
    			Scanner file = new Scanner(new File("answer.txt"));
    			int size = file.nextInt();
    			file.nextLine();
    			
    			for(int i = 0; i < size; i++)
    			{
    				String sentence = file.nextLine();
    				
    				AnswerArrays word = new AnswerArrays(sentence);
    				//System.out.println(word);
    			}
    			
    			
				
    		
    			//Questions
    			Scanner file2 = new Scanner(new File("Question.txt"));
    			size = file2.nextInt();
    			file2.nextLine();
    			
    			for(int i = 0; i < size; i++)
    			{
    				String sentence = file2.nextLine();
    				
    				Questions word = new Questions(sentence);
    				//System.out.println(word);
    			}
    }
    
   
   
}