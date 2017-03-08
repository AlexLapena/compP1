package absyn;

abstract public class Absyn {
  public int pos;

  final static int SPACES = 4;

  static private void indent( int spaces ) {
    for( int i = 0; i < spaces; i++ ) System.out.print( " " );
  }

  /* ----------------------------Misc List Classes-------------------- */
  static public void showTree( ExpList tree, int spaces ) {
    while( tree != null ) {
      showTree( tree.head, spaces );
      tree = tree.tail;
    } 
  }

  static public void showTree( ParamList tree, int spaces ) {
    while( tree != null ) {
      showTree( tree.head, spaces );
      tree = tree.tail;
    } 
  }

  static public void showTree( DecList tree, int spaces ) {
    while( tree != null ) {
      showTree( tree.head, spaces );
      tree = tree.tail;
    } 
  }

  static public void showTree( StmtList tree, int spaces ) {
    while( tree != null ) {
      showTree( tree.head, spaces );
      tree = tree.tail;
    } 
  }

  static public void showTree( DecLocalList tree, int spaces ) {
    while( tree != null ) {
      showTree( tree.head, spaces );
      tree = tree.tail;
    } 
  }

  /* ----------------------------Exp Section-------------------- */
  static private void showTree( Exp tree, int spaces ) {
    if( tree instanceof NilExp )
      showTree( (NilExp)tree, spaces );
    else if( tree instanceof VarExp )
      showTree( (VarExp)tree, spaces );
    else if( tree instanceof IntExp )
      showTree( (IntExp)tree, spaces );
    else if( tree instanceof CallExp )
      showTree( (CallExp)tree, spaces );
    else if( tree instanceof OpExp )
      showTree( (OpExp)tree, spaces );
    else if( tree instanceof AssignExp )
      showTree( (AssignExp)tree, spaces );
    else {
      indent( spaces );
      System.out.println( "Illegal expression at line " + tree.pos  );
    }
  }

  static private void showTree( NilExp tree, int spaces) {
    indent( spaces );
    System.out.println( "NilExp:" );
  }

  static private void showTree( VarExp tree, int spaces) {
    indent( spaces );
    System.out.println( "VarExp:" + tree.variable);
    spaces += SPACES;
  }

