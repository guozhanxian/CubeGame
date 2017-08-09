package com.ralph.domain;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyWindow extends JFrame {
	public MyWindow()
	{
		super.setSize(200, 300);
//		JButton btn = new JButton("我是一个按钮");
//		btn.setSize(35, 20);
//		JButton btn2 = new JButton("我是一个按钮");
//		btn2.setSize(35, 20);
//		
//		//面板
//		JPanel panel = new JPanel();
//		panel.add(btn);
//		panel.add(btn2);
//		
//		add(panel);
		
		JComponent j1 = new MyComp();
		add(j1);
	}
}
