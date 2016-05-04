package com.sapient.exception;

import java.io.File;
import java.lang.Thread.UncaughtExceptionHandler;

import com.sapient.util.ThreadPoolFactory;
/**
 * Delete all created Thread property files if any exception happens 
 * @author kyada3
 *
 */
public class ExceptionHandler implements UncaughtExceptionHandler{
	
	/**
	 * Invoke when Exception Occurs by stoping all running thread and deleting already written file.
	 */
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t.getName() +"throws Excception : "+ e + "Stoping all Running Thread and deleting Created Files.");
		
		stopAllThreads();
		DeleteCreatedFiles(new File("D:/property_file"));
	}
	
	/**
	 * Cancel the Running Task
	 */
	private void stopAllThreads(){
		System.out.println("Invoking Shutdown Now.");
		ThreadPoolFactory.getThreadPool().shutdownNow();
	}
	
	/**
	 * Delete the created files
	 * @param file
	 */
	void DeleteCreatedFiles(File file) {
	    File[] contents = file.listFiles();
	    if (contents != null) {
	        for (File f : contents) {
	        	DeleteCreatedFiles(f);
	        }
	    }
	    file.delete();
	}
}