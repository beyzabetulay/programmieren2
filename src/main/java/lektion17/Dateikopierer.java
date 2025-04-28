package lektion17;

import java.io.*;
import java.util.Scanner;

public class Dateikopierer {

    public static void kopiereUngepuffertByteweise(String quelle, String ziel) {
            long startZeit = System.currentTimeMillis();

            try (InputStream is = new FileInputStream(quelle);
                 OutputStream os = new FileOutputStream(ziel)) {

                int daten;
                while ((daten = is.read()) != -1) {
                    os.write(daten);
                }

            } catch (FileNotFoundException e) {
                System.out.println("Datei nicht gefunden: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Fehler beim Kopieren: " + e.getMessage());
            }

            long endZeit = System.currentTimeMillis();
            System.out.println("Ungepuffert Byteweise Dauer: " + (endZeit - startZeit) + " ms");
        }


    public static void kopiereGepuffertByteweise(String quelle, String ziel) {
        long startZeit = System.currentTimeMillis();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(quelle));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(ziel))) {

            int daten;
            while ((daten = bis.read()) != -1) {
                bos.write(daten);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Fehler beim Kopieren: " + e.getMessage());
        }

        long endZeit = System.currentTimeMillis();
        System.out.println("Gepuffert Byteweise Dauer: " + (endZeit - startZeit) + " ms");
    }

    public static void kopiereMitBuffer(String quelle, String ziel) {
        long startZeit = System.currentTimeMillis();

        try (InputStream is = new FileInputStream(quelle);
             OutputStream os = new FileOutputStream(ziel)) {

            byte[] puffer = new byte[1024];
            int anzahlGelesen;
            while ((anzahlGelesen = is.read(puffer)) != -1) {
                os.write(puffer, 0, anzahlGelesen);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Fehler beim Kopieren: " + e.getMessage());
        }

        long endZeit = System.currentTimeMillis();
        System.out.println("Mit eigenem Buffer Dauer: " + (endZeit - startZeit) + " ms");    }

    public static void vergleicheDateien(String quellDateiPfad, String zielDateiPfad) {
        File quelle = new File(quellDateiPfad);
        File ziel = new File(zielDateiPfad);

        if (quelle.length() == ziel.length()) {
            System.out.println("Dateien sind gleich groß ✅");
        } else {
            System.out.println("Dateien sind unterschiedlich groß ❌");
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie den Pfad der Quelldatei ein (z.B. C:\\Users\\beyza\\Bilgisayar\\Desktop\\Temp\\test.txt: ");
        String quellDateiPfad = scanner.nextLine().trim();

        System.out.println("Bitte geben Sie den Pfad der Zieldatei ein (z.B. C:\\Users\\beyza\\Bilgisayar\\Desktop\\Temp\\sonuc.txt: ");
        String zielDateiPfad = scanner.nextLine().trim();

        //     C:\\Users\\beyza\\Bilgisayar\\Desktop\\Temp\\test.txt
        //     C:\\Users\\beyza\\Bilgisayar\\Desktop\\Temp\\sonuc.txt


        // 10 Wiederholungen pro Methode
        for (int i = 1; i <= 10; i++) {
            System.out.println("\nDurchlauf " + i + ":");

            // Methode 1: ungepufferter Byte-Stream
            kopiereUngepuffertByteweise(quellDateiPfad, zielDateiPfad + "_ungepuffert_" + i);
            vergleicheDateien(quellDateiPfad, zielDateiPfad + "_ungepuffert_" + i);


            // Methode 2: gepufferter Byte-Stream
            kopiereGepuffertByteweise(quellDateiPfad, zielDateiPfad + "_gepuffert_" + i);
            vergleicheDateien(quellDateiPfad, zielDateiPfad + "_gepuffert_" + i);


            // Methode 3: ungepuffert aber mit byte[] buffer
            kopiereMitBuffer(quellDateiPfad, zielDateiPfad + "_mitBuffer_" + i);
            vergleicheDateien(quellDateiPfad, zielDateiPfad + "_mitBuffer_" + i);

        }
    }
}
