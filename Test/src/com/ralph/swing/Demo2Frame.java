package com.ralph.swing;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Demo2Frame extends JFrame {
	public Demo2Frame() {
		Toolkit tool = Toolkit.getDefaultToolkit();
		setSize(tool.getScreenSize().width / 2, tool.getScreenSize().height / 2);
		setLocation(tool.getScreenSize().width / 4, tool.getScreenSize().height / 4);

		Demo2Panel p = new Demo2Panel();
		add(p);

		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == 38) {
					p.setYyy(p.getYyy() - 5);
					repaint();
				} else if (code == 40) {
					p.setYyy(p.getYyy() + 5);
					repaint();
				} else if (code == 37) {
					p.setXxx(p.getXxx() - 5);
					repaint();
				} else if (code == 39) {
					p.setXxx(p.getXxx() + 5);
					repaint();
				}
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				JFrame f = new Demo2Frame();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
			}
		});
	}
}
