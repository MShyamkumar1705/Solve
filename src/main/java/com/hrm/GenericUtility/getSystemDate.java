package com.hrm.GenericUtility;

import java.util.Date;

public class getSystemDate {

	public static void main(String[] args) {

		Date date=new Date();
		String dateAndTime = date.toString();
		String yyyy=dateAndTime.split(" ")[5];
		String dd = dateAndTime.split(" ")[2];
		String mm = dateAndTime.split(" ")[2];
		
		String finalDate = yyyy+ " "+mm+ " "+dd;
		System.out.println(finalDate);
	}

}
