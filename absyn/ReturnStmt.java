package absyn;

public class ReturnStmt extends Stmt {
  public Exp exp;
  public ReturnStmt( int pos, Exp exp ) {
    this.pos = pos;
    this.exp = exp;
  }
}
