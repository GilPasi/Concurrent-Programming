//Assignment 1 
//Authers : Yulia Mosha - 319565610
//		   : Gil Pasi    - 206500936	
package Task2;

import java.util.Random;

public class Pumpkin {
	private String pumpID;
	private int height;
	private High h;
	
	public Pumpkin(String pumpID, High h, int height) {
		this.pumpID = pumpID;
		this.h = h;
		if(height < 0)
			System.err.println("Height cannot be negative");
		else
			this.height = height;
		
	}
	public void grow() {
		//Generate a random int between 1 and 10 cm
		Random rand = new Random();
        int additionalHeight = rand.nextInt(10);
        height += additionalHeight;
		
	}
	
	
	//Getters
	public String GetpumpID() {return pumpID;	}
	public int getHeight() {return height;}
	public High getH() {return h;}



}
