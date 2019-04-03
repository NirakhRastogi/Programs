package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SuperheroBattle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		long n = Long.parseLong(line.split(" ")[0]);
		long k = Long.parseLong(line.split(" ")[1]);
		long[] d = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		long count = calculateWhenMonsterWillDie(n, k, d);
		System.out.println(count);
		br.close();
	}

	private static long calculateWhenMonsterWillDie(long n, long k, long[] d) {
		long result = 0;
		long sum = 0L;
		long tempN = n;
		int i = 0;
		while (tempN > 0 && i < k) {
			sum += d[i];
			tempN += d[i];
			result++;
			i = i + 1;
		}
		if (tempN <= 0) {
			return result;
		} else if (sum >= 0) {
			return -1;
		}
		result=0;
		long remainingRounds = (n / Math.abs(sum)) - 700L;
		n += remainingRounds * sum;
		result += remainingRounds * k;
		i = 0;
		while (n > 0) {
			n += d[i];
			result++;
			i = (int) ((i + 1) % k);
		}
		return result;
	}
}
