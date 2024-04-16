package model;
import graphique.*;

/**
 * Classe ViewPort pour gérer la conversion entre les coordonnées du monde réel et les coordonnées de l'écran.
 */
public class ViewPort {

    private int largeur; // Largeur de la fenêtre graphique
    private int hauteur; // Hauteur de la fenêtre graphique
    private double echelle; // Echelle de conversion des coordonnées réelles en coordonnées graphiques

    // Origine du repère graphique (coordonnées du coin supérieur gauche)
    private int origineX;
    private int origineY;

    // Constructeur

    public ViewPort(int largeur, int hauteur, double echelle) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.echelle = echelle;
        // Par défaut, l'origine du repère graphique est située au coin supérieur gauche de la fenêtre
        this.origineX = 0;
        this.origineY = 0;
    }

    // Getters et setters

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public double getEchelle() {
        return echelle;
    }

    public void setOrigineX(int origineX) {
        this.origineX = origineX;
    }

    public void setOrigineY(int origineY) {
        this.origineY = origineY;
    }

    // Méthodes de conversion de coordonnées

    /**
     * Convertit les coordonnées réelles en coordonnées graphiques.
     *
     * @param x Coordonnée x réelle.
     * @param y Coordonnée y réelle.
     * @return Coordonnées graphiques correspondantes.
     */
    public GCoordonnee convertirCoordonnees(double x, double y) {
        // Calcul des coordonnées graphiques en fonction de l'origine et de l'échelle
        int xGraphique = (int) ((x - origineX) * echelle);
        int yGraphique = (int) ((origineY - y) * echelle); // Inversion de l'axe y pour correspondre à la convention graphique
        return new GCoordonnee(xGraphique, yGraphique);
    }

    /**
     * Convertit les coordonnées graphiques en coordonnées réelles.
     *
     * @param x Coordonnée x graphique.
     * @param y Coordonnée y graphique.
     * @return Coordonnées réelles correspondantes.
     */
    public Point convertirCoordonneesInverse(int x, int y) {
        // Calcul des coordonnées réelles en fonction de l'origine et de l'échelle
        double xReel = (x / echelle) + origineX;
        double yReel = origineY - (y / echelle); // Inversion de l'axe y pour correspondre à la convention mathématique
        return new Point(xReel, yReel);
    }
}
