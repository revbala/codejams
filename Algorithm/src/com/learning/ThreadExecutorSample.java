package com.learning;

import java.util.concurrent.*;

public class ThreadExecutorSample {

	public static void main(String args[]) {

		ExecutorService executor = Executors.newFixedThreadPool(10);
//		executor.submit(()->System.out.println("Hi"));
//		executor.submit(()->System.out.println("Bye"));
//		System.out.println(executor.isShutdown());

		BoundedExecutor bexec = new BoundedExecutor(executor, 10);
		try {
			for (int i = 0; i <= 10; i++) {
				bexec.submitTask(new Runnable() {

					@Override
					public void run() {
						System.out.println("Hi");

					}
				});
			}
		} catch (InterruptedException ie) {
			executor.shutdown();
		}

	}

}

class BoundedExecutor {
	Executor executor;
	Semaphore semaphore;
	
	public BoundedExecutor(Executor exec, int bound) {
		semaphore = new Semaphore(bound);
		executor = exec;
	}

	public void submitTask(final Runnable command) throws InterruptedException {

		semaphore.acquire();
		try {
			executor.execute(new Runnable() {
				public void run() {
					try {
						command.run();
					} finally {
						semaphore.release();
					}
				}
			});
		} catch (RejectedExecutionException rje) {
			semaphore.release();
		}

	}
}