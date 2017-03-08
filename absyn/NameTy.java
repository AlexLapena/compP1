package absyn;

public class NameTy extends Absyn{
  public final static int INT   = 0;
  public final static int VOID  = 1;
  public int typ;
  public NameTy( int pos, int typ) {
  	this.pos = pos;
  	this.typ = typ;
  }

  public String toString() {
  	if (typ == 0) {
  		return "Int ";
  	}
  	else if (typ == 1) {
  		return "Void ";
  	}
  	return "";
  }

}