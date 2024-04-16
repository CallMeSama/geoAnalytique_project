package model.geoobject.operation.triangle;

import util.Operation;

import model.TriangleEquilateral;
import model.TriangleIsocele;
import model.TriangleRectangle;

public class PerimeterOperation implements Operation {

    private final TriangleEquilateral triangleEquilateral;
    private final TriangleIsocele triangleIsocele;
    private final TriangleRectangle triangleRectangle;

    public PerimeterOperation(TriangleEquilateral triangle) {
        this.triangleEquilateral = triangle;
        this.triangleIsocele = null;
        this.triangleRectangle = null;
    }

    public PerimeterOperation(TriangleIsocele triangle) {
        this.triangleEquilateral = null;
        this.triangleIsocele = triangle;
        this.triangleRectangle = null;
    }

    public PerimeterOperation(TriangleRectangle triangle) {
        this.triangleEquilateral = null;
        this.triangleIsocele = null;
        this.triangleRectangle = triangle;
    }

    @Override
    public Object calculer() {
        /*if (triangleEquilateral != null) {
            // Calculate perimeter of equilateral triangle
            return 3 * triangleEquilateral.coteA;
        } else if (triangleIsocele != null) {
            // Calculate perimeter of isosceles triangle
            return triangleIsocele.coteA + triangleIsocele.coteB + triangleIsocele.coteC;
        } else if (triangleRectangle != null) {
            // Calculate perimeter of right-angled triangle
            return triangleRectangle.coteA + triangleRectangle.coteB + triangleRectangle.coteC;
        }*/
        return null; // Default value if none of the conditions are met
    }


    @Override
    public String getTitle() {
        return "Perimeter Calculation";
    }

    @Override
    public int getArite() {
        return 0;
    }

    @Override
    public void setArgument(int num, Object o) {

    }
    @Override
    public Class getClassArgument(int num) {
        return null;
    }

    @Override
    public String getDescriptionArgument(int num) {
        return null;
    }
}
