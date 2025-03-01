package Refugees_Management_System;

public class Refugee extends Person {
	private double donationNeeded;
	private String country;
	private int NbOfChildren;
	private String Description;

	public Refugee() {
		donationNeeded = 0;
		country = null;
		NbOfChildren = 0;
		Description = "";
	}

	public int getId() {
		return super.getId();
	}

	public Refugee(String name, int age, String nationality, double donationNeeded, String country, int NbOfChildren,
			String Description) {
		super(name, age, nationality);
		this.donationNeeded = donationNeeded;
		this.country = country;
		this.NbOfChildren = NbOfChildren;
		this.Description = Description;
	}

	public double getDonationNeeded() {
		return donationNeeded;
	}

	public void setDonationNeeded(double donationNeeded) {
		this.donationNeeded = donationNeeded;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getNbOfChildren() {
		return NbOfChildren;
	}

	public void setNbOfChildren(int NbOfChildren) {
		this.NbOfChildren = NbOfChildren;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

}
