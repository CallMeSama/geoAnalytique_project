package graphique;

import java.awt.Graphics;

/**
 * La classe GOvale représente un ovale ou un cercle graphique à afficher sur un canevas.
 */
public class GOvale extends Graphique {
    // Coordonnées du centre de l'ovale
    private int x, y;
    // Largeur et hauteur de l'ovale
    private int width, height;

    /**
     * Constructeur pour créer un objet GOvale avec les coordonnées et dimensions spécifiées pour un ovale.
     *
     * @param x      la coordonnée x du centre de l'ovale
     * @param y      la coordonnée y du centre de l'ovale
     * @param width  la largeur de l'ovale
     * @param height la hauteur de l'ovale
     */
    public GOvale(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Constructeur pour créer un objet GOvale représentant un cercle avec le même diamètre (même largeur et hauteur).
     *
     * @param x        la coordonnée x du centre du cercle
     * @param y        la coordonnée y du centre du cercle
     * @param diameter le diamètre du cercle
     */
    public GOvale(int x, int y, int diameter) {
        // Appeler le premier constructeur avec le même diamètre pour la largeur et la hauteur
        this(x, y, diameter, diameter);
    }

    /**
     * Méthode pour dessiner l'ovale ou le cercle sur le canevas en utilisant l'objet Graphics spécifié.
     *
     * @param g l'objet Graphics utilisé pour dessiner l'ovale ou le cercle
     */
    @Override
    public void paint(Graphics g) {
        // Dessiner l'ovale ou le cercle en utilisant les coordonnées et dimensions spécifiées
        g.drawOval(x - width / 2, y - height / 2, width, height);
    }
}
