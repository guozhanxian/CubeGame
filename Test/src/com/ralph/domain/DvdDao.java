package com.ralph.domain;

public class DvdDao {
	
	private MyList list = new MyList();
	
	public void insertDvd(DvdEntity obj)
	{
		list.add(obj);
	}
	
	public MyList findAllDvdInfo()
	{
		return this.list;
	}
}
