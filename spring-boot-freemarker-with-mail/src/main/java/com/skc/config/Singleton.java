package com.skc.config;


public class Singleton {
	
	
	private static Singleton singleton = null;
	
	public static Singleton getData() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}

}
