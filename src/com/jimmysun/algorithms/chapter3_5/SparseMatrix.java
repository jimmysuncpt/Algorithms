package com.jimmysun.algorithms.chapter3_5;

public class SparseMatrix {
	private SparseVector[] rows;
	private int n;

	public SparseMatrix(int n) {
		this.n = n;
		rows = new SparseVector[n];
		for (int i = 0; i < n; i++) {
			rows[i] = new SparseVector();
		}
	}

	public void put(int i, int j, double val) {
		if (i < 0 || i >= n) {
			throw new IllegalArgumentException("Illegal index");
		}
		if (j < 0 || j >= n) {
			throw new IllegalArgumentException("Illegal index");
		}
		rows[i].put(j, val);
	}

	public double get(int i, int j) {
		if (i < 0 || i >= n) {
			throw new IllegalArgumentException("Illegal index");
		}
		if (j < 0 || j >= n) {
			throw new IllegalArgumentException("Illegal index");
		}
		return rows[i].get(j);
	}

	public SparseMatrix plus(SparseMatrix that) {
		if (this.n != that.n) {
			throw new RuntimeException("Dimensions disagree");
		}
		SparseMatrix matrix = new SparseMatrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				double sum = rows[i].get(j) + that.get(i, j);
				if (sum != 0) {
					matrix.put(i, j, sum);
				}
			}
		}
		return matrix;
	}

	public SparseVector times(SparseVector that) {
		SparseVector vector = new SparseVector();
		for (int i = 0; i < n; i++) {
			double sum = rows[i].dot(that);
			if (sum != 0) {
				vector.put(i, sum);
			}
		}
		return vector;
	}

	public SparseMatrix times(SparseMatrix that) {
		if (this.n != that.n) {
			throw new RuntimeException("Dimensions disagree");
		}
		SparseMatrix matrix = new SparseMatrix(n);
		SparseVector[] thatLines = new SparseVector[n];
		for (int i = 0; i < n; i++) {
			thatLines[i] = new SparseVector();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				double val = that.get(i, j);
				if (val != 0) {
					thatLines[j].put(i, val);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				double sum = rows[i].dot(thatLines[j]);
				if (sum != 0) {
					matrix.put(i, j, sum);
				}
			}
		}
		return matrix;
	}

	@Override
	public String toString() {
		String s = "n = " + n + "\n";
		for (int i = 0; i < n; i++) {
			s += i + ": " + rows[i] + "\n";
		}
		return s;
	}

	public static void main(String[] args) {
		SparseMatrix A = new SparseMatrix(5);
		SparseVector x = new SparseVector();
		A.put(0, 0, 1.0);
		A.put(1, 1, 1.0);
		A.put(2, 2, 1.0);
		A.put(3, 3, 1.0);
		A.put(4, 4, 1.0);
		A.put(2, 4, 0.3);
		x.put(0, 0.75);
		x.put(2, 0.11);
		System.out.println("x     : " + x);
		System.out.println("A     : " + A);
		System.out.println("A + A : " + A.plus(A));
		System.out.println("Ax    : " + A.times(x));
		System.out.println("AA    : " + A.times(A));
	}
}
