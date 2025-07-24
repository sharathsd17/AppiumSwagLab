package Appconfig;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consists of generic methods related to specific
 * @author Sharath S
 */

public class JavaUtility 
{
/**
 * This method capture the date from util package and formate to as simpledateformate (user friendly)and return 
 * @return Date
 */

	public static String getSystemDate()
	{
		Date d =new Date();
		SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");//this is calender formate
	    String date=s.format(d);
	    return date;
	}
	
}
