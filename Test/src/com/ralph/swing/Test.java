package com.ralph.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame f = new MyWin();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
			}
		});
	}

}
