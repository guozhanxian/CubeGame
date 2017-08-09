package project;


public class shape {

	public cell[] cells = new cell[4];
	public state[] state;
	int index=1000;

	public cell[] getCells() {
		return cells;
	}

	// 方块的偏移量
	class state {
		int row0, col0, row1, col1, row2, col2, row3, col3;

		public state(int row0, int col0, int row1, int col1, int row2,
				int col2, int row3, int col3) {
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

	// 随机产生七中形状中的一种
	public static shape getshape() {
		int num = (int) (Math.random() * 7) + 1;
		switch (num) {
		case 1:
			return new I();
		case 2:
			return new L();
		case 3:
			return new J();
		case 4:
			return new S();
		case 5:
			return new Z();
		case 6:
			return new O();
		case 7:
			return new T();
		default:
			break;
		}
		return null;
	}

	//方块左移
	public void moveLeft() {
		for (int i = 0; i < cells.length; i++) {
			cells[i].moveLeft();
		}
	}

	//方块右移
	public void moveRight() {
		for (int i = 0; i < cells.length; i++) {
			cells[i].moveRight();
		}
	}

	//方块下移
	public void dropDown() {
		for (int i = 0; i < cells.length; i++) {
			cells[i].moveDown();
		}
	}
	
	//左旋
	public void rotateLeft()
	{
		index--;//index = 10001
		// index % states.length = 10001 % 4 = 1
		state s = state[index%state.length];//s1
		// [0] + s1 = [1]
		cell o = cells[0];//获取当前的轴
		cells[1].setRow(o.getRow()+s.row1);
		cells[1].setCol(o.getCol()+s.col1);
		cells[2].setRow(o.getRow()+s.row2);
		cells[2].setCol(o.getCol()+s.col2);
		cells[3].setRow(o.getRow()+s.row3);
		cells[3].setCol(o.getCol()+s.col3);
	}
	
	//右旋
	public void rotateRight()
	{
		index++;//index = 10001
		// index % states.length = 10001 % 4 = 1
		state s = state[index%state.length];//s1
		// [0] + s1 = [1]
		cell o = cells[0];//获取当前的轴
		//轴与相对位置的和作为旋转以后的格子位置
		cells[1].setRow(o.getRow()+s.row1);
		cells[1].setCol(o.getCol()+s.col1);
		cells[2].setRow(o.getRow()+s.row2);
		cells[2].setCol(o.getCol()+s.col2);
		cells[3].setRow(o.getRow()+s.row3);
		cells[3].setCol(o.getCol()+s.col3);
	}
}

class I extends shape {
	public I() {
		cells[0] = new cell(0, 4, gamePanel.I);
		cells[1] = new cell(0, 3, gamePanel.I);
		cells[2] = new cell(0, 5, gamePanel.I);
		cells[3] = new cell(0, 6, gamePanel.I);
		state = new state[] { new state(0, 0, 0, 1, 0, -1, 0, -2), new state(0, 0, -1, 0, 1, 0, 2, 0) };
	}
}

class L extends shape {
	public L() {
		cells[0] = new cell(0, 4, gamePanel.L);
		cells[1] = new cell(0, 3, gamePanel.L);
		cells[2] = new cell(0, 5, gamePanel.L);
		cells[3] = new cell(1, 3, gamePanel.L);
		state = new state[] { new state(0, 0, 0, -1, 0, 1, 1, -1), new state(0, 0, -1, 0, 1, 0, -1, -1),
				new state(0, 0, 0, 1, 0, -1, -1, 1), new state(0, 0, 1, 0, -1, 0, 1, 1) };
	}
}

class J extends shape {
	public J() {
		cells[0] = new cell(0, 4, gamePanel.J);
		cells[1] = new cell(0, 3, gamePanel.J);
		cells[2] = new cell(0, 5, gamePanel.J);
		cells[3] = new cell(1, 5, gamePanel.J);
		state = new state[] { new state(0, 0, 0, -1, 0, 1, 1, 1), new state(0, 0, -1, 0, 1, 0, 1, -1),
				new state(0, 0, 0, 1, 0, -1, -1, -1), new state(0, 0, 1, 0, -1, 0, -1, 1) };
	}
}

class S extends shape {
	public S() {
		cells[0] = new cell(0, 4, gamePanel.S);
		cells[1] = new cell(0, 5, gamePanel.S);
		cells[2] = new cell(1, 3, gamePanel.S);
		cells[3] = new cell(1, 4, gamePanel.S);
		state = new state[] { new state(0, 0, 0, 1, 1, -1, 1, 0), new state(0, 0, -1, 0, 1, 1, 0, 1) };
	}
}

class Z extends shape {
	public Z() {
		cells[0] = new cell(1, 4, gamePanel.Z);
		cells[1] = new cell(0, 3, gamePanel.Z);
		cells[2] = new cell(0, 4, gamePanel.Z);
		cells[3] = new cell(1, 5, gamePanel.Z);
		state = new state[] { new state(0, 0, -1, -1, -1, 0, 0, 1), new state(0, 0, -1, 1, 0, 1, 1, 0) };
	}
}

class O extends shape {
	public O() {
		cells[0] = new cell(0, 4, gamePanel.O);
		cells[1] = new cell(0, 5, gamePanel.O);
		cells[2] = new cell(1, 4, gamePanel.O);
		cells[3] = new cell(1, 5, gamePanel.O);
		state = new state[] { new state(0, 0, 0, 1, 1, 0, 1, 1), new state(0, 0, 0, 1, 1, 0, 1, 1) };
	}
}

class T extends shape {
	public T() {
		cells[0] = new cell(0, 4, gamePanel.T);
		cells[1] = new cell(0, 3, gamePanel.T);
		cells[2] = new cell(0, 5, gamePanel.T);
		cells[3] = new cell(1, 4, gamePanel.T);
		state = new state[] { new state(0, 0, 0, -1, 0, 1, 1, 0), new state(0, 0, -1, 0, 1, 0, 0, -1),
				new state(0, 0, 0, 1, 0, -1, -1, 0), new state(0, 0, 1, 0, -1, 0, 0, 1) };
	}
}
