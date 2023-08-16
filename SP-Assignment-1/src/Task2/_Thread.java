//Assignment 1 
//Authers : Yulia Mosha - 319565610
//		   : Gil Pasi    - 206500936	
package Task2;

public class _Thread extends Thread {
	Pumpkin pump;
	private static int maxHeight = 0;
	
	public _Thread(Pumpkin pump) {
		this.pump = pump;
	}
	
	public void run () {
		
		try {
			int leftHeight = maxHeight - pump.getHeight();
			
			while(pump.getHeight() < maxHeight){//Keep doing untill maxSize is reached
				
				sleep(2000);//Sleep for 2 seconds or 2000 miliseconds
				pump.grow();
				
				leftHeight =  maxHeight - pump.getHeight();
				
				if(leftHeight > 0)
					System.out.println("\t" + pump.GetpumpID() + " :   " + leftHeight
							+ " cm to max height");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		pump.getH().TheBigPumpkin(pump);
		
	}
	
	public static void setMaxHeight(int max) {
		if(max > 0)
			maxHeight = max;
		else
			System.err.println("Max height cannot be negative. "
					+ "please re-run the program");
		
		
	}
	public static int getMaxHeight() {return maxHeight;}

}
