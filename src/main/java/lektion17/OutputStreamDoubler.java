package lektion17;

import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;

public class OutputStreamDoubler extends OutputStream {

    private OutputStream os1;
    private OutputStream os2;

    public OutputStreamDoubler(OutputStream os1, OutputStream os2) {
        this.os1 = os1;
        this.os2 = os2;
    }

    @Override
    public void write(int b) throws IOException {
        IOException writeException = null;

        try {
            os1.write(b);
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in Stream 1:");
            e.printStackTrace();
            writeException = e;
        }

        try {
            os2.write(b);
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in Stream 2:");
            e.printStackTrace();
            if (writeException == null) {
                writeException = e;
            }
        }

        if (writeException != null) {
            throw writeException;
        }
    }

    @Override
    public void close() throws IOException {
        IOException closeException1 = null;
        IOException closeException2 = null;

        try {
            if (os1 != null) {
                os1.close();
            }
        } catch (IOException e) {
            closeException1 = e;
        }

        try {
            if (os2 != null) {
                os2.close();
            }
        } catch (IOException e) {
            closeException2 = e;
        }

        if (closeException1 != null && closeException2 != null) {
            throw new IOException("Fehler beim Schließen beider Streams.", closeException1);
        } else if (closeException1 != null) {
            throw new IOException("Fehler beim Schließen des ersten Streams.", closeException1);
        } else if (closeException2 != null) {
            throw new IOException("Fehler beim Schließen des zweiten Streams.", closeException2);
        }
    }

    public static void main(String[] args) {
        try (OutputStream fos1 = new FileOutputStream("file1.txt");
             OutputStream fos2 = new FileOutputStream("file2.txt");
             OutputStream doubler = new OutputStreamDoubler(fos1, fos2)) {

            doubler.write('H');
            doubler.write('a');
            doubler.write('l');
            doubler.write('l');
            doubler.write('o');
            doubler.write(' ');
            doubler.write('W');
            doubler.write('e');
            doubler.write('l');
            doubler.write('t');
            doubler.write('!');
            System.out.println( "Dateien wurden erfolgreich geschrieben.");

        } catch (IOException e) {
            System.err.println("Fehler beim Arbeiten mit den Streams:");
            e.printStackTrace();
        }
    }

}
