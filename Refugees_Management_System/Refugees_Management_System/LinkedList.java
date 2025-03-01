package Refugees_Management_System;

public class LinkedList<T> {
	private Node<T> first;
	private String name;

	public LinkedList(Node<T> first, String name) {
		super();
		this.first = first;
		this.name = name;
	}

	public LinkedList(String name) {
		super();
		this.name = name;
	}

	public LinkedList() {
		first = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public Node<T> getFirst() {
		return first;
	}

	public void insertAtBack(T data) {
		Node<T> newNode = new Node<>(data);
		if (isEmpty()) {
			first = newNode;
		} else {
			Node<T> current = first;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
	}

	public void insertWithPriority(T data, double priority) {
		Node<T> newNode = new Node<>(data);
		if (isEmpty() || priority >= getPriority(first.getData())) {
			newNode.setNext(first);
			first = newNode;
		} else {
			Node<T> current = first;
			Node<T> previous = null;

			while (current != null && priority < getPriority(current.getData())) {
				previous = current;
				current = current.getNext();
			}

			if (previous != null) {
				newNode.setNext(current);
				previous.setNext(newNode);
			}
		}
	}

	private double getPriority(T data) {
		if (data instanceof Refugee) {
			return ((Refugee) data).getDonationNeeded();
		} else if (data instanceof Donation) {
			return ((Donation) data).getDonationAmount();
		}
		return 0;
	}

	private int getId(T data) {
		if (data instanceof Refugee) {
			return ((Refugee) data).getId();
		} else if (data instanceof Donor) {
			return ((Donor) data).getId();
		}
		return 0;
	}

	private double getAmount(T data) {
		if (data instanceof Donation)
			return ((Donation) data).getDonationAmount();
		return 0;
	}

	public T removeFromFront() {
		if (isEmpty()) {
			throw new IllegalStateException("LinkedList is empty");
		}
		T removedData = first.getData();
		first = first.getNext();
		return removedData;
	}

	public T remove(T data) {
		if (isEmpty()) {
			return null;
		}

		if (first.getData().equals(data)) {
			T removedData = first.getData();
			first = first.getNext();
			return removedData;
		}

		Node<T> previous = first;
		Node<T> current = first.getNext();
		while (current != null) {
			if (current.getData().equals(data)) {
				T removedData = current.getData();
				previous.setNext(current.getNext());
				return removedData;
			}
			previous = current;
			current = current.getNext();
		}
		return null;
	}

	public T searchById(int id) {
		Node<T> current = first;
		while (current != null) {
			if (getId(current.getData()) == id) {
				return current.getData();
			}
			current = current.getNext();
		}
		return null;
	}

	public int size() {
		Node<T> current = first;
		int k = 0;
		while (current != null) {
			k++;
			current = current.getNext();
		}
		return k;
	}

	public RefugeesQueue searchByName(String s) {
		Node<T> current = first;
		while (current != null) {
			if (((RefugeesQueue) current.getData()).getQueueName().equals(s)) {
				return ((RefugeesQueue) current.getData());
			}
			current = current.getNext();
		}
		return null;
	}

	public Refugee searchName(String s) {
		Node<T> current = first;
		while (current != null) {
			if (((RefugeesQueue) current.getData()).getQueueName().equals(s)) {
				return ((Refugee) current.getData());
			}
			current = current.getNext();
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFirst(Node<T> first) {
		this.first = first;
	}

	public T searchByAmount(double amount) {
		Node<T> current = first;
		while (current != null) {
			if (getAmount(current.getData()) == amount) {
				return current.getData();
			}
			current = current.getNext();
		}
		return null;
	}

	public void display() {
		Node<T> current = first;
		while (current != null) {
			if ((current.getData() instanceof Refugee)) {
				Refugee refugee = (Refugee) current.getData();

				System.out.println("Name: " + refugee.getName());
				System.out.println("Id: "+ refugee.getId());
				System.out.println("Age: " + refugee.getAge());
				System.out.println("Country: " + refugee.getCountry());
				System.out.println("Description : Needs " + refugee.getDescription());
				System.out.println("Number Of Children : " + refugee.getNbOfChildren());
				System.out.println("Donation Needed : " + refugee.getDonationNeeded());
				System.out.println();
			} else if (current.getData() instanceof Donation) {
				Donation don = (Donation) current.getData();
				System.out.println(don.getDonor().getName() + " donated $" + don.getDonor().getDonatedAmount());
			}

			else if (current.getData() instanceof RefugeesQueue) {
				RefugeesQueue queue = (RefugeesQueue) current.getData();
				System.out.println("------------------------------------------");
				System.out.println("\t\t"+queue.getQueueName() + ":");
				System.out.println("------------------------------------------");
				queue.displayRefugees();
				System.out.println();
			} else {
				// Handle other types if needed
				System.out.println("Unknown type");
			}
			current = current.getNext();
		}
	}

}
