//created by Pedro Beltran
//This program prompts the user to enter a 
//credit card number as a String. Then displays whether the 
//number is valid or invalid. 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

public class CreditCard {
	public static void main( String [] arg)
	{
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a credit card number as String: ");
		String creditCardString = input.nextLine();
		System.out.println(luhnCheck( creditCardString));

		
	}
	
	//checks and displays if a string of numbers is a credit card number
	public static String luhnCheck( String in)
	{
		if(isACreditCard(in) == true)
		{
			return in + " is valid";
		}
		else
		{
			return in + " is invalid";
		}
	}
	
	//checks if a string of numbers is a credit card number
	public static boolean isACreditCard(String in)
	{
		
		int sumEven  = 0, sumOdd = 0;
		
		//step 1 & 2
		for( int i = 0; i <in.length(); i += 2)
		{
			char a = in.charAt(i);
			int b = Character.getNumericValue(a);
			int c = b*2;
			int d = 0;
			if (c >= 10)
			{
				d = (c % 10) + (c / 10);
			}
			else
			{
				d = c;
			}
			sumEven += d;
		}
		
		
		//step 3
		for( int i = 1; i < in.length(); i += 2)
		{
			char a = in.charAt(i);
			int b = Character.getNumericValue(a);
			sumOdd += b;	
			
		}
		
		//step 4
		int sum = sumEven + sumOdd;
		if(sum % 10 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

//to create an int array int []a = new int[number of spaces];
