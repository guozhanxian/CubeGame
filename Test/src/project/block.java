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
		public int nowrank = 1;// 表示当前等级
		public int[] ranktime = { 600, 500, 400, 350, 300, 280, 250, 200, 150,
				100 };
		public boolean pauitemState = true;// 暂停按钮状态，true表示按钮可用，false表示按钮不可用；
		final Tetrisblok a = new Tetrisblok();
		final Timer timer = new Timer(600, a.new TimerListener());

		public block() {
			final JFrame frame = new JFrame("俄罗斯方块1.8。。。");
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
			// 定义游戏菜单项
			JMenu gameMenu = new JMenu("游戏（G）");
			JMenuItem newitem = new JMenuItem("新游戏（N）");
			gameMenu.add(newitem);
			final JMenuItem pauseitem = new JMenuItem("暂停（P）");
			gameMenu.add(pauseitem);
			final JMenuItem contitem = new JMenuItem("继续（C）");
			gameMenu.add(contitem);
			contitem.setEnabled(false);
			JMenuItem exititem = new JMenuItem("退出（E）");
			gameMenu.add(exititem);
			newitem.setToolTipText("重新开始游戏，快捷键:CTRL+N");
			pauseitem.setToolTipText("暂停游戏，快捷键:CTRL+P");
			contitem.setToolTipText("继续游戏，快捷键:CTRL+C");
			exititem.setToolTipText("退出游戏，快捷键：CTRL+E");
			gameMenu.setToolTipText("包含“新游戏”，“暂停”，“继续”，“退出”四个选项,快捷键：ALT+G。");
			// 添加监听器来实现游戏菜单上的各个菜单项的功能,采用匿名内部类
			// 新游戏菜单项的功能实现
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
			// 暂停菜单项的功能实现
			pauseitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					timer.stop();
					pauseitem.setEnabled(false);
					contitem.setEnabled(true);
					pauitemState = false;
				}
			});
			// 继续菜单项的功能实现
			contitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					timer.start();
					pauseitem.setEnabled(true);
					contitem.setEnabled(false);
					pauitemState = true;
				}
			});
			// 退出菜单项的功能实现
			exititem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			// 定义设置菜单项，以供用户设置个性化游戏界面
			JMenu setMenu = new JMenu("设置（S）");
			JMenu rankMenu = new JMenu("等级设置（R）");
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
			rankMenu.setToolTipText("设置游戏的等级，本游戏分十个等级");
			setMenu.setToolTipText("用户可根据自己的需要设置一些个性化内容，快捷键：ALT+S");
			// 各菜单项的具体实现
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
			// 定义界面风格菜单项，以供不同需求的用户选择
			JMenu uimenu = new JMenu("界面风格（U）");
			JMenuItem localitem = new JMenuItem("本机风格（L）");
			uimenu.add(localitem);
			uimenu.addSeparator();
			JMenuItem javaitem = new JMenuItem("Java风格（J）");
			uimenu.add(javaitem);
			JMenuItem unixitem = new JMenuItem("Unix风格（U）");
			uimenu.add(unixitem);
			JMenuItem windowsitem = new JMenuItem("Windows风格（D）");
			uimenu.add(windowsitem);
			localitem.setToolTipText("将游戏界面设置为本机系统的风格，快捷键：CTRL+L");
			javaitem.setToolTipText("将游戏界面设置为Java风格，快捷键：CTRL+J");
			unixitem.setToolTipText("将游戏界面设置为Unix风格，快捷键：CTRL+U");
			windowsitem.setToolTipText("将游戏界面设置为Windows风格，快捷键：CTRL+D");
			uimenu.setToolTipText("设置游戏的界面风格，包含“Java风格”“Unix风格”"
					+ "“Windows风格”三个选项，快捷键：ALT+U");
			localitem.addActionListener(new ActionListener() {// 注册监听器，使用匿名内部类
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
			JMenu helpMenu = new JMenu("帮助（H）");// 定义帮助菜单项
			JMenuItem aboutitem = new JMenuItem("关于游戏（G）");
			helpMenu.add(aboutitem);
			JMenuItem writeitem = new JMenuItem("关于作者（W）");
			helpMenu.add(writeitem);
			helpMenu.addSeparator();
			JMenuItem rankitem = new JMenuItem("关于等级（R）");
			helpMenu.add(rankitem);
			JMenuItem adviitem = new JMenuItem("游戏忠告（A）");
			helpMenu.add(adviitem);
			aboutitem.setToolTipText("对游戏的一些简单介绍及说明，快捷键：CTRL+G");
			writeitem.setToolTipText("对游戏作者的一些介绍及说明，快捷键：CTRL+W");
			rankitem.setToolTipText("对游戏等级的说明，快捷键：CTRL+R");
			adviitem.setToolTipText("对用户的一些建议，快捷键：CTRL+A");
			helpMenu.setToolTipText("快捷键：ALT+H。其包含“关于游戏”，“关于作者”，“游戏忠告”四个选项");
			// 添加监听器来实现帮助菜单上的各个菜单项的功能,采用匿名内部类
			// 关于游戏菜单项的功能实现
			aboutitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					timer.stop();
					JOptionPane
							.showMessageDialog(
									frame,
									"本游戏由孤独的野狼制作！\n如需要源代码，随时欢迎联系作者！\n"
											+ "作者邮箱：sunchuanhui212@126.com\nQQ号：2442701497\n本游戏功能基本上是齐全的！\n"
											+ "并新增了“暂停”、“重新开始”等功能  ...\n希望您喜欢！\n"
											+ "如有任何疑问及改善意见，随时欢迎指出。\n我们将尽最大的努力满足您的需求！\n"
											+ "最后谢谢您的使用！\n版权所有，请勿侵权！",
									"关于游戏...", JOptionPane.INFORMATION_MESSAGE);
					if (pauitemState) {
						timer.start();
					}
				}
			});
			// 关于作者菜单项的功能实现
			writeitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					timer.stop();
					JOptionPane
							.showMessageDialog(
									frame,
									"作者：孤独的野狼\n性别：男\n籍贯：湖南邵阳\n出生日：1990年11月9日\n"
											+ "现居地：上海\n自我介绍：不帅也不丑\n偶像：爱因斯坦\n"
											+ "最喜欢的歌手：刀郎\n最向往的地方：北京\n座右铭：疯狂源自梦想\n"
											+ "                 勤奋铸就辉煌\n最喜欢的话：我愿变成一座石桥，受五百年风吹，五百年雨打，\n"
											+ "                          五百年日晒，只求你从上面走过...\n"
											+ "梦想：天地有多大，梦有多潇洒\n", "关于作者...",
									JOptionPane.INFORMATION_MESSAGE);
					if (pauitemState) {
						timer.start();
					}
				}
			});
			// 关于等级菜单项的功能实现
			rankitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					timer.stop();
					JOptionPane.showMessageDialog(frame,
							"本游戏分十个等级，等级越高，方块的下落速度越快。\n", "关于等级。。。",
							JOptionPane.INFORMATION_MESSAGE);
					if (pauitemState) {
						timer.start();
					}
				}
			});
			// 游戏忠告菜单项的功能实现
			adviitem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					timer.stop();
					JOptionPane.showMessageDialog(frame,
							"抵制不良游戏 , 拒绝盗版游戏\n\n注意自我保护 , 谨防受骗上当\n\n"
									+ "适度游戏益脑 , 沉迷游戏伤身\n\n合理安排时间 , 享受健康生活\n",
							"健康游戏忠告。。。", JOptionPane.INFORMATION_MESSAGE);
					if (pauitemState) {
						timer.start();
					}
				}
			});
			menu.add(gameMenu);// 将菜单项添加到菜单条中
			menu.add(setMenu);
			menu.add(uimenu);
			menu.add(helpMenu);
			gameMenu.setMnemonic('G');// 游戏菜单项设置快捷键ALT+G
			setMenu.setMnemonic('S');// 设置菜单项设置快捷键ALT+S
			uimenu.setMnemonic('U'); // 界面风格菜单项设置快捷键ALT+U
			helpMenu.setMnemonic('H');// 帮助菜单项设置快捷键ALT+H
			newitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
					InputEvent.CTRL_MASK));// 新游戏选项设置快捷键CTRL+N
			pauseitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
					InputEvent.CTRL_MASK));// 暂停选项设置快捷键CTRL+P
			contitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
					InputEvent.CTRL_MASK));// 继续选项设置快捷键CTRL+C
			exititem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
					InputEvent.CTRL_MASK));// 退出选项设置快捷键CTRL+E
			localitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
					InputEvent.CTRL_MASK));// 本地风格选项设置快捷键CTRL+L
			javaitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,
					InputEvent.CTRL_MASK));// Java风格选项设置快捷键CTRL+J
			unixitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
					InputEvent.CTRL_MASK));// Unix风格选项设置快捷键CTRL+U
			windowsitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
					InputEvent.CTRL_MASK));// Windows风格选项设置快捷键CTRL+D
			aboutitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
					InputEvent.CTRL_MASK));// 关于游戏选项设置快捷键CTRL+G
			writeitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
					InputEvent.CTRL_MASK));// 关于作者选项设置快捷键CTRL+W
			rankitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
					InputEvent.CTRL_MASK));// 关于等级选项设置快捷键CTRL+R
			adviitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
					InputEvent.CTRL_MASK));// 游戏忠告选项设置快捷键CTRL+A
			// 按钮组
			JButton newbutton = new JButton("新游戏");
			JButton pausebutton = new JButton("暂停/继续");
			JButton setbutton = new JButton("设置等级");
			a.setLayout(null);
			newbutton.setBounds(270, 240, 100, 40);
			pausebutton.setBounds(270, 300, 100, 40);
			setbutton.setBounds(270, 360, 100, 40);
			a.add(newbutton);
			a.add(pausebutton);
			a.add(setbutton);
			// 为各按钮添加提示
			newbutton.setToolTipText("重新开始游戏");
			pausebutton.setToolTipText("使游戏暂停或开始");
			setbutton.setToolTipText("设置游戏的等级");
			// 为各按钮添加监听器
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
					final JDialog choicedialog = new JDialog(frame, "选择等级。。。",
							true);

					JPanel jpanel = new JPanel();
					JLabel choicelable = new JLabel("请选择等级：");
					jpanel.add(choicelable, new FlowLayout());
					String[] rankchoiceitem = { "第一级", "第二级", "第三级", "第四级",
							"第五级", "第六级", "第七级", "第八级", "第九级", "第十级" };
					final JComboBox choicejco = new JComboBox(rankchoiceitem);
					jpanel.add(choicejco);
					JButton surebutton = new JButton("确定");
					jpanel.add(surebutton);
					surebutton.setToolTipText("按“确定”键确定选择，取消请直接关闭窗口");
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
					Object[] options = { "是的，我要退出", "不好意思，点错了" };
					int option = JOptionPane.showOptionDialog(null, "您确定要退出吗？",
							"退出提示....", JOptionPane.OK_CANCEL_OPTION,
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

		// 创建一个俄罗斯方块类
		class Tetrisblok extends JPanel {
			private static final long serialVersionUID = 1L;
			Random ran = new Random(); // 使用Random函数；
			public boolean downstate = false;// 是否按住向下键
			public int blockType; // blockType代表方块类型
			public int score = 0; // 分数；
			public int turnState; // turnState代表方块状态
			public int x; // 方块起始位置的横坐标
			public int y; // 方块起始位置的纵坐标
			public int nextb = ran.nextInt(7); // 下一个方块类型；
			public int nextt = ran.nextInt(4); // 下一个方块的形状；
			private int i = 0;
			private int j = 0;
			private boolean flag = false;
			int[][] map = new int[13][27];
			int[][] blockColor = new int[13][27];// 方块的颜色

			Tetrisblok() {
				newblock();
				newmap();
				drawwall();
			}

			// 第一组代表方块的形状，方块形状类型有S、Z、L、J、I、O、T 7种
			// 第二组代表方块旋转几次
			// 第三四组为方块矩阵
			private final int shapes[][][] = new int[][][] {
					// 棒型方块
					{ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
							{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
							{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 } },
					// s型方块
					{ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0 },
							{ 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0 },
							{ 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0 } },
					// z型方块
					{ { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0 },
							{ 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0 },
							{ 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0 } },
					// 右l型方块
					{ { 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0 },
							{ 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0 } },
					// 田型方块
					{ { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 } },
					// 左l型方块
					{ { 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
							{ 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0 } },
					// t型方块
					{ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0 },
							{ 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0 },
							{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0 } } };

			public void newblock() { // 生成新方块的方法
				blockType = nextb;
				turnState = nextt;
				nextb = ran.nextInt(7);
				nextt = ran.nextInt(4);
				x = 4;
				y = 0;
				if (gameover(x, y)) {
					add(x, y, blockType, turnState);
					timer.stop();
					JOptionPane.showMessageDialog(null, "不好意思，游戏结束，请再接再厉！");
					timer.start();
					newmap();
					drawwall();
					score = 0;
				}
			}

			// 是否合法的方法
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

			// 判断游戏结束的方法
			public boolean gameover(int x, int y) {
				if (blow(x, y, blockType, turnState)) {
					return true;
				} else {
					return false;
				}
			}

			// 初始化地图
			public void newmap() {
				for (i = 0; i < 12; i++) {
					for (j = 0; j < 26; j++) {
						map[i][j] = 0;
						blockColor[i][j] = ran.nextInt(12);
					}
				}
			}

			// 画围墙
			public void drawwall() {
				for (i = 0; i < 12; i++) {
					map[i][25] = 2;
				}
				for (j = 0; j < 26; j++) {
					map[11][j] = 2;
					map[0][j] = 2;
				}
			}

			// 旋转的方法
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

			// 左移的方法
			public void left() {
				if (!blow(x - 1, y, blockType, turnState)) {
					x = x - 1;
				}
				repaint();
			}

			// 右移的方法
			public void right() {
				if (!blow(x + 1, y, blockType, turnState)) {
					x = x + 1;
				}
				repaint();
			}

			// 下落的方法
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

			public void delline() {// 消行的方法
				int c = 0;
				int i = 0; // i用来确定本次消了几行
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
				switch (i) {// 确定消行分数
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

			// 把当前添加map
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

			// 画方块的的方法
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				super.setFocusable(true);
				// 画当前方块
				for (j = 0; j < 16; j++) {
					if (shapes[blockType][turnState][j] == 1) {
						// 画矩形区域
						g.setColor(Color.BLUE);
						g.fill3DRect((j % 4 + x + 1) * 20,
								(j / 4 + y - 4) * 20, 20, 20, true);
						g.setColor(Color.BLACK);
						g.draw3DRect((j % 4 + x + 1) * 20,
								(j / 4 + y - 4) * 20, 20, 20, true);
					}
				}
				// 画下一个方块
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
				// 画已经固定的方块
				for (j = 4; j < 26; j++) {
					for (i = 0; i < 12; i++) {
						if (map[i][j] == 2) { // 画围墙
							g.setColor(Color.BLACK);
							g.fill3DRect(i * 20, (j - 4) * 20, 20, 20, true);
							g.setColor(Color.WHITE);
							g.draw3DRect(i * 20, (j - 4) * 20, 20, 20, true);
						}
						if (map[i][j] == 1) { // 画固定的方块
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
				g.drawString("当前等级：" + nowrank, 250, 30);
				g.setColor(Color.BLACK);
				g.drawString("下一个方块：", 250, 50);
			}

			// 定时器监听
			class TimerListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					a.grabFocus();// 取得焦点
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

		// main函数
		public static void main(String[] args) {
			new block();
		}
	}


