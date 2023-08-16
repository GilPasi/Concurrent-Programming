package assig3_2;

import java.util.concurrent.Semaphore;

public class HeavyWorker {
	
	private MySemaphore subSem = new MySemaphore(1);
	private MySemaphore mainSem = new MySemaphore(3);
	private boolean atLeast1A = false;//Make sure work A is performed at least one time


	public void section1() {
		


		System.out.println(Thread.currentThread().getName() + " is in section1");
		
		try {
			/* sleep to simulate some work... */
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + " leaving section1");
		

	}
	
	public void section2() {
		

		
		System.out.println(Thread.currentThread().getName() + " is in section2");
		try {
			/* sleep to simulate some work... */
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + " leaving section2");
		
		
	}
	
	public void workA() {
		
		//Only 3 threads can pass this semaphore

		mainSem.down();

		
		System.out.println(Thread.currentThread().getName() + " doing workA");
		atLeast1A = true;
		
		/* section1() can be called from up to 3 threads at the same time */
		section1();
		/* section2() can be called from one thread out of the 3 above    */	
		
		
		//Only one of the threads can pass this semaphore

		subSem.down();
		
		section2();
		
		subSem.up();
		mainSem.up();

		
	}
	
	public void workB() {
		
		while(!atLeast1A) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

		/* this will be printed only after workA() done at least once */
		System.out.println(Thread.currentThread().getName() + " doing workB");
	}
	
}
