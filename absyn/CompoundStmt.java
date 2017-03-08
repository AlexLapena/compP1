package absyn;

public class CompoundStmt extends Stmt {
  public DecLocalList decs;
  public StmtList stmts;
  public CompoundStmt( int pos, DecLocalList decs, StmtList stmts ) {
    this.pos = pos;
    this.decs = decs;
    this.stmts = stmts;
  }
}
