package lektion15.Unternehmen;

public class Abteilungsleiter extends Angestellter {

    public Abteilungsleiter(String nachname, String vorname, String id, double grundgehalt, String geburtsdatum) {
        super(nachname, vorname, id, grundgehalt, geburtsdatum);
        setGehaltsfaktor(2.0);
    }

    public void befoerdern(Angestellter angestellter) {
        double neuerFaktor = angestellter.getGehaltsfaktor() * 1.10;
        angestellter.setGehaltsfaktor(neuerFaktor);
    }
}
