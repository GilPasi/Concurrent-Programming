/*System-Programming : Assignment 3
 *Authors: Yulia Moshan 319565610
 *			Gil Pasi    206500936 */
public class Runner {
	
	public static void main (String [] args) {
		
		GamePlay gp = new GamePlay();
		
		Gamer g1 = new Gamer(gp);
		Gamer g2 = new Gamer(gp);
		Judge j = new Judge(gp);
		
		j.start();
		g1.start();
		g2.start();
		
		while(gp.getNumOfRounds() <= 10) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
		}
			
		g1.interrupt();
		g2.interrupt();
		j.interrupt();
		
		
		if(g1.getScore() > g2.getScore()) {
			System.out.println("The winner is " + g1.getName());
		}
		else if (g1.getScore() < g2.getScore())
			System.out.println("The winner is " + g2.getName());
		
		else
			System.out.println("tie");
		
		
		if(g1.isAlive()) {
			System.out.println("t1 alive");
		}
		if(g2.isAlive()) {
			System.out.println("t2 alive");
		}
		if(j.isAlive()) {
			System.out.println("j alive");
		}
	}

}
