package com.ralph.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Demo1Frame extends JFrame {
	public Demo1Frame() {
		setSize(200, 200);
		JPanel p = new Demo1Panel();
		add(p);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame f = new Demo1Frame();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
			}
		});
	}
}
