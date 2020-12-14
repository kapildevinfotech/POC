package com.sapient.project.screening.SynchnousQueue;

public class SynchronousQueueCustom<E> implements BlockingQueueCustom<E> {

	boolean addingItem = false;
	E item = null;

	public synchronized E take() throws InterruptedException {
		//Consumer wait till Producer available
		while (item == null){
			System.out.println(Thread.currentThread().getName() +" Blocking Wait");
			wait();
		}
		
		E e = item;
		item = null;
		notifyAll();
		
		System.out.println(Thread.currentThread().getName() +" Taking Item : " + e);
		
		return e;
	}

	public synchronized void put(E e) throws InterruptedException {
		if (e == null){
			return;
		}
		//Producer Wait till another producer hand-off items to Consumer
		while (addingItem){
			wait();
		}
		addingItem = true;
		item = e;
		notifyAll();
		
		System.out.println(Thread.currentThread().getName()+" Adding item : " +item);
		
		//Wait for the Consumer to consume items
		while (item != null){
			wait();
		}
		addingItem = false;
		notifyAll();
	}
}