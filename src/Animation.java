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
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;

import javafx.util.Duration;

public class Animation {

	public static PathElement[] getRandomAnimation(int num)
	{
		if(num == 1)
		{
			PathElement[] path1 = {new MoveTo(525, 770), //Initial start

					new QuadCurveTo(275,30,550,300), //Curve thing
					new ClosePath() //Finished the path back to the start
			};

			return path1;
		}
		if(num == 2)
		{
			PathElement[] path2 = {new MoveTo(525, 770),

					new LineTo(200,500),
					new LineTo(350,250),
					new LineTo(550,250),
					new ClosePath()

			};
			return path2;
		}
		if(num == 3)
		{
			PathElement[] path3 = {new MoveTo(525, 770),

					new CubicCurveTo(525, 770, 1100, -100, 500, 300),

					new ClosePath()

			};
			return path3;
		}
		if(num == 4)
		{
			PathElement[] path4 = {new MoveTo(525, 770),

					new VLineTo(500),
					new LineTo(725,500),
					new ClosePath(),
					new LineTo(200,500),
					new ArcTo(200,500,30, 550, 100, false, false),

					new ClosePath()

			};
			return path4;
		}
		if(num == 5)
		{
			PathElement[] path5 = {new MoveTo(525, 770),

					new VLineTo(200),
					new ClosePath()

			};
			return path5;
		}


		return null;


	}
}
