package com.codeforces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ConnectTrees {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Point a = new Point();
		Point b = new Point();
		Point c = new Point();
		a.x = sc.nextInt();
		a.y = sc.nextInt();
		b.x = sc.nextInt();
		b.y = sc.nextInt();
		c.x = sc.nextInt();
		c.y = sc.nextInt();
		connectTrees(a, b, c);
		sc.close();
	}

	private static void connectTrees(Point a, Point b, Point c) {
		List<Point> pointList = new ArrayList<Point>();
		pointList.add(a);
		pointList.add(b);
		pointList.add(c);
		Collections.sort(pointList);
		a = pointList.get(0);
		b = pointList.get(1);
		c = pointList.get(2);

		List<String> firstPath = new ArrayList<String>();
		List<String> secondPath = new ArrayList<String>();

		firstPath = a.displayPath(b);
		secondPath = b.displayPath(c);
		secondPath.add(c.x + " " + c.y);
		System.out.println(firstPath.size() + secondPath.size());
		for (String path : firstPath) {
			System.out.println(path);
		}
		for (String path : secondPath) {
			System.out.println(path);
		}
	}
}

class Point implements Comparable<Point> {
	public int x;
	public int y;

	@Override
	public int compareTo(Point o) {
		if (x + y < o.x + o.y)
			return -1;
		if (x + y == o.x + o.y) {
//			if (x < o.x)
//				return -1;
//			if (x > o.x)
//				return 1;
//			if (x == o.x) {
//				if (y < o.y)
//					return -1;
//				if (y > o.y)
//					return 1;
//				if (y == o.y)
//					return 0;
//			}
			return 0;
		}
		return 1;
	}

	public List<String> displayPath(Point o) {
		List<String> pathString = new ArrayList<String>();
		for (int j = y; j < o.y; j++) {
			pathString.add(x + " " + j);
		}
		for (int j = x; j < o.x; j++) {
			pathString.add(j + " " + o.y);
		}
		return pathString;
	}
}