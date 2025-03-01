package Refugees_Management_System;

public class Person {
	private static int count = 0;
	private int id;
	private String name;
	private int age;
	private String nationality;

	public Person() {
		this.id = ++count;
		name = null;
		age = 0;
		nationality = null;
	}

	public Person(String name, int age, String nationality) {
		this.id = ++count;
		this.name = name;
		this.age = age;
		this.nationality = nationality;
	}

	public int getId() {
		return id;
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}