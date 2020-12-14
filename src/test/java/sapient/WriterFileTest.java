/*package sapient;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.sapient.project.screening.WritePropertyFile;

*//*
public class WriterFileTest
{
    *//**
     * create the property File
     * No of Thread : Concurrent thread able to read database and writing to file to adjust concurrency level.
     * @throws SQLException 
     *//*
	
	@Ignore
    public void createData() throws SQLException
    {
		WritePropertyFile.createData();
    }
	
	@Test
    public void testApp()
    {
    	int noOfThreads=10;
    	int fetchSize=1000;
    	WritePropertyFile.LoadData(noOfThreads,fetchSize);
    }
	
	*//**
	 * Test Case to check Is property file created.
	 *//*
	@Test
	public void isPropertyfileCreated(){
		File goldman=new File("D:/property_file/Goldman/propertise.props");
		File rbs=new File("D:/property_file/RBS/propertise.props");
		File wellington=new File("D:/property_file/Wellington/propertise.props");
		
		Assert.assertTrue(goldman.isFile());
		Assert.assertTrue(rbs.isFile());
		Assert.assertTrue(wellington.isFile());
	}
	
	*//**
	 * Count No of Record Written in File
	 *//*
	@Test
	public void propertyCountInFile(){
		
		int expectedGoldman=10000;
		String goldman="D:/property_file/Goldman/propertise.props";
		int actualGoldman=recordCount(goldman);
		assertEquals(expectedGoldman,actualGoldman);
		
		int expectedRBS=10000;
		String rbs="D:/property_file/RBS/propertise.props";
		int actualRbs=recordCount(rbs);
		assertEquals(expectedRBS,actualRbs);
		
		int expectedWellington=9999;
		String wellington="D:/property_file/Wellington/propertise.props";
		int actualWellington=recordCount(wellington);
		assertEquals(expectedWellington,actualWellington);
	}

	@Test
	public void checkContentinFile(){
		String regex="key\\d+=value\\d+";//key1@=Value1@
		
		boolean expectedGoldman=true;
		String goldman="D:/property_file/Goldman/propertise.props";
		boolean actualGoldman=contentMatch(goldman, regex);
		assertEquals(expectedGoldman,actualGoldman);
		
		boolean expectedRBS=true;
		String rbs="D:/property_file/RBS/propertise.props";
		boolean actualRbs=contentMatch(rbs, regex);
		assertEquals(expectedRBS,actualRbs);
		
		boolean expectedWellington=true;
		String wellington="D:/property_file/Wellington/propertise.props";
		boolean actualWellington=contentMatch(wellington, regex);
		assertEquals(expectedWellington,actualWellington);
	}
	
	*//**
	 * Compute record count
	 * @param file
	 * @return count
	 *//*
	private int recordCount(String file){
		int count=0;
		String line = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(new File(file)))) {
			
		    while ((line = br.readLine()) != null) {
		       count++;
		    }
		} catch (Exception e) {
			System.out.println(line);
		}
		return count;
	}
	*//**
	 * match the file content
	 * @param file
	 * @param regex
	 * @return boolean
	 *//*
	private boolean contentMatch(String file,String regex){
		boolean match=true;
		
		try (BufferedReader br = new BufferedReader(new FileReader(new File(file)))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       if(!line.matches(regex)){
		    	   match=false;
		    	   break;
		       }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return match;
	}
}*/