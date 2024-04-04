package org.example;

public class City {
    int id;
    int x;
    int y;

    public City(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public double distanceTo(City city) {
        int xDistance = Math.abs(this.x - city.x);
        int yDistance = Math.abs(this.y - city.y);
        return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
    }
}
