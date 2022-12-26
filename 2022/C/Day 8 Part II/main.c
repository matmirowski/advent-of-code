#include <stdio.h>

int data[99][99];

int treesVisibleUp(int tree, int x, int y) {
    int treeCounter = 1;
    if (x == 0)
        return treeCounter;
    x--;
    while (x >= 0) {
        if (data[x][y] >= tree)
            return treeCounter;
        x--;
        treeCounter++;
    }
    return treeCounter - 1;
}

int treesVisibleDown(int tree, int x, int y) {
    int treeCounter = 1;
    if (x == 98)
        return treeCounter;
    x++;
    while (x <= 98) {
        if (data[x][y] >= tree)
            return treeCounter;
        x++;
        treeCounter++;
    }
    return treeCounter - 1;
}

int treesVisibleLeft(int tree, int x, int y) {
    int treeCounter = 1;
    if (y == 0)
        return treeCounter;
    y--;
    while (y >= 0) {
        if (data[x][y] >= tree)
            return treeCounter;
        y--;
        treeCounter++;
    }
    return treeCounter - 1;
}

int treesVisibleRight(int tree, int x, int y) {
    int treeCounter = 1;
    if (y == 98)
        return treeCounter;
    y++;
    while (y <= 98) {
        if (data[x][y] >= tree)
            return treeCounter;
        y++;
        treeCounter++;
    }
    return treeCounter - 1;
}

int getTreesScore(int tree, int x, int y) {
    return treesVisibleUp(tree, x, y) * treesVisibleDown(tree, x, y) * treesVisibleLeft(tree, x, y)
           * treesVisibleRight(tree, x, y);
}

int main() {
    char line[101];
    FILE *file = fopen("input.txt", "r");
    if (!file) {
        printf("File not found!");
        return 1;
    }

    // load data to 2d array
    int x = 0;
    int highestScore = 0;
    while (fgets(line, sizeof(line), file)) {
        for (int y = 0; y < 99; y++) {
            data[x][y] = line[y] - '0';
        }
        x++;
    }

    for (int row = 0; row < 99; row++) {
        for (int col = 0; col < 99; col++) {
            int tree = data[row][col];
            int score = getTreesScore(tree, row, col);
            if (getTreesScore(tree, row, col) > highestScore)
                highestScore = score;
        }
    }
    printf("%d", highestScore);
    return 0;
}
