package com.jimmysun.algorithms.chapter1_3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> implements Iterable<Item> {
	private Node first;
	private int N;
	private int operates;

	private class Node {
		Item item;
		Node next;

		Node() {
		};

		/**
		 * Exercise 1.3.42
		 * 
		 * @param x
		 */
		Node(Node x) {
			item = x.item;
			if (x.next != null) {
				next = new Node(x.next);
			}
			N++;
		}
	}

	public Stack() {
		first = null;
		N = 0;
	}

	/**
	 * Exercise 1.3.42
	 * 
	 * @param s
	 */
	public Stack(Stack<Item> s) {
		first = new Node(s.first);
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
		operates++;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		operates++;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	/**
	 * Exercise 1.3.50
	 * 
	 * @author Jimmy
	 *
	 */
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		private int count = operates;

		@Override
		public boolean hasNext() {
			if (count != operates) {
				throw new ConcurrentModificationException();
			}
			return current != null;
		}

		@Override
		public Item next() {
			if (count != operates) {
				throw new ConcurrentModificationException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
		}
	}

	/**
	 * Exercise 1.3.7
	 * 
	 * @return
	 */
	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack underflow");
		}
		return first.item;
	}

	/**
	 * Exercise 1.3.47
	 * 
	 * @param stack
	 */
	public void catenation(Stack<Item> stack) {
		if (stack.first != null) {
			Stack<Item> temp = new Stack<>(stack);
			Node last = temp.first;
			while (last.next != null) {
				last = last.next;
			}
			last.next = first;
			first = temp.first;
		}
	}

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				s.push(item);
			} else if (!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}
