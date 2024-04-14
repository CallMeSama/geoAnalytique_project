import javax.swing.SwingUtilities;
import gui.GeoAnalytiqueGUI;
import controlleur.GeoAnalytiqueControleur;
import model.ViewPort;
import util.Dessinateur;
import view.GeoAnalytiqueView;

public class Main {
    public static void main(String[] args) {
        // Créer la vue, le viewport et le dessinateur
        GeoAnalytiqueView vue = new GeoAnalytiqueView();
        ViewPort viewport = new ViewPort(1000, 1000, 800, 600);
        Dessinateur dessinateur = new Dessinateur();

        // Créer le contrôleur
        GeoAnalytiqueControleur controleur = new GeoAnalytiqueControleur(vue, viewport, dessinateur);


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