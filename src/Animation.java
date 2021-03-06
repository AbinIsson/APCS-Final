import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.VLineTo;

public class Animation extends Basketball{

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

	/*
	 * Updated 
	 */

	public static PathElement[] bar()
	{
		PathElement[] path = {new MoveTo(185,420), //Start from green

				new HLineTo(0),
				new HLineTo(380),
				new HLineTo(185)
		};
		return path;
	}

	public static PathElement[] getMissAnimation(int num)
	{
		if(num == 1)
		{
			PathElement[] miss1 = {new MoveTo(525, 770), //Initial start

					new LineTo(570,200),
					new LineTo(650,250),
					new LineTo(700,350),
					new LineTo(700,770)
			};

			return miss1;
		}
		if(num == 2)
		{
			PathElement[] miss2 = {new MoveTo(525, 770), //Initial start

					new VLineTo(490),
					new LineTo(300,250),
					new ClosePath()
			};

			return miss2;
		}

		if(num == 3)
		{
			PathElement[] miss3 = {new MoveTo(525, 770), //Initial start

					new VLineTo(550),
					new LineTo(375,275),
					new LineTo(525,200),
					new LineTo(725,275),
					new ClosePath()
			};

			return miss3;
		}	
		if(num == 4)
		{
			PathElement[] miss4 = {new MoveTo(525, 770), //Initial start


					new LineTo(125,700),
					new LineTo(420,200),
					new LineTo(575,200),
					new LineTo(1000,700),
					new ClosePath()
			};

			return miss4;
		}

		return null;
	}
}