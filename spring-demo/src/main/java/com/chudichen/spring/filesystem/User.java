package com.chudichen.spring.filesystem;

/**
 * @author chudichen
 * @date 2020-08-04
 */
public class User {

	private String name;

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public void sayHell() {
		System.out.println("hello " + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
