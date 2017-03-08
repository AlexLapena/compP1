package absyn;

public class Params extends Absyn {
  public ParamList pList;
  public boolean voidP;

  public Params(int pos, ParamList pList) {
    this.pList = pList;
    this.voidP = false;

    //Checks to see if the params are VOID
    if(this.pList == null){
    	this.voidP = true;
    }
  }
}
