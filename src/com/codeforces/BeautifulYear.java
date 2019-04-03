package com.codeforces;

import java.util.Scanner;

public class BeautifulYear {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		beautifulYear(n);
		sc.close();
	}

	private static void beautifulYear(int n) {
		for (int i = n + 1; i < 10000; i++) {
			String iStr = String.valueOf(i);
			boolean checkDistint = true;
			for (int j = 0; j < iStr.length(); j++) {
				checkDistint = iStr.indexOf(iStr.charAt(j)) == iStr.lastIndexOf(iStr.charAt(j));
				if (!checkDistint)
					break;
			}
			if (checkDistint) {
				System.out.println(i);
				break;
			}
		}
	}
}
