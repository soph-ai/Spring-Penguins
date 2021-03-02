package com.qa.penguins.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // marks as table
public class Penguin {

	@Id // marks as PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT
	private Long id;

	private String name;

	private int age;

	private int noOfChildren;

	private int tuxedoSize;

	public Penguin(Long id, String name, int age, int noOfChildren, int tuxedoSize) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.noOfChildren = noOfChildren;
		this.tuxedoSize = tuxedoSize;
	}

	public Penguin(String name, int age, int noOfChildren, int tuxedoSize) {
		super();
		this.name = name;
		this.age = age;
		this.noOfChildren = noOfChildren;
		this.tuxedoSize = tuxedoSize;
	}

	public Penguin() {
		super();
		// REQUIRED
	}

	// REQUIRED
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + noOfChildren;
		result = prime * result + tuxedoSize;
		return result;
	}

	// vvv MAKES THE MOCK WORK vvv
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Penguin other = (Penguin) obj;
		if (age != other.age)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (noOfChildren != other.noOfChildren)
			return false;
		if (tuxedoSize != other.tuxedoSize)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Penguin [id=" + id + ", name=" + name + ", age=" + age + ", noOfChildren=" + noOfChildren
				+ ", tuxedoSize=" + tuxedoSize + "]";
	}

}
