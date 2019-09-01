
//created by Beltran, Pedro
//This program shows how data can be retrieved from a txt file and 
//be used to make calculations as well as write to another txt file

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

public class FileProcessor {
	public static void main ( String [] arg) throws Exception
	{
	
		File infile = new File("DATA.TXT");
		if (infile.exists())
		{
			Scanner input = new Scanner(infile);
			
			File outfile = new File("RESULTS.TXT");
			writeGradesToFile(input, outfile);
			
			
			System.exit(0);
		}
		else
		{
			System.out.println("...file not found...");
		}
	
	
	}
	
	//reads student's scores from scanner object in and writes grades to file object out
	public static void writeGradesToFile( Scanner in, File out) throws Exception
	{
		PrintWriter pr = new PrintWriter(out);
		pr.println("A list of student's grades\n");
		
		while(in.hasNext())
		{
			String name = in.next();
			String ssn = in.next();
			double t1 = in.nextDouble();
			double t2 = in.nextDouble();
			double t3 = in.nextDouble();
			double t4 = in.nextDouble();
			double t5 = in.nextDouble();
			
			System.out.println( name+ " " +ssn+ " your grade is: " +calculateGrade(t1,t2,t3,t4,t5));
			pr.println(name+ " " +ssn+ " your grade is: " +calculateGrade(t1,t2,t3,t4,t5));
		}
		in.close();
		pr.close();
	}
	
	//calculates a student's letter grade
	public static char calculateGrade(double a, double b, double c, double d, double e)
	{
		double total;
		char grade = ' ';
		total = (.15 * (a+b)) + (.4 * c) + (.1 * d) + (.2 * e);
		
		if (total >= 110)
			grade = 'A';
		else
		{
			switch((int)total/10)
			{
			case 10: case 9: grade = 'A'; break;
			case 8: grade = 'B'; break;
			case 7: grade = 'C'; break;
			case 6: grade = 'D'; break;
			default: grade = 'F';
			}
		}
		
		return grade;
	}

}
