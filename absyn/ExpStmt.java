package absyn;

public class ExpStmt extends Stmt {
  public Exp exp;
  public ExpStmt(int pos, Exp exp) {
    this.pos = pos;
    this.exp = exp;
  }
}

