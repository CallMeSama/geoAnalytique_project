package util;

import graphique.*;
import model.*;
import model.geoobject.operation.point.CalculerDistancePointOperation;
import exception.*;

/**
 * Le Dessinateur est un visiteur qui convertit les objets géométriques en objets graphiques.
 */
public class Dessinateur implements GeoObjectVisitor<Graphique, VisiteurException> {

    /**
     * Visite un point géométrique.
     *
     * @param point Le point à visiter.
     * @return Le résultat de la visite.
     * @throws VisiteurException Si une erreur apparait pendant la visite.
     */
    @Override
    public Graphique visit(Point point) throws VisiteurException {
        if (point == null) {
            throw new VisiteurException("Attention vous visitez un point null!");
        }
        // Convert the Point object to a Graphique object
        GCoordonnee gCoordonnee = new GCoordonnee((int) (point.getX()), (int) point.getY());
        return gCoordonnee;
    }

    /**
     * Visite une droite et la convertit en ligne graphique.
     *
     * @param droite La droite à visiter.
     * @return La ligne graphique correspondant à la droite.
     * @throws VisiteurException Si une erreur apparait pendant la visite.
     */
    @Override
    public Graphique visit(Droite droite) throws VisiteurException {
        if (droite == null) {
            throw new VisiteurException("Attention vous visitez une droite null!");
        }
        // Convert the Droite object to a Graphique object
        return new GLigne((int) droite.getPoint1().getX(), (int) droite.getPoint1().getY(),
                (int) droite.getPoint2().getX(), (int) droite.getPoint2().getY());
    }

    @Override
    public Graphique visit(Segment segment) throws VisiteurException {
        if (segment == null) {
            throw new VisiteurException("Attention vous ne pouvez visiter un Segment null");
        }
        // Convert the Segment object to a Graphique object
        return new GLigne((int) segment.getPoint1().getX(), (int) segment.getPoint1().getY(),
                (int) segment.getPoint2().getX(), (int) segment.getPoint2().getY());
    }

    /**
     * Visite un cercle et le convertit en ovale graphique.
     *
     * @param cercle Le cercle à visiter.
     * @return L'ovale graphique correspondant au cercle.
     * @throws VisiteurException Si le rectangle est null.
     */
    @Override
    public Graphique visit(Cercle cercle) throws VisiteurException {
        if (cercle == null) {
            throw new VisiteurException("Attention vous ne pouvez visiter un Cercle null");
        }
        // Convert the Cercle object to a Graphique object
        CalculerDistancePointOperation cdpoCercle = new CalculerDistancePointOperation(cercle.getPetitAxe().getPoint1(), cercle.getPetitAxe().getPoint2());
        return new GOvale((int) cercle.getCentre().getX(), (int) cercle.getCentre().getY(), (int) cdpoCercle.calculer());
    }

    /**
     * Visite une ellipse et la convertit en ovale graphique.
     *
     * @param ellipse L'ellipse à visiter.
     * @return L'ovale graphique correspondant à l'ellipse.
     * @throws VisiteurException Si le rectangle est null.
     */
    @Override
    public Graphique visit(Ellipse ellipse) throws VisiteurException {
        if (ellipse == null) {
            throw new VisiteurException("Attention vous ne pouvez visiter une Ellipse null");
        }
        CalculerDistancePointOperation cdpoEllipse1 = new CalculerDistancePointOperation(ellipse.getGrandAxe().getPoint1(), ellipse.getGrandAxe().getPoint2());
        CalculerDistancePointOperation cdpoEllipse2 = new CalculerDistancePointOperation(ellipse.getPetitAxe().getPoint1(), ellipse.getPetitAxe().getPoint2());
        return new GOvale((int) ellipse.getCentre().getX(), (int) ellipse.getCentre().getY(), (int) cdpoEllipse1.calculer(), (int) cdpoEllipse2.calculer());
    }

    /**
     * Visite un carré et le convertit en graphique.
     *
     * @param carre Le carré à visiter.
     * @return Le graphique correspondant au carré.
     * @throws VisiteurException Si le rectangle est null.
     */
    @Override
    public Graphique visit(Carre carre) throws VisiteurException {
        if (carre == null) {
            throw new VisiteurException("Attention vous ne pouvez visiter une carre null");
        }
        int[] xCoordonnees = {(int) carre.sommet[0].getX(), (int) carre.sommet[1].getX(), (int) carre.sommet[2].getX(), (int) carre.sommet[3].getX()};
        int[] yCoordonnees = {(int) carre.sommet[0].getY(), (int) carre.sommet[1].getY(), (int) carre.sommet[2].getY(), (int) carre.sommet[3].getY()};
        return new GParallelogramme(xCoordonnees, yCoordonnees);
    }

    /**
     * Visite un rectangle et le convertit en graphique.
     *
     * @param rectangle Le rectangle à visiter.
     * @return Le graphique correspondant au rectangle.
     * @throws VisiteurException Si le rectangle est null.
     */
    @Override
    public Graphique visit(Rectangle rectangle) throws VisiteurException {
        if (rectangle == null) {
            throw new VisiteurException("Attention, vous ne pouvez visiter un rectangle null");
        }
        int[] xCoordonnees = {(int) rectangle.sommet[0].getX(), (int) rectangle.sommet[1].getX(), (int) rectangle.sommet[2].getX(), (int) rectangle.sommet[3].getX()};
        int[] yCoordonnees = {(int) rectangle.sommet[0].getY(), (int) rectangle.sommet[1].getY(), (int) rectangle.sommet[2].getY(), (int) rectangle.sommet[3].getY()};
        return new GParallelogramme(xCoordonnees, yCoordonnees);
    }

