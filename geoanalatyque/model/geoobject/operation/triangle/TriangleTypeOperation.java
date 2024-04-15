package model.geoobject.operation.triangle;

import util.Operation;


import model.Triangle;

public class TriangleTypeOperation implements Operation {

    private final double sideA;
    private final double sideB;
    private final double sideC;

    public TriangleTypeOperation(Triangle triangle) {
        this.sideA = triangle.coteA;
        this.sideB = triangle.coteB;
        this.sideC = triangle.coteC;
    }

    @Override
    public String getTitle() {
        return "Triangle Type Identification";
    }

    @Override
    public int getArite() {
        return 0; // Assuming no fixed number of arguments for triangle type identification
    }

    @Override
    public void setArgument(int num, Object o) {
        // No need to implement this for triangle type identification
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Class getClassArgument(int num) {
        return null; // Not used for triangle type identification
    }

    @Override
    public String getDescriptionArgument(int num) {
        return null; // Not used for triangle type identification
    }

    @Override
    public Object calculer() {
        if (sideA == sideB && sideB == sideC) {
            return "Equilateral Triangle";
        } else if (sideA == sideB || sideB == sideC || sideA == sideC) {
            return "Isosceles Triangle";
        } else {
            // Check for right-angled triangle based on Pythagorean theorem
            if (sideA * sideA + sideB * sideB == sideC * sideC ||
                    sideA * sideA + sideC * sideC == sideB * sideB ||
                    sideB * sideB + sideC * sideC == sideA * sideA) {
                return "Right-Angled Triangle";
            } else {
                return "Scalene Triangle";
            }
        }
    }
}

