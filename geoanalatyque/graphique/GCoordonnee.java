package graphique;

import java.awt.Graphics;

/**
 * La classe GCoordonnee représente un point graphique à afficher sur un
 * canevas.
 */
public class GCoordonnee extends Graphique {
    // Coordonnées du point
    private int x;
    private int y;

    /**
     * Constructeur pour créer un objet GCoordonnee avec les coordonnées spécifiées.
     *
     * @param x la coordonnée x du point
     * @param y la coordonnée y du point
     */
    public GCoordonnee(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return x;
    }

    /**
     * Méthode pour dessiner le point sur le canevas en utilisant l'objet Graphics
     * spécifié.
     *
     * @param g l'objet Graphics utilisé pour dessiner le point
     */
    @Override
    public void paint(Graphics g) {
        // Dessiner un point en utilisant une ligne de longueur nulle
        g.drawLine(x, y, x, y);
    }
}
