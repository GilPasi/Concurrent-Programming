import java.util.Random;

/*System-Programming : Assignment 3
 *Authors: Yulia Moshan 319565610
 *			Gil Pasi    206500936 */

public class GamePlay {
	private boolean coin_available_ = true;
	private int round_counter_ = 0;
	
	
	public synchronized void makeCoinAvail(boolean val) {
		//TODO improve
		coin_available_ = val;
		
		if(coin_available_)
			notifyAll();
		
		
		
	}
	
	public synchronized boolean flipCoin() {
		
		while(!coin_available_) {
			System.out.println(Thread.currentThread().getName() + " is waiting for coin");
			try {
				wait();
			} catch (InterruptedException e) {}
			
		}//Close while
		coin_available_ = false;//Take coin
		
		System.out.println(Thread.currentThread().getName() + " is flipping coin");
		
		round_counter_ ++;
		
		 Random rand = new Random();
	     int rand_int1 = rand.nextInt(2);
	     //TODO add promotion in points
	     
		coin_available_ = true;//Leave coin
		
		notifyAll();

		return rand_int1 == 1;	
		
	}
	
	public synchronized int getNumOfRounds() {return round_counter_;}
	

}
