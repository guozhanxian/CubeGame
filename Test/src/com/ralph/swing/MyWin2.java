package com.ralph.swing;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyWin2 extends JFrame {
	private JButton b1, b2;
	private JTextField jt;

	public JButton getB1() {
		return b1;
	}

	public void setB1(JButton b1) {
		this.b1 = b1;
	}

	public JButton getB2() {
		return b2;
	}

	public void setB2(JButton b2) {
		this.b2 = b2;
	}

	public JTextField getJt() {
		return jt;
	}

	public void setJt(JTextField jt) {
		this.jt = jt;
	}

	public MyWin2() {
		setSize(200, 200);
		setLayout(new FlowLayout());
		b1 = new JButton("我是第一个按钮");
		b1.setSize(80, 30);
		b2 = new JButton("我是第二个按钮");
		b2.setSize(80, 30);
		jt = new JTextField(10);

		// TouchHandler h = new TouchHandler(this);
		// b1.addActionListener(h);
		// b2.addActionListener(h);
		// ButtonHandler h = new ButtonHandler();
		// b1.addActionListener(h);
		// b2.addActionListener(h);

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jt.setText("第一个按钮");
			}
		});

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jt.setText("第二个按钮");
			}
		});

		add(b1);
		add(b2);
		add(jt);
	}

	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b1) {
				jt.setText("First");
			} else if (e.getSource() == b2) {
				jt.setText("Second");
			}
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				MyWin2 w = new MyWin2();
				w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				w.setVisible(true);
			}
		});
	}
}
