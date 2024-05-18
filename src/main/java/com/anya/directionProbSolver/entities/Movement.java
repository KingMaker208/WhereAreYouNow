package com.anya.directionProbSolver.entities;


public class Movement {
    private int units;
    private String direction;

    public Movement() {}

    public Movement(int units, String direction) {
        this.units = units;
        this.direction = direction;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
