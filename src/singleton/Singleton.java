package singleton;

import java.util.ArrayList;

import Church.Church;


public class Singleton {
	
	private static Singleton s = null;
	private Singleton () {};
	
	public ArrayList <Church> list = new ArrayList<>();
	
	public static Singleton getInstance () {
		if(s == null)
			s = new Singleton();
		return s;
	}
	
}