package com.sapient.project.screening.model;
/**
 * File Object used to represent row data of Database
 * @author kyada3
 */
public class FileDto {
	
	private String filePath;
	private String key;
	private String value;
	
	public FileDto(String filePath, String key, String value){
		this.filePath=filePath;
		this.key=key;
		this.value=value;
	}
	
	@Override
	public String toString() {
		return key+"="+value;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
