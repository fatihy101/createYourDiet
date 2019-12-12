package project_test_field;
import java.util.*;
public class IBM_Calculation {

	public static void main(String[] args) {
		System.out.println("ATTENTION!\nBMI is not used for muscle builders, long distance athletes, pregnant women, the elderly or young children. "
				+ "\nThis is because BMI does not take into account whether the weight is carried as muscle or fat, just the number. "
				+ "\nThose with a higher muscle mass, such as athletes, may have a high BMI but not be at greater health risk. "
				+ "\nThose with a lower muscle mass, such as children who have not completed their growth or the elderly who may be losing some muscle mass may have a lower BMI. "
				+ "\nDuring pregnancy and lactation, a woman's body composition changes, so using BMI is not appropriate.");
System.out.println("ref: https://www.diabetes.ca"); 
//These texts will be in a textBox in swing.

//Main algorithm for BMI
		Scanner input = new Scanner(System.in);
		System.out.println("\nYour height (e.g. 170):");
		double height = input.nextDouble()/100;
		
		System.out.println("Your weight: ");
		double weight = input.nextDouble();
		
		if(weight>400) {
			System.out.println("Max. is 500 kg. Please enter again:");
			weight = input.nextDouble();
		} 
		
		double BMI = weight/(height*height);
		
System.out.println("Your body mass index is:" + String.format("%.2f", BMI));

personStatus(BMI, height, weight);

		
		
	}
	
	//Method for deciding to person's status. 
	public static void personStatus(double BMI, double height, double weight)
	{
		double massIndexes[] = {18.5,24.9,29.9};
		String status[] = {"underweight","healthy","overweight","obese","ERROR"};
				int temp = 4;
		for (int i = 0; i < massIndexes.length; i++) {

			        if(BMI < massIndexes[i])
					{
					  temp = i;
						break;
					}	
			        else temp = 3; 
				}
		System.out.println("\nYou\'re "+status[temp]);
		
		//To show ideal kilogram of the person. 
		if(temp == 0 || temp == 2|| temp == 3) 
			{
			System.out.println("\n\nA healthy person\'s BMI is 25.");
			

			   double idealWeight = 0;
			   double idealWeightDif;
			   if(BMI<18.5) 
			   {
			   idealWeight = (height*height)*18.5;
			   idealWeightDif = idealWeight - weight; 
			   System.out.println("You should gain " + String.format("%.2f",idealWeightDif) + " kg!");
			   }
			   else if(BMI>24.9)
			   {
				   idealWeight = (height*height)*24.9;
				   idealWeightDif = weight -idealWeight;
				   System.out.println("You should lose " + String.format("%.2f",idealWeightDif) +" kg!" );
			   }
			   System.out.println("Your ideal weight is "+ String.format("%.2f",idealWeight)+".");
			
			} //Ending of first if statement	
		
		
		
}
}
