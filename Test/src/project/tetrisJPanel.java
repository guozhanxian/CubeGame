package project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tetrisJPanel extends JPanel implements ActionListener, KeyListener {

	JButton newgame = new JButton("开始");
	JButton endgame = new JButton("退出");
	tetrisAct[] act = new tetrisAct[4];
	tetrisAct[] actTemp = new tetrisAct[4];
	int score = 0, speed = 0, tscore = 0;
	Random r = new Random();
	boolean start = false;
	int[][] map = new int[10][18];
	Timer t;
	int temp;
	JDialog dialog = new JDialog();
	JLabel label = new JLabel();
	JButton button = new JButton("ok");

	public tetrisJPanel() {

		// setSize(510, 640);
		for (int i = 0; i < act.length; i++) {
			act[i] = new tetrisAct();
		}
		for (int i = 0; i < act.length; i++) {
			actTemp[i] = new tetrisAct();
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 18; j++) {
				map[i][j] = 0;
			}
		}

		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(newgame);
		add(endgame);
		newgame.addActionListener(this);
		endgame.addActionListener(this);
		addKeyListener(this);
		dialog.setLayout(new GridLayout(2, 1));
		dialog.add(label);
		dialog.add(button);
		button.addActionListener(this);
		dialog.setSize(200, 100);
		dialog.setLocation(200, 200);
		dialog.setVisible(false);

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		// Graphics2D g2 = (Graphics2D) g;
		g.drawRect(9, 10, 200, 360);
		g.drawString("分数:  " + score, 220, 60);
		g.drawLine(220, 65, 360, 65);
		g.drawString("速度:  " + speed, 220, 90);
		g.drawLine(220, 95, 360, 95);
		g.drawString("下一个方块", 250, 120);
		g.drawString("俄罗斯方块1.0V", 220, 340);
		g.drawString("@little硕", 220, 360);

		// 绘制形状
		if (start) {
			g.setColor(Color.BLUE);
			for (int i = 0; i < 4; i++) {
				g.fillRect(10 + act[i].x * 20, 10 + act[i].y * 20, 20, 20);
			}
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 18; j++) {
					if (map[i][j] >= 1) {
						g.setColor(Color.RED);
						g.fillRect(10 + i * 20, 10 + j * 20, 20, 20);
					}
				}
			}
			g.setColor(new Color(0, 0, 255));
			for (int i = 0; i < 4; i++) {
				g.fillRect(220 + actTemp[i].x * 20, 160 + actTemp[i].y * 20,
						20, 20);
			}
		}

	}

	// 用于产生新方块
	private boolean newAct() {
		// TODO Auto-generated method stub
		switch (temp) {
		// 长棒形
		case 0:
			act[0].setX(1);
			act[0].setY(0);
			act[1].setX(2);
			act[1].setY(0);
			act[2].setX(3);
			act[2].setY(0);
			act[3].setX(4);
			act[3].setY(0);
			break;
		// 田字形
		case 1:
			act[0].setX(2);
			act[0].setY(0);
			act[1].setX(3);
			act[1].setY(0);
			act[2].setX(2);
			act[2].setY(1);
			act[3].setX(3);
			act[3].setY(1);
			break;
		// 正L形
		case 2:
			act[0].setX(2);
			act[0].setY(0);
			act[1].setX(2);
			act[1].setY(1);
			act[2].setX(2);
			act[2].setY(2);
			act[3].setX(3);
			act[3].setY(2);
			break;
		// 反L形
		case 3:
			act[0].setX(3);
			act[0].setY(0);
			act[1].setX(3);
			act[1].setY(1);
			act[2].setX(3);
			act[2].setY(2);
			act[3].setX(2);
			act[3].setY(2);
			break;
		// 土字形
		case 4:
			act[0].setX(3);
			act[0].setY(0);
			act[1].setX(2);
			act[1].setY(1);
			act[2].setX(3);
			act[2].setY(1);
			act[3].setX(4);
			act[3].setY(1);
			break;

		// Z字形
		case 5:
			act[0].setX(2);
			act[0].setY(0);
			act[1].setX(3);
			act[1].setY(0);
			act[2].setX(3);
			act[2].setY(1);
			act[3].setX(4);
			act[3].setY(1);
			break;
		// S字形
		case 6:
			act[0].setX(3);
			act[0].setY(0);
			act[1].setX(4);
			act[1].setY(0);
			act[2].setX(2);
			act[2].setY(1);
			act[3].setX(3);
			act[3].setY(1);
			break;
		default:
			System.out.println("没有这个形状！");
			break;
		}
		for (int i = 0; i < 4; i++) {
			if (maxYes(act[i].x, act[i].y)) {
				return false;
			}
		}

		return true;
	}

	public void nextAct() {
		switch (temp) {
		// 长棒形
		case 0:
			actTemp[0].setX(1);
			actTemp[0].setY(0);
			actTemp[1].setX(2);
			actTemp[1].setY(0);
			actTemp[2].setX(3);
			actTemp[2].setY(0);
			actTemp[3].setX(4);
			actTemp[3].setY(0);
			break;
		// 田字形
		case 1:
			actTemp[0].setX(2);
			actTemp[0].setY(0);
			actTemp[1].setX(3);
			actTemp[1].setY(0);
			actTemp[2].setX(2);
			actTemp[2].setY(1);
			actTemp[3].setX(3);
			actTemp[3].setY(1);
			break;
		// 正L形
		case 2:
			actTemp[0].setX(2);
			actTemp[0].setY(0);
			actTemp[1].setX(2);
			actTemp[1].setY(1);
			actTemp[2].setX(2);
			actTemp[2].setY(2);
			actTemp[3].setX(3);
			actTemp[3].setY(2);
			break;
		// 反L形
		case 3:
			actTemp[0].setX(3);
			actTemp[0].setY(0);
			actTemp[1].setX(3);
			actTemp[1].setY(1);
			actTemp[2].setX(3);
			actTemp[2].setY(2);
			actTemp[3].setX(2);
			actTemp[3].setY(2);
			break;
		// 土字形
		case 4:
			actTemp[0].setX(3);
			actTemp[0].setY(0);
			actTemp[1].setX(2);
			actTemp[1].setY(1);
			actTemp[2].setX(3);
			actTemp[2].setY(1);
			actTemp[3].setX(4);
			actTemp[3].setY(1);
			break;

		// Z字形
		case 5:
			actTemp[0].setX(2);
			actTemp[0].setY(0);
			actTemp[1].setX(3);
			actTemp[1].setY(0);
			actTemp[2].setX(3);
			actTemp[2].setY(1);
			actTemp[3].setX(4);
			actTemp[3].setY(1);
			break;
		// S字形
		case 6:
			actTemp[0].setX(3);
			actTemp[0].setY(0);
			actTemp[1].setX(4);
			actTemp[1].setY(0);
			actTemp[2].setX(2);
			actTemp[2].setY(1);
			actTemp[3].setX(3);
			actTemp[3].setY(1);
			break;
		default:
			System.out.println("没有这个形状！");
			break;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == newgame) {
			if (e.getActionCommand().equals("开始")) {
				newgame.setText("重置");
				requestFocus(true);
				start = true;
				temp = r.nextInt(7);
				if (!newAct()) {
					timer();
					temp = r.nextInt(7);
					nextAct();
					repaint();

				} else {
					// repaint();
					return;

				}

			} else {
				start = false;
				score = 0;
				tscore = 0;
				speed = 0;
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 18; j++) {
						map[i][j] = 0;
					}
				}
				newgame.setText("开始");
			}
		}

		if (e.getSource() == endgame) {
			System.exit(0); // 枚举
		}
		if (e.getSource() == button) {
			score = 0;
			tscore = 0;
			speed = 0;
			start = false;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 18; j++) {
					map[i][j] = 0;
				}
			}
			newgame.setText("开始");
			dialog.setVisible(false);
			repaint();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	// 移动方块
	public void Move(int x, int y) {
		// TODO Auto-generated method stub
		if (minYes(x, y)) {
			for (int i = 0; i < 4; i++) {
				act[i].x += x;
				act[i].y += y;
			}
		}
		repaint();
	}

	// 消行的方法
	private int delact() {
		int line = 0;
		for (int i = 0; i < 18; i++) {
			int j;
			for (j = 0; j < 10; j++) {
				if (map[i][j] == 0) {
					break;
				}
			}
			if (j >= 10) {
				line += 1;
				if (i != 0) {
					for (int j2 = i - 1; j2 > 0; j2--) {
						for (int k = 0; k < 10; k++) {
							map[k][j2 + 1] = map[k][j2];
						}
					}
					for (int j2 = 0; j2 < 10; j2++) {
						map[0][j2] = 0;
					}
				}
			}
		}
		repaint();
		return line;
	}

	// 下落的方法
	public void down() {

		if (minYes(0, 1)) {
			for (int i = 0; i < 4; i++) { // 可以下落
				act[i].y += 1;
			}
			repaint();
		} else {
			//
			//t.cancel();
			for (int i = 0; i < 4; i++) { // 不能下落
				map[act[i].x][act[i].y] = 1;
			}
			int line = delact();
			if (line != 0) {
				score = +10 * line * line;
				if (score - score >= 300) {
					tscore = score;
					if (speed <= 9) {
						speed += 1;
					}
				}
			}
			if (!newAct()) {
				temp = r.nextInt(7);
				nextAct();
				//timer();
			} else {
				//t.cancel();
				label.setText("游戏结束，您的分数是" + score);
				dialog.setVisible(true);
			}
			repaint();
		}
	}

	// 旋转的方法
	public void up() {
		tetrisAct[] tt = new tetrisAct[4];
		for (int i = 0; i < tt.length; i++) {
			//
			tt[i] = new tetrisAct();
			tt[i].x = act[i].x;
			tt[i].y = act[i].y;
		}
		int cx = (tt[0].x + tt[1].x + tt[2].x + tt[3].x) / 4;
		int cy = (tt[0].y + tt[1].y + tt[2].y + tt[3].y) / 4;
		for (int i = 0; i < tt.length; i++) {
			tt[i].x = cx + cy - act[i].y;
			tt[i].y = cy - cx + act[i].x;
		}
		for (int i = 0; i < tt.length; i++) {
			if (!maxYes(tt[i].x, tt[i].y)) {
				return;
			}
		}
		for (int i = 0; i < tt.length; i++) {
			act[i].x = tt[i].x;
			act[i].y = tt[i].y;
		}
		repaint();
	}

	// 判断边界
	public boolean minYes(int x, int y) {
		for (int i = 0; i < 4; i++) {
			if (!maxYes(act[i].x + x, act[i].y + y)) {
				return false;
			}
		}

		return true;
	}

	public boolean maxYes(int x, int y) {

		if (x < 0 || x >= 10 || y < 0 || y >= 18) {
			return false;
		}
		if (map[x][y] == 1) {
			return false;
		}
		return true;
	}

	// 键盘控制方向
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		// System.out.println(code);
		if (start) {
			switch (code) {
			case 40:
				down();
				break;
			case 38:
				up();
				break;
			case 37:
				Move(-1, 0);
				break;
			case 39:
				Move(1, 0);
				break;

			default:
				break;
			}
		}

	}

	public void timer() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (start) {
					down();
				}
			}
		}, 10, 1000 - (100 * speed));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
