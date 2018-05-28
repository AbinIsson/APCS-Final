import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MakeOrMiss extends Application
{
	public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage)
	{
		StackPane y = new StackPane();

		primaryStage.setScene(new Scene(y, 700, 700));
		primaryStage.show();
		
		Canvas canvas = new Canvas( 700, 700 );
		Scene scene = new Scene(y, 300, 300);
		y.getChildren().add( canvas );
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		Image ballPic = new Image("file:Ball.png", 700, 700, false, false);
		ImageView ball = new ImageView(ballPic);
		gc.drawImage(ball.getImage(), 0, 0);
    
        ScaleTransition st = new ScaleTransition(Duration.millis(2000), ball);
        st.setByX(1.5f);
        st.setByY(1.5f);
        st.setCycleCount(Animation.INDEFINITE);
        st.setAutoReverse(true);
    
        st.play();
        
        
    }

    
}
