package lektion14;

public class Kugelvolumen {
    public static double berechneKugelvolumen(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius darf nicht negativ sein!");
        }
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    public static void main(String[] args) {
        double a = berechneKugelvolumen(5);
        System.out.println(a);
    }
}
