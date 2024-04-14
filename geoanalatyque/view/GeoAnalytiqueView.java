package view;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import graphique.Graphique;
import model.GeoObject;
import model.ViewPort;

public class GeoAnalytiqueView extends JPanel {
    private ArrayList<Graphique> graphiques;
    private ViewPort viewport ;
    private GeoObject selectedObject;

    public GeoAnalytiqueView() {
        super();
        int largeurEcran = 800;
        int hauteurEcran = 600;
        double largeurMonde = largeurEcran / 10.0;
        double hauteurMonde = hauteurEcran / 10.0;
        this.viewport = new ViewPort(largeurMonde, hauteurMonde, largeurEcran, hauteurEcran);
        this.graphiques = new ArrayList<>();
    }

    public void addGraphique(Graphique g) {
        this.graphiques.add(g);
    }

    public void removeGraphique(Graphique g) {
        this.graphiques.remove(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessiner l'axe des abscisses et des graduations
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
        for (int i = -(int)(viewport.largeurMonde / 2); i <= viewport.largeurMonde / 2; i++) {
            int x = viewport.mondeVersEcranX(i);
            g.drawLine(x, getHeight() / 2, x, getHeight() / 2 - 5);
            g.drawString(Integer.toString(i), x, getHeight() / 2 - 10);
        }

        // Dessiner l'axe des ordonnées et des graduations
        g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
        for (int i = -(int)(viewport.hauteurMonde / 2); i <= viewport.hauteurMonde / 2; i++) {
            int y = viewport.mondeVersEcranY(i);
            g.drawLine(getWidth() / 2, y, getWidth() / 2 + 5, y);
            g.drawString(Integer.toString(i), getWidth() / 2 + 10, y);
        }
        for (Graphique graphique : graphiques) {
            graphique.paint(g);
        }
    }

    public void updateSelectedObject(GeoObject objet) {
        this.selectedObject = objet;
        this.repaint();
    }
}