package util;

import model.*;


/**
 * Interface définissant le visiteur des objets géométriques.
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
}
