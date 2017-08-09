package com.ralph.domain;

import java.util.Scanner;

public class DvdUI {
	private Scanner sc = new Scanner(System.in);
	private DvdService service = new DvdService();
	public static void main(String[] args) {
		DvdUI ui = new DvdUI();
		ui.printMenu();
	}
	
	public void printMenu()
	{
		System.out.println("=========================");
		System.out.println("1、添加DVD信息   2、查看DVD信息");
		System.out.println("=========================");
		System.out.println("请输入选项");
		String select = sc.nextLine();
		
		switch(select)
		{
			case "1":
				addDvdInfo();
				break;
			case "2":
				showDvdInfo();
				break;
		}
	}

	private void showDvdInfo() {
		MyList list = service.findAllDvd();
		
		for(int i=0;i<list.size();i++)
		{
			DvdEntity obj = (DvdEntity) list.get(i);
			System.out.println(obj);
		}
		printMenu();
	}

	private void addDvdInfo() {
		System.out.println("请输入DVD的名字：");
		String name = sc.nextLine();
		
		System.out.println("请输入DVD的价格：");
		String price = sc.nextLine();
		
		DvdEntity obj = new DvdEntity(name, Double.parseDouble(price), null, false);
		service.add(obj);
		System.out.println("添加成功！");
		printMenu();
	}
}
