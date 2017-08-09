package project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gamePanel extends JPanel {

	public int score = 0;
	public int linenum = 0;

	private shape current;
	private shape next;

	public static final int rows = 20;
	public static final int cols = 20;
	public static final int size = 26;

	private cell[][] cells = new cell[rows][cols];

	JButton b1 = new JButton("��ʼ");
	JButton b2 = new JButton("�˳�");

	private static Image background;
	public static Image I;
	public static Image L;
	public static Image J;
	public static Image Z;
	public static Image S;
	public static Image O;
	public static Image T;
	
	//����ͼƬ
	static {
		try {
			background = ImageIO
					.read(gamePanel.class.getResource("tetris.png"));
			I = ImageIO.read(gamePanel.class.getResource("I.png"));
			L = ImageIO.read(gamePanel.class.getResource("L.png"));
			J = ImageIO.read(gamePanel.class.getResource("J.png"));
			Z = ImageIO.read(gamePanel.class.getResource("Z.png"));
			S = ImageIO.read(gamePanel.class.getResource("S.png"));
			O = ImageIO.read(gamePanel.class.getResource("O.png"));
			T = ImageIO.read(gamePanel.class.getResource("T.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// shape a = shape.getshape();

	//���췽��
	public gamePanel() {
		setSize(542, 589);
		setLayout(null);
		add(b1);
		b1.setBounds(320, 247, 60, 30);
		add(b2);
		b2.setBounds(400, 247, 60, 30);
		// shape a = shape.getshape();
//		addKeyListener(this);
		timer();
		
		
	}
	

	//�������
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		g.translate(10, 13);
		setFont(new Font("��Բ", Font.BOLD, 25));
		g.drawString("������" + score, 290, 160);
		g.drawString("����������" + linenum, 290, 216);
		setFont(new Font("��Բ", Font.BOLD, 20));
		g.drawString("��һ�����飺", 290, 23);
		// ����ǰ����
		paintCurrentShape(g);
		// ����һ������
		paintNextShape(g);

		// for (int i = 0; i < 4; i++) {
		// g.drawImage(a.cells[i].getImg(),
		// a.cells[i].getRow()*26,a.cells[i].getCol()*26,null);
		// }

	}

	//��ȡ��ǰ����һ������
	public void action() {
		current = shape.getshape();
		next = shape.getshape();
		
this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
			}
		});
		this.requestFocus();
	}
	
	// ����ǰ����
	private void paintCurrentShape(Graphics g) {
		// TODO Auto-generated method stub
		cell[] cs = current.getCells();
		for (int i = 0; i < cs.length; i++) {
			int x = cs[i].getCol() * size;
			int y = cs[i].getRow() * size;
			g.drawImage(cs[i].getImg(), x, y, null);
		}
	}

	// ����һ������
	private void paintNextShape(Graphics g) {
		// TODO Auto-generated method stub
		cell[] cs = next.getCells();
		for (int i = 0; i < cs.length; i++) {
			int x = (cs[i].getCol() + 10) * size+2;
			int y = (cs[i].getRow() + 2) * size-10;
			g.drawImage(cs[i].getImg(), x, y, null);
		}
	}
	
	// ��ʱ��
	public void timer() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				final shape s =new shape();
//				System.out.println("00");
				
				
				repaint();
			}
		}, 10, 400);
		
	}

	
	
	
//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	@Override
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//		shape s=new shape();
//		int code = e.getKeyCode();
//		System.out.println("code");
//		if (code == 37) {
//			s.moveLeft();
//		}
//		if (code == 39) {
//			s.moveRight();
//		}
//		
//	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame f = new JFrame();
				gamePanel gp = new gamePanel();
				
				f.setSize(541, 588);
				f.setTitle("����˹����1.0V-->@little˶����");
				
				f.add(gp);
				f.setLocationRelativeTo(null);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
				
				gp.action();
			}
		});
		
	}

}
