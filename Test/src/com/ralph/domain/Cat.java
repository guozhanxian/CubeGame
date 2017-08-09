package com.ralph.domain;

public class Cat{
	
	public Cat() {
		super();
	}
	private String name;
	private int age;
	private String color;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Cat(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + ", color=" + color + "]";
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("拜拜！");
	}
}
