package com.jimmysun.algorithms.chapter4_2;

import java.util.Iterator;

import com.jimmysun.algorithms.chapter1_3.Stack;

import edu.princeton.cs.algs4.In;

public class Euler {
	private Stack<Integer> cycle = null;

	public Euler(Digraph G) {
		if (G.E() == 0) {
			return;
		}
		for (int v = 0; v < G.V(); v++) {
			if (G.outdegree(v) != G.indegree(v)) {
				return;
			}
		}
		Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.V()];
		for (int v = 0; v < G.V(); v++) {
			adj[v] = G.adj(v).iterator();
		}
		int s;
		for (s = 0; s < G.V(); s++) {
			if (G.outdegree(s) > 0) {
				break;
			}
		}
		if (s == G.V()) {
			s = -1;
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		cycle = new Stack<>();
		while (!stack.isEmpty()) {
			int v = stack.pop();
			while (adj[v].hasNext()) {
				stack.push(v);
				v = adj[v].next();
			}
			cycle.push(v);
		}
		if (cycle.size() != G.E() + 1) {
			cycle = null;
		}
	}

	public boolean hasCycle() {
		return cycle != null;
	}

	public Iterable<Integer> cycle() {
		return cycle;
	}

	public static void main(String[] args) {
		Digraph G = new Digraph(new In(args[0]));
		Euler euler = new Euler(G);
		if (euler.hasCycle()) {
			for (int v : euler.cycle()) {
				System.out.print(v + " ");
			}
			System.out.println();
		} else {
			System.out.println("Not has Eular cycle");
		}
	}
}
