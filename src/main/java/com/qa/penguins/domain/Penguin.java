package com.qa.penguins.domain;

public class Penguin {

	private String name;

	private int age;

	private int noOfChildren;

	private int tuxedoSize;

	public Penguin(String name, int age, int noOfChildren, int tuxedoSize) {
		super();
		this.name = name;
		this.age = age;
		this.noOfChildren = noOfChildren;
		this.tuxedoSize = tuxedoSize;
	}

	public Penguin() {
		super();
	}

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

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public int getTuxedoSize() {
		return tuxedoSize;
	}

	public void setTuxedoSize(int tuxedoSize) {
		this.tuxedoSize = tuxedoSize;
	}

}
