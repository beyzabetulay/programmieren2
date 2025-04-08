package lektion15;

import lektion15.Unternehmen.Abteilung;
import lektion15.Unternehmen.Abteilungsleiter;
import lektion15.Unternehmen.Angestellter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnternehmenTest {

    @Test
    public void testGehaltAngestellter() {
        Angestellter a = new Angestellter("Müller", "Anna", "A1", 3000, "1990-01-01");
        assertEquals(3000.0, a.berechneGehalt(), 0.01);
    }

    @Test
    public void testGehaltAbteilungsleiter() {
        Abteilungsleiter l = new Abteilungsleiter("Schmidt", "Peter", "L1", 3000, "1980-01-01");
        assertEquals(6000.0, l.berechneGehalt(), 0.01);
    }

    @Test
    public void testBefoerdern() {
        Abteilungsleiter l = new Abteilungsleiter("Schmidt", "Peter", "L1", 3000, "1980-01-01");
        Angestellter a = new Angestellter("Müller", "Anna", "A1", 3000, "1990-01-01");

        l.befoerdern(a);

        assertEquals(1.1, a.getGehaltsfaktor(), 0.001);
        assertEquals(3300.0, a.berechneGehalt(), 0.01);
    }

    @Test
    public void testAbteilungStrukturOhneArrayList() {
        Abteilungsleiter l = new Abteilungsleiter("Schmidt", "Peter", "L1", 3000, "1980-01-01");
        Abteilung abteilung = new Abteilung(l, 2);

        Angestellter a1 = new Angestellter("Maier", "Lisa", "A2", 2800, "1992-03-03");
        Angestellter a2 = new Angestellter("Weber", "Tom", "A3", 2900, "1991-09-09");

        abteilung.angestelltenHinzufuegen(a1);
        abteilung.angestelltenHinzufuegen(a2);

        assertEquals(2, abteilung.getAnzahlMitarbeiter());
        assertEquals("Peter Schmidt", abteilung.getLeiter().getName());
        assertEquals("Lisa Maier", abteilung.getMitarbeiter()[0].getName());
    }
}
