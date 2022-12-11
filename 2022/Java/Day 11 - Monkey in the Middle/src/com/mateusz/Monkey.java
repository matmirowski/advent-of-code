package com.mateusz;

import java.util.ArrayList;
import java.util.List;

public class Monkey {
    private final char opChar;
    private final int opNum;
    private final List<Integer> items;
    private final int divNum;
    private final int monkeyTrue;
    private final int monkeyFalse;
    private int inspectedItems = 0;

    public Monkey(char opChar, int opNum, List<Integer> items, int divNum, int monkeyTrue, int monkeyFalse) {
        this.opChar = opChar;
        this.opNum = opNum;
        this.items = items;
        this.divNum = divNum;
        this.monkeyTrue = monkeyTrue;
        this.monkeyFalse = monkeyFalse;
    }

    int operation(int num) {
        if (opChar == '*') {
            if (opNum == -1)
                return num * num;
            return opNum * num;
        }
        else { // +
            return num + opNum;
        }
    }

    public void inspect() {
        this.inspectedItems++;
    }

    public List<Integer> getItems() {
        return items;
    }

    public int getDivNum() {
        return divNum;
    }

    public int getMonkeyTrue() {
        return monkeyTrue;
    }

    public int getMonkeyFalse() {
        return monkeyFalse;
    }

    public int getInspectedItems() {
        return inspectedItems;
    }
}
