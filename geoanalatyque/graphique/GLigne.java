package graphique;

import java.awt.Graphics;

/**
 * La classe GLigne représente une ligne graphique à afficher sur un canevas.
 */
public class GLigne extends Graphique {
    // Coordonnées des points de début et de fin de la ligne
    private int x1, y1, x2, y2;

    /**
     * Constructeur pour créer un objet GLigne avec les coordonnées spécifiées pour les points de début et de fin.
     *
     * @param x1 la coordonnée x du point de début de la ligne
     * @param y1 la coordonnée y du point de début de la ligne
     * @param x2 la coordonnée x du point de fin de la ligne
     * @param y2 la coordonnée y du point de fin de la ligne
     */
    public GLigne(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Méthode pour dessiner la ligne sur le canevas en utilisant l'objet Graphics spécifié.
     *
     * @param g l'objet Graphics utilisé pour dessiner la ligne
     */
    @Override
    public void paint(Graphics g) {
        // Dessiner la ligne en utilisant les coordonnées spécifiées
        g.drawLine(x1, y1, x2, y2);
    }
}
