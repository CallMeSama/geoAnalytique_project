package util;

import graphique.*;
import model.*;
import model.geoobject.operation.point.CalculerDistancePointOperation;

/**
 * Le Dessinateur est un visiteur qui convertit les objets géométriques en objets graphiques.
 */
public class Dessinateur implements GeoObjectVisitor<Graphique> {

    /**
     * Visite un point et le convertit en coordonnée graphique.
     *
     * @param point Le point à visiter.
     * @return Le graphique correspondant au point.
     */
    @Override
    public Graphique visit(Point point) {
        GCoordonnee gCoordonnee = new GCoordonnee((int) (point.getX()), (int) point.getY());
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
        return new GLigne((int) droite.getPoint1().getX(), (int) droite.getPoint1().getY(),
                (int) droite.getPoint2().getX(), (int) droite.getPoint2().getY());
    }

    /**
     * Visite un segment et le convertit en ligne graphique.
     *
     * @param segment Le segment à visiter.
     * @return La ligne graphique correspondant au segment.
     */
    @Override
    public Graphique visit(Segment segment) {
        return new GLigne((int) segment.getPoint1().getX(), (int) segment.getPoint1().getY(),
                (int) segment.getPoint2().getX(), (int) segment.getPoint2().getY());
    }

    /**
     * Visite un cercle et le convertit en ovale graphique.
     *
     * @param cercle Le cercle à visiter.
     * @return L'ovale graphique correspondant au cercle.
     */
    @Override
    public Graphique visit(Cercle cercle) {
        CalculerDistancePointOperation cdpoCercle = new CalculerDistancePointOperation(cercle.getPetitAxe().getPoint1(), cercle.getPetitAxe().getPoint2());
        return new GOvale((int) cercle.getCentre().getX(), (int) cercle.getCentre().getY(), (int) cdpoCercle.calculer());
    }

    /**
     * Visite une ellipse et la convertit en ovale graphique.
     *
     * @param ellipse L'ellipse à visiter.
     * @return L'ovale graphique correspondant à l'ellipse.
     */
    @Override
    public Graphique visit(Ellipse ellipse) {
        CalculerDistancePointOperation cdpoEllipse1 = new CalculerDistancePointOperation(ellipse.getGrandAxe().getPoint1(), ellipse.getGrandAxe().getPoint2());
        CalculerDistancePointOperation cdpoEllipse2 = new CalculerDistancePointOperation(ellipse.getPetitAxe().getPoint1(), ellipse.getPetitAxe().getPoint2());
        return new GOvale((int) ellipse.getCentre().getX(), (int) ellipse.getCentre().getY(), (int) cdpoEllipse1.calculer(), (int) cdpoEllipse2.calculer());
    }

    /**
     * Visite un carré et le convertit en graphique.
     *
     * @param carre Le carré à visiter.
     * @return Le graphique correspondant au carré.
     */
    @Override
    public Graphique visit(Carre carre) {
        int[] xCoordonnees = {(int) carre.sommet[0].getX(), (int) carre.sommet[1].getX(), (int) carre.sommet[2].getX(), (int) carre.sommet[3].getX()};
        int[] yCoordonnees = {(int) carre.sommet[0].getY(), (int) carre.sommet[1].getY(), (int) carre.sommet[2].getY(), (int) carre.sommet[3].getY()};
        return new GParallelogramme(xCoordonnees, yCoordonnees);
    }

    /**
     * Visite un rectangle et le convertit en graphique.
     *
     * @param rectangle Le rectangle à visiter.
     * @return Le graphique correspondant au rectangle.
     */
    @Override
    public Graphique visit(Rectangle rectangle) {
        int[] xCoordonnees = {(int) rectangle.sommet[0].getX(), (int) rectangle.sommet[1].getX(), (int) rectangle.sommet[2].getX(), (int) rectangle.sommet[3].getX()};
        int[] yCoordonnees = {(int) rectangle.sommet[0].getY(), (int) rectangle.sommet[1].getY(), (int) rectangle.sommet[2].getY(), (int) rectangle.sommet[3].getY()};
        return new GParallelogramme(xCoordonnees, yCoordonnees);
    }

    /**
     * Visite un parallélogramme et le convertit en graphique.
     *
     * @param parallelogramme Le parallélogramme à visiter.
     * @return Le graphique correspondant au parallélogramme.
     */
    @Override
    public Graphique visit(Parallelogramme parallelogramme) {
        int[] xCoordonnees = {(int) parallelogramme.sommet[0].getX(), (int) parallelogramme.sommet[1].getX(), (int) parallelogramme.sommet[2].getX(), (int) parallelogramme.sommet[3].getX()};
        int[] yCoordonnees = {(int) parallelogramme.sommet[0].getY(), (int) parallelogramme.sommet[1].getY(), (int) parallelogramme.sommet[2].getY(), (int) parallelogramme.sommet[3].getY()};
        return new GParallelogramme(xCoordonnees, yCoordonnees);
    }

    /**
     * Visite un triangle rectangle et le convertit en graphique.
     *
     * @param rectTri Le triangle rectangle à visiter.
     * @return Le graphique correspondant au triangle rectangle.
     */
    @Override
    public Graphique visit(TriangleRectangle rectTri) {
        int[] xCoordonnees = {(int) rectTri.sommet[0].getX(), (int) rectTri.sommet[1].getX(), (int) rectTri.sommet[2].getX()};
        int[] yCoordonnees = {(int) rectTri.sommet[0].getY(), (int) rectTri.sommet[1].getY(), (int) rectTri.sommet[2].getY()};
        return new GTriangle(xCoordonnees, yCoordonnees);
    }

    /**
     * Visite un triangle isocèle et le convertit en graphique.
     *
     * @param isoTri Le triangle isocèle à visiter.
     * @return Le graphique correspondant au triangle isocèle.
     */
    @Override
    public Graphique visit(TriangleIsocele isoTri) {
        int[] xCoordonnees = {(int) isoTri.sommet[0].getX(), (int) isoTri.sommet[1].getX(), (int) isoTri.sommet[2].getX()};
        int[] yCoordonnees = {(int) isoTri.sommet[0].getY(), (int) isoTri.sommet[1].getY(), (int) isoTri.sommet[2].getY()};
        return new GTriangle(xCoordonnees, yCoordonnees);
    }

    /**
     * Visite un triangle équilatéral et le convertit en graphique.
     *
     * @param equiTri Le triangle équilatéral à visiter.
     * @return Le graphique correspondant au triangle équilatéral.
     */
    @Override
    public Graphique visit(TriangleEquilateral equiTri) {
        int[] xCoordonnees = {(int) equiTri.sommet[0].getX(), (int) equiTri.sommet[1].getX(), (int) equiTri.sommet[2].getX()};
        int[] yCoordonnees = {(int) equiTri.sommet[0].getY(), (int) equiTri.sommet[1].getY(), (int) equiTri.sommet[2].getY()};
        return new GTriangle(xCoordonnees, yCoordonnees);
    }
}
