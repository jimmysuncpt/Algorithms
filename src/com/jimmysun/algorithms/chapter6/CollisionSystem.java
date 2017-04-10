package com.jimmysun.algorithms.chapter6;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Particle;
import edu.princeton.cs.algs4.StdDraw;

public class CollisionSystem {
	private class Event implements Comparable<Event> {
		private final double time;
		private final Particle a, b;
		private final int countA, countB;

		public Event(double t, Particle a, Particle b) {
			this.time = t;
			this.a = a;
			this.b = b;
			if (a != null) {
				countA = a.count();
			} else {
				countA = -1;
			}
			if (b != null) {
				countB = b.count();
			} else {
				countB = -1;
			}
		}

		@Override
		public int compareTo(Event that) {
			if (this.time < that.time) {
				return -1;
			} else if (this.time > that.time) {
				return +1;
			} else {
				return 0;
			}
		}

		public boolean isValid() {
			if (a != null && a.count() != countA) {
				return false;
			}
			if (b != null && b.count() != countB) {
				return false;
			}
			return true;
		}
	}

	private MinPQ<Event> pq;
	private double t = 0.0;
	private Particle[] particles;

	public CollisionSystem(Particle[] particles) {
		this.particles = particles;
	}

	private void predictCollisions(Particle a, double limit) {
		if (a == null) {
			return;
		}
		for (int i = 0; i < particles.length; i++) {
			double dt = a.timeToHit(particles[i]);
			if (t + dt <= limit) {
				pq.insert(new Event(t + dt, a, particles[i]));
			}
		}
		double dtX = a.timeToHitVerticalWall();
		if (t + dtX <= limit) {
			pq.insert(new Event(t + dtX, a, null));
		}
		double dtY = a.timeToHitHorizontalWall();
		if (t + dtY <= limit) {
			pq.insert(new Event(t + dtY, null, a));
		}
	}

	public void redraw(double limit, double Hz) {
		StdDraw.clear();
		for (int i = 0; i < particles.length; i++) {
			particles[i].draw();
		}
		StdDraw.show(20);
		if (t < limit) {
			pq.insert(new Event(t + 1.0 / Hz, null, null));
		}
	}

	public void simulate(double limit, double Hz) {
		pq = new MinPQ<Event>();
		for (int i = 0; i < particles.length; i++) {
			predictCollisions(particles[i], limit);
		}
		pq.insert(new Event(0, null, null));
		while (!pq.isEmpty()) {
			Event event = pq.delMin();
			if (!event.isValid()) {
				continue;
			}
			for (int i = 0; i < particles.length; i++) {
				particles[i].move(event.time - t);
			}
			t = event.time;
			Particle a = event.a, b = event.b;
			if (a != null && b != null) {
				a.bounceOff(b);
			} else if (a != null && b == null) {
				a.bounceOffVerticalWall();
			} else if (a == null && b != null) {
				b.bounceOffHorizontalWall();
			} else if (a == null && b == null) {
				redraw(limit, Hz);
			}
			predictCollisions(a, limit);
			predictCollisions(b, limit);
		}
	}

	public static void main(String[] args) {
		StdDraw.show(0);
		int N = Integer.parseInt(args[0]);
		Particle[] particles = new Particle[N];

		for (int i = 0; i < N; i++) {
			particles[i] = new Particle();
		}
		CollisionSystem system = new CollisionSystem(particles);
		system.simulate(10000, 0.5);
	}
}
