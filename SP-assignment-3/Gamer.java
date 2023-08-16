/*System-Programming : Assignment 3
 *Authors: Yulia Moshan 319565610
 *			Gil Pasi    206500936 */
package SemesterA.SystemProgramming.Assignment3.assig3_1;

public class Gamer implements Runnable {
	private int goodFlipsCounter = 0;
	private GamePlay gamePlay;
	private final int MAX_ROUNDS = 10;
	private final int SLEEP_TIME = 1000;

	public Gamer(GamePlay gamePlay) {
		this.gamePlay = gamePlay;
	}

	public void run() {
		play();
	}

	public void play() {
		while (gamePlay.getNumOfRounds() <= MAX_ROUNDS) {
			if (gamePlay.flipCoin())
				goodFlipsCounter++;
			// added to follow game progression
			System.out.printf("%s score is: %d\n", Thread.currentThread().getName(), goodFlipsCounter);
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
			}
		}
	}

	public int getScore() {
		return goodFlipsCounter;
	}
}
