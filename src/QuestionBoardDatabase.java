import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class QuestionBoardDatabase 
{
	public static void main( String args[] ) throws IOException
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