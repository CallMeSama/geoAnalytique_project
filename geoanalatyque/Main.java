import javax.swing.SwingUtilities;
import gui.GeoAnalytiqueGUI;
import controlleur.GeoAnalytiqueControleur;
import model.ViewPort;
import util.Dessinateur;
import view.GeoAnalytiqueView;

public class Main {
    public static void main(String[] args) {
        ViewPort viewport = new ViewPort(1000, 1000, 30);
        Dessinateur dessinateur = new Dessinateur(viewport);

        GeoAnalytiqueControleur controleur = new GeoAnalytiqueControleur(dessinateur);
        GeoAnalytiqueView vue = new GeoAnalytiqueView();

        controleur.setView(vue);
        vue.setControleur(controleur);

        // Créer l'interface utilisateur
        GeoAnalytiqueGUI gui = new GeoAnalytiqueGUI(controleur);

        // Afficher l'interface utilisateur
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gui.setVisible(true);
            }
        });
    }
}