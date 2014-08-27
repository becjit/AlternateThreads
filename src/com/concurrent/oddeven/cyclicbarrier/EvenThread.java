package com.concurrent.oddeven.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class EvenThread implements Runnable {
	
	private CyclicBarrier barrier;
	
	private int lastCount =0;
	
	public EvenThread(CyclicBarrier barrier){
		
		this.barrier = barrier;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i< 100;i++){
//			
			try {
//				semaphore.acquire();
				int number= 2*lastCount +2;
				System.out.println("Even = " +  number);
				lastCount++;
				barrier.await();
				Thread.sleep(1000);
//				semaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			
		}

	}

}
