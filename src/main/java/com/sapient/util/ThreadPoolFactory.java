package com.sapient.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Create new connection when requested
 * @author kyada3
 *
 */
public class ThreadPoolFactory {
	
	private static final ExecutorService executor=Executors.newCachedThreadPool();
	
	/**
	 * Get the Thread pool to manage the worker thread to write file.
	 * @return connection
	 */
	public static ExecutorService getThreadPool(){
		return executor;
	}
	
}
