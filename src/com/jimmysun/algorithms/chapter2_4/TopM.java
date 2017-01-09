package com.jimmysun.algorithms.chapter2_4;

import com.jimmysun.algorithms.chapter1_3.Stack;
import com.jimmysun.algorithms.chapter2_1.Transaction;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TopM {
	public static void main(String[] args) {
		int M = Integer.parseInt(args[0]);
		MinPQ<Transaction> pq = new MinPQ<Transaction>(M + 1);
		while (StdIn.hasNextLine()) {
			pq.insert(new Transaction(StdIn.readLine()));
			if (pq.size() > M) {
				pq.delMin();
			}
		}
		Stack<Transaction> stack = new Stack<Transaction>();
		while (!pq.isEmpty()) {
			stack.push(pq.delMin());
		}
		for (Transaction t : stack) {
			StdOut.println(t);
		}
	}
}
