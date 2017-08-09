package com.ralph.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class MyWin extends JFrame {
	private Timer timer;
	public MyWin() {
		Toolkit tool = Toolkit.getDefaultToolkit();
		setSize(tool.getScreenSize().width/2, tool.getScreenSize().height/2);
		setLocation(tool.getScreenSize().width/4, tool.getScreenSize().height/4);
		
		MyPanel p = new MyPanel();
		add(p);
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
			    p.setXxx(p.getXxx()+5);
			    repaint();
			}
		}, 700,700);
	}
}
