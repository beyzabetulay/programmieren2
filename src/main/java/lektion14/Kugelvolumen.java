package lektion14;

public class Kugelvolumen {
    public static double berechneKugelvolumen(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius darf nicht negativ sein!");
        }
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}
