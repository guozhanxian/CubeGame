package com.ralph.cube;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private Shape current;
	private Shape next;

	public static final int ROWS = 20;
	public static final int COLS = 10;
	public static final int SIZE = 26;
	private Cell[][] walls = new Cell[ROWS][COLS];

	private int score;
	private int lines;
	private Timer timer;

	public static final int FONT_SIZE = 20;
	public static final int FONT_COLOR = 0x679;

	private static Image background;
	public static Image I;
	public static Image L;
	public static Image T;
	public static Image O;
	public static Image S;
	public static Image Z;
	public static Image J;
	static {
		try {
			background = ImageIO.read(GamePanel.class.getResource("tetris.png"));
			I = ImageIO.read(GamePanel.class.getResource("I.png"));
			L = ImageIO.read(GamePanel.class.getResource("L.png"));
			T = ImageIO.read(GamePanel.class.getResource("T.png"));
			O = ImageIO.read(GamePanel.class.getResource("O.png"));
			S = ImageIO.read(GamePanel.class.getResource("S.png"));
			Z = ImageIO.read(GamePanel.class.getResource("Z.png"));
			J = ImageIO.read(GamePanel.class.getResource("J.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initAction() {
		// clearWalls，清空墙数组
		current = Shape.genShape();
		next = Shape.genShape();
		// 创建定时器，开始定时
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// 滑块下落
				cubeDropDown();
				repaint();
			}
		}, 700, 700);
		// 相关变量初始化
		// 绑定事件
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			    int code = e.getKeyCode();
			    switch(code)
			    {
			        case 37: moveLeft();break;//left
			        case 38: break;//up
			        case 39: moveRight();break;//right
			        case 40: break;//down
			    }
			    repaint();
			}
		});
		requestFocus();
	}
	private void moveLeft()
	{
		current.moveLeft();
	}
	private void moveRight()
	{
		current.moveRight();
	}
	private void cubeDropDown() {
		if (!isBottom()) {
			// 可以下落
			current.dropDown();
		} else {
			// 当前组件放到墙里
			// 判断墙里的内容有没有可以消除的行。
			// 交换current和next
			// 让next随机生成一个形状
			Cell[] cs = current.getCells();
			for (int i = 0; i < cs.length; i++) {
				int row = cs[i].getRow();
				int col = cs[i].getCol();
				walls[row][col] = cs[i];
			}

			current = next;
			next = Shape.genShape();
		}
	}

	@Override
	public void paint(Graphics g) {
		// 画背景
		g.drawImage(background, 0, 0, null);
		g.translate(10, 10);
		// 画当前形状
		paintCurrentShape(g);
		// 画下一个形状
		paintNextShape(g);
		// 画成绩
		paintScore(g);
		// 画Walls
		paintWall(g);
	}

	private void paintWall(Graphics g) {
		for (int line = 0; line < walls.length; line++) {
			Cell[] cs = walls[line];
			for (int col = 0; col < cs.length; col++) {
				Cell cell = cs[col];
				if (cell != null) {
					int x = cell.getRow() * SIZE;
					int y = cell.getCol() * SIZE;
					g.drawImage(cell.getImg(), y - 1, x - 1, null);
				}
			}
		}
	}

	private void paintScore(Graphics g2) {
		Graphics2D g = (Graphics2D) g2;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Font f = new Font(Font.SERIF, Font.BOLD, FONT_SIZE);
		g.setFont(f);
		g.setColor(new Color(FONT_COLOR));
		int x = 290;
		int y = 162;
		g.drawString("SCORE:", x, y);
		y += 56;
		g.drawString("LINES:", x, y);
		y += 56;
		g.drawString("停止：", x, y);
	}

	private void paintNextShape(Graphics g) {
		Cell[] cs = next.getCells();
		for (int i = 0; i < cs.length; i++) {
			int x = (cs[i].getCol() + 10) * SIZE + 1;
			int y = (cs[i].getRow() + 1) * SIZE + 1;
			g.drawImage(cs[i].getImg(), x, y, null);
		}
	}

	private void paintCurrentShape(Graphics g) {
		Cell[] cs = current.getCells();
		for (int i = 0; i < cs.length; i++) {
			int x = cs[i].getCol() * SIZE + 1;
			int y = cs[i].getRow() * SIZE + 1;
			g.drawImage(cs[i].getImg(), x, y, null);
		}
	}

	public boolean canMoveLeft() {
		return false;
	}

	public boolean canMoveRight() {
		return false;
	}

	public boolean isBottom() {
		Cell[] cs = current.getCells();
		for (int i = 0; i < cs.length; i++) {
			int xxx = cs[i].getRow();
			int yyy = cs[i].getCol();
			if ((xxx + 1) == ROWS || walls[xxx + 1][yyy] != null) {
				// 到底了，不能再移动了

				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		GamePanel p = new GamePanel();
		f.add(p);
		f.setSize(525, 550);
		f.setUndecorated(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("俄罗斯方块");
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		p.initAction();
	}
}
