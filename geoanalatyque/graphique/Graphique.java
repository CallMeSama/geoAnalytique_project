package graphique;

import java.awt.Graphics;

/**
 * La classe abstraite Graphique est une classe de base pour représenter des éléments graphiques
 * dans une application graphique.
 */
public abstract class Graphique {

    /**
     * Méthode abstraite permettant de dessiner l'élément graphique sur le canevas spécifié
     * à l'aide de l'objet Graphics fourni.
     *
     * @param g l'objet Graphics utilisé pour dessiner l'élément graphique sur le canevas
     */
    public abstract void paint(Graphics g);
}
