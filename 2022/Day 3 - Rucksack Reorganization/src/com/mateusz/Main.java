package com.mateusz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;
        int prioritySum = 0;

        // part 1
        while ((line = reader.readLine()) != null) {
            String part1 = line.substring(0, line.length() / 2);
            String part2 = line.substring(line.length() / 2);
            char matchingChar = ' ';
            for (int i = 0; i < line.length() / 2; i++) {
                char c = part1.charAt(i);
                for (int j = 0; j < line.length() / 2; j++) {
                    if (c == part2.charAt(j)) {
                        matchingChar = c;
                        break;
                    }
                }
            }

            int prority;
            if ((int) matchingChar >= 97)
                prority = (int) matchingChar - 96;
            else
                prority = (int) matchingChar - 38;

            prioritySum += prority;
        }
        System.out.println(prioritySum);
    }
}
