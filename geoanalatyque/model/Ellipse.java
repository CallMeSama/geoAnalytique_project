package model;

import graphique.Graphique;
import util.GeoObjectVisitor;

import java.lang.Math;

/**
 * La classe Ellipse représente une ellipse dans un espace bidimensionnel.
 * Elle étend la classe Surface.
 */
public class Ellipse extends Surface {
    protected Point centre;      // Le centre de l'ellipse
    protected Point foyer1;     // Le premier foyer de l'ellipse
    protected Point foyer2;     // Le deuxième foyer de l'ellipse
    protected Segment grandAxe; // Le grand axe de l'ellipse
    protected Segment petitAxe; // Le petit axe de l'ellipse

    /**
     * Constructeur de la classe Ellipse.
     * @param centre Le centre de l'ellipse.
     * @param foyer1 Le premier foyer de l'ellipse.
     * @param foyer2 Le deuxième foyer de l'ellipse.
     * @param grandAxe Le grand axe(la moitié du grand "diametre") de l'ellipse.
     * @param petitAxe Le petit axe((la moitié du petit "diametre")) de l'ellipse.
     */
    public Ellipse(Point centre, Point foyer1, Point foyer2, Segment grandAxe, Segment petitAxe) {
        this.centre = centre;
        this.foyer1 = foyer1;
        this.foyer2 = foyer2;
        this.grandAxe = grandAxe;
        this.petitAxe = petitAxe;
    }

    /**
     * Calcule et retourne l'aire de l'ellipse.
     * @return L'aire de l'ellipse.
     */
    @Override
    public double calculAire() {
        return Math.PI * this.grandAxe.length() * this.petitAxe.length();
    }

    /**
     * Calcule et retourne le périmètre de l'ellipse.
     * @return Le périmètre de l'ellipse.
     */
    @Override
    public double calculPerimetre() {
        double a = grandAxe.calculerLongueur();
        double b = petitAxe.calculerLongueur();
        double perimetre = 2 * Math.PI * Math.sqrt((a * a + b * b) / 2);
        return perimetre;
    }

    /**
     * Calcule les coordonnées d'un point sur une ellipse en fonction de l'angle θ.
     * @param angleThetaDegré Angle θ en degré.
     * @return Point avec les coordonnées (x, y) du point sur l'ellipse.
     */
    public Point calculerCoordonneesPoint(double angleThetaDegré) {
        //L’angle est l’angle en degrés entre le rayon de l'ellipse et l’axe horizontal.
        
        double angleRadian = Math.toRadians(angleThetaDegré)
        double x = this.centre.x + this.grandAxe.calculerLongueur()  * Math.cos(angleRadian);
        double y = this.centre.y + this.petitAxe.calculerLongueur()  * Math.sin(angleRadian);
        return new Point(x, y);
    }

    /**
     * Accepte un visiteur géométrique pour appliquer une opération sur cet objet.
     * Cette méthode invoque la méthode correspondante du visiteur avec cet objet en tant que paramètre.
     *
     * @param visitor Le visiteur géométrique à accepter.
     */
    public void accept(GeoObjectVisitor<Graphique> visitor) {
        visitor.visit(this);
    }
}
