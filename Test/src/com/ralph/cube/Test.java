package com.ralph.cube;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
	     int[][] walls = {{1,2,3},{4,5,6},{7,8,9},{6,6,6}};
	     
	     for(int i=2;i>=1;i--)
	     {
	    	     System.arraycopy(walls[i-1], 0, walls[i], 0, walls[i-1].length);
	     }
	     
	     Arrays.fill(walls[0], 0);
	     
	     for(int[] arr:walls)
	     {
	    	 	System.out.println(Arrays.toString(arr));
	     }
	}
}