    /**
     * Visite un parallélogramme et le convertit en graphique.
     *
     * @param parallelogramme Le parallélogramme à visiter.
     * @return Le graphique correspondant au parallélogramme.
     * @throws VisiteurException Si le parallélogramme est null.
     */
    @Override
    public Graphique visit(Parallelogramme parallelogramme) throws VisiteurException {
        if (parallelogramme == null) {
            throw new VisiteurException("Attention, vous ne pouvez visiter un parallélogramme null");
        }
        int[] xCoordonnees = {(int) parallelogramme.sommet[0].getX(), (int) parallelogramme.sommet[1].getX(), (int) parallelogramme.sommet[2].getX(), (int) parallelogramme.sommet[3].getX()};
        int[] yCoordonnees = {(int) parallelogramme.sommet[0].getY(), (int) parallelogramme.sommet[1].getY(), (int) parallelogramme.sommet[2].getY(), (int) parallelogramme.sommet[3].getY()};
        return new GParallelogramme(xCoordonnees, yCoordonnees);
    }

    /**
     * Visite un triangle rectangle et le convertit en graphique.
     *
     * @param rectTri Le triangle rectangle à visiter.
     * @return Le graphique correspondant au triangle rectangle.
     * @throws VisiteurException Si le triangle rectangle est null.
     */
    @Override
    public Graphique visit(TriangleRectangle rectTri) throws VisiteurException {
        if (rectTri == null) {
            throw new VisiteurException("Attention, vous ne pouvez visiter un triangle rectangle null");
        }
        int[] xCoordonnees = {(int) rectTri.sommet[0].getX(), (int) rectTri.sommet[1].getX(), (int) rectTri.sommet[2].getX()};
        int[] yCoordonnees = {(int) rectTri.sommet[0].getY(), (int) rectTri.sommet[1].getY(), (int) rectTri.sommet[2].getY()};
        return new GTriangle(xCoordonnees, yCoordonnees);
    }

    /**
     * Visite un triangle isocèle et le convertit en graphique.
     *
     * @param isoTri Le triangle isocèle à visiter.
     * @return Le graphique correspondant au triangle isocèle.
     * @throws VisiteurException Si le triangle isocèle est null.
     */
    @Override
    public Graphique visit(TriangleIsocele isoTri) throws VisiteurException {
        if (isoTri == null) {
            throw new VisiteurException("Attention, vous ne pouvez visiter un triangle isocèle null");
        }
        int[] xCoordonnees = {(int) isoTri.sommet[0].getX(), (int) isoTri.sommet[1].getX(), (int) isoTri.sommet[2].getX()};
        int[] yCoordonnees = {(int) isoTri.sommet[0].getY(), (int) isoTri.sommet[1].getY(), (int) isoTri.sommet[2].getY()};
        return new GTriangle(xCoordonnees, yCoordonnees);
    }

    /**
     * Visite un triangle équilatéral et le convertit en graphique.
     *
     * @param equiTri Le triangle équilatéral à visiter.
     * @return Le graphique correspondant au triangle équilatéral.
     * @throws VisiteurException Si le triangle équilatéral est null.
     */
    @Override
    public Graphique visit(TriangleEquilateral equiTri) throws VisiteurException {
        if (equiTri == null) {
            throw new VisiteurException("Attention, vous ne pouvez visiter un triangle équilatéral null");
        }
        int[] xCoordonnees = {(int) equiTri.sommet[0].getX(), (int) equiTri.sommet[1].getX(), (int) equiTri.sommet[2].getX()};
        int[] yCoordonnees = {(int) equiTri.sommet[0].getY(), (int) equiTri.sommet[1].getY(), (int) equiTri.sommet[2].getY()};
        return new GTriangle(xCoordonnees, yCoordonnees);
    }
    /**
     * Visite un objet géométrique et le convertit en graphique.
     *
     * @param geoObj L'objet géométrique à visiter.
     * @return Le graphique correspondant à l'objet géométrique.
     * @throws VisiteurException Si l'objet géométrique est null.
     * @throws IncorrectTypeOperationException Si l'objet géométrique n'est pas un type attendu.
     */

    public Graphique visit(GeoObject geoObj) throws VisiteurException, IncorrectTypeOperationException {
        if (geoObj == null) {
            throw new VisiteurException("Attention, vous ne pouvez visiter un objet géométrique null");
        }
        if (geoObj instanceof Point) {
            return visit((Point) geoObj);
        } else if (geoObj instanceof Droite) {
            return visit((Droite) geoObj);
        } else if (geoObj instanceof Segment) {
            return visit((Segment) geoObj);
        } else if (geoObj instanceof Cercle) {
            return visit((Cercle) geoObj);
        } else if (geoObj instanceof Ellipse) {
            return visit((Ellipse) geoObj);
        } else if (geoObj instanceof Carre) {
            return visit((Carre) geoObj);
        } else if (geoObj instanceof Rectangle) {
            return visit((Rectangle) geoObj);
        } else if (geoObj instanceof Parallelogramme) {
            return visit((Parallelogramme) geoObj);
        } else if (geoObj instanceof TriangleRectangle) {
            return visit((TriangleRectangle) geoObj);
        } else if (geoObj instanceof TriangleIsocele) {
            return visit((TriangleIsocele) geoObj);
        } else if (geoObj instanceof TriangleEquilateral) {
            return visit((TriangleEquilateral) geoObj);
        } else {
            throw new IncorrectTypeOperationException("Type d'objet géométrique non attendu: " );
        }
    }
}