package lektion14;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

 class StreckeTest {

    @Test
    public void testStreckeKonstruktor() {
        Strecke s1 = new Strecke(5, 3);
        assertTrue(s1.getA() == 3 && s1.getB() == 5);

        Strecke s2 = new Strecke(2, 8);
        assertTrue(s2.getA() == 2 && s2.getB() == 8);

        Strecke s3 = new Strecke(4, 4);
        assertTrue(s3.getA() == 4 && s3.getB() == 4);
    }

    @Test
    public void testUeberschneidung() {
        Strecke s1 = new Strecke(2, 6);
        Strecke s2 = new Strecke(4, 8);
        assertTrue(s1.ueberschneidet(s2));

        Strecke s3 = new Strecke(10, 15);
        Strecke s4 = new Strecke(16, 20);
        assertFalse(s3.ueberschneidet(s4));

        Strecke s5 = new Strecke(5, 10);
        Strecke s6 = new Strecke(10, 15);
        assertFalse(s5.ueberschneidet(s6)); // Berührung zählt nicht als Überschneidung
    }

    @Test
    public void testToString() {
        Strecke s1 = new Strecke(3, 5);
        assertEquals(s1.toString(),("3--5"));
        assertFalse(s1.toString().equals("3-5"));

        Strecke s2 = new Strecke(2, 8);
        assertTrue(s2.toString().equals("2------8"));

        Strecke s3 = new Strecke(4, 4);
        assertTrue(s3.toString().equals("4"));
    }
}
