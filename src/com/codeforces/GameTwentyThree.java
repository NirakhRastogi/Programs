package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameTwentyThree {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int n = Integer.parseInt(line.split(" ")[0]);
		int m = Integer.parseInt(line.split(" ")[1]);
		if (n == m)
			System.out.println("0");
		else if (m % n != 0)
			System.out.println("-1");
		else {
			int count = getNumberOfMoves(m / n);
			System.out.println(count);
		}
		br.close();
	}

	private static int getNumberOfMoves(int k) {
		int count = 0;
		while (k != 0) {
			if (k == 1)
				break;
			if (k % 2 == 0) {
				k = k / 2;
				count++;
			} else if (k % 3 == 0) {
				k = k / 3;
				count++;
			} else {
				return -1;
			}
		}
		return count;
	}
}
