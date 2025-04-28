package lektion16.schach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrettTest {

    @Test
    void kombiniere() {
    }
    @Test
    public void testKombiniere() {
        // İlk tahtada (brett1) bazı kareler işaretlensin
        Brett brett1 = new Brett();
        brett1.markiereFeld(2, 2);
        brett1.markiereFeld(3, 3);

        // İkinci tahtada (brett2) farklı kareler işaretlensin
        Brett brett2 = new Brett();
        brett2.markiereFeld(3, 3);  // Her iki tahtada ortak olan kare
        brett2.markiereFeld(4, 4);

        // İki tahtayı birleştir
        Brett kombiniertesBrett = brett1.kombiniere(brett2);

        // Beklenen durum:
        // (2,2), (3,3) ve (4,4) kareleri işaretli olmalı, diğerleri işaretli olmamalı
        assertTrue(kombiniertesBrett.gibFeld(2, 2),"Kare (2,2) işaretlenmiş olmalı.");
        assertTrue(kombiniertesBrett.gibFeld(3, 3),"Kare (3,3) işaretlenmiş olmalı.");
        assertTrue(kombiniertesBrett.gibFeld(4, 4),"Kare (4,4) işaretlenmiş olmalı.");

        // Diğer karelerin işaretsiz olması kontrol edilsin
        assertFalse(kombiniertesBrett.gibFeld(1, 1),"Kare (1,1) işaretlenmemiş olmalı.");
        assertFalse(kombiniertesBrett.gibFeld(5, 5),"Kare (5,5) işaretlenmemiş olmalı." );
    }
}

