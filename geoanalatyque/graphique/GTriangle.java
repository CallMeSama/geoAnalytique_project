package graphique;
import java.awt.Graphics;
public class GTriangle extends Graphique{
    private int[] xCoordonnees;
    private int[] yCoordonnees;

    public GTriangle(int[] xCoordonnees, int[] yCoordonnees ){
        this.xCoordonnees = xCoordonnees;
        this.yCoordonnees = yCoordonnees;
    }

    @Override
    public void paint(Graphics g) {
        g.drawPolygon(xCoordonnees, yCoordonnees, 3 );
    }
}
