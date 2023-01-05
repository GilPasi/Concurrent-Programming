/* System-Programming : Assignment 3
 *Authors: Yulia Moshan 319565610
 *			Gil Pasi    206500936 */
package SemesterA.SystemProgramming.Assignment3.assig3_1;

public class Judge implements Runnable {
	private GamePlay gamePlay;
	private final int MAX_ROUNDS = 10;
	private final int SECOND = 1000;
	private final int HALF_SECOND = 1000;

	public Judge(GamePlay gamePlay) {
		this.gamePlay = gamePlay;
	}

	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted() && gamePlay.getNumOfRounds() <= MAX_ROUNDS) {
				// "takes" the coin for 1 sec
				gamePlay.makeCoinAvail(false);
				Thread.sleep(SECOND);
				// "releases" the coin for 0.5 sec
				gamePlay.makeCoinAvail(true);
				Thread.sleep(HALF_SECOND);
			}
		} catch (InterruptedException e) {
		}
	}
}
