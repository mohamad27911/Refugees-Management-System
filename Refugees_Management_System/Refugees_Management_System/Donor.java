package Refugees_Management_System;

public class Donor extends Person {
	private double donatedAmount;

	public Donor() {
		donatedAmount = 0;
	}

	public int getId() {
		return super.getId();
	}

	public Donor(String name, int age, String nationality, double donatedAmount) {
		super(name, age, nationality);
		this.donatedAmount = donatedAmount;
	}

	public double getDonatedAmount() {
		return donatedAmount;
	}

	public void setDonatedAmount(double amount) {
		this.donatedAmount = amount;
	}
}