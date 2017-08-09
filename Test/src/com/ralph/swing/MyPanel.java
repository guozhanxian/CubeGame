package com.ralph.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private static Image carImg;
	static
	{
		try {
			carImg = ImageIO.read(MyPanel.class.getResource("car.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private int xxx = 30;
	private int yyy = 30;
	
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

	public MyPanel()
	{
		Toolkit tool = Toolkit.getDefaultToolkit();
		setSize(tool.getScreenSize().width/2, tool.getScreenSize().height/2);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		
		Ellipse2D.Double ell = new Ellipse2D.Double();
		ell.setFrame(100, 100, 100, 100);
		g2.setColor(Color.GREEN);
		g2.fill(ell);
		
		g2.drawImage(carImg, xxx, yyy, null);
	}
}
