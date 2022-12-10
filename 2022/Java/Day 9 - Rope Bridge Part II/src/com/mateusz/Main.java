package com.mateusz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int START_X = 1000;
    public static int START_Y = 1000;
    public static int MAX_SIZE = 2000;

    public static void checkMoveUp(Snake tail, Snake head) {
        if (head.getY() == tail.getY() + 2) {
            if (head.getX() == tail.getX() + 1)
                tail.move('R');
            else if (head.getX() == tail.getX() + 2) {
                tail.move('R');
                tail.move('R');
            }
            else if (head.getX() == tail.getX() - 1)
                tail.move('L');
            else if (head.getX() == tail.getX() - 2) {
                tail.move('L');
                tail.move('L');
            }
            tail.move('U');
        }
    }

    public static void checkMoveDown(Snake tail, Snake head) {
        if (head.getY() == tail.getY() - 2) {
            if (head.getX() == tail.getX() + 1)
                tail.move('R');
            else if (head.getX() == tail.getX() + 2) {
                tail.move('R');
                tail.move('R');
            }
            else if (head.getX() == tail.getX() - 1)
                tail.move('L');
            else if (head.getX() == tail.getX() - 2) {
                tail.move('L');
                tail.move('L');
            }
            tail.move('D');
        }
    }

    public static void checkMoveLeft(Snake tail, Snake head) {
        if (head.getX() == tail.getX() - 2) {
            if (head.getY() == tail.getY() + 1)
                tail.move('U');
            else if (head.getY() == tail.getY() + 2) {
                tail.move('U');
                tail.move('U');
            }
            else if (head.getY() == tail.getY() - 1)
                tail.move('D');
            else if (head.getY() == tail.getY() - 2) {
                tail.move('D');
                tail.move('D');
            }
            tail.move('L');
        }
    }

    public static void checkMoveRight(Snake tail, Snake head) {
        if (head.getX() == tail.getX() + 2) {
            if (head.getY() == tail.getY() + 1)
                tail.move('U');
            else if (head.getY() == tail.getY() + 2) {
                tail.move('U');
                tail.move('U');
            }
            else if (head.getY() == tail.getY() - 1)
                tail.move('D');
            else if (head.getY() == tail.getY() - 2) {
                tail.move('D');
                tail.move('D');
            }
            tail.move('R');
        }
    }

    public static void move(Snake tail, Snake head) {
        checkMoveUp(tail, head);
        checkMoveDown(tail, head);
        checkMoveLeft(tail, head);
        checkMoveRight(tail, head);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;
        int[][] visitedFields = new int[MAX_SIZE][MAX_SIZE];
        visitedFields[START_X][START_Y] = 1;

        List<Snake> snakes = new ArrayList<>();
        for (int i = 0 ; i < 10; i++) {
            snakes.add(new Snake(START_X, START_Y));
        }

        while ((line = reader.readLine()) != null) {
            char dir = line.charAt(0);
            int spaceIndex = line.indexOf(' ');
            int move = Integer.parseInt(line.substring(spaceIndex + 1));
            for (int i = 0; i < move; i++) {
                snakes.get(0).move(dir); // move head
                for (int j = 1; j < 10; j++) {
                    Snake tail = snakes.get(j);
                    Snake head = snakes.get(j - 1);
                    move(tail, head);
                }
                int tailX = snakes.get(9).getX();
                int tailY = snakes.get(9).getY();
                visitedFields[tailX][tailY] = 1;
            }
        }

        // summing visited fields
        int visited_sum = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (visitedFields[i][j] == 1)
                    visited_sum++;
            }
        }
        System.out.println(visited_sum);
    }
}
