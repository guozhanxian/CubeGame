package project;

import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.event.KeyEvent;  
import java.awt.event.KeyListener;  
import java.awt.event.MouseEvent;  
import java.awt.event.MouseMotionListener;  
import java.util.Timer;  
import java.util.TimerTask;  
  
import javax.swing.JFrame;  
import javax.swing.JOptionPane;  
import javax.swing.JPanel;  
  
/* 
 * 1--����+���+�̶� 
 * 2--������ϻ���һ��С�����봦�� 
 * 3--��С������ 
 * 4--��С����˶�����ͷ���ֵ�����жϣ������д������������ʵ��С��ķ��� 
 * 5--��ӵ��岢ʵ�������Ƶ����ƶ� 
 * 6--С�����������û������������������ 
 *  
 *  
 */  
public class pinball extends JFrame implements MouseMotionListener{  
    private static final long serialVersionUID = 1L;  
    private int fw = 800 ; //���ڵĳߴ�  
    private int fh = 600 ;  
    private TTQP ttqp = null ;  
    private int bx = 200 ; //��ĳ�ʼλ��  
    private int by = 200 ;  
    private int b2r = 50 ; //��ĳߴ�  
    private String direction = "right_down" ; //��ʼ���� ����  
    private Timer timer = new Timer();  
    private int block_x = 350 ;  
    private int block_y = 580 ;  
    private int block_w = 100 ;  
    private int block_h = 20 ;  
      
    private int speed = 1 ;  
    private int score = 0 ;  
      
    public pinball() {  
        this.setAlwaysOnTop(true);  
        this.setUndecorated(true);  
        this.getContentPane().setBackground(Color.BLACK);  
        this.setSize(fw, fh);  
        this.setLocationRelativeTo(null);  
        this.setResizable(false);  
        ttqp = new TTQP();  
        this.add(ttqp);  
        this.setVisible(true);  
        this.addMouseMotionListener(this);  
        this.addKeyListener(new KeyListener() {  
            @Override  
            public void keyTyped(KeyEvent e) {}  
            @Override  
            public void keyReleased(KeyEvent e) {}  
            @Override  
            public void keyPressed(KeyEvent e) {if(e.getKeyCode()==32){System.exit(0);}}});  
    }  
    class TTQP extends JPanel{  
        private static final long serialVersionUID = 1L;  
        public TTQP() {  
            this.setOpaque(false);  
            timer.schedule(new TimerTask() {  
                @Override  
                public void run() {  //ʵ��С����ƶ�  
                    /* 
                     * �����ÿһ����������괦�� 
                     */  
                    if("right_down".equalsIgnoreCase(direction)){ //���·����λ�ô���  
                        bx += speed ;  by += speed  ;  
                    }  
                    if("right_up".equalsIgnoreCase(direction)){ //���Ϸ����λ�ô���  
                        bx += speed ;  by -= speed ;  
                    }  
                    if("left_up".equalsIgnoreCase(direction)){//���Ϸ����λ�ô���  
                        bx -= speed ;  by -= speed ;  
                    }  
                    if("left_down".equalsIgnoreCase(direction)){//���·����λ�ô���  
                        bx -= speed ;  by += speed ;  
                    }  
                    /* 
                     * ����÷���ʲô���ʱ���������С��ķ��� 
                     */  
//                  ���С��ײ�y����ֵ��=�����ϱߵ�y����    by + b2r >= block_y    
//                  ����С��ײ�x����ֵ��=�����ϱߵ�x����    bx + b2r/2 >= block_x   
//                  ���ҡ�=�����ϱߵ�x����ֵ+����Ŀ��       bx + b2r/2 <= block_x + block_w          
//                  ��ô �����ı䷽��         
//                  ���� ����ֹͣ GAME OVER         
//                  if(by+b2r>=fh){ //�ױߵ��ж�  
//                      if("right_down".equalsIgnoreCase(direction)){ //С����������  
//                          direction = "right_up" ;  
//                      }else{ //С����������  
//                          direction = "left_up" ;  
//                      }  
//                  }  
                    if(by + b2r >= block_y && bx + b2r/2 >= block_x && bx + b2r/2 <= block_x + block_w){  
                        if("right_down".equalsIgnoreCase(direction)){ //С����������  
                            direction = "right_up" ;  
                            speed ++ ;  
                            score ++ ;  
                        }else{ //С����������  
                            direction = "left_up" ;  
                            speed ++ ;  
                            score ++ ;  
                        }  
                    }  
                    if(by + b2r >= fh){  
                        JOptionPane.showMessageDialog(ttqp, "GAME OVER !", "�����ʾ��Ϣ",JOptionPane.DEFAULT_OPTION);  
                        Runtime.getRuntime().exit(0);  
                    }  
                      
                    if(bx+b2r>=fw){ //�ұߵ��ж�  
                        if("right_up".equalsIgnoreCase(direction)){ //С������ ����  
                            direction = "left_up" ;  
                        }else{  //С����������  
                            direction = "left_down" ;  
                        }  
                    }  
                    if(by<=0){ //���ߵ��ж�  
                        if("left_up".equalsIgnoreCase(direction)){ //С������ ����  
                            direction = "left_down" ;  
                        }else{  //С����������  
                            direction = "right_down" ;  
                        }  
                    }  
                    if(bx<=0){ //��ߵ��ж�  
                        if("left_up".equalsIgnoreCase(direction)){ //С������ ����  
                            direction = "right_up" ;  
                        }else{  //С����������  
                            direction = "right_down" ;  
                        }  
                    }  
                    TTQP.this.repaint() ;  
                }  
            }, 0 , 10) ;  
        }  
        @Override  
        public void paint(Graphics g) {  
            g.setColor(Color.WHITE);  
            g.fillOval(bx, by, b2r, b2r);  
              
            g.setColor(Color.PINK);  
            g.fillRect(block_x, block_y, block_w, block_h);  
              
            g.setColor(Color.RED) ;  
            g.drawString("SCORE : " + score, 20, 20) ;  
        }  
    }  
    public static void main(String[] args) {  
        new pinball();  
    }  
    @Override  
    public void mouseDragged(MouseEvent e) { //��ק���� ʵ�ֿ��Ƶ�����ƶ�  
        block_x = e.getX() ;  
        if(block_x <=0){  
            block_x = 0 ;  
        }  
        if(block_x+block_w >=fw){  
            block_x = fw-block_w ;  
        }  
        this.repaint() ;  
    }  
    @Override  
    public void mouseMoved(MouseEvent e) {}  
}  