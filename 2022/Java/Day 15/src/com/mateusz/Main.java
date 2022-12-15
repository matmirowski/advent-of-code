package com.mateusz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;
        ArrayList<Sensor> sensors = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] lineArray = line.split(" ");
            int sensorX = Integer.parseInt(lineArray[2].substring(2, lineArray[2].indexOf(",")));
            int sensorY = Integer.parseInt(lineArray[3].substring(2, lineArray[3].indexOf(":")));
            int beaconX = Integer.parseInt(lineArray[8].substring(2, lineArray[8].indexOf(",")));
            int beaconY = Integer.parseInt(lineArray[9].substring(2));
            sensors.add(new Sensor(sensorX, sensorY, beaconX, beaconY));
        }

        int blockedFields = 0;
        int constY = 2_000_000;

        for (int x = -5_000_000; x < 5_000_000; x++) {
            for (Sensor sensor : sensors) {
                if (sensor.getBeaconX() == x && sensor.getBeaconY() == constY) {
                    break;
                }
                if (sensor.isFieldBlocked(x, constY)) {
                    blockedFields++;
                    break;
                }
            }
        }
        System.out.println(blockedFields);
    }
}
