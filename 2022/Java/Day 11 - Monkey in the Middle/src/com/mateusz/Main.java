package com.mateusz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static int FILE_LENGTH = 55;

    public static void main(String[] args) throws IOException {

        // load data from file
        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;
        String[] data = new String[FILE_LENGTH];
        int fileIndex = 0;
        while ((line = reader.readLine()) != null) {
            data[fileIndex] = line;
            fileIndex++;
        }

        // get data from file and instantionate monkeys
        List<Monkey> monkeys = new ArrayList<>();
        for (int i = 1; i < FILE_LENGTH; i = i + 7) {
            List<Integer> intItems = new ArrayList<>();
            String[] items =  data[i].substring(18).split(",");
            String opNumStr = data[i+1].substring(25);
            char operation = data[i+1].charAt(23);
            int divNum = Integer.parseInt(data[i+2].substring(21));
            int trueMonkey = data[i+3].charAt(29) - '0';
            int falseMonkey = data[i+4].charAt(30) - '0';

            int opNum;
            if (opNumStr.equals("old")) {
                opNum = -1;
            } else {
                opNum = Integer.parseInt(opNumStr.strip());
            }
            for (String item : items) {
                intItems.add(Integer.parseInt(item.strip()));
            }
            monkeys.add(new Monkey(operation, opNum, intItems, divNum, trueMonkey, falseMonkey));
        }

        // 20 rounds
        for (int i = 0; i < 20; i++) {
            for (Monkey monkey : monkeys) {
                for (Integer item : monkey.getItems()) {
                    int newItem = monkey.operation(item);
                    newItem /= 3;
                    if (newItem % monkey.getDivNum() == 0) { // true
                        monkeys.get(monkey.getMonkeyTrue()).getItems().add(newItem);
                    } else { // false
                        monkeys.get(monkey.getMonkeyFalse()).getItems().add(newItem);
                    }
                    monkey.inspect();
                }
                monkey.getItems().clear();
            }
        }

        // find two most active monkeys
        Integer monkeyBusiness = monkeys.stream()
                .map(Monkey::getInspectedItems)
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .reduce((a,b) -> a * b)
                .orElse(null);
        System.out.println(monkeyBusiness);
    }
}
