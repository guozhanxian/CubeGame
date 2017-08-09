package com.ralph.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class MyComp2 extends JComponent {
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Font f = new Font("LiSong Pro",Font.BOLD,16);
		g2.setFont(f);
		Color c = new Color(0, 255, 0);
		g2.setColor(c);
		g2.drawString("我是蝈蝈！", 150, 50);
		
		Ellipse2D.Double ss = new Ellipse2D.Double();
		ss.setFrame(200, 200, 150, 150);
		g2.setColor(Color.RED);
		g2.fill(ss);

	}
}
