package graphique;

import java.awt.Graphics;

import model.Droite;
import model.Point;
import model.ViewPort;
import util.Dessinateur;

/**
 * La classe abstraite Graphique est une classe de base pour représenter des
 * éléments graphiques
 * dans une application graphique.
 */
public abstract class Graphique {

    private Dessinateur dessinateur;

    /**
     * Méthode abstraite permettant de dessiner l'élément graphique sur le canevas
     * spécifié
     * à l'aide de l'objet Graphics fourni.
     *
     * @param g l'objet Graphics utilisé pour dessiner l'élément graphique sur le
     *          canevas
     */
    public abstract void paint(Graphics g);

    /* public void dessinerRepere(Graphics g, ViewPort viewport, int width, int height) {
        // Dessiner l'axe des abscisses et des graduations
        g.drawLine(0, height / 2, width, height / 2);
        for (int i = -(int) (viewport.largeurMonde / 2); i <= viewport.largeurMonde /
                2; i++) {
            if (i == 0)
                continue; // Ne pas afficher le 0
            int x = viewport.mondeVersEcranX(i) + width / 2;
            g.drawLine(x, height / 2, x, height / 2 - 5);
            g.drawString(Integer.toString(i), x, height / 2 + 20); // Déplacer les numérotations aux côtés opposés
            // des graduations
        }
        // Dessiner l'axe des ordonnées et des graduations
        g.drawLine(width / 2, 0, width / 2, height);
        for (int i = -(int) (viewport.hauteurMonde / 2); i <= viewport.hauteurMonde /
                2; i++) {
            if (i == 0)
                continue; // Ne pas afficher le 0
            int y = height / 2 - viewport.mondeVersEcranY(i);
            g.drawLine(width / 2, y, width / 2 + 5, y);
            g.drawString(Integer.toString(i), width / 2 - 20, i < 0 ? y + 5 : y);
        }
    } */
}
