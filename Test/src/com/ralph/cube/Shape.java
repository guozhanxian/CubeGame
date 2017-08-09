package com.ralph.cube;

import java.util.Random;

public class Shape {
	Cell[] cells = new Cell[4];
	State[] states;
	int index = 1000;
	
	public Cell[] getCells() {
		return cells;
	}

	class State {
		int row0, col0, row1, col1, row2, col2, row3, col3;

		public State(int row0, int col0, int row1, int col1, int row2, int col2, int row3, int col3) {
			super();
			this.row0 = row0;
			this.col0 = col0;
			this.row1 = row1;
			this.col1 = col1;
			this.row2 = row2;
			this.col2 = col2;
			this.row3 = row3;
			this.col3 = col3;
		}
	}

	public static Shape genShape() {
		Random r = new Random();
		int num = r.nextInt(7);
		switch (num) {
		case 0:
			return new T();
		case 1:
			return new I();
		case 2:
			return new J();
		case 3:
			return new L();
		case 4:
			return new O();
		case 5:
			return new S();
		case 6:
			return new Z();
		}
		return null;
	}
	
	public void moveLeft()
	{
		for(int i=0;i<cells.length;i++)
		{
			cells[i].moveLeft();
		}
	}
	
	public void moveRight()
	{
		for(int i=0;i<cells.length;i++)
		{
			cells[i].moveRight();
		}
	}
	
	public void dropDown()
	{
		for(int i=0;i<cells.length;i++)
		{
			cells[i].moveDown();
		}
	}
	
	public void rotateLeft()
	{
		index--;//index = 10001
		// index % states.length = 10001 % 4 = 1
		State s = states[index%states.length];//s1
		// [0] + s1 = [1]
		Cell o = cells[0];//获取当前的轴
		cells[1].setRow(o.getRow()+s.row1);
		cells[1].setCol(o.getCol()+s.col1);
		cells[2].setRow(o.getRow()+s.row2);
		cells[2].setCol(o.getCol()+s.col2);
		cells[3].setRow(o.getRow()+s.row3);
		cells[3].setCol(o.getCol()+s.col3);
	}
	
	public void rotateRight()
	{
		index++;//index = 10001
		// index % states.length = 10001 % 4 = 1
		State s = states[index%states.length];//s1
		// [0] + s1 = [1]
		Cell o = cells[0];//获取当前的轴
		//轴与相对位置的和作为旋转以后的格子位置
		cells[1].setRow(o.getRow()+s.row1);
		cells[1].setCol(o.getCol()+s.col1);
		cells[2].setRow(o.getRow()+s.row2);
		cells[2].setCol(o.getCol()+s.col2);
		cells[3].setRow(o.getRow()+s.row3);
		cells[3].setCol(o.getCol()+s.col3);
	}
}

class T extends Shape {
	public T() {
		cells[0] = new Cell(0, 4, GamePanel.T);
		cells[1] = new Cell(0, 3, GamePanel.T);
		cells[2] = new Cell(0, 5, GamePanel.T);
		cells[3] = new Cell(1, 4, GamePanel.T);
		states = new State[] { new State(0, 0, 0, -1, 0, 1, 1, 0), new State(0, 0, -1, 0, 1, 0, 0, -1),
				new State(0, 0, 0, 1, 0, -1, -1, 0), new State(0, 0, 1, 0, -1, 0, 0, 1) };
	}
}

class I extends Shape {
	public I() {
		cells[0] = new Cell(0, 4, GamePanel.I);
		cells[1] = new Cell(0, 3, GamePanel.I);
		cells[2] = new Cell(0, 5, GamePanel.I);
		cells[3] = new Cell(0, 6, GamePanel.I);
		states = new State[] { new State(0, 0, 0, 1, 0, -1, 0, -2), new State(0, 0, -1, 0, 1, 0, 2, 0) };
	}
}

class L extends Shape {
	public L() {
		cells[0] = new Cell(0, 4, GamePanel.L);
		cells[1] = new Cell(0, 3, GamePanel.L);
		cells[2] = new Cell(0, 5, GamePanel.L);
		cells[3] = new Cell(1, 3, GamePanel.L);
		states = new State[] { new State(0, 0, 0, -1, 0, 1, 1, -1), new State(0, 0, -1, 0, 1, 0, -1, -1),
				new State(0, 0, 0, 1, 0, -1, -1, 1), new State(0, 0, 1, 0, -1, 0, 1, 1) };
	}
}

class J extends Shape {
	public J() {
		cells[0] = new Cell(0, 4, GamePanel.J);
		cells[1] = new Cell(0, 3, GamePanel.J);
		cells[2] = new Cell(0, 5, GamePanel.J);
		cells[3] = new Cell(1, 5, GamePanel.J);
		states = new State[] { new State(0, 0, 0, -1, 0, 1, 1, 1), new State(0, 0, -1, 0, 1, 0, 1, -1),
				new State(0, 0, 0, 1, 0, -1, -1, -1), new State(0, 0, 1, 0, -1, 0, -1, 1) };
	}
}

class S extends Shape {
	public S() {
		cells[0] = new Cell(0, 4, GamePanel.S);
		cells[1] = new Cell(0, 5, GamePanel.S);
		cells[2] = new Cell(1, 3, GamePanel.S);
		cells[3] = new Cell(1, 4, GamePanel.S);
		states = new State[] { new State(0, 0, 0, 1, 1, -1, 1, 0), new State(0, 0, -1, 0, 1, 1, 0, 1) };
	}
}

class Z extends Shape {
	public Z() {
		cells[0] = new Cell(1, 4, GamePanel.Z);
		cells[1] = new Cell(0, 3, GamePanel.Z);
		cells[2] = new Cell(0, 4, GamePanel.Z);
		cells[3] = new Cell(1, 5, GamePanel.Z);
		states = new State[] { new State(0, 0, -1, -1, -1, 0, 0, 1), new State(0, 0, -1, 1, 0, 1, 1, 0) };
	}
}

class O extends Shape {
	public O() {
		cells[0] = new Cell(0, 4, GamePanel.O);
		cells[1] = new Cell(0, 5, GamePanel.O);
		cells[2] = new Cell(1, 4, GamePanel.O);
		cells[3] = new Cell(1, 5, GamePanel.O);
		states = new State[] { new State(0, 0, 0, 1, 1, 0, 1, 1), new State(0, 0, 0, 1, 1, 0, 1, 1) };
	}
}
