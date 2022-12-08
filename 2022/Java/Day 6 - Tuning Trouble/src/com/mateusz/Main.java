package com.mateusz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;
        int result = 0;
        int result2 = 0;
        while ((line = reader.readLine()) != null) {
            for (int i = 3; i < line.length(); i++) {

                // part 1
                Set<Character> chars = new HashSet<>();
                chars.add(line.charAt(i));
                chars.add(line.charAt(i-1));
                chars.add(line.charAt(i-2));
                chars.add(line.charAt(i-3));
                if (chars.size() == 4) {
                    result = i + 1;
                    break;
                }
            }

            // part 2
            for (int i = 13; i < line.length(); i++) {
                Set<Character> chars2 = new HashSet<>();
                for (int j = i; j >= i - 13; j--) {
                    chars2.add(line.charAt(j));
                }
                if (chars2.size() == 14) {
                    result2 = i + 1;
                    break;
                }
            }
        }
        System.out.println(result);
        System.out.println(result2);
    }
}
