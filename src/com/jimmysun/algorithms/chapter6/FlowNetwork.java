package com.jimmysun.algorithms.chapter6;

import com.jimmysun.algorithms.chapter1_3.Bag;

import edu.princeton.cs.algs4.In;

public class FlowNetwork {
	private final int V;
	private int E;
	private Bag<FlowEdge>[] adj;

	public FlowNetwork(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<FlowEdge>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<FlowEdge>();
		}
	}

	public FlowNetwork(In in) {
		this(in.readInt());
		int E = in.readInt();
		if (E < 0) {
			throw new IllegalArgumentException("Number of edges must be nonnegative");
		}
		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			double capacity = in.readDouble();
			addEdge(new FlowEdge(v, w, capacity));
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(FlowEdge e) {
		adj[e.from()].add(e);
		adj[e.to()].add(e);
		E++;
	}

	public Iterable<FlowEdge> adj(int v) {
		return adj[v];
	}

	public Iterable<FlowEdge> edges() {
		Bag<FlowEdge> bag = new Bag<FlowEdge>();
		for (int v = 0; v < V; v++) {
			for (FlowEdge e : adj[v]) {
				if (e.to() != v) {
					bag.add(e);
				}
			}
		}
		return bag;
	}

	@Override
	public String toString() {
		String s = V + " vertices, " + E + " edges\n";
		for (int v = 0; v < V; v++) {
			s += v + ": ";
			for (FlowEdge e : this.adj(v)) {
				s += e + " ";
			}
			s += "\n";
		}
		return s;
	}
}
