package com.xxy.community.community.provider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
* @descript
* @author kongz
* @since 2017年2月27日 下午2:49:14
*/
public class DataType {
	public static String getDataType() throws IOException{
		String result = null;
		InputStream inStream = DataType.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		Properties prop = new Properties();
		prop.load(inStream);
		result  = prop.getProperty("dialect");
		if(result == null){
			result = "mysql";
		}
		return result;
	}
	/*public static void main(String[] args) throws IOException {
		System.out.println(getDataType());
	}*/
}
