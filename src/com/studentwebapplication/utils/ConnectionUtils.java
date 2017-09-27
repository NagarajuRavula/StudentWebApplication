package com.studentwebapplication.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import org.apache.log4j.Logger;

import com.studentwebapplication.beanfactory.*;

public class ConnectionUtils {
	private static Connection con = null;
	private static Logger log = Logger.getLogger(ConnectionUtils.class);

	private ConnectionUtils() {

	}

	public static Connection getConnection() {
		Properties props = (Properties) ObjectFactory.getInstance(Properties.class);
		FileInputStream fis = null;
		try {

			fis = new FileInputStream("/home/nagarajur/workspace/StudentWebApp/src/resources/db.properties");
			props.load(fis);
			Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			con = DriverManager.getConnection(props.getProperty("DB_URL"), props.getProperty("DB_USERNAME"),
					props.getProperty("DB_PASSWORD"));

		} catch (Exception e) {
			log.error(e);
		}

		return con;

	}

}