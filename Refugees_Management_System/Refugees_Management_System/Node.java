package Refugees_Management_System;

public class Node<T> {
	private T data;
	private double priority;
	private Node<T> next;
	


	public Node() {
		this.data = null;
		this.next = null;
	}

	public Node(T data) {
		this.data = data;
		this.next = null;
	}
	public Node(T data,double p) {
		this.data = data;
		this.next = null;
		this.priority=0.0;
	}
	public double getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
}
