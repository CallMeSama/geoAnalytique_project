package model.geoobject.operation.triangle;

import util.Operation;

import model.TriangleRectangle;

public class RightAngledOperation implements Operation {

    private final TriangleRectangle triangleRectangle;

    public RightAngledOperation(TriangleRectangle triangle) {
        this.triangleRectangle = triangle;
    }

    @Override
    public String getTitle() {
        return "Right-Angled Check";
    }

    @Override
    public int getArite() {
        return 0; // Assuming no fixed number of arguments for right-angled check
    }

    @Override
    public void setArgument(int num, Object o) {
        // No need to implement this for right-angled check
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Class getClassArgument(int num) {
        return null; // Not used for right-angled check
    }

    @Override
    public String getDescriptionArgument(int num) {
        return null; // Not used for right-angled check
    }

    @Override
    public Object calculer() {
        /* if (triangleRectangle != null) {
            // Check if the triangle is right-angled (Pythagorean theorem)
            return triangleRectangle.coteA * triangleRectangle.coteA + triangleRectangle.coteB * triangleRectangle.coteB ==
                    triangleRectangle.coteC * triangleRectangle.coteC;
        }*/
        return false; // Default value if not a right-angled triangle or type not supported
    }
}