  static private void showTree( IntExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "IntExp: " + tree.value ); 
  }

  static private void showTree( CallExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "CallExp: " + tree.func);
    spaces += SPACES;
    showTree( tree.args, spaces+SPACES ); 
  }

  static private void showTree( OpExp tree, int spaces ) {
    indent( spaces );
    System.out.print( "OpExp:" ); 
    switch( tree.op ) {
      case OpExp.PLUS:
        System.out.println( " + " );
        break;
      case OpExp.MINUS:
        System.out.println( " - " );
        break;
      case OpExp.MUL:
        System.out.println( " * " );
        break;
      case OpExp.DIV:
        System.out.println( " / " );
        break;
      case OpExp.LT:
        System.out.println( " < " );
        break;
      case OpExp.LTE:
        System.out.println( " <= " );
        break;
      case OpExp.GT:
        System.out.println( " > " );
        break;
      case OpExp.GTE:
        System.out.println( " >= " );
        break;
      case OpExp.EQEQ:
        System.out.println( " == " );
        break;
      case OpExp.NE:
        System.out.println( " != " );
        break;
      case OpExp.EQUALS:
        System.out.println( " = " );
        break;
      default:
        System.out.println( "Unrecognized operator at line " + tree.pos);
    }
    spaces += SPACES;
    showTree( tree.left, spaces );
    showTree( tree.right, spaces ); 
  }

  static private void showTree( AssignExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "AssignExp:" );
    spaces += SPACES;
    showTree( tree.lhs, spaces );
    showTree( tree.rhs, spaces );
  }


  /* ----------------------------Dec Section-------------------- */
  static private void showTree( Dec tree, int spaces ) {
    if( tree instanceof FunctionDec )
      showTree( (FunctionDec)tree, spaces );
    else if( tree instanceof SimpleDec )
      showTree( (SimpleDec)tree, spaces );
    else if( tree instanceof ArrayDec )
      showTree( (ArrayDec)tree, spaces );
    else {
      indent( spaces );
      System.out.println( "Illegal expression at line " + tree.pos  );
    }
  }

  static private void showTree( FunctionDec tree, int spaces ) {
    indent( spaces );
    System.out.println( "FunctionDec:" + tree.result.toString() + " " + tree.func);
    spaces += SPACES;
    showTree( tree.params, spaces );
    showTree( tree.body, spaces );
  }

   static private void showTree( SimpleDec tree, int spaces ) {
    if(tree == null) {
      return;
    }
    indent( spaces );
    System.out.println( "SimpleDec:" + tree.typ.toString() + " " + tree.name);
    spaces += SPACES;
  }

  static private void showTree( ArrayDec tree, int spaces ) {
    if(tree == null) {
      return;
    }
    indent( spaces );
    System.out.println( "ArrayDec: " + tree.typ.toString() + " " + tree.name + "[]");
    spaces += SPACES;
    showTree( tree.size, spaces + SPACES);
  }

   /* ----------------------------Params Section-------------------- */

  static private void showTree(Params tree, int spaces) {
    indent(spaces);
    System.out.println("Params:");
    spaces += SPACES;
    if(tree.voidP){
      indent(spaces);
      System.out.println("VOID");
    }
    else
      showTree(tree.pList, spaces);
  }

  static private void showTree(Param tree, int spaces) {
    indent(spaces);
    if (tree.array)
      System.out.println("Param: " + tree.typ.toString() + " " + tree.id + "[]");
    else
      System.out.println("Param: " + tree.typ.toString() + " " + tree.id );
  }

   /* ----------------------------Statement Section-------------------- */

  static private void showTree( Stmt tree, int spaces ) {
    if( tree instanceof WhileStmt )
      showTree( (WhileStmt)tree, spaces );
    else if( tree instanceof ReturnStmt )
      showTree( (ReturnStmt)tree, spaces );
    else if( tree instanceof CompoundStmt ) 
      showTree( (CompoundStmt)tree, spaces );
    else if( tree instanceof ExpStmt )
      showTree( (ExpStmt)tree, spaces );
    else if( tree instanceof SelectStmt ) 
      showTree( (SelectStmt)tree, spaces );
  }

  static private void showTree( WhileStmt tree, int spaces ) {
    indent( spaces );
    System.out.println( "WhileStmt:" );
    spaces += SPACES;
    showTree( tree.test, spaces );
    showTree( tree.body, spaces );
  }

  static private void showTree( ExpStmt tree, int spaces ) {
    indent( spaces );
    System.out.println( "ExpStmt:" );
    spaces += SPACES;
    showTree( tree.exp, spaces  ); 
  }

  static private void showTree( CompoundStmt tree, int spaces ) {
    indent( spaces );
    System.out.println( "CompoundStmt:" );
    spaces += SPACES;
    showTree( tree.decs, spaces );
    showTree( tree.stmts, spaces );
  }

  static private void showTree( ReturnStmt tree, int spaces) {
    indent(spaces);
    System.out.println( "ReturnStmt:" );
    spaces += SPACES;
    if (tree.exp != null)
      showTree(tree.exp, spaces);
    else{
      indent(spaces);
      System.out.println("No Return Value");
    }
  }
  
  static private void showTree( SelectStmt tree, int spaces ) {
    indent( spaces );
    System.out.println( "SelectStmt:" );
    spaces += SPACES;
    showTree( tree.test, spaces );
    showTree( tree.thenpart, spaces );
    if (tree.elsepart != null) {
      showTree( tree.elsepart, spaces );
    }
  }

}
