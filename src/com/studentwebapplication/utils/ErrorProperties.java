package com.studentwebapplication.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.studentwebapplication.beanfactory.ObjectFactory;

public class ErrorProperties {

	public static Properties getProperty()
	{
		Properties props = (Properties) ObjectFactory.getInstance(Properties.class);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(
					"/home/nagarajur/workspace/StudentWebApplication/src/resources/errorMessage.properties");
			props.load(fis);
		} catch (Exception e) {
			e.printStackTrace();

		}
		finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return props;
	}
}
