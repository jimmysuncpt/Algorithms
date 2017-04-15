package com.jimmysun.algorithms.chapter6;

public class FlowEdge {
	private final int v;
	private final int w;
	private final double capacity;
	private double flow;

	public FlowEdge(int v, int w, double capacity) {
		this.v = v;
		this.w = w;
		this.capacity = capacity;
		this.flow = 0.0;
	}

	public int from() {
		return v;
	}

	public int to() {
		return w;
	}

	public double capacity() {
		return capacity;
	}

	public double flow() {
		return flow;
	}

	public int other(int vertex) {
		if (vertex == v) {
			return w;
		} else if (vertex == w) {
			return v;
		} else {
			throw new RuntimeException("Inconsistent edge");
		}
	}

	public double residualCapacityTo(int vertex) {
		if (vertex == v) {
			return flow;
		} else if (vertex == w) {
			return capacity - flow;
		} else {
			throw new RuntimeException("Inconsistent edge");
		}
	}

	public void addResidualFlowTo(int vertex, double delta) {
		if (vertex == v) {
			flow -= delta;
		} else if (vertex == w) {
			flow += delta;
		} else {
			throw new RuntimeException("Inconsistent edge");
		}
	}

	@Override
	public String toString() {
		return String.format("%d->%d %.2f %.2f", v, w, capacity, flow);
	}
}
