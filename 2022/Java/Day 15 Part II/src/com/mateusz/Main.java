package com.mateusz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final ArrayList<Sensor> sensors = new ArrayList<>();

    private static long getTuningFreq() {
        for (int x = 0; x <= 4_000_000; x++) {
            for (int y = 0; y <= 4_000_000; y++) {
                boolean isOkay = true;
                for (Sensor sensor : sensors) {
                    if ((sensor.getBeaconX() == x && sensor.getBeaconY() == y) || sensor.isFieldBlocked(x, y)) {
                        isOkay = false;
                        break;
                    }
                }
                if (isOkay) {
                    return x * 4_000_000 + y;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] lineArray = line.split(" ");
            int sensorX = Integer.parseInt(lineArray[2].substring(2, lineArray[2].indexOf(",")));
            int sensorY = Integer.parseInt(lineArray[3].substring(2, lineArray[3].indexOf(":")));
            int beaconX = Integer.parseInt(lineArray[8].substring(2, lineArray[8].indexOf(",")));
            int beaconY = Integer.parseInt(lineArray[9].substring(2));
            sensors.add(new Sensor(sensorX, sensorY, beaconX, beaconY));
        }
        System.out.println(getTuningFreq());
    }
}
