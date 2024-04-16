package model.geoobject.operation.triangle;
import util.Operation;
import model.TriangleEquilateral;
import model.TriangleIsocele;
import model.TriangleRectangle;

public class AreaOperation implements Operation {

    private final TriangleEquilateral triangleEquilateral;
    private final TriangleIsocele triangleIsocele;
    private final TriangleRectangle triangleRectangle;

    public AreaOperation(TriangleEquilateral triangle) {
        this.triangleEquilateral = triangle;
        this.triangleIsocele = null;
        this.triangleRectangle = null;
    }

    public AreaOperation(TriangleIsocele triangle) {
        this.triangleEquilateral = null;
        this.triangleIsocele = triangle;
        this.triangleRectangle = null;
    }

    public AreaOperation(TriangleRectangle triangle) {
        this.triangleEquilateral = null;
        this.triangleIsocele = null;
        this.triangleRectangle = triangle;
    }

    @Override
    public String getTitle() {
        return "Area Calculation";
    }

    @Override
    public int getArite() {
        return 0; // Assuming no fixed number of arguments for area calculation
    }

    @Override
    public void setArgument(int num, Object o) {
        // No need to implement this for area calculation
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Class getClassArgument(int num) {
        return null; // Not used for area calculation
    }

    @Override
    public String getDescriptionArgument(int num) {
        return null; // Not used for area calculation
    }

    @Override
    public Object calculer() {
        /** if (triangleEquilateral != null) {
            // Calculate area of equilateral triangle
            return (Math.sqrt(3) / 4) * Math.pow(triangleEquilateral.coteA, 2);
        } else if (triangleIsocele != null) {
            // Calculate area of isosceles triangle using Heron's formula
            double s = (triangleIsocele.coteA + triangleIsocele.coteB + triangleIsocele.coteC) / 2.0;
            return Math.sqrt(s * (s - triangleIsocele.coteA) * (s - triangleIsocele.coteB) * (s - triangleIsocele.coteC));
        } else if (triangleRectangle != null) {
            // Calculate area of right-angled triangle
            return (triangleRectangle.coteA * triangleRectangle.coteB) / 2.0;
        }**/
        return null; // Default value if none of the conditions are met
    }
}

