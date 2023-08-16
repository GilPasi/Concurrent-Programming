/*System-Programming : Assignment 3
 *Authors: Yulia Moshan 319565610
 *			Gil Pasi    206500936 */
package SemesterA.SystemProgramming.Assignment3.assig3_1;

public class Runner {

	public static void main(String[] args) {
		GamePlay gamePlay = new GamePlay();
		Gamer player1 = new Gamer(gamePlay);
		Gamer player2 = new Gamer(gamePlay);
		
		Thread judge = new Thread(new Judge(gamePlay));
		Thread p1 = new Thread(player1);
		Thread p2 = new Thread(player2);
		
		p1.start();
		p2.start();
		judge.start();

		// forcing to wait for both players to end the game before continuing
		try {
			p1.join();
			p2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// stops the judge when the game is over
		judge.interrupt();
		
		// prints the winner
		if (player1.getScore() == player2.getScore())
			System.out.println("tie");
		else if (player1.getScore() > player2.getScore())
			System.out.println("player 1 wins");
		else
			System.out.println("player 2 wins");
		
		// added to make sure there isn't a livelock
		if(p1.isAlive())
			System.out.println("p1 is alive");
		if(p2.isAlive())
			System.out.println("p2 is alive");
		if(judge.isAlive())
			System.out.println("j is alive");
	}
}
