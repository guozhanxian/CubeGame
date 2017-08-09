package project;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class gameFrame extends JFrame {

	public gameFrame() {
		setSize(541, 588);

		setTitle("俄罗斯方块1.0V-->@little硕制作");
		gamePanel gp = new gamePanel();
		add(gp);
		gp.action();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new gameFrame();
	}

}
