package com.jimmysun.algorithms.chapter4_4;

import com.jimmysun.algorithms.chapter1_3.Bag;

public class EdgeWeightedDigraph {
	private final int V;
	private int E;
	private Bag<DirectedEdge>[] adj;

	public EdgeWeightedDigraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<DirectedEdge>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<DirectedEdge>();
		}
	}

	/**
	 * Exercise 4.4.2
	 * 
	 * @param in
	 */
	// public EdgeWeightedDigraph(In in) {
	// }

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(DirectedEdge e) {
		adj[e.from()].add(e);
		E++;
	}

	public Iterable<DirectedEdge> adj(int v) {
		return adj[v];
	}

	public Iterable<DirectedEdge> edges() {
		Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
		for (int v = 0; v < V; v++) {
			for (DirectedEdge e : adj[v]) {
				bag.add(e);
			}
		}
		return bag;
	}

	/**
	 * Exercise 4.3.17
	 */
	// @Override
	// public String toString() {
	// }
}
