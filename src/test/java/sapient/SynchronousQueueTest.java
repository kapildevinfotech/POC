/*package sapient;

import org.junit.Before;
import org.junit.Test;

import com.sapient.SynchnousQueue.SynchronousQueueCustom;
*//**
 * Test case of Synchronous Queue
 * @author kyada3
 *
 *//*
public class SynchronousQueueTest {
	SynchronousQueueCustom<Integer> queue;
	
	@Before
	public void createQueue(){
		queue=new SynchronousQueueCustom<Integer>();
	}
	
	*//**
	 * Thread Blocking Operation of put/take
	 * @throws InterruptedException
	 *//*
	@Test
	public void testSQ() throws InterruptedException{
		
		Thread consumer1=new Thread(new Consumer<Integer>(queue));
		consumer1.setName("Consumer 1");
		consumer1.start();
		Thread consumer2=new Thread(new Consumer<Integer>(queue));
		consumer2.setName("Consumer 2");
		consumer2.start();
		
		Thread.sleep(500);
		
		Thread producer1=new Thread(new Producer<Integer>(queue,1));
		producer1.setName("Producer 1");
		producer1.start();
		Thread producer2=new Thread(new Producer<Integer>(queue,2));
		producer2.setName("Producer 2");
		producer2.start();
	}
	
	*//**
	 * Producer Thread
	 * @author kyada3
	 * @param <E>
	 *//*
	class Producer<E> implements Runnable{
		
		SynchronousQueueCustom<E> queue;
		E item;
		
		public Producer(SynchronousQueueCustom<E> queue,E item) {
			this.queue=queue;
			this.item=item;
		}	
		@Override
		public void run(){
			try {
				queue.put(item);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	*//**
	 * Consumer Thread
	 * @author kyada3
	 * @param <E>
	 *//*
	class Consumer<E> implements Runnable {

		SynchronousQueueCustom<E> queue;
		E item;

		public Consumer(SynchronousQueueCustom<E> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				item = queue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
*/