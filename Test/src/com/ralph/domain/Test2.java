package com.ralph.domain;

public class Test2 {
	public static void main(String[] args) {
//	    A a = new A();
//	    A.B b = a.new B();
//	    b.hello();
		
//		A.B b = new A.B();
//		b.hello();
		//创建匿名内部类对象
		Cat c = new Cat("AAA",2,"Black") {
			private int i = 99;
			public void hello()
			{
				System.out.println(super.getName());
			}
		};
		
		I i = new I() {
			@Override
			public void hello() {
				System.out.println("Hello World!");
			}
		};
		
		i.hello();
	}
}
