package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PolycarpAndRest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> k = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayList::new));
		int count = getMaxRestHours(n, k);
		System.out.println(count);
		br.close();
	}

	private static int getMaxRestHours(int n, List<Integer> k) {
		int count = 0;
		int i = 0;
		while (i < n) {
			if (k.get(i) == 1) {
				int j = i;
				int subCount = 0;
				while (k.get(j) == 1) {	
					subCount++;
					j += 1;
					j = j % k.size();
					i = Math.max(i, j);
				}
				count = Math.max(subCount, count);
			}
			i++;
		}
		return count;
	}
}
