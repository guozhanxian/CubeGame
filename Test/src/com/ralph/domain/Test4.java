package com.ralph.domain;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Test4 {

	public static void main(String[] args) {
		Test4 t = new Test4();
		Test4.MyThread t2 = t.new MyThread();
	     EventQueue.invokeLater(t2);
	}
	
	class MyThread implements Runnable
	{
		@Override
		public void run() {
			JFrame f = new MyWindow();
		     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     f.setTitle("这是一个窗体");
		     f.setVisible(true);
		}
	}

}
