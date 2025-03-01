package Refugees_Management_System;

public class Donation {
	private Donor donor;
	private double donationAmount;
	

	public Donation() {
		this.donor = null;
		this.donationAmount = 0.0;
	}

	
	public Donation(Donor donor, double donationAmount) {
		this.donor = donor;
		this.donationAmount = donationAmount;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public double getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}

	
	public String toString() {
		
        return donor.getName() + " donated $" + donationAmount;
    }
}
