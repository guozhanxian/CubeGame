package project;

import javax.swing.JFrame;


public class tetrisJFrame extends JFrame {

	
	public  tetrisJFrame(){
		
		setTitle("����˹����1.0V--->@Little˶����");
		tetrisJPanel jp=new tetrisJPanel();
		add(jp);
		setSize(380,420);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new tetrisJFrame();
	}
	
	
	
}
