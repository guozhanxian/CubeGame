package project;

import java.awt.Image;

public class cell {
	
	private int row;
	private int col;
	private Image img;
	
	
	//有参构造方法
	public cell(int row, int col, Image img) {
		super();
		this.row = row;
		this.col = col;
		this.img = img;
	}
	
	//无参构造方法
	public cell() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//set/get()方法
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
	
    //左移
	public void moveLeft(){
		col--;
	}
	
	//右移
	public void moveRight(){
		col++;
	}
	
	//下移
	public void moveDown(){
		row++;
	}
	
	
	
	

}
