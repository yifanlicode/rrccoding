
/*
 * Name: YifanLi
 * Program: Full Stack Web Development
 * Course: WEBD-1009 Programming 1
 * Created: 2022-09-07
 * Updated: 2022-09-10
 */      

public class Pounds
{
	public static void main(String[] args) 
	{
		//Declaring variables
		int kilograms = 0;
		final double pounds_kilograms = 0.454;

		//calculate kilograms to pounds
		kilograms = 10;
		System.out.println( kilograms + " kilogram is " + (kilograms / pounds_kilograms) + " pounds. ");
		kilograms = 50;
		System.out.println(kilograms + " kilogram is " + (kilograms / pounds_kilograms) + " pounds. ");
		kilograms = 100;
		System.out.println(kilograms + " kilogram is " + (kilograms / pounds_kilograms) + " pounds. ");
	}
}