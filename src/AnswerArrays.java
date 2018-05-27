import java.util.ArrayList;

public class AnswerArrays 
{

	private static String correct;
	private static String choiceB;
	private static String choiceC;
	private static String choiceD;
	
	String[] answerChoices = new String[4];
	static ArrayList<AnswerArrays> arr = new ArrayList<AnswerArrays>();
	
	public AnswerArrays(String str)
	{
		answerChoices  = str.split(" - "); //Make an array with 4 answer choices
		
        
		for(int i = 0; i < answerChoices.length; i++) //Now put all choices into an ArrayList
		{
			if(i == 0)
				correct = answerChoices[i];
			if(i == 1)
				choiceB = answerChoices[i];
			if(i == 2)
				choiceC = answerChoices[i];
			if(i == 3)
				choiceD = answerChoices[i];
			
		}
		
		arr.add(new AnswerArrays(correct, choiceB, choiceC, choiceD)); //making the ArrayList with objects
	}
	public AnswerArrays(String correct, String cB, String cC, String cD)
	{
		this.correct = correct;
		choiceB = cB;
		choiceC = cC;
		choiceD = cD;
	}
	
	
	
	public static String getCorrect(int num)
	{
		String val = "";
		for(int i = 0; i< 30; i++)
		{
			//Would this if statement work?
			if(arr.get(i) == arr.get(num))
			{
				//arr.remove(i).correct;
			}
			val += arr.get(num).correct + "\n";
			return val;
		}
		return "";
	}
	public static String getChoiceB(int num)
	{
		return arr.get(num).choiceB;
	}
	public static String getChoiceC(int num)
	{
		
		return arr.get(num).choiceC;
	}
	public static String getChoiceD(int num)
	{
		return arr.get(num).choiceD;
	}
	
	public static String getAllChoices()
	{
		return "";
	}
	
	@Override
	public String toString()
	{
		return choiceB;
	}
}