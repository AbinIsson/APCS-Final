import java.util.ArrayList;
import java.util.Arrays;

public class GenerateRandomQuestions extends QuestionBoardDatabase
{
	
	
	public String getQuestions()
	{
		
		ArrayList<String> questions = new ArrayList<String>();
		
		
		questions.add("What is Mr.Stites's first name?");
		questions.add("What is 9 + 10?");
		questions.add("What does the fox say?");
		questions.add("What is another name for money?");
		questions.add("Drake or Kendrick Lamar?");
		questions.add("What is 5 + 5?");
		questions.add("Who was the 44th president?");
		questions.add("Who is married to Jay-Z?");
		questions.add("What is 30 + 50?");
		questions.add("What is 7 x 7?");
		questions.add("Name the seventh planet from the sun.");
		questions.add("What is the world's longest river?");
		questions.add("What is the composition of water on Earth?");
		questions.add("Which is the best Sort Method?");
		questions.add("How many countries are in the world?");
		questions.add("How many continents are in the world?");
		questions.add("What is the shortcut for tab?");
		questions.add("What is the square root of 225?");
		questions.add("How many legs does a centipede?");
		questions.add("What color is an orange?");
		questions.add("A dog barks a cat...");
		questions.add("What U.S president is on the $2 bill?");
		questions.add("Which state would you find Mount Rushmore?");
		questions.add("What is the first element on the period table?");
		questions.add("Whats the smallest U.S state?");
		questions.add("How many colors are in a rainbow?");
		questions.add("What element are diamonds mostly made up of?");
		questions.add("What planet is the farthest from the sun?");
		questions.add("How long does it take earth to spin once on its axis?");
		questions.add("What is the pound sign (#) called?");
		
		/*for(int i = 0;i < questions.size();i++)
		{
			return "\n" + questions.get(i);
		}
		int num = (int)(Math.random()*29 + 0);
		String val = "";
		for(int i = 0; i< 30; i++)
		{
			if(questions.get(i) == questions.get(i))
			{
				questions.remove(i);
			}
			val += questions.remove(num) + "\n";
			return val;
		}*/
		
		
		for(int i = 0; i < 30; i++)
		{
			Questions q = new Questions(questions.get(i));
			return q.getQuestion();
			
			
		}
		return "";
		
	
		
		
		
	}
	
	public static void main(String args[])
	{
		GenerateRandomQuestions gen = new GenerateRandomQuestions();
		gen.getQuestions();
	}
}