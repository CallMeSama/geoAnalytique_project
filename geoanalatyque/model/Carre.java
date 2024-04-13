package model;

public class Carre extends GeoObject{

    private double cote;

    public Carre(double cote) {
        this.cote = cote;
    }

    public double calculerPerimetre() {
        return 4 * cote;
    }

    public double calculerAire() {
        return cote * cote;
    }


    // Getters et Setters
    public double getcote() {
        return cote;
    }

    public void setcote(double cote) {
        this.cote = cote;
    }

}
