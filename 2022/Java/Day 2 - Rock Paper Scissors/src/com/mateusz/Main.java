package com.mateusz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;
        int pointsPart1 = 0;
        int pointsPart2 = 0;
        HashMap<Character, Integer> shapeToPoints = new HashMap<>();
        shapeToPoints.put('A', 1);
        shapeToPoints.put('B', 2);
        shapeToPoints.put('C', 3);

        while ((line = reader.readLine()) != null) {
            // part 1
            char enemyPick = line.charAt(0);
            char myPick = line.charAt(2);
            switch (myPick) {
                case 'X': // rock
                    pointsPart1 += 1;
                    if (enemyPick == 'A')
                        pointsPart1 += 3;
                    else if (enemyPick == 'C')
                        pointsPart1 += 6;
                    break;
                case 'Y': // paper
                    pointsPart1 += 2;
                    if (enemyPick == 'B')
                        pointsPart1 += 3;
                    else if (enemyPick == 'A')
                        pointsPart1 += 6;
                    break;
                case 'Z': // scissors
                    pointsPart1 += 3;
                    if (enemyPick == 'C')
                        pointsPart1 += 3;
                    else if (enemyPick == 'B')
                        pointsPart1 += 6;
                    break;
            }

            // part 2
            switch (myPick) {
                case 'X':
                    if (enemyPick == 'A')
                        pointsPart2 += 3;
                    else if (enemyPick == 'B')
                        pointsPart2 += 1;
                    else
                        pointsPart2 += 2;
                    break;
                case 'Y':
                    pointsPart2 += shapeToPoints.get(enemyPick) + 3;
                    break;
                case 'Z':
                    pointsPart2 += 6;
                    if (enemyPick == 'A')
                        pointsPart2 += 2;
                    else if (enemyPick == 'B')
                        pointsPart2 += 3;
                    else
                        pointsPart2 += 1;
                    break;
            }
        }

        System.out.println(pointsPart1);
        System.out.println(pointsPart2);
    }
}
