//Assignment 1 
//Authers : Yulia Mosha - 319565610
//		   : Gil Pasi    - 206500936	
package Task2;

import java.io.PrintStream;

public class High {
	int currentPlace = 1;
	
	
	public synchronized void  TheBigPumpkin(Pumpkin p)  {
		switch(currentPlace) {
		case 1 :
			//create as an atomic command
			String out = "\t**********************************\n"
							+"\t->" + p.GetpumpID() + " Is the winner: Max height"+
							"\n\t**********************************";
					
			System.out.println(out);
			++currentPlace;
			break;

		case 2:
			String out1 = "\n\t->" + p.GetpumpID() + " Is on 2-nd place\n";
			System.out.println(out1);
			++currentPlace;
			break;
		case 3:
			String out2 ="\n\t->" + p.GetpumpID() + " Is on 3-rd place\n";
			System.out.println(out2);
			++currentPlace;
			break;
		case 4:
			String out3 ="\n\t->" + p.GetpumpID() + " Is on 4-th place\n";
			System.out.println(out3);
			++currentPlace;
			break;
		case 5:
			String out4 ="\n\t->" + p.GetpumpID() + " Is on 5-th place\n";
			System.out.println(out4);
			++currentPlace;
			break;			
		}
			
		
		
	}


}
