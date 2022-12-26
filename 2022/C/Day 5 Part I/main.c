#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char stacks[9][1000];
    strcpy(stacks[0], "FDBZTJRN");
    strcpy(stacks[1], "RSNJH");
    strcpy(stacks[2], "CRNJGZFQ");
    strcpy(stacks[3], "FVNGRTQ");
    strcpy(stacks[4], "LTQF");
    strcpy(stacks[5], "QCWZBRGN");
    strcpy(stacks[6], "FCLSNHM");
    strcpy(stacks[7], "DNQMTJ");
    strcpy(stacks[8], "PGS");

    char line[100];
    FILE *file = fopen("input.txt", "r");
    if (!file) {
        printf("File not found!");
        return 1;
    }

    while (fgets(line, sizeof(line), file)) {
        int move;
        int moveFrom;
        int moveTo;

        // parse data
        const char delimiter[2] = " ";
        char* splitLine; // pointer for word (split by ' ')
        splitLine = strtok(line, delimiter);
        for (int i = 0; splitLine != NULL; i++) {
            switch (i) {
                case 1:
                    move = atoi(splitLine);
                    break;
                case 3:
                    moveFrom = atoi(splitLine);
                    break;
                case 5:
                    moveTo = atoi(splitLine);
                    break;
            }
            // strtok uses static, so we pass null
            splitLine = strtok(NULL, delimiter);
        }

        // move block
        char* moveFromArray = stacks[moveFrom-1];
        char* moveToArray = stacks[moveTo - 1];
        for (int i = 1; i <= move; i++) {
            char block = moveFromArray[strlen(moveFromArray) - 1];
            moveFromArray[strlen(moveFromArray) - 1] = '\0';
            int moveToLen = strlen(moveToArray);
            moveToArray[moveToLen] = block;
            moveToArray[moveToLen + 1] = '\0';
        }
    }

    // print result
    for (int i = 0; i < 9; i++) {
        char* array = stacks[i];
        printf("%c", array[strlen(array) - 1]);
    }
    return 0;
}
