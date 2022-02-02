package Main;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import Main.LexicalAnalysis.LexicalAnalysis;
import Main.Token.Token;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Input the name of .f file (like 'Name.f') or press Enter to watch a sample file: ");
        Scanner in = new Scanner(System.in);
        Path pathToFile = Paths.get(in.nextLine());
		in.close();
	
		LexicalAnalysis la = new LexicalAnalysis(pathToFile);
		ArrayList<Token> tokens = la.tokenize();

		for (Token token : tokens) {
			System.out.println(
				token
			);
		}
    }
}