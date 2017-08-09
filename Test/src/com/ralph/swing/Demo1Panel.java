package com.ralph.swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Demo1Panel extends JPanel {
	private JButton b1;
	private JButton b2;
	private JTextArea ja;

	public Demo1Panel() {
		setSize(200, 200);

		b1 = new JButton("粗体");
		b2 = new JButton("斜体");
		ja = new JTextArea(20, 30);

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(b1.getText().equals("粗体"))
				{
					ja.setFont(new Font("Arial", Font.BOLD, 14));
					b1.setText("正常");
				}else {
					ja.setFont(new Font("Arial", Font.PLAIN, 14));
					b1.setText("粗体");
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(b2.getText().equals("斜体"))
				{
					ja.setFont(new Font("Arial", Font.ITALIC, 14));
					b2.setText("非斜体");
				}else {
					ja.setFont(new Font("Arial", Font.PLAIN, 14));
					b2.setText("斜体");
				}
			}
		});

		add(b1);
		add(b2);
		add(ja);
	}
}
