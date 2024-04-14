package graphique;
import java.awt.Graphics;
public class GParallelogramme extends Graphique {
    private int[] xCoordonnees;
    private int[] yCoordonnees;

    public GParallelogramme(int[] xCoordonnees, int[] yCoordonnees ){
        this.xCoordonnees = xCoordonnees;
        this.yCoordonnees = yCoordonnees;
    }

    @Override
    public void paint(Graphics g) {
        g.drawPolygon(xCoordonnees, yCoordonnees, 4 );
    }

}
