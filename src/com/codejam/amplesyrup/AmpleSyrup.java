package com.codejam.amplesyrup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

public class AmpleSyrup {
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = Paths.get("").toAbsolutePath() + "/src/com/codejam/amplesyrup/A-large-practice.in";
		File fo = new File(fileName);
		if (!fo.exists()) {
			throw new FileNotFoundException();
		}
		String outFileName = Paths.get("").toAbsolutePath() + "/src/com/codejam/amplesyrup/" + fo.getName().substring(0,fo.getName().length()-3) + "-output.txt";
		System.out.println(outFileName);
		try (BufferedReader br = new BufferedReader(new FileReader(fo));
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File(outFileName)))) {
			int t = Integer.parseInt(br.readLine());
			for (int testNumber = 0; testNumber < t; testNumber++) {
				int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int[][] rh = new int[nk[0]][2];
				for (int i = 0; i < nk[0]; i++) {
					rh[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				}
				Arrays.sort(rh, (int[] o1, int[] o2) -> (int) Math.signum(o2[0] - (double)o1[0]));
				double[][] ans = new double[nk[0] + 1][nk[1] + 1];
	            for(int i = 0; i < nk[0]; i++) {
	                for (int j = 0; j <= nk[1]; j++) {
	                    ans[i + 1][j] = Math.max(ans[i + 1][j], ans[i][j]);
	                    if (j == nk[1]) continue;
	                    ans[i + 1][j + 1] = Math.max(ans[i + 1][j + 1], ans[i][j] + 2 * Math.PI * rh[i][0] * rh[i][1] + (j == 0 ? Math.PI * rh[i][0] * rh[i][0] : 0));
	                }
	            }
	            System.out.println("Case #" + (testNumber+1) + ": " + ans[nk[0]][nk[1]]);
	            bw.append("Case #" + (testNumber+1) + ": " + ans[nk[0]][nk[1]]);
	            bw.newLine();
			}

		} catch (IOException e) {
			System.err.println("File not found.." + e);
			System.out.println(e);
		}
	}
}
