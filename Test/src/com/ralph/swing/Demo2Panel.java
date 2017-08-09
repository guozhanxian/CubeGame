package com.ralph.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Demo2Panel extends JPanel {
	private static Image carImg;
	static {
		try {
			carImg = ImageIO.read(Demo2Panel.class.getResource("car.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Demo2Panel() {
		Toolkit tool = Toolkit.getDefaultToolkit();
		setSize(tool.getScreenSize().width / 2, tool.getScreenSize().height / 2);
	}
	
	private int xxx = 10;
	private int yyy = 10;
	public int getXxx() {
		return xxx;
	}
	public void setXxx(int xxx) {
		this.xxx = xxx;
	}
	public int getYyy() {
		return yyy;
	}
	public void setYyy(int yyy) {
		this.yyy = yyy;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(carImg, xxx, yyy, null);
	}
}
