package lektion14;

public class Punkt {
    int x;
    int y;

    public void verschiebePunkt(int zielX, int zielY) {
        if (zielX < 0 || zielY < 0 || zielX > 1920 || zielY > 1080) {
            throw new RuntimeException("Ungültige Werte");
        } else {
            x = zielX;
            y = zielY;
        }
    }
}