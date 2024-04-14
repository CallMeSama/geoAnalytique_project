package util;

import model.*;

/**
 * Interface définissant le visiteur des objets géométriques.
 *
 * @param <ModelObjet> Type du résultat de la visite.
 */
public interface GeoObjectVisitor<ModelObjet> {

    /**
     * Visite un point géométrique.
     *
     * @param point Le point à visiter.
     * @return Le résultat de la visite.
     */
    ModelObjet visit(Point point);

    /**
     * Visite une droite géométrique.
     *
     * @param droite La droite à visiter.
     * @return Le résultat de la visite.
     */
    ModelObjet visit(Droite droite);

    /**
     * Visite un segment géométrique.
     *
     * @param segment Le segment à visiter.
     * @return Le résultat de la visite.
     */
    ModelObjet visit(Segment segment);

    /**
     * Visite un cercle géométrique.
     *
     * @param cercle Le cercle à visiter.
     * @return Le résultat de la visite.
     */
    ModelObjet visit(Cercle cercle);

    /**
     * Visite une ellipse géométrique.
     *
     * @param ellipse L'ellipse à visiter.
     * @return Le résultat de la visite.
     */
    ModelObjet visit(Ellipse ellipse);

    /**
     * Visite un carré géométrique.
     *
     * @param carre Le carré à visiter.
     * @return Le résultat de la visite.
     */
    ModelObjet visit(Carre carre);

    /**
     * Visite un rectangle géométrique.
     *
     * @param rectangle Le rectangle à visiter.
     * @return Le résultat de la visite.
     */
    ModelObjet visit(Rectangle rectangle);

    /**
     * Visite un parallélogramme géométrique.
     *
     * @param parallelogramme Le parallélogramme à visiter.
     * @return Le résultat de la visite.
     */
    ModelObjet visit(Parallelogramme parallelogramme);

    /**
     * Visite un triangle équilatéral géométrique.
     *
     * @param trEquilateral Le triangle équilatéral à visiter.
     * @return Le résultat de la visite.
     */
    ModelObjet visit(TriangleEquilateral trEquilateral);

    /**
     * Visite un triangle isocèle géométrique.
     *
     * @param isoTri Le triangle isocèle à visiter.
     * @return Le résultat de la visite.
     */
    ModelObjet visit(TriangleIsocele isoTri);

    /**
     * Visite un triangle rectangle géométrique.
     *
     * @param rectTri Le triangle rectangle à visiter.
     * @return Le résultat de la visite.
     */
    ModelObjet visit(TriangleRectangle rectTri);
}
