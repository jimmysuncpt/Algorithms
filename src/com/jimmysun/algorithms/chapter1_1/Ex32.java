package com.jimmysun.algorithms.chapter1_1;

import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdDraw;

public class Ex32 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		ArrayList<Double> list = new ArrayList<>();
		while (scanner.hasNextDouble()) {
			list.add(scanner.nextDouble());
		}
		int N = Integer.parseInt(args[0]);
		double l = Double.parseDouble(args[1]), r = Double.parseDouble(args[2]);
		int[] num = new int[N];
		int max = 0;
		double step = (r - l) / N;
		for (int i = 0; i < list.size(); i++) {
			double element = list.get(i);
			if (element >= l && element <= r) {
				for (int j = 0; j < N; j++) {
					if (element > l + step * j && element <= l + step * j + step) {
						num[j]++;
						if (max < num[j]) {
							max = num[j];
						}
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			double x = (1.0 * i + 0.5) / N;
			double y = num[i] / (max * 2.0);
			double rw = 0.4 / N;
			StdDraw.filledRectangle(x, y, rw, y);
		}
	}
}
