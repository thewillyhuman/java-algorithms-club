package Linkedlist;

public class LinkedNode<T extends Comparable<T>> {

	private T value;
	private LinkedNode<T> prev, next;

	public LinkedNode( T value ) {
		this.value = value;
	}

	public T value() {
		return this.value;
	}

	public void value( T value ) {
		this.value = value;
	}

	public LinkedNode<T> previous() {
		return this.prev;
	}

	public void previous( LinkedNode<T> previousNode ) {
		this.prev = previousNode;
	}

	public LinkedNode<T> next() {
		return this.next;
	}

	public void next( LinkedNode<T> nextNode ) {
		this.next = nextNode;
	}

	public void delete() {
		this.value = null;
		this.next = null;
		this.prev = null;
	}
}
