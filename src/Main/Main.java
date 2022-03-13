package Main;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import Main.Element.Element;
import Main.Interpreter.Interpreter;
import Main.Types.*;
import Main.parser.Parser;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("You should specify the path to the file f");
            return;
        }

        ElementsList ast = Parser.buildAST(args[0]);

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
}