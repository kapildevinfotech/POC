package com.sapient.SynchnousQueue;
/**
 * Blocking Queue 
 * @author kyada3
 * @param <E>
 */
interface BlockingQueueCustom<E> {
      void put(E item)  throws InterruptedException ;
      E take()  throws InterruptedException;
}