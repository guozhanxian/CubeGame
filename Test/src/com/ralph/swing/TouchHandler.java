package com.ralph.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TouchHandler implements ActionListener {

	private MyWin2 win;
	public TouchHandler(MyWin2 win)
	{
		this.win = win;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	    if(e.getSource()==win.getB1())
	    {
	    	    //one
	    	    win.getJt().setText("One");
	    }else if(e.getSource()==win.getB2())
	    {
	    	   //two
	    	   win.getJt().setText("Two");
	    }
	}

}
