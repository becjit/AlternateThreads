package com.concurrent.oddeven.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/* Alternately  Executing Thread Using Cyclic Barrier. 
 * This does not enforce any order .Any one of  the thread can execute
 * first . But this  ensure it executes 
 * either in "odd even" order or in "even odd" order */

public class OddEvenCyclicBarrier {
	
	public static void main(String[] args){
		
		CyclicBarrier barrier = new CyclicBarrier(2, new Runnable(){
			public void run(){
				System.out.println("Cycle Done");
			}
		});
		Thread evenThread =new Thread( new EvenThread(barrier));
		Thread oddThread = new Thread(new OddThread(barrier));
		
		//while (true){
			oddThread.start();
			evenThread.start();
		//}
		
		
		
	}

}
