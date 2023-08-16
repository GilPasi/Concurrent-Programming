package Task1;

//Assignment 1 
//Authers : Yulia Mosha - 319565610
//		   : Gil Pasi    - 206500936	
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		
		//Create an array of pointers to the relevant array-list
		ArrayList [] table = new ArrayList[4];
		table [0] = new ArrayList<String>();
		table [1] = new ArrayList<String>();
		table [2] = new ArrayList<String>();
		table [3] = new ArrayList<String>();
	
		//Define file object and a scanner
		File report = new File("teams.txt");
		File rankList = new File("rank.txt");
		FileWriter fwr = null;
		Scanner s= null;

		try {
			fwr = new FileWriter(rankList);
			s = new Scanner(report);
			
			
			while(true) {//Will be caught at NoSuchElementException 
				String countryName = s.next();
				int countryGrade = s.nextInt();
				table[countryGrade - 1 ].add(countryName);
			}
			
			
			
		}catch(NoSuchElementException e) {
			//Part of the plan, continue the code flow
		} 
		
		
		//Address unplanned exceptions:
		catch (FileNotFoundException e) {
			System.err.println("File was not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		
		
		try {
			fwr.write(textFormat(table));
			fwr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static String textFormat(ArrayList [] table) {
		
		/**This method's only job is to print in a nice format*/
		String out = "";
		for (int i = 0 ; i < table.length; i++) {
			out += ("\n" +(i + 1) + " ");
			
			for(int j = 0; j < table[i].size(); j++) {
				out +=(table[i].get(j));
				
				if( j != table[i].size() - 1)
					out += ",";
			}
			out += "\n";
		}
		return out;
		
	}
	
	public static void withdrawResults (Scanner s,FileWriter fwr,ArrayList <String>[] table) {
	
	}
}
