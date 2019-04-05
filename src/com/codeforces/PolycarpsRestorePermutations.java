package com.codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PolycarpsRestorePermutations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int[] q = new int[n - 1];
		for (int i = 0; i < q.length; i++) {
			q[i] = sc.nextInt();
		}
		callPermutationMethod(n, q);
		sc.close();

	}

	private static void callPermutationMethod(int n, int[] q) {
		int[] p = new int[n];
		int register = -1;
		for (int i = 0; i < n - 1; i++) {
			if (q[i] >= 0) {
				p[i] = 1;
				p[i + 1] = q[i] + 1;
				register = i + 1;
				break;
			}
		}

		boolean isValid = true;

		if (register == -1) {
			System.out.println("-1");
		} else {
			for (int i = register + 1; i < n; i++) {
				p[i] = q[i - 1] + p[i - 1];
				if (p[i] <= 0) {
					isValid = false;
					break;
				}
			}
			for (int i = register - 2; i >= 0; i--) {
				p[i] = p[i + 1] - q[i];
				if (p[i] <= 0) {
					isValid = false;
					break;
				}
			}
			if (isValid) {
				List<Integer> list = new ArrayList<Integer>();
				for (int i = 0; i < n; i++) {
					list.add(p[i]);
				}
				for (int i = 1; i <= n; i++) {
					if (!list.contains(i)) {
						isValid = false;
						break;
					}
				}
				if (isValid) {
					for (int i = 0; i < p.length; i++) {
						System.out.print(p[i] + " ");
					}
				} else {
					System.out.println("-1");
				}
			} else {
				System.out.println("-1");
			}
		}

	}
}
