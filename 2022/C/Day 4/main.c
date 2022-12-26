#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
 * There was no implementation of java String.indexOf() which I 100% trusted so I made one by myself
 */
int indexOf(char line[], char c) {
    for (int i = 0; i < strlen(line); i++) {
        if (line[i] == c)
            return i;
    }
    return -1;
}

/*
 * My own implementation of String.substring() method
 */
void substring(int start, int end, char* src, char* dest) {
    for (int i = start, destIndex = 0; i < end; i++, destIndex++) {
        *(dest + destIndex) = *(src + i);
        *(dest + destIndex + 1) = '\0';
    }
}

int main() {
    char line[100];
    int fullyOverlappingPairs = 0;
    int partiallyOverlappingPairs = 0;

    FILE *file = fopen("input.txt", "r");
    if (!file) {
        printf("File not found!");
        return 1;
    }

    while (fgets(line, sizeof(line), file)) {
        // parsing data was the toughest task here
        int separatorIndex = indexOf(line, ',');
        char range1[10];
        char range2[10];
        char range1StartChr[10];
        char range1EndChr[10];
        char range2StartChr[10];
        char range2EndChr[10];

        // split both ranges to range1 and range2
        substring(0, separatorIndex, line, range1);
        substring(separatorIndex + 1, strlen(line), line, range2);
        int range1SeparatorIndex = indexOf(range1, '-');
        int range2SeparatorIndex = indexOf(range2, '-');

        // split numbers from range1 and range2 to char arrays
        substring(0, range1SeparatorIndex, range1, range1StartChr);
        substring(range1SeparatorIndex + 1, strlen(range1), range1, range1EndChr);
        substring(0, range2SeparatorIndex, range2, range2StartChr);
        substring(range2SeparatorIndex + 1, strlen(range2), range2, range2EndChr);

        // convert char arrays to integers
        int range1Start = atoi(range1StartChr);
        int range1End = atoi(range1EndChr);
        int range2Start = atoi(range2StartChr);
        int range2End = atoi(range2EndChr);

        // check values
        if ((range1Start >= range2Start && range1End <= range2End) ||
            (range2Start >= range1Start && range2End <= range1End))
            fullyOverlappingPairs++;
        else if ((range1Start >= range2Start && range1Start <= range2End) ||
                 (range1Start <= range2Start && range1End >= range2Start)) {
            partiallyOverlappingPairs++;
        }
    }
    fclose(file);
    printf("%d\n", fullyOverlappingPairs);
    printf("%d", partiallyOverlappingPairs + fullyOverlappingPairs);
    return 0;
}
