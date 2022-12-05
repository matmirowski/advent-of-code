package com.mateusz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;
        int fullyOverlappingPairs = 0;
        int partiallyOverlappingPairs = 0;

        while ((line = reader.readLine()) != null) {
            int separatorIndex = line.indexOf(',');
            String range1 = line.substring(0, separatorIndex);
            String range2 = line.substring(separatorIndex + 1);
            int range1SeparatorIndex = range1.indexOf('-');
            int range2SeparatorIndex = range2.indexOf('-');
            int range1Start = Integer.parseInt(range1.substring(0, range1SeparatorIndex));
            int range1End = Integer.parseInt(range1.substring(range1SeparatorIndex + 1));
            int range2Start = Integer.parseInt(range2.substring(0, range2SeparatorIndex));
            int range2End = Integer.parseInt(range2.substring(range2SeparatorIndex + 1));

            if ((range1Start >= range2Start && range1End <= range2End) ||
                    (range2Start >= range1Start && range2End <= range1End))
                fullyOverlappingPairs++;
            else if ((range1Start >= range2Start && range1Start <= range2End) ||
                    (range1Start <= range2Start && range1End >= range2Start)) {
                partiallyOverlappingPairs++;
            }
        }
        System.out.println(fullyOverlappingPairs);
        System.out.println(partiallyOverlappingPairs + fullyOverlappingPairs);
    }
}
