package com.ralph.domain;

import java.util.ArrayList;

public class Test extends Object{

	public static void main(String[] args) {
	    ArrayList list = new ArrayList();
	    list.add(new Cat("AAA", 2, "Black"));
	    list.add(new Cat("CCC", 1, "yellow"));
	    
	    for(int i=0;i<list.size();i++)
	    {
	    	    System.out.println(list.get(i));
	    }
	}

}
