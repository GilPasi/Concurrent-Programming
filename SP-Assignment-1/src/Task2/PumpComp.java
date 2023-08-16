//Assignment 1 
//Authers : Yulia Mosha - 319565610
//		   : Gil Pasi    - 206500936	
package Task2;

import java.util.Scanner;

public class PumpComp {
	public static void main (String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter max pumpkin height: ");
		int mh = s.nextInt();
		_Thread.setMaxHeight(mh);
		
		High globalH = new High();/*There is no need for a new High object
									for each and every pumpkin, since "theBigPumpkin"
									 method is global*/
		Pumpkin p1 = new Pumpkin("One",globalH, 5);
		Pumpkin p2 = new Pumpkin("Two",globalH, 5);
		Pumpkin p3 = new Pumpkin("Three",globalH, 5);
		Pumpkin p4 = new Pumpkin("Four",globalH, 5);
		Pumpkin p5 = new Pumpkin("Five",globalH, 5);

		_Thread t1 = new _Thread(p1);
		_Thread t2 = new _Thread(p2);
		_Thread t3 = new _Thread(p3);
		_Thread t4 = new _Thread(p4);
		_Thread t5 = new _Thread(p5);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		
		
		
	}
	
	

}
