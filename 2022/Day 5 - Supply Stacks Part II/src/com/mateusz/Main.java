package com.mateusz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        //[N]     [Q]         [N]
        //[R]     [F] [Q]     [G] [M]
        //[J]     [Z] [T]     [R] [H] [J]
        //[T] [H] [G] [R]     [B] [N] [T]
        //[Z] [J] [J] [G] [F] [Z] [S] [M]
        //[B] [N] [N] [N] [Q] [W] [L] [Q] [S]
        //[D] [S] [R] [V] [T] [C] [C] [N] [G]
        //[F] [R] [C] [F] [L] [Q] [F] [D] [P]
        // 1   2   3   4   5   6   7   8   9

        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;
        List<ArrayList<Character>> stacks = new ArrayList<>();

        ArrayList<Character> stack1 = new ArrayList<>();
        ArrayList<Character> stack2 = new ArrayList<>();
        ArrayList<Character> stack3 = new ArrayList<>();
        ArrayList<Character> stack4 = new ArrayList<>();
        ArrayList<Character> stack5 = new ArrayList<>();
        ArrayList<Character> stack6 = new ArrayList<>();
        ArrayList<Character> stack7 = new ArrayList<>();
        ArrayList<Character> stack8 = new ArrayList<>();
        ArrayList<Character> stack9 = new ArrayList<>();

        Collections.addAll(stack1, 'F', 'D', 'B', 'Z', 'T', 'J', 'R', 'N');
        Collections.addAll(stack2, 'R', 'S', 'N', 'J', 'H');
        Collections.addAll(stack3, 'C', 'R', 'N', 'J', 'G', 'Z', 'F', 'Q');
        Collections.addAll(stack4, 'F', 'V', 'N', 'G', 'R', 'T', 'Q');
        Collections.addAll(stack5, 'L', 'T', 'Q', 'F');
        Collections.addAll(stack6, 'Q', 'C', 'W', 'Z', 'B', 'R', 'G', 'N');
        Collections.addAll(stack7, 'F', 'C', 'L', 'S', 'N', 'H', 'M');
        Collections.addAll(stack8, 'D', 'N', 'Q', 'M', 'T', 'J');
        Collections.addAll(stack9, 'P', 'G', 'S');

        stacks.add(stack1);
        stacks.add(stack2);
        stacks.add(stack3);
        stacks.add(stack4);
        stacks.add(stack5);
        stacks.add(stack6);
        stacks.add(stack7);
        stacks.add(stack8);
        stacks.add(stack9);

        while ((line = reader.readLine()) != null) {
            String[] inputList = line.split(" ");
            // move 1 from 2 to 1
            int move = Integer.parseInt(inputList[1]);
            int moveFrom = Integer.parseInt(inputList[3]);
            int moveTo = Integer.parseInt(inputList[5]);

            ArrayList<Character> moveFromArray = stacks.get(moveFrom-1);
            ArrayList<Character> moveToArray = stacks.get(moveTo-1);
            ArrayList<Character> moveBlocks = new ArrayList<>();
            for (int i = 1; i <= move; i++) {
                Character block = moveFromArray.get(moveFromArray.size() - 1);
                moveFromArray.remove(moveFromArray.size() - 1);
                moveBlocks.add(block);
            }
            Collections.reverse(moveBlocks);
            moveToArray.addAll(moveBlocks);
        }

        for (int i = 0; i < 9; i++) {
            ArrayList<Character> list = stacks.get(i);
            System.out.print(list.get(list.size() - 1));
        }

    }
}
