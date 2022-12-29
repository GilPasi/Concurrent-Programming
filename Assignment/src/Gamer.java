/*System-Programming : Assignment 3
 *Authors: Yulia Moshan 319565610
 *			Gil Pasi    206500936 */
public class Gamer extends Thread {
	
	private int goodFlipsCounter = 0;
	private GamePlay gp;
	private final static int MAX_ROUNDS = 10;
	private final static int SLEEP_PERIOD = 1000;

	
	public Gamer(GamePlay gp) {
		this.gp = gp;
	}
	
	public void run() {
		play();
	}
	
	public void play() {
		
		
		while(!isInterrupted() && gp.getNumOfRounds() <= MAX_ROUNDS ) {
			if(gp.flipCoin()) 
				goodFlipsCounter++;
			try {
				sleep(SLEEP_PERIOD);
			} catch (InterruptedException e) {}
				
		}
		
		
	}
	
	public int getScore() {return goodFlipsCounter;	}

}
