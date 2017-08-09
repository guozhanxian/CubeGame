package com.ralph.swing;

import java.awt.GraphicsEnvironment;
import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) {
		String[] arr = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		System.out.println(Arrays.toString(arr));
	}

}
	