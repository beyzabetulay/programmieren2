package lektion16.schach;

public class TurmImpl extends AbstractFigur implements Turm
{
  public TurmImpl(int x, int y)
  {
    super(x, y);
  }

  public Brett gibErlaubteFelder()
  {
    Brett brett = new Brett();
    for (int i = 1; i <= 8; i++)
    {
      brett.markiereFeld(i, y);
      brett.markiereFeld(x, i);
    }
    return brett;
  }
  
  public static void main(String[] args)
  {
    TurmImpl turm = new TurmImpl(4,5);
    Brett brett = turm.gibErlaubteFelder();
    Brett.printBrett(brett);
  }
}
