package Refugees_Management_System;

public class DonationQueue {
	private LinkedList<Donation> donationList;

	public DonationQueue() {
		donationList = new LinkedList<>();
	}
	

	public LinkedList<Donation> getDonationList() {
		return donationList;
	}


	public void setDonationList(LinkedList<Donation> donationList) {
		this.donationList = donationList;
	}

	

	public void addDonation(Donation d) {
		donationList.insertWithPriority(d, d.getDonationAmount());
	}
	 public Donation removeDonation(Donation d) {
		return donationList.remove(d);
	 }
	 public Donation searchDonation(double amount) {
		 return donationList.searchByAmount(amount);
	 }
	 public void Display() {
		if (!donationList.isEmpty()) {
			 donationList.display();

		}else {
			System.out.println("List is Empty!");
		}
	 }
}