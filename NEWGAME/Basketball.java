import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Basketball extends Background 
{
	private int score;  // This variable keeps track of the points obtained
						//  throughout the game
	
	
	@Override

	public void start(Stage primaryStage)  
	{
		//Animation  - Gets the ball image and sets location
		ImageView ball = new ImageView();
		ball.setImage(new Image("file:Ball.png",100, 100, false, false));
		ball.setX(475);
		
		ball.setY(600);

		//Getting a random path animation
		PathElement[] path = Animation.getRandomAnimation((int) (Math.random()*5+1));
		//PathElement[] path = Animation.getRandomAnimation(4);


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
		
		
		

		  //Bar For Arrow
	      Rectangle rect1 = new Rectangle(20, 20, 100, 50);
        rect1.setFill(Color.BLUE);
        rect1.setTranslateX(10);
        rect1.setTranslateY(400);
        root.getChildren().addAll(rect1);
        
        
        Rectangle rect2 = new Rectangle(20, 20, 70, 50);
        rect2.setFill(Color.RED);
        rect2.setTranslateX(90);
        rect2.setTranslateY(400);
        root.getChildren().addAll(rect2);
        
        Rectangle rect3 = new Rectangle(20, 20, 40, 50);
        rect3.setFill(Color.ORANGE);
        rect3.setTranslateX(140);
        rect3.setTranslateY(400);
        root.getChildren().addAll(rect3);
        
        Rectangle rect4 = new Rectangle(20, 20, 24, 50);
        rect4.setFill(Color.GREEN);
        rect4.setTranslateX(165);
        rect4.setTranslateY(400);
        root.getChildren().addAll(rect4);
        
        Rectangle rect5 = new Rectangle(20, 20, 40, 50);
        rect5.setFill(Color.ORANGE);
        rect5.setTranslateX(195);
        rect5.setTranslateY(400);
        root.getChildren().addAll(rect5);
      
        Rectangle rect6 = new Rectangle(20, 20, 70, 50);
        rect6.setFill(Color.RED);
        rect6.setTranslateX(242);
        rect6.setTranslateY(400);
        root.getChildren().addAll(rect6);
        
        Rectangle rect7 = new Rectangle(20, 20, 100, 50);
        rect7.setFill(Color.BLUE);
        rect7.setTranslateX(325);
        rect7.setTranslateY(400);
        root.getChildren().addAll(rect7);



        ImageView ball2 = new ImageView(); 	//Ball on Bar
		ball2.setImage(new Image("file:Ball.png",40, 40, false, false));      
        
        PathElement[] bar = Animation.bar();


		//Adding location of the path for animation
		Path road2 = new Path(); //Path of the bar
		road2.setStroke(Color.TRANSPARENT); //Making the color invisible
		road2.getElements().addAll(bar);
		/*ball2.setX(185);
		ball2.setY(420);*/

		PathTransition barAnim = new PathTransition();
		barAnim.setNode(ball2);
		barAnim.setPath(road2);
		barAnim.setDuration(new Duration(1500));
		barAnim.setCycleCount(Timeline.INDEFINITE);

		
		root.getChildren().addAll(road2,ball2);
		
		barAnim.play();

		//Disable maximize option on program
		primaryStage.resizableProperty().setValue(Boolean.FALSE);

		

	}
	
	/*
	 * @param - location of the ball on the rectangle, 
	 * this will determine the score for that player
	 */
	private void calculateScore(double location)
	{
		
	}
	
	/*
	 * @param - the number of points that  needs to be added
	 * Updates the score variable with @param
	 */
	private void incrementScore(int howMany)
	{
		score += howMany;
	}
	
	/*
	 * @return the updated the score of the current player
	 */
	private int getScore()
	{
		return score;
	}
	
	
	

}
