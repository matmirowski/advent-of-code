package com.mateusz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static int checkCycle(int cycle, int x) {
        if ((cycle + 20) % 40 == 0) {
            return cycle * x;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;
        int value, x = 1, cycle = 0, signalSum = 0;

        while ((line = reader.readLine()) != null) {
            if (!line.equals("noop")) {
                value = Integer.parseInt(line.substring(5));
                cycle++;
                signalSum += checkCycle(cycle, x);
            } else {
                value = 0;
            }
            cycle++;
            signalSum += checkCycle(cycle, x);
            x += value;
        }
        System.out.println(signalSum);
    }
}
