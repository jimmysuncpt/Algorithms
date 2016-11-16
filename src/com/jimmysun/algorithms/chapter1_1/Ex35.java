package com.jimmysun.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Ex35 {
	public static void main(String[] args) {
		int SIDES = 6;
		double[] dist = new double[2 * SIDES + 1];
		for (int i = 1; i <= SIDES; i++) {
			for (int j = 1; j <= SIDES; j++) {
				dist[i + j] += 1.0;
			}
		}
		System.out.print("Probability:");
		for (int k = 2; k <= 2 * SIDES; k++) {
			dist[k] /= 36.0;
			System.out.printf("%6.3f", dist[k]);
		}
		System.out.println();
		int[] num = new int[2 * SIDES + 1];
		int N = StdIn.readInt();
		for (int i = 0; i < N; i++) {
			num[StdRandom.discrete(dist)]++;
		}
		double frequency;
		boolean isAccurate = true;
		System.out.print("Frequency:");
		for (int i = 2; i <= 2 * SIDES; i++) {
			frequency = (double) num[i] / N;
			System.out.printf("%6.3f", frequency);
			if (Math.abs(frequency - dist[i]) > 0.001) {
				isAccurate = false;
			}
		}
		System.out.println();
		System.out.println("Is accurate? " + isAccurate);
	}
}
