package symbols;

import absyn.*;

public class SymTable {

	private final static int SPACES = 4;

	// Go over this
	public SymTable() {
		this.scope();
		SymFunction input = new SymFunction("input", 4, NameTy.INT);
		SymFunction output = new SymFunction("output", 7, NameTy.VOID);
		output.addParameter(new IntSym("x",0))// *******
		this.addSym(input);
		this.addSym(output);
	}

	/* ----------------------------Showing Table-------------------- */

	/* ---------------------------- Lists -------------------------- */
	public void showTable(DecList tree, int spaces) {
		while (tree != null){
			showTable(tree.head, spaces);
			tree = tree.tail;
		}
		System.out.println("Global Scope:");
		spaces += SPACES;
		//print scope
	}

	public void showTable(DecLocalList tree, int spaces) {
		while (tree != null) {
			showTable(tree.head, spaces);
			tree = tree.tail;
		}
	}

	public void showTable(ParamList tree, int spaces ) {
		while(tree != null) {
			showTable(tree.head, spaces);
			tree = tree.tail;
		}
	}

	public void showTable(StmtList tree, int spaces, SymFunction fnc ) {
		while(tree != null) {
			showTable(tree.head, spaces);
			tree = tree.tail;
		}
	}

	// *** FIX ME
	public void showTable(ExpList tree, int spaces, ) {
		while (tree != null) {
			if(tree.head instanceof VarExp){
				VarExp var = (VarExp) tree.head;
				// add Functionality -> understand it
			}
			showTable(tree.head, spaces);
			tree = tree.tail;
		}
	}

	/* ---------------------------- Declarations -------------------- */
	public void showTable(Dec tree, int spaces) {
		if( tree instanceof FunctionDec)
			showTable( (FunctionDec)tree, spaces);
		else if( tree instanceof SimpleDec)
			showTable( (SimpleDec)tree, spaces);
		else if( tree instanceof ArrayDec )
			showTable( (ArrayDec)tree, spaces);
		else{/*Do nothing*/}
	}

	// Made to Variable declarations, err check here
	// ***** CHECK OVER
	private void showTable(FunctionDec tree, int spaces) {
		spaces += SPACES;
		indent(spaces);
		System.out.println("Local Scope -> " + tree.name + ":");
		Sym s = new SymFunction(tree.name, 0, tree.typ.toString());
		if(!this.addSym(s)) {
			indent(spaces);
			System.out.println("Error redefining function.");
		}
		//Change function names!!!
		this.scope();
		spaces += SPACES;
		showTable(tree.params, spaces);
		showTable(tree.body, spaces);
		this.printScope(spaces);
		this leaveScope();
	}

	private void showTable(SimpleDec tree, int spaces) {
		Sym s = new SymInt(tree.name, tree.size);
		if(!this.addSym(s)){
			indent(spaces);
			System.out.println("Error redefining variable at " + (tree.pos +1) + ".");
		}
	}

	private void showTable(ArrayDec tree, int spaces) {
		Sym s = new SymArray(tree.name, tree.size);
		if(!this.addSym(s)){
			indent(spaces);
			System.out.println("Error redefining variable at " + (tree.pos +1) + ".");
		}
	}

	/* ---------------------------- Parameters -------------------- */
	private void showTable(Params tree, int spaces) {
		// Check if parameters are void
		if(!tree.voidP) {
			showTable(tree.pList, spaces);
		}
	}

	private void showTable(Param tree, int spaces) {
		if(tree.array) {
			Sym s = new SymArray(tree.id, 0);
			if(!this.addSym(s)){
				indent(spaces);
				System.out.println("Error redefining parameter.");
			}
			else {
				this.currFnc.addParameter(s);
			}
		}
		else {
			Sym s = new SymInt(tree.id, 0);
			if(!this.addSym(s)){
				indent(spaces);
				System.out.println("Error redefining parameter.");
			}
			else {
				this.currFnc.addParameter(s);
			}
		}
	}

	/* ---------------------------- Statements -------------------- */

	public void showTable(Stmt tree, int spaces) {
		if(tree instanceof CompundStmt){
			indent(spaces);
			System.out.println("Local block:");
			this.scope();
			spaces += SPACES;
			showTable((CompoundStatement)tree, spaces);
			this.printScope(spaces);
			this.leaveScope();
		}
		else if(tree instanceof ExpStmt)
			showTable((ExpStmt)tree, spaces);
		else if (tree instanceof SelectStmt)
			showTable((SelectStmt)tree, spaces)
		else if (tree instanceof WhileStmt)
			showTable((WhileStmt)tree, spaces);
		else if (tree instanceof ReturnStmt)
			showTable((ReturnStmt)tree, spaces);
		else {
			indent(spaces);
			System.out.println("Illegal expression at line " + tree.pos );
		}
	}

	private void showTable(CompoundStatement tree, int spaces) {
		showTable(tree.decs, spaces);
		showTable(tree.stmts, spaces);
	}

	private void showTable(ExpStmt tree, int spaces) {
		showTable(tree.exp, int spaces);
	}

	// fix me
	private void showTable(SelectStmt tree, int spaces) {
		showTable(tree.decs, spaces);
		showTable(tree.stmts, spaces);
	}

	// fix me
	private void showTable(WhileStmt tree, int spaces) {
		showTable(tree.exp, int spaces);
	}

	// fix me
	private void showTable(ReturnStmt tree, int spaces) {
		showTable(tree.exp, int spaces);
	}

	/* ---------------------------- Expressions -------------------- */

	public void showTable(Exp tree, int spaces) {
		if(tree instanceof AssignExp)
			showTable((AssignExp)tree, spaces);
		else if( tree instanceof VarExp )
      		showTree( (VarExp)tree, spaces );
   		else if( tree instanceof IntExp )
       		showTree( (IntExp)tree, spaces );
    	else if( tree instanceof CallExp )
      		showTree( (CallExp)tree, spaces );
    	else if( tree instanceof OpExp )
      		showTree( (OpExp)tree, spaces );
      	else {
   			indent( spaces );
      		System.out.println( "Illegal expression at line " + tree.pos  );
   		}
	}

	private void showTable(AssignExp tree, int spaces) {
		showTable(tree.exp, int spaces);
	}

	private void showTable(VarExp tree, int spaces) {
		showTable(tree.exp, int spaces);
	}

	private void showTable(IntExp tree, int spaces) {
		showTable(tree.exp, int spaces);
	}

	private void showTable(CallExp tree, int spaces) {
		showTable(tree.exp, int spaces);
	}

	private void showTable(OpExp tree, int spaces) {
		showTable(tree.exp, int spaces);
	}

}