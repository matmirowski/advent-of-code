package com.mateusz;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<Integer> calories = new ArrayList<>();
        int currentCalories = 0;
        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.equals("")) {
                calories.add(currentCalories);
                currentCalories = 0;
            }
            else {
                currentCalories += Integer.parseInt(line);
            }
        }
        reader.close();

        calories.sort(Comparator.reverseOrder());

        Integer summedCalories = calories.stream()
                .limit(3)
                .reduce(Integer::sum)
                .get();

        System.out.println(calories.get(0));
        System.out.println(summedCalories);
    }
}
