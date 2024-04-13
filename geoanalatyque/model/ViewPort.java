package model;

public class ViewPort {
    private double worldWidth;
    private double worldHeight;
    private int screenWidth;
    private int screenHeight;

    public ViewPort(double worldWidth, double worldHeight, int screenWidth, int screenHeight) {
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    // Convertit les coordonnées du monde réel en coordonnées de pixels
    public int worldToScreenX(double worldX) {
        return (int) (worldX / worldWidth * screenWidth);
    }

    public int worldToScreenY(double worldY) {
        return (int) (worldY / worldHeight * screenHeight);
    }

    // Convertit les coordonnées de pixels en coordonnées du monde réel
    public double screenToWorldX(int screenX) {
        return screenX / (double) screenWidth * worldWidth;
    }

    public double screenToWorldY(int screenY) {
        return screenY / (double) screenHeight * worldHeight;
    }
}
