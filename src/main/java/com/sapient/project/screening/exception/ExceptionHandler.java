package com.sapient.project.screening.exception;

import java.io.File;
import java.lang.Thread.UncaughtExceptionHandler;

import com.sapient.project.screening.util.ThreadPoolFactory;

public class ExceptionHandler implements UncaughtExceptionHandler{
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t.getName() +"throws Excception : "+ e + "Stoping all Running Thread and deleting Created Files.");
		
		stopAllThreads();
		DeleteCreatedFiles(new File("D:/property_file"));

	}
	
	private void stopAllThreads(){
		System.out.println("Invoking Shutdown Now.");
		ThreadPoolFactory.getThreadPool().shutdownNow();
	}
	
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