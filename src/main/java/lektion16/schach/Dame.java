package lektion16.schach;

public class Dame extends AbstractFigur implements Laeufer, Turm
{
  Laeufer laeufer;
  Turm turm;
  
  public Dame(int x, int y)
  {
    super(x, y);
    laeufer = new LaeuferImpl(x, y);
    turm = new TurmImpl(x, y);
  }

  @Override
  public Brett gibErlaubteFelder()
  {
    Brett brettLaeufer = laeufer.gibErlaubteFelder();
    Brett brettTurm = turm.gibErlaubteFelder();
    Brett kombiniertesBrett = brettTurm.kombiniere(brettLaeufer);
    return kombiniertesBrett;
  }

  public static void main(String[] args)
  {
    Dame d = new Dame(4,5);
    System.out.println(d.gibErlaubteFelder());
    Brett brett = d.gibErlaubteFelder();
    Brett.printBrett(brett);
  }
}
