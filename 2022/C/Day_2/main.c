#include <stdio.h>

int main() {
    char line[10];
    int pointsPart1 = 0;
    int pointsPart2 = 0;
    FILE *file = fopen("input.txt", "r");

    if (!file) {
        printf("File not found!");
        return 1;
    }

    while (fgets(line, sizeof(line), file)) {
        // part 1
        
        char enemyPick = line[0];
        char myPick = line[2];

        switch (myPick) {

        }
    }
    fclose(file);
    return 0;
}
