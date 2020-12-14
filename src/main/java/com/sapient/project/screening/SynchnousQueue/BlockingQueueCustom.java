package com.sapient.project.screening.SynchnousQueue;

interface BlockingQueueCustom<E> {
      void put(E item)  throws InterruptedException ;
      E take()  throws InterruptedException;
}