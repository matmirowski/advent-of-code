#include <stdio.h>

int main() {
    char line[5];
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
                if (enemyPick == 'A') {
                    pointsPart2 += 4; // 3 + 1
                }
                else if (enemyPick == 'B') {
                    pointsPart2 += 5; // 3 + 2
                }
                else if (enemyPick == 'C'){ // C
                    pointsPart2 += 6; // 3 + 3
                }
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
    fclose(file);

    printf("%d\n", pointsPart1);
    printf("%d", pointsPart2);
    return 0;
}
