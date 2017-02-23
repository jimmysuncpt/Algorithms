package com.jimmysun.algorithms.chapter4_3;

import com.jimmysun.algorithms.chapter1_3.Bag;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

public class PrimMST {
	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private IndexMinPQ<Double> pq;

	public PrimMST(EdgeWeightedGraph G) {
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++) {
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		pq = new IndexMinPQ<Double>(G.V());

		distTo[0] = 0.0;
		pq.insert(0, 0.0);
		while (!pq.isEmpty()) {
			visit(G, pq.delMin());
		}
	}

	private void visit(EdgeWeightedGraph G, int v) {
		marked[v] = true;
		for (Edge e : G.adj(v)) {
			int w = e.other(v);

			if (marked[w]) {
				continue;
			}
			if (e.weight() < distTo[w]) {
				edgeTo[w] = e;

				distTo[w] = e.weight();
				if (pq.contains(w)) {
					pq.changeKey(w, distTo[w]);
				} else {
					pq.insert(w, distTo[w]);
				}
			}
		}
	}

	/**
	 * Exercise 4.3.21
	 * 
	 * @return
	 */
	public Iterable<Edge> edges() {
		Bag<Edge> mst = new Bag<>();
		for (int i = 1; i < edgeTo.length; i++) {
			mst.add(edgeTo[i]);
		}
		return mst;
	}

	/**
	 * Exercise 4.3.31
	 * 
	 * @return
	 */
	public double weight() {
		double weight = 0;
		for (int i = 0; i < distTo.length; i++) {
			weight += distTo[i];
		}
		return weight;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);

		PrimMST mst = new PrimMST(G);
		for (Edge e : mst.edges()) {
			StdOut.println(e);
		}
		StdOut.println(mst.weight());
	}
}
