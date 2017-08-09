package com.ralph.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class MyComp extends JComponent {
	public MyComp()
	{
		setSize(100, 100);
	}
	
	private static Image carImg;
	private int x = 20;
	private int y = 50;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	static
	{
		try {
			carImg = ImageIO.read(MyComp.class.getResource("car.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(carImg,x,y,null);
	}
}
