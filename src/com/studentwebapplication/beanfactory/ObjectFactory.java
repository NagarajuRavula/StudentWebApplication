package com.studentwebapplication.beanfactory;

import org.apache.log4j.Logger;

public class ObjectFactory {

	public static Object getInstance(Class className) {

		Class name = null;
		Logger log = Logger.getLogger(ObjectFactory.class);
		Object obj = null;

		try {
			name = Class.forName(className.getName());
			obj = name.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			log.error(e);
		}
		return obj;
	}
}
