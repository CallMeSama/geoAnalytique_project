package model;

/**
 * Classe ViewPort pour gérer la conversion entre les coordonnées du monde réel et les coordonnées de l'écran.
 */
public class ViewPort {
    public double largeurMonde;
    public double hauteurMonde;
    private int largeurEcran;
    private int hauteurEcran;

    /**
     * Constructeur pour un ViewPort.
     *
     * @param largeurMonde La largeur dans le monde réel.
     * @param hauteurMonde La hauteur dans le monde réel.
     * @param largeurEcran La largeur de l'écran.
     * @param hauteurEcran La hauteur de l'écran.
     */
    public ViewPort(double largeurMonde, double hauteurMonde, int largeurEcran, int hauteurEcran) {
        this.largeurMonde = largeurMonde;
        this.hauteurMonde = hauteurMonde;
        this.largeurEcran = largeurEcran;
        this.hauteurEcran = hauteurEcran;
    }

    /**
     * Convertit les coordonnées du monde réel en coordonnées de pixels sur l'axe X.
     *
     * @param mondeX La coordonnée X dans le monde réel.
     * @return La coordonnée X correspondante sur l'écran.
     */
    public int mondeVersEcranX(double mondeX) {
        return (int) (mondeX / largeurMonde * largeurEcran);
    }

    /**
     * Convertit les coordonnées du monde réel en coordonnées de pixels sur l'axe Y.
     *
     * @param mondeY La coordonnée Y dans le monde réel.
     * @return La coordonnée Y correspondante sur l'écran.
     */
    public int mondeVersEcranY(double mondeY) {
        return (int) (mondeY / hauteurMonde * hauteurEcran);
    }

    /**
     * Convertit les coordonnées de pixels en coordonnées du monde réel sur l'axe X.
     *
     * @param ecranX La coordonnée X sur l'écran.
     * @return La coordonnée X correspondante dans le monde réel.
     */
    public double ecranVersMondeX(int ecranX) {
        return ecranX / (double) largeurEcran * largeurMonde;
    }

    /**
     * Convertit les coordonnées de pixels en coordonnées du monde réel sur l'axe Y.
     *
     * @param ecranY La coordonnée Y sur l'écran.
     * @return La coordonnée Y correspondante dans le monde réel.
     */
    public double ecranVersMondeY(int ecranY) {
        return ecranY / (double) hauteurEcran * hauteurMonde;
    }
}