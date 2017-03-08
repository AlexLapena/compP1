package absyn;

public class SelectStmt extends Stmt {
  public Exp test;
  public Stmt thenpart;
  public Stmt elsepart;
  public SelectStmt( int pos, Exp test, Stmt thenpart, Stmt elsepart ) {
    this.pos = pos;
    this.test = test;
    this.thenpart = thenpart;
    this.elsepart = elsepart;
  }
}
