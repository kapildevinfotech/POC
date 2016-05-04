package com.sapient.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * Connection factory is a singleton factory method to provide instance of DB.
 * @author kyada3
 */
public class ConnectionFactory {

	private static MysqlDataSource conn = null;

	/**
	 * Get the DB connection to read data
	 * 
	 * @return connection
	 */
	public static MysqlDataSource getConnInstance() {
		if (conn == null) {
			return getDBConnection();
		}
		return conn;
	}

	/**
	 * Method to create DB connection
	 * 
	 * @return connection
	 */
	private static MysqlDataSource getDBConnection() {
		try {
			Properties props = getDBConnectionProperty();
			String connectionUrl = props.getProperty("connectionUrl");
			String dbUser = props.getProperty("user");
			String dbPwd = props.getProperty("password");

			conn = new MysqlDataSource();
			conn.setUrl(connectionUrl);
			conn.setUser(dbUser);
			conn.setPassword(dbPwd);

		} catch (Exception ex) {
			System.out.println("Exception :" + ex);
		}
		return conn;
	}

	/**
	 * Load the dataBase property to connect to DB
	 * 
	 * @return
	 */
	private static Properties getDBConnectionProperty() {
		Properties prop = new Properties();
		String propFileName = "database.propertise";

		try (InputStream inputStream = ConnectionFactory.class.getClassLoader()
				.getResourceAsStream(propFileName)) {
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '"
						+ propFileName + "' not found in the classpath");
			}
		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
		}
		return prop;
	}
}
