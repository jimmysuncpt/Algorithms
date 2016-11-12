package com.jimmysun.algorithms.chapter1_1;

import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ex31 {
	static class Point {
		double x;
		double y;

		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double p = Double.parseDouble(args[1]);
		if (p < 0 || p > 1) {
			System.out.println("p is not valid!");
			return;
		}
		Point[] points = new Point[N];
		double angle = 360.0 / N;
		StdDraw.circle(0.5, 0.5, 0.5);
		StdDraw.setPenRadius(0.05);
		for (int i = 0; i < N; i++) {
			points[i] = new Point(0.5 + 0.5 * Math.cos(angle * i * Math.PI / 180),
					0.5 + 0.5 * Math.sin(angle * i * Math.PI / 180));
			StdDraw.point(points[i].x, points[i].y);
		}
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(Color.GRAY);
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (StdRandom.bernoulli(p)) {
					StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
				}
			}
		}
	}
}
