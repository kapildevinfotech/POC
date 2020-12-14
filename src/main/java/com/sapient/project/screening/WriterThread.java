package com.sapient.project.screening;

import com.sapient.project.screening.util.ConnectionFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;


class WriterThread implements Runnable {
	
	private final static Connection CONNECTION = ConnectionFactory.getConnInstance();
	
	int startIndex;
	int endIndex;
	int fetchSize;

	public WriterThread(int startIndex, int endIndex,int fetchSize) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.fetchSize=fetchSize;
	}

	public void run() {/*

		ResultSet result = null;
		String sql = "select * from property_details where file_id between ? and ?";
		
		//Use : FetchSize(Default is 10) and Result set Forward iteration with concurrent Read Only
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
								ResultSet.CONCUR_READ_ONLY);
				       										)
		{
			stmt.setFetchSize(fetchSize);
			
			System.out.println(Thread.currentThread() + "start Index : "
					+ startIndex + "| EndIndex :" + endIndex);
			stmt.setInt(1, startIndex);
			stmt.setInt(2, endIndex);
			
			result = stmt.executeQuery();

			String filePath;
			String key;
			String value;
			//FileDto file;

			while (result.next()) {
				filePath = result.getString("file_path");
				key = result.getString("file_key");
				value = result.getString("file_value");

				//file = new FileDto(filePath, key, value);

				StringBuilder buffer = new StringBuilder();
				//buffer.append(file.getKey()).append("=")
					//	.append(file.getValue()).append(System.lineSeparator());
				ByteBuffer byteBuffer = ByteBuffer.wrap(buffer.toString()
						.getBytes());

				Set<StandardOpenOption> options = new HashSet<StandardOpenOption>();
				options.add(StandardOpenOption.CREATE);
				options.add(StandardOpenOption.APPEND);

				//Path path = Paths.get(file.getFilePath());
				//Files.createDirectories(path);
				//Path filePathtoCreate = Paths.get(file.getFilePath(),
					//	"propertise.props");

				//FileChannel fileChannel = FileChannel.open(filePathtoCreate,
					//	options);
				//fileChannel.write(byteBuffer);
				//fileChannel.close();
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	*/}
}
