package absyn;

public class WhileStmt extends Stmt {
  public Exp test;
  public Stmt body;
  public WhileStmt( int pos, Exp test, Stmt body ) {
    this.pos = pos;
    this.test = test;
    this.body = body;
  }
}
