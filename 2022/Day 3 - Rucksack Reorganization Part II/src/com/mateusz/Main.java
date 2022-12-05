package com.mateusz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;
        int lineCounter = 1;
        int prioritySum = 0;

        ArrayList<String> lines = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        for (int i = 2; i < lines.size(); i = i + 3) {
            String line1 = lines.get(i);
            String line2 = lines.get(i-1);
            String line3 = lines.get(i-2);
            char commonChar = findCommonChar(line1, line2, line3);
            int prority = 0;
            if ((int) commonChar >= 97)
                prority = (int) commonChar - 96;
            else
                prority = (int) commonChar - 38;
            prioritySum += prority;
        }

        System.out.println(prioritySum);
    }

    public static char findCommonChar(String line1, String line2, String line3) {
        for (int j = 0; j < line1.length(); j++) {
            char c1 = line1.charAt(j);
            for (int k = 0; k < line2.length(); k++) {
                char c2 = line2.charAt(k);
                for (int l = 0; l < line3.length(); l++) {
                    char c3 = line3.charAt(l);
                    if (c1 == c2 && c2 == c3) {
                        return c1;
                    }
                }
            }
        }
        return '/';
    }

}

