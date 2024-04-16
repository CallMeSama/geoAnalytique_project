package graphique;
import java.awt.Graphics;
public class GParallelogramme extends Graphique {
    private int[] xCoordonnees;
    private int[] yCoordonnees;

    public GParallelogramme(GCoordonnee[] xCoordonnees, GCoordonnee[] yCoordonnees) {
        this.xCoordonnees = new int[xCoordonnees.length];
        this.yCoordonnees = new int[yCoordonnees.length];
        for (int i = 0; i < xCoordonnees.length; i++) {
            this.xCoordonnees[i] = (int) xCoordonnees[i].getX();
            this.yCoordonnees[i] = (int) yCoordonnees[i].getY();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawPolygon(xCoordonnees, yCoordonnees, 4 );
    }

}
