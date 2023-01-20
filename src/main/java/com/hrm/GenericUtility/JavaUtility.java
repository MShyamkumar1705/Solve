package com.hrm.GenericUtility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random r=new Random();
		int random = r.nextInt(500);
		return random;
	}
	/**
	 * 
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date d=new Date();
		return d.toString();
	}
	/**
	 * 
	 * @return
	 */
	public String getSystemDateWithFormat() {
		Date date=new Date();
		String dateAndTime = date.toString();
		String yyyy=dateAndTime.split(" ")[5];
		String dd = dateAndTime.split(" ")[2];
		String mm = dateAndTime.split(" ")[2];
		
		String finalDate = yyyy+ " "+mm+ " "+dd;
		return finalDate;
		
	}
	
	public String docsUpload() {
		File docx=new File("./src/test/resources/Mshyamkumar.docx");
		String docsPath = docx.getAbsolutePath();
		return docsPath;
		
	}
	public String SystemDateAndTime() {
				SimpleDateFormat dateformat = new SimpleDateFormat("dd-mm-yy HH:MM:SS");
				Date systemDate = new Date();
				String getDateAndTime = dateformat.format(systemDate);
				System.out.println(getDateAndTime);
				return getDateAndTime;
				
				
		
	}

}
