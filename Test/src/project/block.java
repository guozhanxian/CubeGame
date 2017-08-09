package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



	public class block extends JFrame {
		private static final long serialVersionUID = 1L;
		public int nowrank = 1;// ��ʾ��ǰ�ȼ�
		public int[] ranktime = { 600, 500, 400, 350, 300, 280, 250, 200, 150,
				100 };
		public boolean pauitemState = true;// ��ͣ��ť״̬��true��ʾ��ť���ã�false��ʾ��ť�����ã�
		final Tetrisblok a = new Tetrisblok();
		final Timer timer = new Timer(600, a.new TimerListener());

		public block() {
			final JFrame frame = new JFrame("����˹����1.8������");
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
				SwingUtilities.updateComponentTreeUI(frame);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
			a.addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {
					if (pauitemState) {
						switch (e.getKeyCode()) {
						case KeyEvent.VK_DOWN:
							a.down();
							break;
						case KeyEvent.VK_SPACE:
							a.turn();
							break;
						case KeyEvent.VK_RIGHT:
							a.right();
							break;
						case KeyEvent.VK_LEFT:
							a.left();
							break;
						default:
							break;
						}
					}
				}

				public void keyReleased(KeyEvent e) {
					if (pauitemState) {
						timer.start();
					}
				}

				public void keyTyped(KeyEvent e) {

				}
			});
			frame.setLayout(new BorderLayout());
			frame.add(a);
			timer.start();
			final JMenuBar menu = new JMenuBar();
			frame.setJMenuBar(menu);
			// ������Ϸ�˵���
			JMenu gameMenu = new JMenu("��Ϸ��G��");
			JMenuItem newitem = new JMenuItem("����Ϸ��N��");
			gameMenu.add(newitem);
			final JMenuItem pauseitem = new JMenuItem("��ͣ��P��");
			gameMenu.add(pauseitem);
			final JMenuItem contitem = new JMenuItem("������C��");
			gameMenu.add(contitem);
			contitem.setEnabled(false);
			JMenuItem exititem = new JMenuItem("�˳���E��");
			gameMenu.add(exititem);
			newitem.setToolTipText("���¿�ʼ��Ϸ����ݼ�:CTRL+N");
			pauseitem.setToolTipText("��ͣ��Ϸ����ݼ�:CTRL+P");
			contitem.setToolTipText("������Ϸ����ݼ�:CTRL+C");
			exititem.setToolTipText("�˳���Ϸ����ݼ���CTRL+E");
			gameMenu.setToolTipText("����������Ϸ��������ͣ�����������������˳����ĸ�ѡ��,��ݼ���ALT+G��");
			// ��Ӽ�������ʵ����Ϸ�˵��ϵĸ����˵���Ĺ���,���������ڲ���
			// ����Ϸ�˵���Ĺ���ʵ��
			newitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					a.newmap();
					a.drawwall();
					a.score = 0;
					a.x = 4;
					a.y = -1;
					a.blockType = a.ran.nextInt(7);
					a.turnState = a.ran.nextInt(4);
					a.nextb = a.ran.nextInt(7);
					a.nextt = a.ran.nextInt(4);
				}
			});
			// ��ͣ�˵���Ĺ���ʵ��
			pauseitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					timer.stop();
					pauseitem.setEnabled(false);
					contitem.setEnabled(true);
					pauitemState = false;
				}
			});
			// �����˵���Ĺ���ʵ��
			contitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					timer.start();
					pauseitem.setEnabled(true);
					contitem.setEnabled(false);
					pauitemState = true;
				}
			});
			// �˳��˵���Ĺ���ʵ��
			exititem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			// �������ò˵���Թ��û����ø��Ի���Ϸ����
			JMenu setMenu = new JMenu("���ã�S��");
			JMenu rankMenu = new JMenu("�ȼ����ã�R��");
			JMenuItem firstItem = new JMenuItem("1");
			JMenuItem secondItem = new JMenuItem("2");
			JMenuItem thirdItem = new JMenuItem("3");
			JMenuItem forthItem = new JMenuItem("4");
			JMenuItem fifthItem = new JMenuItem("5");
			JMenuItem sixthItem = new JMenuItem("6");
			JMenuItem seventhItem = new JMenuItem("7");
			JMenuItem eighthItem = new JMenuItem("8");
			JMenuItem nighthItem = new JMenuItem("9");
			JMenuItem tenthItem = new JMenuItem("10");
			rankMenu.add(firstItem);
			rankMenu.add(secondItem);
			rankMenu.add(thirdItem);
			rankMenu.add(forthItem);
			rankMenu.add(fifthItem);
			rankMenu.add(sixthItem);
			rankMenu.add(seventhItem);
			rankMenu.add(eighthItem);
			rankMenu.add(nighthItem);
			rankMenu.add(tenthItem);
			setMenu.add(rankMenu);
			rankMenu.setToolTipText("������Ϸ�ĵȼ�������Ϸ��ʮ���ȼ�");
			setMenu.setToolTipText("�û��ɸ����Լ�����Ҫ����һЩ���Ի����ݣ���ݼ���ALT+S");
			// ���˵���ľ���ʵ��
			firstItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nowrank = 1;
					timer.setDelay(ranktime[nowrank - 1]);
				}
			});
			secondItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nowrank = 2;
					timer.setDelay(ranktime[nowrank - 1]);
				}
			});
			thirdItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nowrank = 3;
					timer.setDelay(ranktime[nowrank - 1]);
				}
			});
			forthItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nowrank = 4;
					timer.setDelay(ranktime[nowrank - 1]);
				}
			});
			fifthItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nowrank = 5;
					timer.setDelay(ranktime[nowrank - 1]);
				}
			});
			sixthItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nowrank = 6;
					timer.setDelay(ranktime[nowrank - 1]);
				}
			});
			seventhItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nowrank = 7;
					timer.setDelay(ranktime[nowrank - 1]);
				}
			});
			eighthItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nowrank = 8;
					timer.setDelay(ranktime[nowrank - 1]);
				}
			});
			nighthItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nowrank = 9;
					timer.setDelay(ranktime[nowrank - 1]);
				}
			});
			tenthItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nowrank = 10;
					timer.setDelay(ranktime[nowrank - 1]);
				}
			});
			// ���������˵���Թ���ͬ������û�ѡ��
			JMenu uimenu = new JMenu("������U��");
			JMenuItem localitem = new JMenuItem("�������L��");
			uimenu.add(localitem);
			uimenu.addSeparator();
			JMenuItem javaitem = new JMenuItem("Java���J��");
			uimenu.add(javaitem);
			JMenuItem unixitem = new JMenuItem("Unix���U��");
			uimenu.add(unixitem);
			JMenuItem windowsitem = new JMenuItem("Windows���D��");
			uimenu.add(windowsitem);
			localitem.setToolTipText("����Ϸ��������Ϊ����ϵͳ�ķ�񣬿�ݼ���CTRL+L");
			javaitem.setToolTipText("����Ϸ��������ΪJava��񣬿�ݼ���CTRL+J");
			unixitem.setToolTipText("����Ϸ��������ΪUnix��񣬿�ݼ���CTRL+U");
			windowsitem.setToolTipText("����Ϸ��������ΪWindows��񣬿�ݼ���CTRL+D");
			uimenu.setToolTipText("������Ϸ�Ľ����񣬰�����Java��񡱡�Unix���"
					+ "��Windows�������ѡ���ݼ���ALT+U");
			localitem.addActionListener(new ActionListener() {// ע���������ʹ�������ڲ���
						public void actionPerformed(ActionEvent e) {
							try {
								UIManager.setLookAndFeel(UIManager
										.getSystemLookAndFeelClassName());
								SwingUtilities.updateComponentTreeUI(frame);
							} catch (ClassNotFoundException e1) {
								e1.printStackTrace();
							} catch (InstantiationException e1) {
								e1.printStackTrace();
							} catch (IllegalAccessException e1) {
								e1.printStackTrace();
							} catch (UnsupportedLookAndFeelException e1) {
								e1.printStackTrace();
							}
						}
					});
			javaitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						UIManager
								.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
						SwingUtilities.updateComponentTreeUI(frame);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						e1.printStackTrace();
					} catch (UnsupportedLookAndFeelException e1) {
						e1.printStackTrace();
					}
				}
			});
			unixitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						UIManager
								.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
						SwingUtilities.updateComponentTreeUI(frame);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						e1.printStackTrace();
					} catch (UnsupportedLookAndFeelException e1) {
						e1.printStackTrace();
					}
				}
			});
			windowsitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						UIManager
								.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
						SwingUtilities.updateComponentTreeUI(frame);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						e1.printStackTrace();
					} catch (UnsupportedLookAndFeelException e1) {
						e1.printStackTrace();
					}
				}
			});
			JMenu helpMenu = new JMenu("������H��");// ��������˵���
			JMenuItem aboutitem = new JMenuItem("������Ϸ��G��");
			helpMenu.add(aboutitem);
			JMenuItem writeitem = new JMenuItem("�������ߣ�W��");
			helpMenu.add(writeitem);
			helpMenu.addSeparator();
			JMenuItem rankitem = new JMenuItem("���ڵȼ���R��");
			helpMenu.add(rankitem);
			JMenuItem adviitem = new JMenuItem("��Ϸ�Ҹ棨A��");
			helpMenu.add(adviitem);
			aboutitem.setToolTipText("����Ϸ��һЩ�򵥽��ܼ�˵������ݼ���CTRL+G");
			writeitem.setToolTipText("����Ϸ���ߵ�һЩ���ܼ�˵������ݼ���CTRL+W");
			rankitem.setToolTipText("����Ϸ�ȼ���˵������ݼ���CTRL+R");
			adviitem.setToolTipText("���û���һЩ���飬��ݼ���CTRL+A");
			helpMenu.setToolTipText("��ݼ���ALT+H���������������Ϸ�������������ߡ�������Ϸ�Ҹ桱�ĸ�ѡ��");
			// ��Ӽ�������ʵ�ְ����˵��ϵĸ����˵���Ĺ���,���������ڲ���
			// ������Ϸ�˵���Ĺ���ʵ��
			aboutitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					timer.stop();
					JOptionPane
							.showMessageDialog(
									frame,
									"����Ϸ�ɹ¶���Ұ��������\n����ҪԴ���룬��ʱ��ӭ��ϵ���ߣ�\n"
											+ "�������䣺sunchuanhui212@126.com\nQQ�ţ�2442701497\n����Ϸ���ܻ���������ȫ�ģ�\n"
											+ "�������ˡ���ͣ���������¿�ʼ���ȹ���  ...\nϣ����ϲ����\n"
											+ "�����κ����ʼ������������ʱ��ӭָ����\n���ǽ�������Ŭ��������������\n"
											+ "���лл����ʹ�ã�\n��Ȩ���У�������Ȩ��",
									"������Ϸ...", JOptionPane.INFORMATION_MESSAGE);
					if (pauitemState) {
						timer.start();
					}
				}
			});
			// �������߲˵���Ĺ���ʵ��
			writeitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					timer.stop();
					JOptionPane
							.showMessageDialog(
									frame,
									"���ߣ��¶���Ұ��\n�Ա���\n���᣺��������\n�����գ�1990��11��9��\n"
											+ "�־ӵأ��Ϻ�\n���ҽ��ܣ���˧Ҳ����\nż�񣺰���˹̹\n"
											+ "��ϲ���ĸ��֣�����\n�������ĵط�������\n�����������Դ������\n"
											+ "                 �ڷ����ͻԻ�\n��ϲ���Ļ�����Ը���һ��ʯ�ţ��������紵����������\n"
											+ "                          �������ɹ��ֻ����������߹�...\n"
											+ "���룺����ж�����ж�����\n", "��������...",
									JOptionPane.INFORMATION_MESSAGE);
					if (pauitemState) {
						timer.start();
					}
				}
			});
			// ���ڵȼ��˵���Ĺ���ʵ��
			rankitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					timer.stop();
					JOptionPane.showMessageDialog(frame,
							"����Ϸ��ʮ���ȼ����ȼ�Խ�ߣ�����������ٶ�Խ�졣\n", "���ڵȼ�������",
							JOptionPane.INFORMATION_MESSAGE);
					if (pauitemState) {
						timer.start();
					}
				}
			});
			// ��Ϸ�Ҹ�˵���Ĺ���ʵ��
			adviitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					timer.stop();
					JOptionPane.showMessageDialog(frame,
							"���Ʋ�����Ϸ , �ܾ�������Ϸ\n\nע�����ұ��� , ������ƭ�ϵ�\n\n"
									+ "�ʶ���Ϸ���� , ������Ϸ����\n\n������ʱ�� , ���ܽ�������\n",
							"������Ϸ�Ҹ档����", JOptionPane.INFORMATION_MESSAGE);
					if (pauitemState) {
						timer.start();
					}
				}
			});
			menu.add(gameMenu);// ���˵�����ӵ��˵�����
			menu.add(setMenu);
			menu.add(uimenu);
			menu.add(helpMenu);
			gameMenu.setMnemonic('G');// ��Ϸ�˵������ÿ�ݼ�ALT+G
			setMenu.setMnemonic('S');// ���ò˵������ÿ�ݼ�ALT+S
			uimenu.setMnemonic('U'); // ������˵������ÿ�ݼ�ALT+U
			helpMenu.setMnemonic('H');// �����˵������ÿ�ݼ�ALT+H
			newitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
					InputEvent.CTRL_MASK));// ����Ϸѡ�����ÿ�ݼ�CTRL+N
			pauseitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
					InputEvent.CTRL_MASK));// ��ͣѡ�����ÿ�ݼ�CTRL+P
			contitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
					InputEvent.CTRL_MASK));// ����ѡ�����ÿ�ݼ�CTRL+C
			exititem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
					InputEvent.CTRL_MASK));// �˳�ѡ�����ÿ�ݼ�CTRL+E
			localitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
					InputEvent.CTRL_MASK));// ���ط��ѡ�����ÿ�ݼ�CTRL+L
			javaitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,
					InputEvent.CTRL_MASK));// Java���ѡ�����ÿ�ݼ�CTRL+J
			unixitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
					InputEvent.CTRL_MASK));// Unix���ѡ�����ÿ�ݼ�CTRL+U
			windowsitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
					InputEvent.CTRL_MASK));// Windows���ѡ�����ÿ�ݼ�CTRL+D
			aboutitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
					InputEvent.CTRL_MASK));// ������Ϸѡ�����ÿ�ݼ�CTRL+G
			writeitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
					InputEvent.CTRL_MASK));// ��������ѡ�����ÿ�ݼ�CTRL+W
			rankitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
					InputEvent.CTRL_MASK));// ���ڵȼ�ѡ�����ÿ�ݼ�CTRL+R
			adviitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
					InputEvent.CTRL_MASK));// ��Ϸ�Ҹ�ѡ�����ÿ�ݼ�CTRL+A
			// ��ť��
			JButton newbutton = new JButton("����Ϸ");
			JButton pausebutton = new JButton("��ͣ/����");
			JButton setbutton = new JButton("���õȼ�");
			a.setLayout(null);
			newbutton.setBounds(270, 240, 100, 40);
			pausebutton.setBounds(270, 300, 100, 40);
			setbutton.setBounds(270, 360, 100, 40);
			a.add(newbutton);
			a.add(pausebutton);
			a.add(setbutton);
			// Ϊ����ť�����ʾ
			newbutton.setToolTipText("���¿�ʼ��Ϸ");
			pausebutton.setToolTipText("ʹ��Ϸ��ͣ��ʼ");
			setbutton.setToolTipText("������Ϸ�ĵȼ�");
			// Ϊ����ť��Ӽ�����
			newbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					a.newmap();
					a.drawwall();
					a.score = 0;
					a.x = 4;
					a.y = -1;
					a.blockType = a.ran.nextInt(7);
					a.turnState = a.ran.nextInt(4);
					a.nextb = a.ran.nextInt(7);
					a.nextt = a.ran.nextInt(4);
				}
			});
			pausebutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (pauitemState) {
						timer.stop();
						pauseitem.setEnabled(false);
						contitem.setEnabled(true);
						pauitemState = false;
					} else {
						timer.start();
						pauseitem.setEnabled(true);
						contitem.setEnabled(false);
						pauitemState = true;
					}
				}
			});
			setbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					timer.stop();
					final JDialog choicedialog = new JDialog(frame, "ѡ��ȼ�������",
							true);

					JPanel jpanel = new JPanel();
					JLabel choicelable = new JLabel("��ѡ��ȼ���");
					jpanel.add(choicelable, new FlowLayout());
					String[] rankchoiceitem = { "��һ��", "�ڶ���", "������", "���ļ�",
							"���弶", "������", "���߼�", "�ڰ˼�", "�ھż�", "��ʮ��" };
					final JComboBox choicejco = new JComboBox(rankchoiceitem);
					jpanel.add(choicejco);
					JButton surebutton = new JButton("ȷ��");
					jpanel.add(surebutton);
					surebutton.setToolTipText("����ȷ������ȷ��ѡ��ȡ����ֱ�ӹرմ���");
					choicedialog.add(jpanel);
					surebutton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							nowrank = choicejco.getSelectedIndex() + 1;
							timer.setDelay(ranktime[nowrank - 1]);
							a.repaint();
							choicedialog.dispose();
						}
					});
					choicedialog.setBounds(320, 200, 320, 90);
					choicedialog.setVisible(true);
					if (pauitemState) {
						timer.start();
					}
				}
			});
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			frame.setBounds(300, 100, 400, 520);
			frame.setVisible(true);
			frame.setResizable(false);
			frame.addWindowListener(new WindowListener() {
				public void windowOpened(WindowEvent e) {

				}

				public void windowClosing(WindowEvent e) {
					timer.stop();
					Object[] options = { "�ǵģ���Ҫ�˳�", "������˼�������" };
					int option = JOptionPane.showOptionDialog(null, "��ȷ��Ҫ�˳���",
							"�˳���ʾ....", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options,
							options[0]);
					if (option == JOptionPane.OK_OPTION) {
						System.exit(0);
					}
					if (pauitemState) {
						timer.start();
					}
				}

				public void windowClosed(WindowEvent e) {

				}

				public void windowIconified(WindowEvent e) {
					timer.stop();
				}

				public void windowDeiconified(WindowEvent e) {
					if (pauitemState) {
						timer.start();
					}
				}

				public void windowActivated(WindowEvent e) {
					if (pauitemState) {
						timer.start();
					}
				}

				public void windowDeactivated(WindowEvent e) {
					timer.stop();
				}

			});
		}

		// ����һ������˹������
		class Tetrisblok extends JPanel {
			private static final long serialVersionUID = 1L;
			Random ran = new Random(); // ʹ��Random������
			public boolean downstate = false;// �Ƿ�ס���¼�
			public int blockType; // blockType����������
			public int score = 0; // ������
			public int turnState; // turnState������״̬
			public int x; // ������ʼλ�õĺ�����
			public int y; // ������ʼλ�õ�������
			public int nextb = ran.nextInt(7); // ��һ���������ͣ�
			public int nextt = ran.nextInt(4); // ��һ���������״��
			private int i = 0;
			private int j = 0;
			private boolean flag = false;
			int[][] map = new int[13][27];
			int[][] blockColor = new int[13][27];// �������ɫ

			Tetrisblok() {
				newblock();
				newmap();
				drawwall();
			}

			// ��һ����������״��������״������S��Z��L��J��I��O��T 7��
			// �ڶ����������ת����
			// ��������Ϊ�������
			private final int shapes[][][] = new int[][][] {
					// ���ͷ���
					{ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
							{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
							{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 } },
					// s�ͷ���
					{ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0 },
							{ 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0 },
							{ 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0 } },
					// z�ͷ���
					{ { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0 },
							{ 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0 },
							{ 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0 } },
					// ��l�ͷ���
					{ { 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0 },
							{ 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0 } },
					// ���ͷ���
					{ { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 } },
					// ��l�ͷ���
					{ { 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
							{ 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0 } },
					// t�ͷ���
					{ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0 },
							{ 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0 } } };

			public void newblock() { // �����·���ķ���
				blockType = nextb;
				turnState = nextt;
				nextb = ran.nextInt(7);
				nextt = ran.nextInt(4);
				x = 4;
				y = 0;
				if (gameover(x, y)) {
					add(x, y, blockType, turnState);
					timer.stop();
					JOptionPane.showMessageDialog(null, "������˼����Ϸ���������ٽ�������");
					timer.start();
					newmap();
					drawwall();
					score = 0;
				}
			}

			// �Ƿ�Ϸ��ķ���
			public boolean blow(int x, int y, int blockType, int turnState) {
				for (int a = 0; a < 4; a++) {
					for (int b = 0; b < 4; b++) {
						if (((shapes[blockType][turnState][a * 4 + b] == 1) && (map[x
								+ b + 1][y + a] == 1))
								|| ((shapes[blockType][turnState][a * 4 + b] == 1) && (map[x
										+ b + 1][y + a] == 2))) {
							return true;
						}
					}
				}
				return false;
			}

			// �ж���Ϸ�����ķ���
			public boolean gameover(int x, int y) {
				if (blow(x, y, blockType, turnState)) {
					return true;
				} else {
					return false;
				}
			}

			// ��ʼ����ͼ
			public void newmap() {
				for (i = 0; i < 12; i++) {
					for (j = 0; j < 26; j++) {
						map[i][j] = 0;
						blockColor[i][j] = ran.nextInt(12);
					}
				}
			}

			// ��Χǽ
			public void drawwall() {
				for (i = 0; i < 12; i++) {
					map[i][25] = 2;
				}
				for (j = 0; j < 26; j++) {
					map[11][j] = 2;
					map[0][j] = 2;
				}
			}

			// ��ת�ķ���
			public void turn() {
				int tempturnState = turnState;
				turnState = (turnState + 1) % 4;
				if (!blow(x, y, blockType, turnState)) {
				}
				if (blow(x, y, blockType, turnState)) {
					turnState = tempturnState;
				}
				repaint();
			}

			// ���Ƶķ���
			public void left() {
				if (!blow(x - 1, y, blockType, turnState)) {
					x = x - 1;
				}
				repaint();
			}

			// ���Ƶķ���
			public void right() {
				if (!blow(x + 1, y, blockType, turnState)) {
					x = x + 1;
				}
				repaint();
			}

			// ����ķ���
			public void down() {
				if (!blow(x, y + 1, blockType, turnState)) {
					y = y + 1;
				}
				if (blow(x, y + 1, blockType, turnState)) {
					add(x, y, blockType, turnState);
					newblock();
				}
				delline();
				repaint();
			}

			public void delline() {// ���еķ���
				int c = 0;
				int i = 0; // i����ȷ���������˼���
				for (int b = 0; b < 26; b++) {
					for (int a = 0; a < 12; a++) {
						if (map[a][b] == 1) {
							c = c + 1;
							if (c == 10) {
								i = i + 1;
								for (int d = b; d > 0; d--) {
									for (int e = 0; e < 11; e++) {
										map[e][d] = map[e][d - 1];
									}
								}
							}
						}
					}
					c = 0;
				}
				switch (i) {// ȷ�����з���
				case 1:
					score = score + 1;
					break;
				case 2:
					score = score + 3;
					break;
				case 3:
					score = score + 6;
					break;
				case 4:
					score = score + 10;
					break;
				default:
					break;
				}
			}

			// �ѵ�ǰ���map
			public void add(int x, int y, int blockType, int turnState) {
				int j = 0;
				for (int a = 0; a < 4; a++) {
					for (int b = 0; b < 4; b++) {
						if (map[x + b + 1][y + a] == 0) {
							map[x + b + 1][y + a] = shapes[blockType][turnState][j];
						}
						j++;
					}
				}
			}

			// ������ĵķ���
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				super.setFocusable(true);
				// ����ǰ����
				for (j = 0; j < 16; j++) {
					if (shapes[blockType][turnState][j] == 1) {
						// ����������
						g.setColor(Color.BLUE);
						g.fill3DRect((j % 4 + x + 1) * 20,
								(j / 4 + y - 4) * 20, 20, 20, true);
						g.setColor(Color.BLACK);
						g.draw3DRect((j % 4 + x + 1) * 20,
								(j / 4 + y - 4) * 20, 20, 20, true);
					}
				}
				// ����һ������
				for (j = 0; j < 16; j++) {
					if (shapes[nextb][nextt][j] == 1) {
						g.setColor(Color.BLUE);
						g.fill3DRect((j % 4 + 1) * 20 + 250, (j / 4) * 20 + 50,
								20, 20, true);
						g.setColor(Color.BLACK);
						g.draw3DRect((j % 4 + 1) * 20 + 250, (j / 4) * 20 + 50,
								20, 20, true);

					}
				}
				// ���Ѿ��̶��ķ���
				for (j = 4; j < 26; j++) {
					for (i = 0; i < 12; i++) {
						if (map[i][j] == 2) { // ��Χǽ
							g.setColor(Color.BLACK);
							g.fill3DRect(i * 20, (j - 4) * 20, 20, 20, true);
							g.setColor(Color.WHITE);
							g.draw3DRect(i * 20, (j - 4) * 20, 20, 20, true);
						}
						if (map[i][j] == 1) { // ���̶��ķ���
							g.setColor(Color.GREEN);
							g.fill3DRect(i * 20, (j - 4) * 20, 20, 20, true);
							g.setColor(Color.BLACK);
							g.draw3DRect(i * 20, (j - 4) * 20, 20, 20, true);
						}
					}
				}
				g.setColor(Color.black);
				g.drawString("score = " + score, 250, 10);
				g.setColor(Color.BLACK);
				g.drawString("��ǰ�ȼ���" + nowrank, 250, 30);
				g.setColor(Color.BLACK);
				g.drawString("��һ�����飺", 250, 50);
			}

			// ��ʱ������
			class TimerListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					a.grabFocus();// ȡ�ý���
					repaint();
					if (!blow(x, y + 1, blockType, turnState)) {
						y = y + 1;
						delline();
					}

					if (blow(x, y + 1, blockType, turnState)) {
						if (flag == true) {
							add(x, y, blockType, turnState);
							delline();
							newblock();
							flag = false;
						}
						flag = true;
					}
				}
			}
		}

		// main����
		public static void main(String[] args) {
			new block();
		}
	}


