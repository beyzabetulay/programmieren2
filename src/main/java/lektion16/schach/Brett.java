package lektion16.schach;

public class Brett
{
  boolean[][] brett = new boolean[8][8];
  
  public Brett()
  {
  }
  public Brett kombiniere(Brett anderesBrett) {
    Brett neuesBrett = new Brett();

    // 8x8 döngü ile her kareyi kontrol ederek
    // herhangi birinde işaretli ise, yeni tahtada işaretle
    for (int y = 1; y <= 8; y++) {
      for (int x = 1; x <= 8; x++) {
        if (this.gibFeld(x, y) || anderesBrett.gibFeld(x, y)) {
          neuesBrett.markiereFeld(x, y);
        }
      }
    }

    return neuesBrett;
  }


  public void markiereFeld(int x, int y)
  {
    brett[x-1][y-1] = true;
  }
  
  public boolean gibFeld(int x, int y)
  {
    return brett[x-1][y-1];
  }
// um die brett zu schreiben
  public static void printBrett(Brett brett) {
    for (int y = 1; y <= 8; y++) {
      for (int x = 1; x <= 8; x++) {
        System.out.print(brett.gibFeld(x, y) ? "x " : "_ ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    // İlk tahtayı oluştur ve bazı kareleri işaretle.
    Brett brett1 = new Brett();
    brett1.markiereFeld(3, 3);
    brett1.markiereFeld(4, 4);

    // İkinci tahtayı oluştur ve farklı kareleri işaretle.
    Brett brett2 = new Brett();
    brett2.markiereFeld(4, 4);  // Ortak kare olabilir
    brett2.markiereFeld(5, 5);

    // İki tahtayı kombine et.
    Brett kombiniertesBrett = brett1.kombiniere(brett2);

    // Çıktıyı görsel olarak kontrol etmek için 8x8 tahtayı yazdır.
    printBrett(kombiniertesBrett);
  }
}
