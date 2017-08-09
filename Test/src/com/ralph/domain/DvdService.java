package com.ralph.domain;

public class DvdService {
	private DvdDao dao = new DvdDao();
	
	public void add(DvdEntity obj)
	{
		dao.insertDvd(obj);
	}
	
	public MyList findAllDvd()
	{
		return dao.findAllDvdInfo();
	}
}
