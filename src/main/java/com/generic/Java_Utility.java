package com.generic;

import java.util.Date;
import java.util.Random;

/**
 * This class is used to perform all Java functions
 * @author HP USER
 *
 */
public class Java_Utility {

	/**
	 * @author Satyajeet
	 * This method creates random numbers upto 1000
	 * @return
	 */
	public int randomnum()
	{
		Random r=new Random();
		int ran=r.nextInt(1000);
		return ran;
	}

	/**
	 * @author Satyajeet
	 * This method is used to fetch current day
	 * @return
	 */
	public String currentday()
	{
		Date d=new Date();
		System.out.println(d.toString());
		String currentdate=d.toString();
		String[] arr = currentdate.split(" ");
		String day = arr[0];
		return day;

	}

	/**
	 * @author Satyajeet
	 * This method is used to fetch month
	 * @return
	 */
	public String month()
	{
		Date d=new Date();
		System.out.println(d.toString());
		String currentdate=d.toString();
		String[] arr = currentdate.split(" ");
		String month = arr[1];
		return month;
	}

	/**
	 * @author Satyajeet
	 * This method is used to fetch date
	 * @return
	 */
	public String date()
	{
		Date d=new Date();
		System.out.println(d.toString());
		String currentdate=d.toString();
		String[] arr = currentdate.split(" ");
		String todaysdate = arr[2];
		return todaysdate;
	}

	/**
	 * @author Satyajeet
	 * This method is used to fetch year
	 * @return
	 */
	public String year()
	{
		Date d=new Date();
		System.out.println(d.toString());
		String currentdate=d.toString();
		String[] arr = currentdate.split(" ");
		String year = arr[5];
		return year;
	}
	
	public String time()
	{
		Date d=new Date();
		System.out.println(d.toString());
		String currentdate=d.toString();
		String[] arr = currentdate.split(" ");
		String time = arr[3];
		return time;
	}


}


