package com.learning;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhiliosopher implements Runnable{
	
	private int bites = 10;
	private Chopstick lower, higher;
	
	public DiningPhiliosopher(Chopstick left, Chopstick right) {
		if(left.getNumber()>right.getNumber()) {
			this.lower = right;
			this.higher = left;
		}else {
			this.higher = right;
			this.lower = left;
		}
	}
	
	public void eat() {
		pickup();
		//eat
		putdown();
	}
	
	public void pickup() {		
		lower.pickup();
		higher.pickup();
	}
	
	public void putdown() {
		higher.putdown();
		lower.putdown();
	}
	
	public void run() {
		for (int i=0; i<bites; i++) {
			eat();
		}
	}
	
	public void main() {
		int i=1;
		while (i++<=5) {			
			DiningPhiliosopher phil = new DiningPhiliosopher(new Chopstick(i), new Chopstick(i+1));
			Thread t = new Thread(phil);
			t.start();			
		}
	}
}

class Chopstick{
	Lock lock = null;
	int number;
	
	public Chopstick(int number) {
		this.number = number;
		lock = new ReentrantLock();
	}
	
	public void pickup() {
		lock.lock();
	}
	
	public void putdown() {
		lock.unlock();
	}
	
	public int getNumber() {
		return number;
	}
}
