package com.mateusz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int getLargerNums(BufferedReader reader) throws IOException {
        String line;
        int prev = 0, result = 0;
        boolean firstLine = true;
        while ((line = reader.readLine()) != null) {
            if (firstLine) {
                prev = Integer.parseInt(line);
                firstLine = false;
                continue;
            }
            int currentNumber = Integer.parseInt(line);
            if (currentNumber > prev)
                result++;
            prev = currentNumber;
        }
        return result;
    }

    private static int getTripleSumCounter(BufferedReader reader) throws IOException {
        List<Integer> nums = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            nums.add(Integer.parseInt(line));
        }

        int prevSum = 0;
        int counter = 0;
        for (int i = 2; i < nums.size(); i++) {
            int sum = nums.get(i) + nums.get(i - 1) + nums.get(i - 2);
            if (i != 2 && sum > prevSum) {
                counter++;
            }
            prevSum = sum;
        }
        return counter;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        try {
            int result = getLargerNums(reader);
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Error loading file!");
        }
        reader.close();

        BufferedReader reader2 = new BufferedReader(new FileReader("input.txt"));
        try {
            int result = getTripleSumCounter(reader2);
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Error loading file!");
        }
        reader.close();


    }
}
