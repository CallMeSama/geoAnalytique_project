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
        int largeurEcran = 1366;
        int hauteurEcran = 768;
        double largeurMonde = largeurEcran / 30.0;
        double hauteurMonde = hauteurEcran / 30.0;
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
            if (i == 0) continue;  // Ne pas afficher le 0
            int x = viewport.mondeVersEcranX(i) + getWidth() / 2;
            g.drawLine(x, getHeight() / 2, x, getHeight() / 2 - 5);
            g.drawString(Integer.toString(i), x, getHeight() / 2 + 20);  // Déplacer les numérotations aux côtés opposés des graduations
        }

        // Dessiner l'axe des ordonnées et des graduations
        g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
        for (int i = -(int)(viewport.hauteurMonde / 2); i <= viewport.hauteurMonde / 2; i++) {
            if (i == 0) continue;  // Ne pas afficher le 0
            int y = getHeight() / 2 - viewport.mondeVersEcranY(i);
            g.drawLine(getWidth() / 2, y, getWidth() / 2 + 5, y);
            g.drawString(Integer.toString(i), getWidth() / 2 - 20, i < 0 ? y + 5 : y);  // Déplacer les numérotations aux côtés opposés des graduations
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