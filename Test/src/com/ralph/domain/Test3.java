package com.ralph.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test3 {
	public static void main(String[] args) {
	    Cat c1 = new Cat("AAA",2,"Black");
	    Cat c2 = new Cat("BBB",1,"White");
	    
	    //System.out.println(c1.compareTo(c2));
	    
	    List list = new ArrayList();
	    list.add(c1);
	    list.add(c2);
	    
	    Collections.sort(list,new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Cat c1 = (Cat)o1;
				Cat c2 = (Cat)o2;
				return c1.getAge()-c2.getAge();
			}
		});
	    for(int i=0;i<list.size();i++)
	    {
	    		System.out.println(list.get(i));
	    }
	    
	    int[] arr = {10,5,8,3,12,7};
	    Arrays.sort(arr);
	    System.out.println(Arrays.toString(arr));
	}
}
