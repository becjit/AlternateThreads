package com.concurrent.oddeven.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class OddThread implements Runnable {
	
private CyclicBarrier barrier;
private  int lastCount =0; 
	
	public OddThread(CyclicBarrier barrier){
		
		this.barrier = barrier;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i=0; i< 100;i++){
//			
			try {
				//semaphore.acquire();
				int number= 2*lastCount+1;
				System.out.println("Odd = " +  number);
				lastCount++;
				//semaphore.release();
				barrier.await();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
