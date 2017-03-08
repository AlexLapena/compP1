package absyn;

public class VarExp extends Exp {
  public String variable;
  public Exp exp;
  public VarExp( int pos, String variable, Exp exp ) {
    this.pos = pos;
    this.variable = variable;
    this.exp = exp;
  }
}
