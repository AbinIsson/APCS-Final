import java.util.ArrayList;

public class Questions
{
	private static String q;
	
	static ArrayList<String> question = new ArrayList<String>();
	
	private static int num;
	
	public Questions(String str)
	{
		q = str;
		question.add(str);
		num = (int)(Math.random()*29 + 0);
	}
	
	public static String getQuestion()
	{
		return q;
	}
	
	public static int getRandomNumber()
	{
		 
		 return num;
	}
	public static String getRandomQuestion()
	{
		
		
		String val = "";
		for(int i = 0; i< 30; i++)
		{
			//Would this if statement work?
			if(question.get(i) == question.get(num))
			{
				question.remove(i);
			}
			val += question.remove(num) + "\n";
			return val;
		}
		return "";
	}
	
	
	@Override
	public String toString()
	{
		return q;
	}
}