package absyn;

public class FunctionDec extends Dec {
  public String func;
  public NameTy result;
  public Params params;
  public CompoundStmt body;
  public FunctionDec( int pos, NameTy result, String func, Params params, CompoundStmt body) {
    this.pos = pos;
    this.result = result;
    this.func = func;
    this.params = params;
    this.body = body;
  }
}