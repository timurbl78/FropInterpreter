package Main;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.io.File; 
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.FileWriter;

import Main.Interpreter.*;
import Main.Types.*;
import Main.Element.*;
import Main.parser.*;

public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println("You should specify the path to the file f");
            return;
        }
        
        String pathToFile = args[0];
        File newFile = tempWithoutComments(pathToFile);

        if (newFile.length()==0) {
            System.out.println("No such file, check the path");
            return;
        }

        ElementsList ast = Parser.buildAST(newFile.getAbsolutePath());

        PrintWriter writer = new PrintWriter("AST.json", StandardCharsets.UTF_8);
        writer.print(ast);
        writer.close();

        Interpreter interpreter = new Interpreter();
        System.out.println("AST tree was built. Please, check file 'FropInterpreter/AST.json'");
        
        int i = 0;
        assert ast != null;
        for (Element elem : ast) {
            try {
                interpreter.stackTrace.add(new StackTraceElement("", "main", "", Parser.lines.get(i++)));
                Element calculated = interpreter.calc(elem);
                if (calculated != null) {
                    System.out.println(calculated);
                }
                interpreter.stackTrace.pop();
            } catch (Error e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
    }
    public static File tempWithoutComments(String pathToFile) throws IOException{
        Pattern pattern = Pattern.compile("#.*$");
         try {
          File myFile = new File(pathToFile);
          Scanner myReader = new Scanner(myFile);
          StringBuffer bf = new StringBuffer();
          String data = myReader.nextLine();
          Matcher match = pattern.matcher(data);
          data = match.replaceAll("");
          bf.append(data);
          while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            match = pattern.matcher(data);
            data = match.replaceAll("");
            bf.append(System.lineSeparator()+data);
          }
          myReader.close();
          String fileContents = bf.toString();
          String tempFileName = myFile.getParent()+"\\temp"+myFile.getName();
          File tempFile = File.createTempFile(tempFileName, "");
          tempFile.getName();
          FileWriter wr = new FileWriter(tempFile);
          wr.write(fileContents);
          wr.close();
          tempFile.deleteOnExit();
          return tempFile;
        } catch (FileNotFoundException e) {
          File notFoundCase = File.createTempFile(pathToFile, "");
          notFoundCase.deleteOnExit();
          return notFoundCase;
        }
      }
}