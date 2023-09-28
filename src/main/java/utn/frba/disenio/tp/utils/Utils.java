package utn.frba.disenio.tp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public static Date stringToDate(String dateSt,String format) {
		try {
			return dateSt!=null?new SimpleDateFormat(format).parse(dateSt):null;  
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
