package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class pinBallPanel extends JPanel {

	Graphics2D g2;

	private int x1 = 0;
	private int y1 = 0;

	private int x2 = 220;

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	private int y2 = 522;

	public pinBallPanel() {

		// Toolkit tool= Toolkit.getDefaultToolkit();
		setSize(600, 500);

	}

	public void paint(Graphics g) {
		g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		g2.fillOval(x1, y1, 40, 40);
		// Rectangle rectangleB = new Recatangle(x,y,width,height);
		// rectangleA.intersects(rectangleB) //
		// 传入一个矩形类参数，如果碰撞则返回true，反之则返回false</span>
		g2.fillRect(x2, y2, 150, 15);
		if (getX1() > 520) {
			Font f = new Font("幼圆", Font.BOLD, 50);
			setFont(f);
			g2.drawString("游戏结束", 250, 250);

		}

	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

}
