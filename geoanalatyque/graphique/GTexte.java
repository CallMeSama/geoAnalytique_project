package graphique;

import java.awt.*;

/**
 * La classe GTexte représente un texte à afficher sur un canevas.
 */
public class GTexte extends Graphique {
    // Texte à afficher
    private String texte;
    // Coordonnées du point de départ du texte
    private int x, y;
    // Police du texte
    private Font police;

    /**
     * Constructeur pour créer un objet GTexte avec le texte spécifié, les coordonnées de départ et la police.
     *
     * @param texte  le texte à afficher
     * @param x      la coordonnée x du point de départ du texte
     * @param y      la coordonnée y du point de départ du texte
     * @param police la police du texte
     */
    public GTexte(String texte, int x, int y, Font police) {
        this.texte = texte;
        this.x = x;
        this.y = y;
        this.police = police;
    }

    /**
     * Méthode pour dessiner le texte sur le canevas en utilisant l'objet Graphics spécifié.
     *
     * @param g l'objet Graphics utilisé pour dessiner le texte
     */
    @Override
    public void paint(Graphics g) {
        // Sauvegarder la police actuelle pour la restaurer plus tard
        Font policeActuelle = g.getFont();
        // Appliquer la police spécifiée
        g.setFont(police);
        // Dessiner le texte sur le canevas
        g.drawString(texte, x, y);
        // Remettre la police qu'on avait avant le changement
        g.setFont(policeActuelle);
    }
}
