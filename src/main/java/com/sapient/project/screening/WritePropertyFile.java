package com.sapient.project.screening;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import com.sapient.project.screening.exception.ExceptionHandler;
import com.sapient.project.screening.util.ConnectionFactory;
import com.sapient.project.screening.util.ThreadPoolFactory;

/**
 * Class to provide the writing of multithreaded property file.
 * 
 * @author kyada3
 * 
 */
public class WritePropertyFile {

   private final static ExecutorService executors = ThreadPoolFactory.getThreadPool();
   private final static DataSource dataSource=(DataSource) ConnectionFactory.getConnInstance();

   	public static void createData() throws SQLException{
   		String sql="insert into property_details(file_path,file_key,file_value) values(?,?,?)";
		
		Connection connection =dataSource.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql); 
			
			for( int i=40000;i<45000;i++){
				
				stmt.setString(1, "D:/property_file/Wellington");
				stmt.setString(2,"key"+i);
				stmt.setString(3, "Value"+i);
				stmt.addBatch();
			}
			stmt.executeBatch();
   	}
   	
	public static void LoadData(int noOfThreads,int fetchSize) {
		String sql="select count(1) as count from property_details";
		
		try(Connection connection =dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(sql);) {

			// Create the threads
			Thread[] threadList = new Thread[noOfThreads];
			// Compute the Size of Records in Database
			
			result.next();
			int recordsize = result.getInt("count");

			// Compute the no of records fetch by each thread
			int mod = recordsize % noOfThreads;
			int recordToFetch = (recordsize + mod) / noOfThreads;

			// Index of file Id to fetch by each thread.
			int startIndex;
			int endIndex;

			//Create Worker Threads
			for (int i = 1; i <= noOfThreads; i++) {
				
				startIndex = recordToFetch * (i - 1) + 1;
				endIndex = recordToFetch * i;
				
				threadList[i - 1] = new Thread(new WriterThread(startIndex,endIndex,fetchSize));
				threadList[i - 1].setUncaughtExceptionHandler(new ExceptionHandler());// Set custom Exception handler
				
				executors.execute(threadList[i - 1]);
			}

			executors.shutdown();
			executors.awaitTermination(1, TimeUnit.HOURS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
