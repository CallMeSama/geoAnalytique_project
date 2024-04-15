package model.geoobject.operation.segment;

import model.Segment;
import util.Operation;
import model.Point;

/**
 * Classe représentant l'opération de vérification de l'intersection entre deux segments.
 */
public class IntersecteAvecSegmentOperation implements Operation {
    private Segment segment1;
    private Segment segment2;

    /**
     * Constructeur de l'opération.
     * 
     * @param segment1 Le premier segment à vérifier.
     * @param segment2 Le deuxième segment à vérifier.
     */
    public IntersecteAvecSegmentOperation(Segment segment1, Segment segment2) {
        this.segment1 = segment1;
        this.segment2 = segment2;
    }

    @Override
    public String getTitle() {
        return "Vérifier si le segment intersecte un autre segment";
    }

    @Override
    public int getArite() {
        return 2;
    }

    @Override
    public void setArgument(int num, Object o) {
        if (num == 0) {
            segment1 = (Segment) o;
        } else if (num == 1) {
            segment2 = (Segment) o;
        } else {
            throw new IllegalArgumentException("Numéro d'argument invalide");
        }
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class getClassArgument(int num) {
        return Segment.class;
    }

    @Override
    public Object calculer() {
        Point p1 = segment1.getPoint1();
        Point q1 = segment1.getPoint2();
        Point p2 = segment2.getPoint1();
        Point q2 = segment2.getPoint2();

        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        // Les segments s'intersectent ssi les orientations des points sont différentes
        if (o1 != o2 && o3 != o4) {
            return true;
        }

        // Cas spéciaux
        // p1, q1 et p2 sont colinéaires et p2 est sur le segment p1q1
        if (o1 == 0 && onSegment(p1, p2, q1)) return true;
        // p1, q1 et q2 sont colinéaires et q2 est sur le segment p1q1
        if (o2 == 0 && onSegment(p1, q2, q1)) return true;
        // p2, q2 et p1 sont colinéaires et p1 est sur le segment p2q2
        if (o3 == 0 && onSegment(p2, p1, q2)) return true;
         // p2, q2 et q1 sont colinéaires et q1 est sur le segment p2q2
        if (o4 == 0 && onSegment(p2, q1, q2)) return true;

        // Aucun des cas ci-dessus
        return false;
    }

    @Override
    public String getDescriptionArgument(int num) {
        if (num == 0) {
            return "Premier segment à vérifier";
        } else if (num == 1) {
            return "Deuxième segment à vérifier";
        } else {
            throw new IllegalArgumentException("Numéro d'argument invalide");
        }
    }

    // Fonction utilitaire pour trouver l'orientation de triplet (p, q, r)
    private int orientation(Point p, Point q, Point r) {
        double val = (q.getY() - p.getY()) * (r.getX() - q.getX()) - (q.getX() - p.getX()) * (r.getY() - q.getY());
        if (val == 0) return 0; // Colinéaire
        return (val > 0) ? 1 : 2; // Sens horaire ou antihoraire
    }

    // Fonction utilitaire pour vérifier si le point q est sur le segment pr
    private boolean onSegment(Point p, Point q, Point r) {
        return q.getX() <= Math.max(p.getX(), r.getX()) && q.getX() >= Math.min(p.getX(), r.getX()) &&
               q.getY() <= Math.max(p.getY(), r.getY()) && q.getY() >= Math.min(p.getY(), r.getY());
    }
}
