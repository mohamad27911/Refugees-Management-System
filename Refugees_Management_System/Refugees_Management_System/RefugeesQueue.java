package Refugees_Management_System;

public class RefugeesQueue {

	private LinkedList<Refugee> refugeeList;
	private String queueName;

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public RefugeesQueue() {
		refugeeList = new LinkedList<>();
	}
	public RefugeesQueue(String name) {
		refugeeList = new LinkedList<>(name);
		this.queueName=name;
	}

	public LinkedList<Refugee> getRefugeeList() {
		return refugeeList;
	}

	public void setRefugeeList(LinkedList<Refugee> refugeeList) {
		this.refugeeList = refugeeList;
	}

	public void addRefugee(Refugee r) {
		refugeeList.insertWithPriority(r, r.getDonationNeeded());
	}

	public Refugee removeRefugee(Refugee r) {
		return refugeeList.remove(r);
	}

	public Refugee searchRefugee(int r) {
		return refugeeList.searchById(r);
	}
	public Refugee searchCountry(String s) {
		return refugeeList.searchName(s);
	}

	public void displayRefugees() {
		if (!refugeeList.isEmpty()) {
			refugeeList.display();
		}else {
			System.out.println("Refugee Queue is Empty !");
		}
	}

	public void distributeAid(DonationQueue donationQueue) {
	    double totalDonation = 0;
	    Node<Donation> currentDonation = donationQueue.getDonationList().getFirst();
	    while (currentDonation != null) {
	    	donationQueue.getDonationList().removeFromFront();
	        totalDonation += currentDonation.getData().getDonationAmount();
	        currentDonation = currentDonation.getNext();
	    }
	    distributeAidAmongRefugees(totalDonation);
	}

	private void distributeAidAmongRefugees(double totalDonation) {
	    double remainingDonation = totalDonation;
	    Node<Refugee> currentRefugee = refugeeList.getFirst();

	    while (currentRefugee != null && remainingDonation > 0) {
	        Refugee r = currentRefugee.getData();

	        if (r.getDonationNeeded() <= remainingDonation) {
	            remainingDonation -= r.getDonationNeeded();
	            r.setDonationNeeded(0);
	            refugeeList.remove(r);
	        } else {
	            r.setDonationNeeded(r.getDonationNeeded() - remainingDonation);
	            remainingDonation = 0;
	            Refugee tempRefugee = r; // Temporary refugee
	            refugeeList.remove(r);
	            refugeeList.insertWithPriority(tempRefugee, tempRefugee.getDonationNeeded());
	        }
	        currentRefugee = currentRefugee.getNext();
	    }

	    if (remainingDonation > 0) {
	        System.out.println("Total donation of $" + totalDonation + " distributed among the refugees.");
	    } else {
	        System.out.println("Partial donation of $" + (totalDonation - remainingDonation) + " distributed among the refugees.");
	    }
	}

	

	
	
	

}
