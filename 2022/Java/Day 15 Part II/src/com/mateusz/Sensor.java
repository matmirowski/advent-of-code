package com.mateusz;

public class Sensor {
    private final int x;
    private final int y;
    private final int beaconX;
    private final int beaconY;
    private final int distanceToBeacon;

    public Sensor(int x, int y, int beaconX, int beaconY) {
        this.x = x;
        this.y = y;
        this.beaconX = beaconX;
        this.beaconY = beaconY;
        this.distanceToBeacon = calculateDistance(x, y, beaconX, beaconY);
    }

    private static int calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public boolean isFieldBlocked(int fieldX, int fieldY) {
        if (calculateDistance(fieldX, fieldY, this.x, this.y) <= distanceToBeacon) {
            return true;
        }
        return false;
    }

    public int getBeaconX() {
        return beaconX;
    }

    public int getBeaconY() {
        return beaconY;
    }
}
