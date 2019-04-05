package com.codejam.savingtheuniverseagain;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.codejam.baseimpl.BaseImpl;

public class SavingTheUniverseAgain extends BaseImpl {
    public static void main(String[] args) throws FileNotFoundException {
        initializeReaderAndWriter(SavingTheUniverseAgain.class, "input", ".txt");
    }

    private static int solveToSaveUniverse(int d, char[] program) {
        long damage = computeDamage(program);
        int swapCount = 0;
        if (damage <= d)
            return swapCount;

        boolean isSwapped = false;
        boolean isRunStarted = false;
        while (computeDamage(program) > d && (isSwapped || !isRunStarted)) {
            isRunStarted = true;
            boolean isSwappable = false;
            for (int i = program.length - 1; i >= 0; i--) {
                char c = program[i];
                if (c == 'S')
                    isSwappable = true;
                if (c == 'C' && isSwappable) {
                    program[i] = 'S';
                    program[i + 1] = 'C';
                    swapCount++;
                    isSwapped = true;
                }
            }
        }

        if (!isSwapped)
            return -1;

        return swapCount;
    }

    private static long computeDamage(char[] program) {
        long damage = 0L;
        long beamDamage = 1L;
        for (char c : program) {
            if (c == 'C')
                beamDamage *= 2;
            if (c == 'S')
                damage += beamDamage;
        }
        return damage;
    }

    @Override
    public void implementCode(Scanner sc, PrintWriter out) {
        int t = sc.nextInt();
        for (int testNumber = 1; testNumber <= t; testNumber++) {
            int d = sc.nextInt();
            String program = sc.next();
            int output = solveToSaveUniverse(d, program.toCharArray());
            System.out.println("Case #" + testNumber + ": " + (output == -1 ? "IMPOSSIBLE" : output));
        }
    }
}
