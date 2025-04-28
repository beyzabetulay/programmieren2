package lektion14;

public class Person {
    String vorname;
    String nachname;
    String strasse;
    String hausnummer;
    String ort;
    String postleitzahl;
    //In Deutschland können Postleitzahlen mit einer Null beginnen. wenn int ist, "01234" -> "1234"

    public Person(String vorname, String nachname, String strasse, String hausnummer, String postleitzahl, String ort) {
        if (!(vorname.charAt(0) >= 'A' && vorname.charAt(0) <= 'Z') ||
            !(strasse.charAt(0) >= 'A' && strasse.charAt(0) <= 'Z') ||
            !(ort.charAt(0) >= 'A' && ort.charAt(0) <= 'Z')) {
            throw new RuntimeException("Vorname, Strasse und Ort müssen mit einem Großbuchstaben beginnen!");
        }

        if (!(hausnummer.charAt(0) >= '0' && hausnummer.charAt(0) <= '9')) {
            throw new RuntimeException("Hausnummer muss mit einer Ziffer beginnen!");
        }

        if (postleitzahl.length() != 5) {
            throw new RuntimeException("Postleitzahl muss genau 5 Zeichen lang sein!");
        }

        this.vorname = vorname;
        this.nachname = nachname;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.postleitzahl = postleitzahl;
        this.ort = ort;
    }
}
