package lektion15.Unternehmen;

public class Abteilung {
    private Abteilungsleiter leiter;
    private Angestellter[] mitarbeiter;
    private int aktuelleAnzahl;

    public Abteilung(Abteilungsleiter leiter, int maxMitarbeiter) {
        this.leiter = leiter;
        this.mitarbeiter = new Angestellter[maxMitarbeiter];
        this.aktuelleAnzahl = 0;
    }

    public void angestelltenHinzufuegen(Angestellter angestellter) {
        if (aktuelleAnzahl < mitarbeiter.length) {
            mitarbeiter[aktuelleAnzahl] = angestellter;
            aktuelleAnzahl++;
        }
    }

    public Abteilungsleiter getLeiter() {
        return leiter;
    }

    public Angestellter[] getMitarbeiter() {
        return mitarbeiter;
    }

    public int getAnzahlMitarbeiter() {
        return aktuelleAnzahl;
    }
}

