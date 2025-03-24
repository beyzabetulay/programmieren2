package lektion14;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PunktTest {

    Punkt punkt = new Punkt();

    @Test
    public void testNegativeX(){
        try{
            punkt.verschiebePunkt(-1,0);
            fail("Runtime Exception expected");
        }
        catch(RuntimeException e){
            String error = e.getMessage();
            assertEquals("Ungültige Werte", error);
        }
    }

    @Test
    public void testNegativeY(){
        try{
            punkt.verschiebePunkt(0,-1);
            fail("Runtime Exception expected");
        }
        catch(RuntimeException e){
            String error = e.getMessage();
            assertEquals("Ungültige Werte", error);
        }
    }

    @Test
    public void testGrosserX(){
        try{
            punkt.verschiebePunkt(1921,0);
            fail("Runtime Exception expected");
        }
        catch(RuntimeException e){
            String error = e.getMessage();
            assertEquals("Ungültige Werte", error);
        }
    }

    @Test
    public void testGrosserY(){
        try{
            punkt.verschiebePunkt(0,1081);
            fail("Runtime Exception expected");
        }
        catch(RuntimeException e){
            String error = e.getMessage();
            assertEquals("Ungültige Werte", error);
        }
    }

}