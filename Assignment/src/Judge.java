/*System-Programming : Assignment 3
 *Authors: Yulia Moshan 319565610
 *			Gil Pasi    206500936 */
public class Judge extends Thread{
	
	private GamePlay gp;
	private final static int HALF_SEC = 500, SEC = 1000;
	

	public Judge (GamePlay gp) {
		this.gp = gp;
	}
	
	
	public void run() {
		while(!isInterrupted() && gp.getNumOfRounds() <= 10) {
			gp.makeCoinAvail(false);
			try {
				sleep(HALF_SEC);
				gp.makeCoinAvail(true);
				sleep(SEC);	
			} catch (InterruptedException e) {}
			
			
		}
	}
	
	

}
