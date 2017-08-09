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
 * 1--窗口+面板+固定 
 * 2--在面板上画出一个小球（中央处） 
 * 3--让小球动起来 
 * 4--对小球的运动方向和方向值进行判断，并进行处理方向的修正，实现小球的反弹 
 * 5--添加挡板并实现鼠标控制挡板移动 
 * 6--小球碰到挡板和没有碰到挡板的情况处理 
 *  
 *  
 */  
public class pinball extends JFrame implements MouseMotionListener{  
    private static final long serialVersionUID = 1L;  
    private int fw = 800 ; //窗口的尺寸  
    private int fh = 600 ;  
    private TTQP ttqp = null ;  
    private int bx = 200 ; //球的初始位置  
    private int by = 200 ;  
    private int b2r = 50 ; //球的尺寸  
    private String direction = "right_down" ; //初始方向 右下  
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
                public void run() {  //实现小球的移动  
                    /* 
                     * 定义好每一个方向的坐标处理 
                     */  
                    if("right_down".equalsIgnoreCase(direction)){ //右下方向的位置处理  
                        bx += speed ;  by += speed  ;  
                    }  
                    if("right_up".equalsIgnoreCase(direction)){ //右上方向的位置处理  
                        bx += speed ;  by -= speed ;  
                    }  
                    if("left_up".equalsIgnoreCase(direction)){//左上方向的位置处理  
                        bx -= speed ;  by -= speed ;  
                    }  
                    if("left_down".equalsIgnoreCase(direction)){//左下方向的位置处理  
                        bx -= speed ;  by += speed ;  
                    }  
                    /* 
                     * 定义好发生什么情况时，如何修正小球的方向 
                     */  
//                  如果小球底部y坐标值》=挡板上边的y坐标    by + b2r >= block_y    
//                  并且小球底部x坐标值》=挡板上边的x坐标    bx + b2r/2 >= block_x   
//                  并且《=挡板上边的x坐标值+挡板的宽度       bx + b2r/2 <= block_x + block_w          
//                  那么 正常改变方向         
//                  否则 程序停止 GAME OVER         
//                  if(by+b2r>=fh){ //底边的判断  
//                      if("right_down".equalsIgnoreCase(direction)){ //小球来自右下  
//                          direction = "right_up" ;  
//                      }else{ //小球来自左下  
//                          direction = "left_up" ;  
//                      }  
//                  }  
                    if(by + b2r >= block_y && bx + b2r/2 >= block_x && bx + b2r/2 <= block_x + block_w){  
                        if("right_down".equalsIgnoreCase(direction)){ //小球来自右下  
                            direction = "right_up" ;  
                            speed ++ ;  
                            score ++ ;  
                        }else{ //小球来自左下  
                            direction = "left_up" ;  
                            speed ++ ;  
                            score ++ ;  
                        }  
                    }  
                    if(by + b2r >= fh){  
                        JOptionPane.showMessageDialog(ttqp, "GAME OVER !", "玩家提示信息",JOptionPane.DEFAULT_OPTION);  
                        Runtime.getRuntime().exit(0);  
                    }  
                      
                    if(bx+b2r>=fw){ //右边的判断  
                        if("right_up".equalsIgnoreCase(direction)){ //小球来自 右上  
                            direction = "left_up" ;  
                        }else{  //小球来自右下  
                            direction = "left_down" ;  
                        }  
                    }  
                    if(by<=0){ //顶边的判断  
                        if("left_up".equalsIgnoreCase(direction)){ //小球来自 左上  
                            direction = "left_down" ;  
                        }else{  //小球来自右上  
                            direction = "right_down" ;  
                        }  
                    }  
                    if(bx<=0){ //左边的判断  
                        if("left_up".equalsIgnoreCase(direction)){ //小球来自 左上  
                            direction = "right_up" ;  
                        }else{  //小球来自左下  
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
    public void mouseDragged(MouseEvent e) { //拖拽方法 实现控制挡板的移动  
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