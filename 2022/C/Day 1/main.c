#include <stdio.h>
#include <stdlib.h>

int main()
{
    int calories[2300] = {0};
    int currentCalories = 0;
    int calorieCount = 0;
    char line[10];
    FILE *file = fopen("input.txt", "r");

    if (!file) {
        printf("File not found!");
        return 1;
    }

    while (fgets(line, sizeof(line), file)) {
        if (line[0] == '\n') {
            calories[calorieCount++] = currentCalories;
            currentCalories = 0;
        }
        else {
            currentCalories += atoi(line);
        }
    }
    fclose(file);

    // bubble sort - reversed
    for (int i = 0; i < calorieCount - 1; i++) {
        for (int j = i + 1; j < calorieCount; j++) {
            if (calories[i] < calories[j]) {
                int temp = calories[i];
                calories[i] = calories[j];
                calories[j] = temp;
            }
        }
    }

    int topThreeCalories = calories[0] + calories[1] + calories[2];

    printf("%d\n", calories[0]);
    printf("%d\n", topThreeCalories);

    return 0;
}