package lektion15.Unternehmen;

public class Angestellter {
    private String nachname;
    private String vorname;
    private String id;
    private double grundgehalt;
    private double gehaltsfaktor;
    private String geburtsdatum;

    public Angestellter(String nachname, String vorname, String id, double grundgehalt, String geburtsdatum) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.id = id;
        this.grundgehalt = grundgehalt;
        this.gehaltsfaktor = 1.0;
        this.geburtsdatum = geburtsdatum;
    }

    public double berechneGehalt() {
        return grundgehalt * gehaltsfaktor;
    }

    public void setGehaltsfaktor(double gehaltsfaktor) {
        this.gehaltsfaktor = gehaltsfaktor;
    }

    public double getGehaltsfaktor() {
        return gehaltsfaktor;
    }

    public String getId() {
        return id;
    }

    // Getter-Methoden für Tests etc.
    public String getName() {
        return vorname + " " + nachname;
    }
    public String getGeburtsDatum() {
        return geburtsdatum;
    }

    public double getGehalt() {
        return grundgehalt;
    }
}
