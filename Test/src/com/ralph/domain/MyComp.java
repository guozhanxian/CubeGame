package com.ralph.domain;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class MyComp extends JComponent {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.drawString("Hello,我是蝈蝈！", 30, 100);
	}
}
