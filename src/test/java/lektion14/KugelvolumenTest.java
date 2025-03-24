package lektion14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class KugelvolumenTest {

    @Test
    public void testBerechneKugelvolumen() {
        assertTrue(Kugelvolumen.berechneKugelvolumen(0) == 0.0);
        assertTrue(Kugelvolumen.berechneKugelvolumen(1) > 4.18 && Kugelvolumen.berechneKugelvolumen(1) < 4.19);
        assertTrue(Kugelvolumen.berechneKugelvolumen(5) > 523.5 && Kugelvolumen.berechneKugelvolumen(5) < 523.7);
    }

    @Test
    public void testNegativerRadius() {
        try {
            Kugelvolumen.berechneKugelvolumen(-1);
            fail("RuntimeException erwartet!");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().equals("Radius darf nicht negativ sein!"));
        }
    }
}
