package lektion14;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testGueltigePerson() {
        // Geçerli bir kişi nesnesi oluşturulmalı ve hata atmamalı
        Person p = new Person("Max", "Mustermann", "Hauptstrasse", "12A", "12345", "Berlin");
        assertTrue(true); // Eğer buraya kadar gelirse, test başarılı
    }

    @Test
    public void testVornameMitKleinbuchstabe() {
        try {
            new Person("max", "Mustermann", "Hauptstrasse", "12A", "12345", "Berlin");
            fail("RuntimeException erwartet!");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().equals("Vorname, Strasse und Ort müssen mit einem Großbuchstaben beginnen!"));
        }
    }

    @Test
    public void testStrasseMitKleinbuchstabe() {
        try {
            new Person("Max", "Mustermann", "hauptstrasse", "12A", "12345", "Berlin");
            fail("RuntimeException erwartet!");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().equals("Vorname, Strasse und Ort müssen mit einem Großbuchstaben beginnen!"));
        }
    }

    @Test
    public void testOrtMitKleinbuchstabe() {
        try {
            new Person("Max", "Mustermann", "Hauptstrasse", "12A", "12345", "berlin");
            fail("RuntimeException erwartet!");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().equals("Vorname, Strasse und Ort müssen mit einem Großbuchstaben beginnen!"));
        }
    }

    @Test
    public void testHausnummerMitBuchstabe() {
        try {
            new Person("Max", "Mustermann", "Hauptstrasse", "A12", "12345", "Berlin");
            fail("RuntimeException erwartet!");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().equals("Hausnummer muss mit einer Ziffer beginnen!"));
        }
    }

    @Test
    public void testPostleitzahlZuKurz() {
        try {
            new Person("Max", "Mustermann", "Hauptstrasse", "12A", "1234", "Berlin");
            fail("RuntimeException erwartet!");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().equals("Postleitzahl muss genau 5 Zeichen lang sein!"));
        }
    }

    @Test
    public void testPostleitzahlZuLang() {
        try {
            new Person("Max", "Mustermann", "Hauptstrasse", "12A", "123456", "Berlin");
            fail("RuntimeException erwartet!");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().equals("Postleitzahl muss genau 5 Zeichen lang sein!"));
        }
    }
}