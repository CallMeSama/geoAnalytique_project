package util;
import graphique.*;
import model.*;

/**
 * Le Dessinateur est un visiteur qui convertit les objets géométriques en objets graphiques.
 */
public class Dessinateur implements GeoObjectVisitor<Graphique>{

    /**
     * Visite un point et le convertit en coordonnée graphique.
     *
     * @param point Le point à visiter.
     * @return Le graphique correspondant au point.
     */
    @Override
    public Graphique visit(Point point) {
        GCoordonnee gCoordonnee = new GCoordonnee((int)(point.getX()), (int)point.getY());
        return gCoordonnee;
    }

    /**
     * Visite une droite et la convertit en ligne graphique.
     *
     * @param droite La droite à visiter.
     * @return La ligne graphique correspondant à la droite.
     */
    @Override
    public Graphique visit(Droite droite) {
        return new GLigne((int)droite.getPoint1().getX(), (int)droite.getPoint1().getY(),
                (int)droite.getPoint2().getX(), (int)droite.getPoint2().getY());
    }

    /**
     * Visite un segment et le convertit en ligne graphique.
     *
     * @param segment Le segment à visiter.
     * @return La ligne graphique correspondant au segment.
     */
    @Override
    public Graphique visit(Segment segment) {
        return new GLigne((int)segment.getPoint1().getX(), (int)segment.getPoint1().getY(),
                (int)segment.getPoint2().getX(), (int)segment.getPoint2().getY());
    }

    /**
     * Visite un cercle et le convertit en ovale graphique.
     *
     * @param cercle Le cercle à visiter.
     * @return L'ovale graphique correspondant au cercle.
     */
    @Override
    public Graphique visit(Cercle cercle) {
        return new GOvale((int)cercle.getCentre().getX(), (int)cercle.getCentre().getY(), (int)cercle.getPetitAxe().calculerLongueur());
    }

    /**
     * Visite une ellipse et la convertit en ovale graphique.
     *
     * @param ellipse L'ellipse à visiter.
     * @return L'ovale graphique correspondant à l'ellipse.
     */
    @Override
    public Graphique visit(Ellipse ellipse) {
        return new GOvale((int)ellipse.getCentre().getX(), (int)ellipse.getCentre().getY(), (int)ellipse.getGrandAxe().calculerLongueur(),(int)ellipse.getPetitAxe().calculerLongueur());
    }
}
