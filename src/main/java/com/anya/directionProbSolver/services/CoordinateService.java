package com.anya.directionProbSolver.services;

import org.springframework.stereotype.Service;

import com.anya.directionProbSolver.entities.Movement;

import java.util.List;

@Service
public class CoordinateService {

    public double calculateDistance(List<Movement> movements) {
        int x = 0, y = 0;
        for (Movement movement : movements) {
            switch (movement.getDirection().toLowerCase()) {
                case "east":
                    x += movement.getUnits();
                    break;
                case "west":
                    x -= movement.getUnits();
                    break;
                case "north":
                    y += movement.getUnits();
                    break;
                case "south":
                    y -= movement.getUnits();
                    break;
            }
        }
        return Math.sqrt(x * x + y * y);
    }

    public String calculateDirection(List<Movement> movements) {
        int x = 0, y = 0;
        for (Movement movement : movements) {
            switch (movement.getDirection().toLowerCase()) {
                case "east":
                    x += movement.getUnits();
                    break;
                case "west":
                    x -= movement.getUnits();
                    break;
                case "north":
                    y += movement.getUnits();
                    break;
                case "south":
                    y -= movement.getUnits();
                    break;
            }
        }

        double angle = Math.toDegrees(Math.atan2(y, x));
        if (angle < 0) {
            angle += 360;
        }

        if (angle == 0) return "East";
        else if (angle == 90) return "North";
        else if (angle == 180) return "West";
        else if (angle == 270) return "South";
        else if (angle > 0 && angle < 90) return "Northeast";
        else if (angle > 90 && angle < 180) return "Northwest";
        else if (angle > 180 && angle < 270) return "Southwest";
        else return "Southeast";
    }
}