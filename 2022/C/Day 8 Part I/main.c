#include <stdio.h>
#include <stdbool.h>

int data[99][99];

bool isTreeVisibleUp(int tree, int x, int y) {
    if (x == 0)
        return true;
    x--;
    while (x >= 0) {
        if (data[x][y] >= tree)
            return false;
        x--;
    }
    return true;
}

bool isTreeVisibleDown(int tree, int x, int y) {
    if (x == 98)
        return true;
    x++;
    while (x <= 98) {
        if (data[x][y] >= tree)
            return false;
        x++;
    }
    return true;
}

bool isTreeVisibleLeft(int tree, int x, int y) {
    if (y == 0)
        return true;
    y--;
    while (y >= 0) {
        if (data[x][y] >= tree)
            return false;
        y--;
    }
    return true;
}

bool isTreeVisibleRight(int tree, int x, int y) {
    if (y == 98)
        return true;
    y++;
    while (y <= 98) {
        if (data[x][y] >= tree)
            return false;
        y++;
    }
    return true;
}

bool isTreeVisible(int tree, int x, int y) {
    if (isTreeVisibleUp(tree, x, y) || isTreeVisibleDown(tree, x, y) || isTreeVisibleLeft(tree, x, y)
        || isTreeVisibleRight(tree, x, y))
        return true;
    return false;
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
    int visibleTrees = 0;
    while (fgets(line, sizeof(line), file)) {
        for (int y = 0; y < 99; y++) {
            data[x][y] = line[y] - '0';
        }
        x++;
    }

    for (int row = 0; row < 99; row++) {
        for (int col = 0; col < 99; col++) {
            int tree = data[row][col];
            if (isTreeVisible(tree, row, col))
                visibleTrees++;
        }
    }
    printf("%d", visibleTrees);
    return 0;
}
