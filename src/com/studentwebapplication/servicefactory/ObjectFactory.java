package com.studentwebapplication.servicefactory;

public class ObjectFactory {

	public static Object getInstance(Class className) {

		Class name = null;

		Object obj = null;

		try {
			name = Class.forName(className.getName());
			obj = name.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
