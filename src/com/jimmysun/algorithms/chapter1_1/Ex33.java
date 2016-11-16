package com.jimmysun.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

public class Ex33 {
	public static void main(String[] args) {
		int h, w;
		System.out.print("The length of array x: ");
		h = StdIn.readInt();
		double[] x = new double[h];
		for (int i = 0; i < x.length; i++) {
			x[i] = StdIn.readDouble();
		}
		System.out.print("The length of array y: ");
		w = StdIn.readInt();
		double[] y = new double[w];
		for (int i = 0; i < y.length; i++) {
			y[i] = StdIn.readDouble();
		}
		System.out.print("The height and width of matrix a: ");
		h = StdIn.readInt();
		w = StdIn.readInt();
		double[][] a = new double[h][w];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = StdIn.readDouble();
			}
		}
		System.out.print("The height and width of matrix b: ");
		h = StdIn.readInt();
		w = StdIn.readInt();
		double[][] b = new double[h][w];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = StdIn.readDouble();
			}
		}
		System.out.println("dot(x, y): " + Matrix.dot(x, y));
		double[][] matrix = Matrix.mult(a, b);
		if (matrix != null) {
			System.out.println("mult(a, b):");
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
		}
		matrix = Matrix.transpose(a);
		if (matrix != null) {
			System.out.println("transpose(a):");
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
		}
		double[] array = Matrix.mult(a, x);
		if (array != null) {
			System.out.println("mult(a, x):");
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
		}
		array = Matrix.mult(y, a);
		if (array != null) {
			System.out.println("mult(y, a):");
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
		}
	}
}
