package Main.LexicalAnalysis;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import Main.Token.SubTokens.SubTokens;
import Main.Token.Token;
import Main.Token.Span.Span;
import Main.Types.Bracket.BracketClose.BracketClose;
import Main.Types.Bracket.BracketOpen.BracketOpen;
import Main.Types.Delimeter.LineDelimeter.LineDelimeter;
import Main.Types.Delimeter.SpaceDelimeter.SpaceDelimeter;
import Main.Types.Function.Function;
import Main.Types.Identifier.Identifier;
import Main.Types.Literal.BooleanLiteral.BooleanLiteral;
import Main.Types.Literal.IntegerLiteral.IntegerLiteral;
import Main.Types.Literal.NullLiteral.NullLiteral;
import Main.Types.Literal.RealLiteral.RealLiteral;
import Main.Types.SpecialForm.SpecialForm;

public class LexicalAnalysis {
    private final Path pathToFile;
    private static final String [] SPECIAL_FORMS = {"quote", "setq", "func", "lambda", "prog", "cond", "while", "return", "break"};
    private static final HashMap<String, SubTokens> SPECIAL_FORMS_TO_TOKENS = new HashMap<>() {{
        put("quote", SubTokens.TOK_QUOTE);
        put("setq", SubTokens.TOK_SETQ);
        put("func", SubTokens.TOK_FUNC);
        put("lambda", SubTokens.TOK_LAMBDA);
        put("prog", SubTokens.TOK_PROG);
        put("cond", SubTokens.TOK_COND);
        put("while", SubTokens.TOK_WHILE);
        put("return", SubTokens.TOK_RETURN);
        put("break", SubTokens.TOK_BREAK);
    }};
    private static final String [] FUNCTIONS = {"plus", "minus", "times", "divide", "head", "tail", "cons", "equal", "nonequal", "less", "lesseq", "greater", "greatereq", "isint", "isreal", "isbool", "isnull", "isatom", "islist", "and", "or", "xor", "not", "eval"};
    private static final HashMap<String, SubTokens> FUNCTIONS_TO_TOKENS = new HashMap<>() {{
        put("plus", SubTokens.TOK_PLUS);
        put("minus", SubTokens.TOK_MINUS);
        put("times", SubTokens.TOK_TIMES);
        put("divide", SubTokens.TOK_DIVIDE);
        put("head", SubTokens.TOK_HEAD);
        put("tail", SubTokens.TOK_TAIL);
        put("cons", SubTokens.TOK_CONS);
        put("equal", SubTokens.TOK_EQUAL);
        put("nonequal", SubTokens.TOK_NONEQUAL);
        put("less", SubTokens.TOK_LESS);
        put("lesseq", SubTokens.TOK_LESSEQ);
        put("greater", SubTokens.TOK_GREATER);
        put("greatereq", SubTokens.TOK_GREATEREQ);
        put("isint", SubTokens.TOK_ISINT);
        put("isreal", SubTokens.TOK_ISREAL);
        put("isbool", SubTokens.TOK_ISBOOL);
        put("isnull", SubTokens.TOK_ISNULL);
        put("isatom", SubTokens.TOK_ISATOM);
        put("islist", SubTokens.TOK_ISLIST);
        put("and", SubTokens.TOK_AND);
        put("or", SubTokens.TOK_OR);
        put("xor", SubTokens.TOK_XOR);
        put("not", SubTokens.TOK_NOT);
        put("eval", SubTokens.TOK_EVAL);
    }};
    private static final String [] BOOLEAN = {"true", "false"};
    private static final String [] NULL = {"null"};
    private static final String [] BRACKETS = {"(", ")"};
    private static final String [] DELIMETERS = {" ", "\n", "\t"};

    public LexicalAnalysis(Path pathToFile) {
        this.pathToFile = pathToFile;
    }

    public ArrayList<Token> tokenize() throws IOException {
        ArrayList<Token> tokens = new ArrayList<>();
        BufferedReader bufferedReader = Files.newBufferedReader(this.pathToFile);
        String line;

        int lineNum = 0, posBegin, posEnd;

        boolean isReady = bufferedReader.ready();

        while(isReady) {
            line = bufferedReader.readLine();
            lineNum++;
            int lenght = line.length();
            int index = 0;
            while (index < lenght) {
                String c = String.valueOf(line.charAt(index));
                
                if (Arrays.asList(BRACKETS).contains(c)) {
                     if (c.equals("(")) {
                         tokens.add(new BracketOpen(new Span(lineNum, index + 1, index + 1)));
                     } else {
                         tokens.add(new BracketClose(new Span(lineNum, index + 1, index + 1)));
                     }
                    System.out.println("Pos: " + lineNum + " " + (index + 1) + " Bracket:" + c);
                } else if (Arrays.asList(DELIMETERS).contains(c)) {
                    if (c.equals(" ")) {
                        tokens.add(new SpaceDelimeter(new Span(lineNum, index + 1, index + 1)));
                    } else {
                        tokens.add(new LineDelimeter(new Span(lineNum, index + 1, index + 1)));
                    }
                    System.out.println("Pos: " + lineNum + " " + (index + 1) + " Delimeter:" + c);
                } else {
                    posBegin = index;
                    posEnd = index;
                    while (!Arrays.asList(BRACKETS).contains(c) && !Arrays.asList(DELIMETERS).contains(c)) {
                        posEnd++;
                        c = String.valueOf(line.charAt(posEnd));
                    }

                    String word = line.substring(posBegin, posEnd);
                    Span span = new Span(lineNum, posBegin, posEnd);

                    if (SPECIAL_FORMS_TO_TOKENS.containsKey(word)) {
                        tokens.add(new SpecialForm(
                                SPECIAL_FORMS_TO_TOKENS.get(word),
                                span
                        ));
                    } else if (FUNCTIONS_TO_TOKENS.containsKey(word)) {
                        tokens.add(new Function(
                                FUNCTIONS_TO_TOKENS.get(word),
                                span
                        ));
                    } else if (Arrays.asList(BOOLEAN).contains(word)) {
                        tokens.add(new BooleanLiteral(word, span));
                    } else if (Arrays.asList(NULL).contains(word)) {
                        tokens.add(new NullLiteral(span));
                    } else if (Character.isDigit(word.charAt(0))) {
                        int numberInt;
                        double numberReal;
                        try {
                            numberInt = Integer.parseInt(word);
                            tokens.add(new IntegerLiteral(
                                    numberInt,
                                    span
                            ));
                            index = posEnd;
                            continue;
                        } catch (NumberFormatException ignored) {}
                        try {
                            numberReal = Double.parseDouble(word);
                            tokens.add(new RealLiteral(
                                    numberReal,
                                    span
                            ));
                            index = posEnd;
                            continue;
                        } catch (NumberFormatException ignored) {}
                        // TODO: throw err "A literal cannot start with a digit"
                    } else {
                        tokens.add(new Identifier(
                            word,
                            span
                        ));
                        // TODO: throw err "A literal can contain only numbers and letters"
                    }
                    
                    index = posEnd - 1;
                }

                index++;
            }
            isReady = bufferedReader.ready();
            if (isReady) {
                System.out.println("Pos: " + lineNum + " " + (index + 1) + " Delimeter:" + "\n");
            }
            tokens.add(new LineDelimeter(new Span(lineNum, index + 1, index + 1)));
        }
        return tokens;
    }
}
