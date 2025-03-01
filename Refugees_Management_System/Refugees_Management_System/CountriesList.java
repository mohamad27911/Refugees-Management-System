package Refugees_Management_System;

public class CountriesList {
	private LinkedList<RefugeesQueue> donationList;

	public CountriesList() {
		donationList = new LinkedList<>();
	}

	public void addCountry(RefugeesQueue r) {
		donationList.insertAtBack(r);
	}

	public RefugeesQueue removeCountry(RefugeesQueue r) {
		return donationList.remove(r);
	}

	public RefugeesQueue searchCountry(String queueName) {
		return donationList.searchByName(queueName);
	}

	public void display() {
		donationList.display();
	}
	

}
