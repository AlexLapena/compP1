/*
  Alex Lapena
  Loai Shaheen
*/
   
import java.io.*;
import java.util.*;   

class Main {
  static public void main(String args[]) {  
    List<String> argsList = new ArrayList<String>();
    String fName;

    /* Determine the mode */
    for (int i = 0; i < args.length - 1; i++) {
      // Syntax Tree
      if(args[i].equals("-a")){
        argsList.add("-a");
      }
      // Symbol Table
      if(args[i].equals("-s")){
        argsList.add("-s");
      }

    }

    fName = args[args.length - 1];
    /* Start the parser */
    try {
      parser p = new parser(fName, argsList, new Lexer(new FileReader(fName)));
      Object result = p.parse().value;      
    } catch (Exception e) {
      /* do cleanup here -- possibly rethrow e */
      e.printStackTrace();
    }
  }
}


