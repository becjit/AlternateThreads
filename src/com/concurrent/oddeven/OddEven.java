package com.concurrent.oddeven;

import java.util.concurrent.Semaphore;

public class OddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Semaphore semaphore = new Semaphore(1,true);
		
		Runnable oddThread = new OddThread(semaphore);
		Runnable evenThread = new EvenThread(semaphore);
		
		
		new Thread(oddThread).start();
		new Thread(evenThread).start();

	}

}
