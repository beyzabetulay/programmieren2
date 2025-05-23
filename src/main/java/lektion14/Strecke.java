package lektion14;

public class Strecke {
    private final int a;
    private final int b;

    public Strecke(int a, int b) {
        if (a > b) { // a muss kleiner
            int temp = a;
            a = b;
            b = temp;
        }
        this.a = a;
        this.b = b;
    }

    // b) Strecken überschneiden sich?
    public boolean ueberschneidet(Strecke andere) {
        return !(this.b <= andere.a || andere.b <= this.a);
    }

    // c) toString() Methode
    @Override
    public String toString() {
        if (a == b)
            return String.valueOf(a);
        String str = a + "";
        for (int i = 0; i < b - a; i++) {
            str += "-";
        }
        return str + b;
    }

    // Getter (für JUnit tests weil da atributt private sind)
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}