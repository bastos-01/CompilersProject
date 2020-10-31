import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.*;


public class MainGramMain {
   public static void main(String[] args) throws Exception {
      CharStream input =null;
      try{
         //read file
         input = CharStreams.fromStream(new FileInputStream(args[0]));
      }
      catch(Exception e){
         ErrorHandling.printError("Couldn't find the file \"" + args[0] + "\"");
         System.exit(1);
      }
   
      // create a lexer that feeds off of input CharStream:
      MainGramLexer lexer = new MainGramLexer(input);
      // create a buffer of tokens pulled from the lexer:
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      // create a parser that feeds off the tokens buffer:
      MainGramParser parser = new MainGramParser(tokens);
      // replace error listener:
      //parser.removeErrorListeners(); // remove ConsoleErrorListener
      //parser.addErrorListener(new ErrorHandlingListener());
      // begin parsing at main rule:
      ParseTree tree = parser.main();
      if (parser.getNumberOfSyntaxErrors() == 0) {

         MainGramCheck visitor0 = new MainGramCheck();
         visitor0.visit(tree);
         if(!ErrorHandling.error()){
         Compiler compiler = new Compiler();
         String outputLang = "java";
            if (!compiler.validTarget(outputLang)) {
               ErrorHandling.printError("Can't find template group file for " + outputLang);
               System.exit(1);
            }
            compiler.setTarget(outputLang);
            ST code = compiler.visit(tree);

            String outputFileName = "output";

            String outputFileExtension =  "." + outputLang;

            String outputFile = outputFileName + outputFileExtension;

            try {
               code.add("name", outputFileName);
               PrintWriter pw = new PrintWriter(new File(outputFile));
               pw.print(code.render());
               pw.close();

            } catch (FileNotFoundException e) {
               System.err.println("Could not write code to the file");
               System.exit(1);
            }
      }
   }
   }
}
