/*System-Programming : Assignment 3
 *Authors: Yulia Moshan 319565610
 *			Gil Pasi    206500936 */
package SemesterA.SystemProgramming.Assignment3.assig3_1;

public class GamePlay {
	private boolean coin_available_ = true;
	private int rounds_counter_ = 0;

	public synchronized void makeCoinAvail(boolean val) {
		if (val)
			notifyAll();
		coin_available_ = val;
	}

	public synchronized boolean flipCoin() {
		// if coin isn't available, player waits
		while (!coin_available_) {
			System.out.printf("%s is waiting for coin\n", Thread.currentThread().getName());
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		// if coin available, player "takes" the coin, flips it and "release" it back
		System.out.printf("%s is flipping coin\n", Thread.currentThread().getName());
		makeCoinAvail(false);
		rounds_counter_++;
		// randomly gets 0 (lose) or 1 (win) in the coin flip
		int flip = (int) (Math.random() * 2);
		makeCoinAvail(true);
		return flip == 1;
	}

	public synchronized int getNumOfRounds() {
		return rounds_counter_;
	}
}
