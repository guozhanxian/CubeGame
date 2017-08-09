package com.ralph.cube;

import java.awt.Image;

public class Cell {
	private int row;
	private int col;
	private Image img;
	
	public Cell() {
		super();
	}
	
	public Cell(int row, int col, Image img) {
		super();
		this.row = row;
		this.col = col;
		this.img = img;
	}

	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	
	public void moveLeft()
	{
		col--;
	}
	
	public void moveRight()
	{
		col++;
	}
	
	public void moveDown()
	{
		row++;
	}
}
