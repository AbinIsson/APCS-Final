import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Basketball extends Background 
{
	// The global variables below are used to create a complete slider which
	// helps calculate the score for the player.
	private Rectangle rect1;
	private Rectangle rect2;
	private Rectangle rect3;
	private Rectangle rect4;
	private Rectangle rect5;
	private Rectangle rect6;
	private Rectangle rect7;

	
	@Override

	public void start(Stage primaryStage)  
	{
		
		//Animation  - Gets the ball image and sets location
		ImageView bigBall = new ImageView();
		bigBall.setImage(new Image(ResourceLoader.load("Ball.png"),100, 100, false, false));
		bigBall.setX(475);
		bigBall.setY(600);

		//Basic set up of Start Page
		StackPane root = new StackPane();
		primaryStage.setScene(new Scene(root, 1700, 1000));
		primaryStage.show();  // Display the stage, currently empty
		 					  // but will be filled graphics later
		
		Canvas canvas = new Canvas( 1700, 1000 );
		root.getChildren().add( canvas );
	
		GraphicsContext gc = canvas.getGraphicsContext2D(); // Made to be used 
															// for adding things
															// like text, and color.

		//Background Image
		Image court = new Image(ResourceLoader.load("Basketball Court.jpg"), 1700, 1000, false, false);
		gc.drawImage(court, 0, 0);
		
		// This font is used throughout the game
		Font daFont = Font.font( "Verdana", FontWeight.BOLD, 32 );


		/*
		 * Below are the addition of all of the different colored 
		 * rectangles that ends up creating the slider for the small ball.
		 */
		rect1 = new Rectangle(10, 20, 100, 50);
		rect1.setFill(Color.BLUE);
		rect1.setTranslateX(10);
		rect1.setTranslateY(400);
		root.getChildren().addAll(rect1);


		rect2 = new Rectangle(20, 20, 70, 50);
		rect2.setFill(Color.RED);
		rect2.setTranslateX(90);
		rect2.setTranslateY(400);
		root.getChildren().addAll(rect2);

		rect3 = new Rectangle(20, 20, 40, 50);
		rect3.setFill(Color.ORANGE);
		rect3.setTranslateX(140);
		rect3.setTranslateY(400);
		root.getChildren().addAll(rect3);

		rect4 = new Rectangle(20, 20, 24, 50);
		rect4.setFill(Color.GREEN);
		rect4.setTranslateX(165);
		rect4.setTranslateY(400);
		root.getChildren().addAll(rect4);

		rect5 = new Rectangle(20, 20, 40, 50);
		rect5.setFill(Color.ORANGE);
		rect5.setTranslateX(195);
		rect5.setTranslateY(400);
		root.getChildren().addAll(rect5);

		rect6 = new Rectangle(20, 20, 70, 50);
		rect6.setFill(Color.RED);
		rect6.setTranslateX(242);
		rect6.setTranslateY(400);
		root.getChildren().addAll(rect6);

		rect7 = new Rectangle(20, 20, 100, 50);
		rect7.setFill(Color.BLUE);
		rect7.setTranslateX(325);
		rect7.setTranslateY(400);
		root.getChildren().addAll(rect7);

		// The portrait image of Mr.Stites
		/*ImageView portrait = new ImageView();
		portrait.setImage(new Image("file:stites.jpeg", 200, 250, false, false));
		portrait.setTranslateX(-700);
		portrait.setTranslateY(-360);*/
		
	/*	String cssBordering = "-fx-border-color:white; \n" //#090a0c
	            + "-fx-border-insets:3;\n"
	            + "-fx-border-radius:100;\n"
	            + "-fx-border-width:3.0";
		HBox top = new HBox();
		top.getChildren().add(portrait);
		top.setStyle(cssBordering);*/
		
		/*Rectangle border = new Rectangle(220,275);
		border.setFill(Color.WHITE);
		border.setTranslateX(-700);
		border.setTranslateY(-350);*/
		
		// The addition of the small ball
		ImageView ball2 = new ImageView(); 	
		ball2.setImage(new Image(ResourceLoader.load("Ball.png"),40, 40, false, false));      
        
		//Adding location of the path for animation
      	PathElement[] bar = Animation.bar();
		Path road2 = new Path(); //Path of the bar
		road2.setStroke(Color.TRANSPARENT); //Making the color invisible(Since its not practical)
		road2.getElements().addAll(bar);
	
		//Setting the animation of the bar slider. 
		PathTransition barAnim = new PathTransition();
		barAnim.setNode(ball2);
		barAnim.setPath(road2);
		barAnim.setDuration(new Duration(1500));
		barAnim.setRate(5f);  // Changes how fast the ball moves on the bar
		barAnim.setCycleCount(Timeline.INDEFINITE);
		barAnim.play();
		
		root.getChildren().addAll(road2,ball2);
	
			// The creation of the stop button
			Button stopButton = new Button();
			
			stopButton.setFont(daFont);
			stopButton.setText("Stop");
			stopButton.setTranslateX(-400);
			stopButton.setTranslateY(400);
			stopButton.setMaxSize(300, 100);

			root.getChildren().add(stopButton);

			/*
			 * Contains the commands after the stop-button has been pressed
			 */
			stopButton.setOnAction(new EventHandler<ActionEvent>() 
			{
				@Override public void handle(ActionEvent event)
				{
					barAnim.pause();

					Bounds boundsInScene = (ball2.getBoundsInParent());
					
					// This variable stores the chances of a make based
					// on the location of the ball on the bar.
					int percent = getPercent(boundsInScene);
					
					gc.setFill(Color.ORANGERED);
					gc.setStroke( Color.BLACK );
					gc.setLineWidth(3);
					Font theFont = Font.font( "Verdana", FontWeight.BOLD, 77 );
					gc.setFont( theFont );
					gc.fillText( "Score: " + percent, 1200, 90 );
					gc.strokeText( "Score: " + percent, 1200, 90 );

					/*
					 * Below are the conditions that determine the 
					 * which animation to play, a miss animation or a make animation.
					 */
					if(percent < 70)  
					{
						//Getting a random path animation
						PathElement[] path = Animation.getMissAnimation((int) (Math.random()*4+1));

						Font daFont = Font.font( "Verdana", FontWeight.BOLD, 32 );
						gc.setFont( daFont );
						if(percent > 50)
						{
							gc.fillText( "So Close, Yet So Far", 1200, 190 );
							gc.strokeText( "So Close, Yet So Far" , 1200, 190 );
						}
						else if(percent <= 50)
						{
							gc.fillText( "Oof That was Ugly", 1200, 190 );
							gc.strokeText( "Oof That was Ugly", 1200, 190 );
						}


						//Adding location of the path for animation
						Path road = new Path();
						road.setStroke(Color.TRANSPARENT); //Making the color invisible(Since its not practical)
						road.getElements().addAll(path);

						PathTransition anim = new PathTransition();
						anim.setNode(bigBall);
						anim.setPath(road);
						anim.setDuration(new Duration(1500));
						anim.setCycleCount(1);

						root.getChildren().addAll(road,bigBall);

						//PLAY ANIMATION COMMAND
						anim.play();
					}
					else if(percent >= 70)
					{
						//Getting a random path animation
						PathElement[] path = Animation.getRandomAnimation((int) (Math.random()*5+1));
						Font daFont = Font.font( "Verdana", FontWeight.BOLD, 32 );
						gc.setFont( daFont );
						if(percent <= 110)
						{
							gc.fillText( "Ice In Your Veins", 1200, 190 );
							gc.strokeText( "Ice In Your Veins" , 1200, 190 );
						}
						else if(percent > 110)
						{
							gc.fillText( "Dang good shot", 1200, 190 );
							gc.strokeText( "Dang good shot", 1200, 190 );
						}

						//Adding location of the path for animation
						Path road = new Path();
						road.setStroke(Color.TRANSPARENT); //Making the color invisible(Since its not practical)
						road.getElements().addAll(path);

						PathTransition anim = new PathTransition();
						anim.setNode(bigBall);
						anim.setPath(road);
						anim.setDuration(new Duration(1500));
						anim.setCycleCount(1);

						root.getChildren().addAll(road,bigBall);

						//PLAY ANIMATION COMMAND
						anim.play();
					}

				}

			});
			
			/*
			 *  This button is created so that the user would be 
			 *  able to retry their attempt.
			 */
			Button tryAgain = new Button ("Try Again");
			tryAgain.setFont(daFont);
			tryAgain.setTranslateX(-400);
			tryAgain.setTranslateY(300);
			tryAgain.setMaxSize(300, 100);

			root.getChildren().add(tryAgain);

			Basketball baller = new Basketball();
			tryAgain.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent event)
				{

					baller.start(primaryStage);

					Stage stage = (Stage) tryAgain.getScene().getWindow();


				}
			});

		
		

	        
	        

		//Disable maximize option on program
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
	}
		
	
	
	/*	
	 * @param -  location of the ball on the rectangle, 
	 * this will determine overall chance of it being a make
	 */
	private int getPercent(Bounds boundsInScene)
	{
		int percent = 0;
		
		if(boundsInScene.intersects(rect1.getBoundsInParent()))
		{
			percent += 25;
		}
		
		 if(boundsInScene.intersects(rect2.getBoundsInParent()))
		{
			percent += 30;
		}
		
		 if(boundsInScene.intersects(rect3.getBoundsInParent()))
		{
			percent += 40;
		}
		
		 if(boundsInScene.intersects(rect4.getBoundsInParent()))
		{
			percent += 50;
		}
		
		 if(boundsInScene.intersects(rect5.getBoundsInParent()))
		{
			percent += 40;
		}
    	
		 if(boundsInScene.intersects(rect6.getBoundsInParent()))
		{
			 percent += 30;
	    }
		 
		 if(boundsInScene.intersects(rect7.getBoundsInParent()))
    	{
    			 percent += 20;
        }
		 
		 return percent;
	}
	

	}