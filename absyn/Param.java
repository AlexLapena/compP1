package absyn;

public class Param extends Absyn {
  public NameTy typ;
  public String id;
  public Boolean array;
  public Param(int pos, NameTy typ, String id, Boolean array) {
    this.typ = typ;
    this.id = id;
    this.array = array;
  }
}
