package util;

import graphique.*;
import model.*;
import model.geoobject.operation.point.CalculerDistancePointOperation;
import exception.*;

/**
 * Le Dessinateur est un visiteur qui convertit les objets géométriques en objets graphiques.
 */
public class Dessinateur implements GeoObjectVisitor<Graphique, VisiteurException> {

    public final ViewPort viewport; // Ajout du viewport comme attribut

    /**
     * Constructeur prenant un viewport en paramètre.
     *
     * @param viewport Le viewport à utiliser pour la conversion des coordonnées.
     */
    public Dessinateur(ViewPort viewport) {
        this.viewport = viewport;
    }

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
        GCoordonnee gCoordonnee = viewport.convertirCoordonnees(point.getX(), point.getY()); // Utilisation du viewport pour la conversion
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
        GCoordonnee gCoordonnee1 = viewport.convertirCoordonnees((int)droite.getPoint1().getX(), (int) droite.getPoint1().getY()); // Utilisation du viewport pour la conversion
        GCoordonnee gCoordonnee2= viewport.convertirCoordonnees((int)droite.getPoint2().getX(), (int) droite.getPoint2().getY()); // Utilisation du viewport pour la conversion

        // Convert the Droite object to a Graphique object
        return new GLigne(gCoordonnee1, gCoordonnee2);
    }

    @Override
    public Graphique visit(Segment segment) throws VisiteurException {
        if (segment == null) {
            throw new VisiteurException("Attention vous ne pouvez visiter un Segment null");
        }

        GCoordonnee gCoordonnee1 = viewport.convertirCoordonnees((int)segment.getPoint1().getX(), (int) segment.getPoint1().getY()); // Utilisation du viewport pour la conversion
        GCoordonnee gCoordonnee2= viewport.convertirCoordonnees((int)segment.getPoint2().getX(), (int) segment.getPoint2().getY()); // Utilisation du viewport pour la conversion

        return new GLigne(gCoordonnee1, gCoordonnee2);
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
        //Il s'agit des coordonnées du centre du cercle dans l'interface graphique
        GCoordonnee gCoordonnee1 = viewport.convertirCoordonnees((int)cercle.getCentre().getX(), (int) cercle.getCentre().getY());

        //Convertion des coordonnées réelles du diametre vers les coordonnées de l'interface
        GCoordonnee gCoordonneeDiametre1 = viewport.convertirCoordonnees((int)cercle.getPetitAxe().getPoint1().getX(), (int) cercle.getPetitAxe().getPoint1().getY());
        GCoordonnee gCoordonneeDiametre2 = viewport.convertirCoordonnees((int)cercle.getPetitAxe().getPoint2().getX(), (int) cercle.getPetitAxe().getPoint2().getY());

        //Créer des objets Points à passer en parametres à GOvale à partir des attributs de GCoordonnes
        Point pointDiametre1 = new Point(gCoordonneeDiametre1.getX(), gCoordonneeDiametre1.getY());
        Point pointDiametre2 = new Point(gCoordonneeDiametre2.getX(), gCoordonneeDiametre2.getY());

        // Convert the Cercle object to a Graphique object
        CalculerDistancePointOperation cdpoCercle = new CalculerDistancePointOperation(pointDiametre1, pointDiametre2);
        return new GOvale( gCoordonnee1.getX(),  gCoordonnee1.getY(), (int) cdpoCercle.calculer());
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
        GCoordonnee gCoordonnee1 = viewport.convertirCoordonnees((int)ellipse.getCentre().getX(), (int) ellipse.getCentre().getY());

        //Convertion des coordonnées réelles du Petit Axe vers les coordonnées de l'interface
        GCoordonnee gCoordonneePetitAxe1 = viewport.convertirCoordonnees((int)ellipse.getPetitAxe().getPoint1().getX(), (int) ellipse.getPetitAxe().getPoint1().getY());
        GCoordonnee gCoordonneePetitAxe2 = viewport.convertirCoordonnees((int)ellipse.getPetitAxe().getPoint2().getX(), (int) ellipse.getPetitAxe().getPoint2().getY());

        //Créer des objets Points à passer en parametres à GOvale à partir des attributs de GCoordonnes
        Point pointPetitAxe1 = new Point(gCoordonneePetitAxe1.getX(), gCoordonneePetitAxe1.getY());
        Point pointPetitAxe2 = new Point(gCoordonneePetitAxe2.getX(), gCoordonneePetitAxe2.getY());

        //Convertion des coordonnées réelles du grandAxe vers les coordonnées de l'interface
        GCoordonnee gCoordonneeGrandAxe1 = viewport.convertirCoordonnees((int)ellipse.getGrandAxe().getPoint1().getX(), (int) ellipse.getPetitAxe().getPoint1().getY());
        GCoordonnee gCoordonneeGrandAxe2 = viewport.convertirCoordonnees((int)ellipse.getGrandAxe().getPoint2().getX(), (int) ellipse.getPetitAxe().getPoint2().getY());

        //Créer des objets Points à passer en parametres à GOvale à partir des attributs de GCoordonnes
        Point pointGrandAxe1 = new Point(gCoordonneeGrandAxe1.getX(), gCoordonneeGrandAxe1.getY());
        Point pointGrandAxe2 = new Point(gCoordonneeGrandAxe2.getX(), gCoordonneeGrandAxe2.getY());

        //calcul des distances du petit et grand Axe
        CalculerDistancePointOperation cdpoEllipse1 = new CalculerDistancePointOperation(pointPetitAxe1,pointPetitAxe2);
        CalculerDistancePointOperation cdpoEllipse2 = new CalculerDistancePointOperation(pointGrandAxe1, pointGrandAxe2);
        return new GOvale((int) gCoordonnee1.getX(), (int) gCoordonnee1.getY(), (int) cdpoEllipse1.calculer(), (int)cdpoEllipse2.calculer() );
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
        int[] xCoordonnees = {(int) carre.sommets[0].getX(), (int) carre.sommets[1].getX(), (int) carre.sommets[2].getX(), (int) carre.sommets[3].getX()};
        int[] yCoordonnees = {(int) carre.sommets[0].getY(), (int) carre.sommets[1].getY(), (int) carre.sommets[2].getY(), (int) carre.sommets[3].getY()};
        GCoordonnee[] gxCoordonnees = new GCoordonnee[4];
        GCoordonnee[] gyCoordonnees = new GCoordonnee[4];
        for (int i = 0; i < 4; i++) {
            gxCoordonnees[i] = viewport.convertirCoordonnees(xCoordonnees[i], yCoordonnees[i]);
            gyCoordonnees[i] = viewport.convertirCoordonnees(xCoordonnees[i], yCoordonnees[i]);
        }
        return new GParallelogramme(gxCoordonnees, gyCoordonnees);
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
        GCoordonnee[] xCoordonnees = {
                viewport.convertirCoordonnees((int) rectangle.sommets[0].getX(), (int) rectangle.sommets[0].getY()),
                viewport.convertirCoordonnees((int) rectangle.sommets[1].getX(), (int) rectangle.sommets[1].getY()),
                viewport.convertirCoordonnees((int) rectangle.sommets[2].getX(), (int) rectangle.sommets[2].getY()),
                viewport.convertirCoordonnees((int) rectangle.sommets[3].getX(), (int) rectangle.sommets[3].getY())
        };
        GCoordonnee[] yCoordonnees = {
                viewport.convertirCoordonnees((int) rectangle.sommets[0].getX(), (int) rectangle.sommets[0].getY()),
                viewport.convertirCoordonnees((int) rectangle.sommets[1].getX(), (int) rectangle.sommets[1].getY()),
                viewport.convertirCoordonnees((int) rectangle.sommets[2].getX(), (int) rectangle.sommets[2].getY()),
                viewport.convertirCoordonnees((int) rectangle.sommets[3].getX(), (int) rectangle.sommets[3].getY())
        };
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
        GCoordonnee[] xCoordonnees = {
                viewport.convertirCoordonnees((int) parallelogramme.sommets[0].getX(), (int) parallelogramme.sommets[0].getY()),
                viewport.convertirCoordonnees((int) parallelogramme.sommets[1].getX(), (int) parallelogramme.sommets[1].getY()),
                viewport.convertirCoordonnees((int) parallelogramme.sommets[2].getX(), (int) parallelogramme.sommets[2].getY()),
                viewport.convertirCoordonnees((int) parallelogramme.sommets[3].getX(), (int) parallelogramme.sommets[3].getY())
        };
        GCoordonnee[] yCoordonnees = {
                viewport.convertirCoordonnees((int) parallelogramme.sommets[0].getX(), (int) parallelogramme.sommets[0].getY()),
                viewport.convertirCoordonnees((int) parallelogramme.sommets[1].getX(), (int) parallelogramme.sommets[1].getY()),
                viewport.convertirCoordonnees((int) parallelogramme.sommets[2].getX(), (int) parallelogramme.sommets[2].getY()),
                viewport.convertirCoordonnees((int) parallelogramme.sommets[3].getX(), (int) parallelogramme.sommets[3].getY()),
        };
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
        GCoordonnee[] xCoordonnees = {
                viewport.convertirCoordonnees((int) rectTri.sommets[0].getX(), (int) rectTri.sommets[0].getY()),
                viewport.convertirCoordonnees((int) rectTri.sommets[1].getX(), (int) rectTri.sommets[1].getY()),
                viewport.convertirCoordonnees((int) rectTri.sommets[2].getX(), (int) rectTri.sommets[2].getY()),

        };
        GCoordonnee[] yCoordonnees = {
                viewport.convertirCoordonnees((int) rectTri.sommets[0].getX(), (int) rectTri.sommets[0].getY()),
                viewport.convertirCoordonnees((int) rectTri.sommets[1].getX(), (int) rectTri.sommets[1].getY()),
                viewport.convertirCoordonnees((int) rectTri.sommets[2].getX(), (int) rectTri.sommets[2].getY()),
        };
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
        GCoordonnee[] xCoordonnees = {
                viewport.convertirCoordonnees((int) isoTri.sommets[0].getX(), (int) isoTri.sommets[0].getY()),
                viewport.convertirCoordonnees((int) isoTri.sommets[1].getX(), (int) isoTri.sommets[1].getY()),
                viewport.convertirCoordonnees((int) isoTri.sommets[2].getX(), (int) isoTri.sommets[2].getY()),

        };
        GCoordonnee[] yCoordonnees = {
                viewport.convertirCoordonnees((int) isoTri.sommets[0].getX(), (int) isoTri.sommets[0].getY()),
                viewport.convertirCoordonnees((int) isoTri.sommets[1].getX(), (int) isoTri.sommets[1].getY()),
                viewport.convertirCoordonnees((int) isoTri.sommets[2].getX(), (int) isoTri.sommets[2].getY()),
        };return new GTriangle(xCoordonnees, yCoordonnees);
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
        GCoordonnee[] xCoordonnees = {
                viewport.convertirCoordonnees((int) equiTri.sommets[0].getX(), (int) equiTri.sommets[0].getY()),
                viewport.convertirCoordonnees((int) equiTri.sommets[1].getX(), (int) equiTri.sommets[1].getY()),
                viewport.convertirCoordonnees((int) equiTri.sommets[2].getX(), (int) equiTri.sommets[2].getY()),

        };
        GCoordonnee[] yCoordonnees = {
                viewport.convertirCoordonnees((int) equiTri.sommets[0].getX(), (int) equiTri.sommets[0].getY()),
                viewport.convertirCoordonnees((int) equiTri.sommets[1].getX(), (int) equiTri.sommets[1].getY()),
                viewport.convertirCoordonnees((int) equiTri.sommets[2].getX(), (int) equiTri.sommets[2].getY()),
        };
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
            throw new IncorrectTypeOperationException("Type d'objet géométrique non attendu" );
        }
    }
}