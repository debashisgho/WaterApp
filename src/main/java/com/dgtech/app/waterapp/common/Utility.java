package com.dgtech.app.WaterApp.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Utility {
	
	public final static String defaultDateFormat = "yyyy/MM/dd HH:mm:ss";
	
	public static Date getCurrentDate(String dateFormatStr) throws Exception{
		DateFormat sdf = new SimpleDateFormat(dateFormatStr);
    	Date date = sdf.parse(sdf.format(new Date()));
    	return date;
	}
	
	public static Date getFormattedDate(String dateFormatStr, String dateStr) throws Exception{
		DateFormat sdf = new SimpleDateFormat(dateFormatStr);
    	//Date date = sdf.parse(sdf.format(new Date()));
		Date date = sdf.parse(dateStr);
    	return date;
	}
	
}
