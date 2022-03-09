package Main;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import Main.Types.*;
import Main.parser.Parser;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO: args: filePath
        ElementsList ast = Parser.buildAST("/Users/timurbl/inno/FropInterpreter/src/tests/frop.f");

        PrintWriter writer = new PrintWriter("AST.json", StandardCharsets.UTF_8);
        writer.print(ast);
        writer.close();

        System.out.println("AST tree was built. Please, check file 'FropInterpreter/AST.json'");
    }
}