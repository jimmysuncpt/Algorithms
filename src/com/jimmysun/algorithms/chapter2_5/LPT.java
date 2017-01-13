package com.jimmysun.algorithms.chapter2_5;

import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;

public class LPT {

	public static void main(String[] args) {
		int M = Integer.parseInt(args[0]);
		int N = StdIn.readInt();
		Job[] jobs = new Job[N];
		for (int i = 0; i < N; i++) {
			jobs[i] = new Job(StdIn.readString(), StdIn.readDouble());
		}
		Arrays.sort(jobs);
		MinPQ<Processor> processorPQ = new MinPQ<>(M);
		for (int i = 0; i < M; i++) {
			processorPQ.insert(new Processor());
		}
		for (int i = N - 1; i >= 0; i--) {
			Processor processor = processorPQ.delMin();
			processor.insert(jobs[i]);
			processorPQ.insert(processor);
		}
		for (int i = 0; !processorPQ.isEmpty(); i++) {
			Processor processor = processorPQ.delMin();
			ArrayList<Job> jobList = processor.getJobs();
			System.out.println("Processor " + i + ":");
			for (int j = 0; j < jobList.size(); j++) {
				System.out.println(jobList.get(j));
			}
		}
	}
}
