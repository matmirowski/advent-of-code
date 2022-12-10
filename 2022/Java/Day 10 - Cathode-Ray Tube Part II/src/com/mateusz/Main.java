package com.mateusz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void displayCRT(int x, int cycle) {
        if (x == cycle-1 || x - 1 == cycle-1 || x + 1 == cycle-1)
            System.out.print('#');
        else
            System.out.print('.');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;
        int value, x = 1, cycle = 0;

        while ((line = reader.readLine()) != null) {
            if (!line.equals("noop")) {
                value = Integer.parseInt(line.substring(5));
                cycle++;
                displayCRT(x, cycle);
                if (cycle % 40 == 0) {
                    System.out.print('\n');
                    cycle = 0;
                }
            } else {
                value = 0;
            }
            cycle++;
            displayCRT(x, cycle);
            if (cycle % 40 == 0) {
                System.out.print('\n');
                cycle = 0;
            }
            x += value;
        }
    }
}
