/* A Bison parser, made by GNU Bison 3.8.2.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2021 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */

package Main.parser;



import java.text.MessageFormat;
import java.util.ArrayList;
/* "%code imports" blocks.  */
/* "parser.y":16  */

import java.io.IOException;
import java.util.*;
import Main.Types.*;
import Main.Element.Element;
import Main.Position.Position;

/* "parser.java":53  */

/**
 * A Bison parser, automatically generated from <tt>parser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class Parser
{
  /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.8.2";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";





  /**
   * A class defining a pair of positions.  Positions, defined by the
   * <code>Position</code> class, denote a point in the input.
   * Locations represent a part of the input through the beginning
   * and ending positions.
   */
  public static class Location {
    /**
     * The first, inclusive, position in the range.
     */
    public Position begin;

    /**
     * The first position beyond the range.
     */
    public Position end;

    /**
     * Create a <code>Location</code> denoting an empty range located at
     * a given point.
     * @param loc The position at which the range is anchored.
     */
    public Location (Position loc) {
      this.begin = this.end = loc;
    }

    /**
     * Create a <code>Location</code> from the endpoints of the range.
     * @param begin The first position included in the range.
     * @param end   The first position beyond the range.
     */
    public Location (Position begin, Position end) {
      this.begin = begin;
      this.end = end;
    }

    /**
     * Print a representation of the location.  For this to be correct,
     * <code>Position</code> should override the <code>equals</code>
     * method.
     */
    public String toString() {
      if (begin.equals (end))
        return begin.toString();
      else
        return begin.toString() + "-" + end.toString();
    }
  }

  private Location yylloc(YYStack rhs, int n)
  {
    if (0 < n)
      return new Location(rhs.locationAt(n-1).begin, rhs.locationAt(0).end);
    else
      return new Location(rhs.locationAt(0).end);
  }

  public enum SymbolKind
  {
    S_YYEOF(0),                    /* "end of file"  */
    S_YYerror(1),                  /* error  */
    S_YYUNDEF(2),                  /* "invalid token"  */
    S_TOK_INTEGER_LITERAL(3),      /* TOK_INTEGER_LITERAL  */
    S_TOK_REAL_LITERAL(4),         /* TOK_REAL_LITERAL  */
    S_TOK_BOOLEAN_LITERAL(5),      /* TOK_BOOLEAN_LITERAL  */
    S_TOK_NULL_LITERAL(6),         /* TOK_NULL_LITERAL  */
    S_TOK_IDENTIFIER(7),           /* TOK_IDENTIFIER  */
    S_TOK_OPEN_BRACKET(8),         /* "("  */
    S_TOK_CLOSE_BRACKET(9),        /* ")"  */
    S_TOK_QUOTE_SIGN(10),          /* "'"  */
    S_TOK_QUOTE(11),               /* TOK_QUOTE  */
    S_TOK_SETQ(12),                /* TOK_SETQ  */
    S_TOK_FUNC(13),                /* TOK_FUNC  */
    S_TOK_LAMBDA(14),              /* TOK_LAMBDA  */
    S_TOK_PROG(15),                /* TOK_PROG  */
    S_TOK_COND(16),                /* TOK_COND  */
    S_TOK_WHILE(17),               /* TOK_WHILE  */
    S_TOK_RETURN(18),              /* TOK_RETURN  */
    S_TOK_BREAK(19),               /* TOK_BREAK  */
    S_YYACCEPT(20),                /* $accept  */
    S_program(21),                 /* program  */
    S_element(22),                 /* element  */
    S_identifier(23),              /* identifier  */
    S_literal(24),                 /* literal  */
    S_list(25),                    /* list  */
    S_list_elements(26),           /* list_elements  */
    S_special_form(27),            /* special_form  */
    S_list_of_ids(28),             /* list_of_ids  */
    S_ids_sequence(29);            /* ids_sequence  */


    private final int yycode_;

    SymbolKind (int n) {
      this.yycode_ = n;
    }

    private static final SymbolKind[] values_ = {
      SymbolKind.S_YYEOF,
      SymbolKind.S_YYerror,
      SymbolKind.S_YYUNDEF,
      SymbolKind.S_TOK_INTEGER_LITERAL,
      SymbolKind.S_TOK_REAL_LITERAL,
      SymbolKind.S_TOK_BOOLEAN_LITERAL,
      SymbolKind.S_TOK_NULL_LITERAL,
      SymbolKind.S_TOK_IDENTIFIER,
      SymbolKind.S_TOK_OPEN_BRACKET,
      SymbolKind.S_TOK_CLOSE_BRACKET,
      SymbolKind.S_TOK_QUOTE_SIGN,
      SymbolKind.S_TOK_QUOTE,
      SymbolKind.S_TOK_SETQ,
      SymbolKind.S_TOK_FUNC,
      SymbolKind.S_TOK_LAMBDA,
      SymbolKind.S_TOK_PROG,
      SymbolKind.S_TOK_COND,
      SymbolKind.S_TOK_WHILE,
      SymbolKind.S_TOK_RETURN,
      SymbolKind.S_TOK_BREAK,
      SymbolKind.S_YYACCEPT,
      SymbolKind.S_program,
      SymbolKind.S_element,
      SymbolKind.S_identifier,
      SymbolKind.S_literal,
      SymbolKind.S_list,
      SymbolKind.S_list_elements,
      SymbolKind.S_special_form,
      SymbolKind.S_list_of_ids,
      SymbolKind.S_ids_sequence
    };

    static final SymbolKind get(int code) {
      return values_[code];
    }

    public final int getCode() {
      return this.yycode_;
    }

    /* YYNAMES_[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
       First, the terminals, then, starting at \a YYNTOKENS_, nonterminals.  */
    private static final String[] yynames_ = yynames_init();
  private static final String[] yynames_init()
  {
    return new String[]
    {
  "end of file", "error", "invalid token", "TOK_INTEGER_LITERAL",
  "TOK_REAL_LITERAL", "TOK_BOOLEAN_LITERAL", "TOK_NULL_LITERAL",
  "TOK_IDENTIFIER", "(", ")", "'", "TOK_QUOTE", "TOK_SETQ", "TOK_FUNC",
  "TOK_LAMBDA", "TOK_PROG", "TOK_COND", "TOK_WHILE", "TOK_RETURN",
  "TOK_BREAK", "$accept", "program", "element", "identifier", "literal",
  "list", "list_elements", "special_form", "list_of_ids", "ids_sequence", null
    };
  }

    /* The user-facing name of this symbol.  */
    public final String getName() {
      return yynames_[yycode_];
    }
  };


  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>Parser</tt>.
   */
  public interface Lexer {
    /* Token kinds.  */
    /** Token "end of file", to be returned by the scanner.  */
    static final int YYEOF = 0;
    /** Token error, to be returned by the scanner.  */
    static final int YYerror = 256;
    /** Token "invalid token", to be returned by the scanner.  */
    static final int YYUNDEF = 257;
    /** Token TOK_INTEGER_LITERAL, to be returned by the scanner.  */
    static final int TOK_INTEGER_LITERAL = 258;
    /** Token TOK_REAL_LITERAL, to be returned by the scanner.  */
    static final int TOK_REAL_LITERAL = 259;
    /** Token TOK_BOOLEAN_LITERAL, to be returned by the scanner.  */
    static final int TOK_BOOLEAN_LITERAL = 260;
    /** Token TOK_NULL_LITERAL, to be returned by the scanner.  */
    static final int TOK_NULL_LITERAL = 261;
    /** Token TOK_IDENTIFIER, to be returned by the scanner.  */
    static final int TOK_IDENTIFIER = 262;
    /** Token "(", to be returned by the scanner.  */
    static final int TOK_OPEN_BRACKET = 263;
    /** Token ")", to be returned by the scanner.  */
    static final int TOK_CLOSE_BRACKET = 264;
    /** Token "'", to be returned by the scanner.  */
    static final int TOK_QUOTE_SIGN = 265;
    /** Token TOK_QUOTE, to be returned by the scanner.  */
    static final int TOK_QUOTE = 266;
    /** Token TOK_SETQ, to be returned by the scanner.  */
    static final int TOK_SETQ = 267;
    /** Token TOK_FUNC, to be returned by the scanner.  */
    static final int TOK_FUNC = 268;
    /** Token TOK_LAMBDA, to be returned by the scanner.  */
    static final int TOK_LAMBDA = 269;
    /** Token TOK_PROG, to be returned by the scanner.  */
    static final int TOK_PROG = 270;
    /** Token TOK_COND, to be returned by the scanner.  */
    static final int TOK_COND = 271;
    /** Token TOK_WHILE, to be returned by the scanner.  */
    static final int TOK_WHILE = 272;
    /** Token TOK_RETURN, to be returned by the scanner.  */
    static final int TOK_RETURN = 273;
    /** Token TOK_BREAK, to be returned by the scanner.  */
    static final int TOK_BREAK = 274;

    /** Deprecated, use YYEOF instead.  */
    public static final int EOF = YYEOF;

    /**
     * Emit an error referring to the given locationin a user-defined way.
     *
     * @param loc The location of the element to which the
     *                error message is related.
     * @param msg The string for the error message.
     */
     void yyerror(Location loc, String msg);


    /**
     * Build and emit a "syntax error" message in a user-defined way.
     *
     * @param ctx  The context of the error.
     */
     void reportSyntaxError(Context ctx);

  }


  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;





  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public Parser(Lexer yylexer)
  {

    this.yylexer = yylexer;

  }


  private java.io.PrintStream yyDebugStream = System.err;

  /**
   * The <tt>PrintStream</tt> on which the debugging output is printed.
   */
  public final java.io.PrintStream getDebugStream() { return yyDebugStream; }

  /**
   * Set the <tt>PrintStream</tt> on which the debug output is printed.
   * @param s The stream that is used for debugging output.
   */
  public final void setDebugStream(java.io.PrintStream s) { yyDebugStream = s; }

  private int yydebug = 0;

  /**
   * Answer the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   */
  public final int getDebugLevel() { return yydebug; }

  /**
   * Set the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   * @param level The verbosity level for debugging output.
   */
  public final void setDebugLevel(int level) { yydebug = level; }


  private int yynerrs = 0;

  /**
   * The number of syntax errors so far.
   */
  public final int getNumberOfErrors() { return yynerrs; }

  /**
   * Print an error message via the lexer.
   * Use a <code>null</code> location.
   * @param msg The error message.
   */
  public final void yyerror(String msg) {
      yylexer.yyerror((Location)null, msg);
  }

  /**
   * Print an error message via the lexer.
   * @param loc The location associated with the message.
   * @param msg The error message.
   */
  public final void yyerror(Location loc, String msg) {
      yylexer.yyerror(loc, msg);
  }

  /**
   * Print an error message via the lexer.
   * @param pos The position associated with the message.
   * @param msg The error message.
   */
  public final void yyerror(Position pos, String msg) {
      yylexer.yyerror(new Location (pos), msg);
  }

  protected final void yycdebugNnl(String s) {
    if (0 < yydebug)
      yyDebugStream.print(s);
  }

  protected final void yycdebug(String s) {
    if (0 < yydebug)
      yyDebugStream.println(s);
  }

  private final class YYStack {
    private int[] stateStack = new int[16];
    private Location[] locStack = new Location[16];
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push(int state, Object value, Location loc) {
      height++;
      if (size == height) {
        int[] newStateStack = new int[size * 2];
        System.arraycopy(stateStack, 0, newStateStack, 0, height);
        stateStack = newStateStack;
        Location[] newLocStack = new Location[size * 2];
        System.arraycopy(locStack, 0, newLocStack, 0, height);
        locStack = newLocStack;

        Object[] newValueStack = new Object[size * 2];
        System.arraycopy(valueStack, 0, newValueStack, 0, height);
        valueStack = newValueStack;

        size *= 2;
      }

      stateStack[height] = state;
      locStack[height] = loc;
      valueStack[height] = value;
    }

    public final void pop() {
      pop(1);
    }

    public final void pop(int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (0 < num) {
        java.util.Arrays.fill(valueStack, height - num + 1, height + 1, null);
        java.util.Arrays.fill(locStack, height - num + 1, height + 1, null);
      }
      height -= num;
    }

    public final int stateAt(int i) {
      return stateStack[height - i];
    }


    public final Location locationAt(int i) {
      return locStack[height - i];
    }

    public final Object valueAt(int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print(java.io.PrintStream out) {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++) {
        out.print(' ');
        out.print(stateStack[i]);
      }
      out.println();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;


  /**
   * Returned by a Bison action in order to request a new token.
   */
  public static final int YYPUSH_MORE = 4;

  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;
  private static final int YYGETTOKEN = 9; /* Signify that a new token is expected when doing push-parsing.  */

  private int yyerrstatus_ = 0;


    /* Lookahead token kind.  */
    int yychar = YYEMPTY_;
    /* Lookahead symbol kind.  */
    SymbolKind yytoken = null;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;


    /* The location where the error started.  */
    Location yyerrloc = null;

    /* Location. */
    Location yylloc = new Location (null, null);

    /* Semantic value of the lookahead.  */
    Object yylval = null;

  /**
   * Whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yyLRGotoState(int yystate, int yysym) {
    int yyr = yypgoto_[yysym - YYNTOKENS_] + yystate;
    if (0 <= yyr && yyr <= YYLAST_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - YYNTOKENS_];
  }

  private int yyaction(int yyn, YYStack yystack, int yylen)
  {
    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    Object yyval = (0 < yylen) ? yystack.valueAt(yylen - 1) : yystack.valueAt(0);
    Location yyloc = yylloc(yystack, yylen);

    yyReducePrint(yyn, yystack);

    switch (yyn)
      {
          case 2: /* program: %empty  */
  if (yyn == 2)
    /* "parser.y":82  */
                                                           { ast = new ElementsList(); };
  break;


  case 3: /* program: program element  */
  if (yyn == 3)
    /* "parser.y":83  */
                                                           { ast.add(((Element)(yystack.valueAt (0)))); };
  break;


  case 4: /* element: identifier  */
  if (yyn == 4)
    /* "parser.y":87  */
                                                           { yyval = ((Identifier)(yystack.valueAt (0))); };
  break;


  case 5: /* element: literal  */
  if (yyn == 5)
    /* "parser.y":88  */
                                                           { yyval = ((Element)(yystack.valueAt (0))); };
  break;


  case 6: /* element: list  */
  if (yyn == 6)
    /* "parser.y":89  */
                                                           { yyval = ((Element)(yystack.valueAt (0))); };
  break;


  case 7: /* element: "'" element  */
  if (yyn == 7)
    /* "parser.y":90  */
                                                           { yyval = new QuoteSpecialForm(((Element)(yystack.valueAt (0)))); };
  break;


  case 9: /* literal: TOK_INTEGER_LITERAL  */
  if (yyn == 9)
    /* "parser.y":98  */
                                                           { yyval = ((IntegerLiteral)(yystack.valueAt (0))); };
  break;


  case 10: /* literal: TOK_REAL_LITERAL  */
  if (yyn == 10)
    /* "parser.y":99  */
                                                           { yyval = ((RealLiteral)(yystack.valueAt (0))); };
  break;


  case 11: /* literal: TOK_BOOLEAN_LITERAL  */
  if (yyn == 11)
    /* "parser.y":100  */
                                                           { yyval = ((BooleanLiteral)(yystack.valueAt (0))); };
  break;


  case 12: /* literal: TOK_NULL_LITERAL  */
  if (yyn == 12)
    /* "parser.y":101  */
                                                           { yyval = ((NullLiteral)(yystack.valueAt (0))); };
  break;


  case 13: /* list: "(" list_elements ")"  */
  if (yyn == 13)
    /* "parser.y":104  */
                                                           { yyval = ((ElementsList)(yystack.valueAt (1))); };
  break;


  case 14: /* list: "(" special_form ")"  */
  if (yyn == 14)
    /* "parser.y":105  */
                                                           { yyval = ((Element)(yystack.valueAt (1))); };
  break;


  case 15: /* list_elements: %empty  */
  if (yyn == 15)
    /* "parser.y":109  */
                                                           { yyval = new ElementsList(); };
  break;


  case 16: /* list_elements: list_elements element  */
  if (yyn == 16)
    /* "parser.y":110  */
                                                           { yyval = ((ElementsList)(yystack.valueAt (1))); ((ElementsList)(yystack.valueAt (1))).add(((Element)(yystack.valueAt (0)))); };
  break;


  case 17: /* special_form: TOK_QUOTE element  */
  if (yyn == 17)
    /* "parser.y":114  */
                                                           { yyval = new QuoteSpecialForm(((Element)(yystack.valueAt (0)))); };
  break;


  case 18: /* special_form: TOK_SETQ identifier element  */
  if (yyn == 18)
    /* "parser.y":115  */
                                                           { yyval = new SetqSpecialForm(((Identifier)(yystack.valueAt (1))), ((Element)(yystack.valueAt (0)))); };
  break;


  case 19: /* special_form: TOK_FUNC identifier list_of_ids element  */
  if (yyn == 19)
    /* "parser.y":116  */
                                                           { yyval = new FuncSpecialForm(((Identifier)(yystack.valueAt (2))), ((LinkedList<Identifier>)(yystack.valueAt (1))), ((Element)(yystack.valueAt (0)))); };
  break;


  case 20: /* special_form: TOK_LAMBDA list_of_ids element  */
  if (yyn == 20)
    /* "parser.y":117  */
                                                           { yyval = new LambdaSpecialForm(((LinkedList<Identifier>)(yystack.valueAt (1))), ((Element)(yystack.valueAt (0)))); };
  break;


  case 21: /* special_form: TOK_PROG list_of_ids element  */
  if (yyn == 21)
    /* "parser.y":118  */
                                                           { yyval = new ProgSpecialForm(((LinkedList<Identifier>)(yystack.valueAt (1))), ((Element)(yystack.valueAt (0)))); };
  break;


  case 22: /* special_form: TOK_COND element element  */
  if (yyn == 22)
    /* "parser.y":119  */
                                                           { yyval = new CondSpecialForm(((Element)(yystack.valueAt (1))), ((Element)(yystack.valueAt (0)))); };
  break;


  case 23: /* special_form: TOK_COND element element element  */
  if (yyn == 23)
    /* "parser.y":120  */
                                                           { yyval = new CondSpecialForm(((Element)(yystack.valueAt (2))), ((Element)(yystack.valueAt (1))), ((Element)(yystack.valueAt (0)))); };
  break;


  case 24: /* special_form: TOK_WHILE element element  */
  if (yyn == 24)
    /* "parser.y":121  */
                                                           { yyval = new WhileSpecialForm(((Element)(yystack.valueAt (1))), ((Element)(yystack.valueAt (0)))); };
  break;


  case 25: /* special_form: TOK_RETURN element  */
  if (yyn == 25)
    /* "parser.y":122  */
                                                           { yyval = new ReturnSpecialForm(((Element)(yystack.valueAt (0)))); };
  break;


  case 26: /* special_form: TOK_BREAK  */
  if (yyn == 26)
    /* "parser.y":123  */
                                                           { yyval = new BreakSpecialForm(); };
  break;


  case 27: /* list_of_ids: "(" ids_sequence ")"  */
  if (yyn == 27)
    /* "parser.y":127  */
                                                         { yyval = ((LinkedList<Identifier>)(yystack.valueAt (1))); };
  break;


  case 28: /* ids_sequence: %empty  */
  if (yyn == 28)
    /* "parser.y":131  */
                                                           { yyval = new LinkedList<Identifier>(); };
  break;


  case 29: /* ids_sequence: ids_sequence identifier  */
  if (yyn == 29)
    /* "parser.y":132  */
                                                         { yyval = ((LinkedList<Identifier>)(yystack.valueAt (1))); ((LinkedList<Identifier>)(yystack.valueAt (1))).add(((Identifier)(yystack.valueAt (0)))); };
  break;



/* "parser.java":753  */

        default: break;
      }

    yySymbolPrint("-> $$ =", SymbolKind.get(yyr1_[yyn]), yyval, yyloc);

    yystack.pop(yylen);
    yylen = 0;
    /* Shift the result of the reduction.  */
    int yystate = yyLRGotoState(yystack.stateAt(0), yyr1_[yyn]);
    yystack.push(yystate, yyval, yyloc);
    return YYNEWSTATE;
  }


  /*--------------------------------.
  | Print this symbol on YYOUTPUT.  |
  `--------------------------------*/

  private void yySymbolPrint(String s, SymbolKind yykind,
                             Object yyvalue, Location yylocation) {
      if (0 < yydebug) {
          yycdebug(s
                   + (yykind.getCode() < YYNTOKENS_ ? " token " : " nterm ")
                   + yykind.getName() + " ("
                   + yylocation + ": "
                   + (yyvalue == null ? "(null)" : yyvalue.toString()) + ")");
      }
  }



  /**
   * Push Parse input from external lexer
   *
   * @param yylextoken current token
   * @param yylexval current lval
   * @param yylexloc current position
   *
   * @return <tt>YYACCEPT, YYABORT, YYPUSH_MORE</tt>
   */
  public int push_parse(int yylextoken, Object yylexval, Location yylexloc) throws java.io.IOException
  {
    /* @$.  */
    Location yyloc;


    if (!this.push_parse_initialized)
      {
        push_parse_initialize ();

        yycdebug ("Starting parse");
        yyerrstatus_ = 0;
      } else
        label = YYGETTOKEN;

    boolean push_token_consumed = true;

    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:
        yycdebug ("Entering state " + yystate);
        if (0 < yydebug)
          yystack.print (yyDebugStream);

        /* Accept?  */
        if (yystate == YYFINAL_)
          {label = YYACCEPT; break;}

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yyPactValueIsDefault (yyn))
          {
            label = YYDEFAULT;
            break;
          }
        /* Fall Through */

      case YYGETTOKEN:
        /* Read a lookahead token.  */
        if (yychar == YYEMPTY_)
          {

            if (!push_token_consumed)
              return YYPUSH_MORE;
            yycdebug ("Reading a token");
            yychar = yylextoken;
            yylval = yylexval;
            yylloc = yylexloc;
            push_token_consumed = false;
          }

        /* Convert token to internal form.  */
        yytoken = yytranslate_ (yychar);
        yySymbolPrint("Next token is", yytoken,
                      yylval, yylloc);

        if (yytoken == SymbolKind.S_YYerror)
          {
            // The scanner already issued an error message, process directly
            // to error recovery.  But do not keep the error token as
            // lookahead, it is too special and may lead us to an endless
            // loop in error recovery. */
            yychar = Lexer.YYUNDEF;
            yytoken = SymbolKind.S_YYUNDEF;
            yyerrloc = yylloc;
            label = YYERRLAB1;
          }
        else
          {
            /* If the proper action on seeing token YYTOKEN is to reduce or to
               detect an error, take that action.  */
            yyn += yytoken.getCode();
            if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode()) {
              label = YYDEFAULT;
            }

            /* <= 0 means reduce or error.  */
            else if ((yyn = yytable_[yyn]) <= 0)
              {
                if (yyTableValueIsError(yyn)) {
                  label = YYERRLAB;
                } else {
                  yyn = -yyn;
                  label = YYREDUCE;
                }
              }

            else
              {
                /* Shift the lookahead token.  */
                yySymbolPrint("Shifting", yytoken,
                              yylval, yylloc);

                /* Discard the token being shifted.  */
                yychar = YYEMPTY_;

                /* Count tokens shifted since error; after three, turn off error
                   status.  */
                if (yyerrstatus_ > 0)
                  --yyerrstatus_;

                yystate = yyn;
                yystack.push(yystate, yylval, yylloc);
                label = YYNEWSTATE;
              }
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction(yyn, yystack, yylen);
        yystate = yystack.stateAt(0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs;
            if (yychar == YYEMPTY_)
              yytoken = null;
            yyreportSyntaxError(new Context(this, yystack, yytoken, yylloc));
          }

        yyerrloc = yylloc;
        if (yyerrstatus_ == 3)
          {
            /* If just tried and failed to reuse lookahead token after an
               error, discard it.  */

            if (yychar <= Lexer.YYEOF)
              {
                /* Return failure if at end of input.  */
                if (yychar == Lexer.YYEOF)
                  {label = YYABORT; break;}
              }
            else
              yychar = YYEMPTY_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:
        yyerrloc = yystack.locationAt (yylen - 1);
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt(0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        // Pop stack until we find a state that shifts the error token.
        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yyPactValueIsDefault (yyn))
              {
                yyn += SymbolKind.S_YYerror.getCode();
                if (0 <= yyn && yyn <= YYLAST_
                    && yycheck_[yyn] == SymbolKind.S_YYerror.getCode())
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              {label = YYABORT; break;}


            yyerrloc = yystack.locationAt (0);
            yystack.pop ();
            yystate = yystack.stateAt(0);
            if (0 < yydebug)
              yystack.print (yyDebugStream);
          }

        if (label == YYABORT)
          /* Leave the switch.  */
          break;


        /* Muck with the stack to setup for yylloc.  */
        yystack.push (0, null, yylloc);
        yystack.push (0, null, yyerrloc);
        yyloc = yylloc (yystack, 2);
        yystack.pop (2);

        /* Shift the error token.  */
        yySymbolPrint("Shifting", SymbolKind.get(yystos_[yyn]),
                      yylval, yyloc);

        yystate = yyn;
        yystack.push (yyn, yylval, yyloc);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        this.push_parse_initialized = false; return YYACCEPT;

        /* Abort.  */
      case YYABORT:
        this.push_parse_initialized = false; return YYABORT;
      }
}

  boolean push_parse_initialized = false;

    /**
     * (Re-)Initialize the state of the push parser.
     */
  public void push_parse_initialize ()
  {
    /* Lookahead and lookahead in internal form.  */
    this.yychar = YYEMPTY_;
    this.yytoken = null;

    /* State.  */
    this.yyn = 0;
    this.yylen = 0;
    this.yystate = 0;
    this.yystack = new YYStack();
    this.label = YYNEWSTATE;

    /* Error handling.  */
    this.yynerrs = 0;
    /* The location where the error started.  */
    this.yyerrloc = null;
    this.yylloc = new Location (null, null);

    /* Semantic value of the lookahead.  */
    this.yylval = null;

    yystack.push (this.yystate, this.yylval, this.yylloc);

    this.push_parse_initialized = true;

  }

  /**
   * Push parse given input from an external lexer.
   *
   * @param yylextoken current token
   * @param yylexval current lval
   * @param yyylexpos current position
   *
   * @return <tt>YYACCEPT, YYABORT, YYPUSH_MORE</tt>
   */
  public int push_parse(int yylextoken, Object yylexval, Position yylexpos) throws java.io.IOException {
      return push_parse(yylextoken, yylexval, new Location(yylexpos));
  }




  /**
   * Information needed to get the list of expected tokens and to forge
   * a syntax error diagnostic.
   */
  public static final class Context {
    Context(Parser parser, YYStack stack, SymbolKind token, Location loc) {
      yyparser = parser;
      yystack = stack;
      yytoken = token;
      yylocation = loc;
    }

    private Parser yyparser;
    private YYStack yystack;


    /**
     * The symbol kind of the lookahead token.
     */
    public final SymbolKind getToken() {
      return yytoken;
    }

    private SymbolKind yytoken;

    /**
     * The location of the lookahead.
     */
    public final Location getLocation() {
      return yylocation;
    }

    private Location yylocation;
    static final int NTOKENS = Parser.YYNTOKENS_;

    /**
     * Put in YYARG at most YYARGN of the expected tokens given the
     * current YYCTX, and return the number of tokens stored in YYARG.  If
     * YYARG is null, return the number of expected tokens (guaranteed to
     * be less than YYNTOKENS).
     */
    int getExpectedTokens(SymbolKind yyarg[], int yyargn) {
      return getExpectedTokens (yyarg, 0, yyargn);
    }

    int getExpectedTokens(SymbolKind yyarg[], int yyoffset, int yyargn) {
      int yycount = yyoffset;
      int yyn = yypact_[this.yystack.stateAt(0)];
      if (!yyPactValueIsDefault(yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative
             indexes in YYCHECK.  In other words, skip the first
             -YYN actions for this state because they are default
             actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST_ - yyn + 1;
          int yyxend = yychecklim < NTOKENS ? yychecklim : NTOKENS;
          for (int yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck_[yyx + yyn] == yyx && yyx != SymbolKind.S_YYerror.getCode()
                && !yyTableValueIsError(yytable_[yyx + yyn]))
              {
                if (yyarg == null)
                  yycount += 1;
                else if (yycount == yyargn)
                  return 0; // FIXME: this is incorrect.
                else
                  yyarg[yycount++] = SymbolKind.get(yyx);
              }
        }
      if (yyarg != null && yycount == yyoffset && yyoffset < yyargn)
        yyarg[yycount] = null;
      return yycount - yyoffset;
    }
  }





  /**
   * Build and emit a "syntax error" message in a user-defined way.
   *
   * @param ctx  The context of the error.
   */
  private void yyreportSyntaxError(Context yyctx) {
      yylexer.reportSyntaxError(yyctx);
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yyPactValueIsDefault(int yyvalue) {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yyTableValueIsError(int yyvalue) {
    return yyvalue == yytable_ninf_;
  }

  private static final byte yypact_ninf_ = -16;
  private static final byte yytable_ninf_ = -1;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final byte[] yypact_ = yypact_init();
  private static final byte[] yypact_init()
  {
    return new byte[]
    {
     -16,    32,   -16,   -16,   -16,   -16,   -16,   -16,    33,    58,
     -16,   -16,   -16,   -16,    58,     0,     0,     1,     1,    58,
      58,    58,   -16,    50,    -1,   -16,   -16,    58,     1,   -16,
      58,    58,    58,    58,   -16,   -16,   -16,   -16,   -16,    58,
      -3,   -16,   -16,    58,   -16,   -16,   -16,   -16,   -16
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte[] yydefact_ = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       2,     0,     1,     9,    10,    11,    12,     8,    15,     0,
       3,     4,     5,     6,     0,     0,     0,     0,     0,     0,
       0,     0,    26,     0,     0,     7,    17,     0,     0,    28,
       0,     0,     0,     0,    25,    13,    16,    14,    18,     0,
       0,    20,    21,    22,    24,    19,    27,    29,    23
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte[] yypgoto_ = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -16,   -16,    -9,   -14,   -16,   -16,   -16,   -16,   -15,   -16
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte[] yydefgoto_ = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
       0,     1,    10,    11,    12,    13,    23,    24,    30,    40
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final byte[] yytable_ = yytable_init();
  private static final byte[] yytable_init()
  {
    return new byte[]
    {
      25,    27,    28,    31,     7,    26,    46,     7,    37,    29,
      32,    33,    34,    39,    36,     0,     0,     0,    38,     0,
       0,    41,    42,    43,    44,     0,    47,     0,     0,     0,
      45,     0,     2,     0,    48,     3,     4,     5,     6,     7,
       8,     0,     9,     0,    14,    15,    16,    17,    18,    19,
      20,    21,    22,     3,     4,     5,     6,     7,     8,    35,
       9,     3,     4,     5,     6,     7,     8,     0,     9
    };
  }

private static final byte[] yycheck_ = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
       9,    15,    16,    18,     7,    14,     9,     7,     9,     8,
      19,    20,    21,    28,    23,    -1,    -1,    -1,    27,    -1,
      -1,    30,    31,    32,    33,    -1,    40,    -1,    -1,    -1,
      39,    -1,     0,    -1,    43,     3,     4,     5,     6,     7,
       8,    -1,    10,    -1,    11,    12,    13,    14,    15,    16,
      17,    18,    19,     3,     4,     5,     6,     7,     8,     9,
      10,     3,     4,     5,     6,     7,     8,    -1,    10
    };
  }

/* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
   state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,    21,     0,     3,     4,     5,     6,     7,     8,    10,
      22,    23,    24,    25,    11,    12,    13,    14,    15,    16,
      17,    18,    19,    26,    27,    22,    22,    23,    23,     8,
      28,    28,    22,    22,    22,     9,    22,     9,    22,    28,
      29,    22,    22,    22,    22,    22,     9,    23,    22
    };
  }

/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    20,    21,    21,    22,    22,    22,    22,    23,    24,
      24,    24,    24,    25,    25,    26,    26,    27,    27,    27,
      27,    27,    27,    27,    27,    27,    27,    28,    29,    29
    };
  }

/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     0,     2,     1,     1,     1,     2,     1,     1,
       1,     1,     1,     3,     3,     0,     2,     2,     3,     4,
       3,     3,     3,     4,     3,     2,     1,     3,     0,     2
    };
  }



  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
  private static final short[] yyrline_ = yyrline_init();
  private static final short[] yyrline_init()
  {
    return new short[]
    {
       0,    82,    82,    83,    87,    88,    89,    90,    94,    98,
      99,   100,   101,   104,   105,   109,   110,   114,   115,   116,
     117,   118,   119,   120,   121,   122,   123,   127,   131,   132
    };
  }


  // Report on the debug stream that the rule yyrule is going to be reduced.
  private void yyReducePrint (int yyrule, YYStack yystack)
  {
    if (yydebug == 0)
      return;

    int yylno = yyrline_[yyrule];
    int yynrhs = yyr2_[yyrule];
    /* Print the symbols being reduced, and their result.  */
    yycdebug ("Reducing stack by rule " + (yyrule - 1)
              + " (line " + yylno + "):");

    /* The symbols being reduced.  */
    for (int yyi = 0; yyi < yynrhs; yyi++)
      yySymbolPrint("   $" + (yyi + 1) + " =",
                    SymbolKind.get(yystos_[yystack.stateAt(yynrhs - (yyi + 1))]),
                    yystack.valueAt ((yynrhs) - (yyi + 1)),
                    yystack.locationAt ((yynrhs) - (yyi + 1)));
  }

  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 274;
    if (t <= 0)
      return SymbolKind.S_YYEOF;
    else if (t <= code_max)
      return SymbolKind.get(yytranslate_table_[t]);
    else
      return SymbolKind.S_YYUNDEF;
  }
  private static final byte[] yytranslate_table_ = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19
    };
  }


  private static final int YYLAST_ = 68;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 2;
  private static final int YYNTOKENS_ = 20;

/* Unqualified %code blocks.  */
/* "parser.y":24  */

  private static ElementsList ast;

  public static ElementsList buildAST(String pathToFile) throws IOException {
    MyLexer lexer = new MyLexer(pathToFile);
    Parser parser = new Parser(lexer);

    int status;

    do {
      int token = lexer.getToken();
      Object lval = lexer.getValue();
      Parser.Location yyloc = lexer.getLocation();
      status = parser.push_parse(token, lval, yyloc);
    } while (status == Parser.YYPUSH_MORE);
  
    if (status != Parser.YYACCEPT) {
      return null;
    }

    return ast;
  }

/* "parser.java":1434  */

}
/* "parser.y":134  */
