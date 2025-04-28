package lektion16.schach;

public class LaeuferImpl extends AbstractFigur implements Laeufer {
    public LaeuferImpl(int x, int y) {
        super(x, y);
    }

    public Brett gibErlaubteFelder() {
        Brett brett = new Brett();
        //TODO: Erg�nzen Sie den Algorithmus zur Bestimmung der Felder

        // Çapraz hareket için yön vektörleri: (dx, dy)
        int[] dx = {1, 1, -1, -1};
        int[] dy = {-1, 1, -1, 1};

        // Filin başlangıç konumunu alıyoruz
        int startX = getX();
        int startY = getY();

        // Her yön için döngü
        for (int i = 0; i < dx.length; i++) {
            int currentX = startX + dx[i];
            int currentY = startY + dy[i];

            // Tahtanın sınırları içinde olduğu sürece ilerle
            while (currentX >= 1 && currentX <= 8 && currentY >= 1 && currentY <= 8) {
                brett.markiereFeld(currentX, currentY);
                currentX += dx[i];
                currentY += dy[i];
            }
        }

        return brett;
    }

    public static void main(String[] args) {
        LaeuferImpl l = new LaeuferImpl(3, 6);
        Brett brett = l.gibErlaubteFelder();
        for (int j = 1; j <= 8; j++) {
            for (int i = 1; i <= 8; i++) {
                if (brett.gibFeld(i, j))
                    System.out.print("x ");
                else
                    System.out.print("o ");
            }
            System.out.println();
        }
    }
}
