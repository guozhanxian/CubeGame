package project;

import java.awt.Image;

public class cell {
	
	private int row;
	private int col;
	private Image img;
	
	
	//�вι��췽��
	public cell(int row, int col, Image img) {
		super();
		this.row = row;
		this.col = col;
		this.img = img;
	}
	
	//�޲ι��췽��
	public cell() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//set/get()����
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
    //����
	public void moveLeft(){
		col--;
	}
	
	//����
	public void moveRight(){
		col++;
	}
	
	//����
	public void moveDown(){
		row++;
	}
	
	
	
	

}
