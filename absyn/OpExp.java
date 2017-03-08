package absyn;

public class OpExp extends Exp {
  public final static int PLUS   = 0;
  public final static int MINUS  = 1;
  public final static int MUL    = 2;
  public final static int DIV    = 3;
  public final static int LT     = 4;
  public final static int LTE    = 5;
  public final static int GT     = 6;
  public final static int GTE    = 7;
  public final static int EQEQ   = 8;
  public final static int NE     = 9;
  public final static int EQUALS = 10;

  public Exp left;
  public int op;
  public Exp right;
  public OpExp( int pos, Exp left, int op, Exp right ) {
    this.pos = pos;
    this.left = left;
    this.op = op;
    this.right = right;
  }
}
