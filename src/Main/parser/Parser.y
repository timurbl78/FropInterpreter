%language "Java"

%define api.package Main.parser
%define api.parser.class {Parser}
%define api.value.type {Object}
%define api.parser.public
%define api.push-pull push

// Customized syntax error messages (see reportSyntaxError)...
%define parse.error custom
%define parse.trace

// ... with locations...
%locations

%code imports {
import java.io.IOException;
import java.util.*;
import Main.Types.*;
import Main.Element.Element;
import Main.Position.Position;
}

%code {
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
}

%token <IntegerLiteral>            TOK_INTEGER_LITERAL
%token <RealLiteral>               TOK_REAL_LITERAL
%token <BooleanLiteral>            TOK_BOOLEAN_LITERAL
%token <NullLiteral>               TOK_NULL_LITERAL

%token <Identifier>                TOK_IDENTIFIER

%token TOK_OPEN_BRACKET            "("
%token TOK_CLOSE_BRACKET           ")"
%token TOK_QUOTE_SIGN              "'"

%token <QuoteSpecialForm>          TOK_QUOTE
%token <SetqSpecialForm>           TOK_SETQ
%token <FuncSpecialForm>           TOK_FUNC
%token <LambdaSpecialForm>         TOK_LAMBDA
%token <ProgSpecialForm>           TOK_PROG
%token <CondSpecialForm>           TOK_COND
%token <WhileSpecialForm>          TOK_WHILE
%token <ReturnSpecialForm>         TOK_RETURN
%token <BreakSpecialForm>          TOK_BREAK

%type <ElementsList>               program
%type <Element>                    element
%type <Identifier>                 identifier
%type <Element>                    literal
%type <Element>                    list
%type <ElementsList>               list_elements
%type <Element>                    special_form
%type <LinkedList<Identifier>>     list_of_ids
%type <LinkedList<Identifier>>     ids_sequence


%%
program:
	%empty                                             { ast = new ElementsList(); }
	| program element                                  { ast.add($2); }
;

element:
	identifier                                         { $$ = $1; }
	| literal                                          { $$ = $1; }
	| list                                             { $$ = $1; }
	| TOK_QUOTE_SIGN element                           { $$ = new QuoteSpecialForm($2); }
	;

identifier:
	TOK_IDENTIFIER
	;

literal:
	TOK_INTEGER_LITERAL                                { $$ = $1; }
	| TOK_REAL_LITERAL                                 { $$ = $1; }
	| TOK_BOOLEAN_LITERAL                              { $$ = $1; }
	| TOK_NULL_LITERAL                                 { $$ = $1; }
	;
list:
	TOK_OPEN_BRACKET list_elements TOK_CLOSE_BRACKET   { $$ = $2; }
	| TOK_OPEN_BRACKET special_form TOK_CLOSE_BRACKET  { $$ = $2; }
	;

list_elements:
	%empty                                             { $$ = new ElementsList(); }
	| list_elements element                            { $$ = $1; $1.add($2); }
	;

special_form:
	TOK_QUOTE element                                  { $$ = new QuoteSpecialForm($2); }
	| TOK_SETQ identifier element                      { $$ = new SetqSpecialForm($2, $3); }
	| TOK_FUNC identifier list_of_ids element          { $$ = new FuncSpecialForm($2, $3, $4); }
	| TOK_LAMBDA list_of_ids element                   { $$ = new LambdaSpecialForm($2, $3); }
	| TOK_PROG list_of_ids element                     { $$ = new ProgSpecialForm($2, $3); }
	| TOK_COND element element                         { $$ = new CondSpecialForm($2, $3); }
	| TOK_COND element element element                 { $$ = new CondSpecialForm($2, $3, $4); }
	| TOK_WHILE element element                        { $$ = new WhileSpecialForm($2, $3); }
	| TOK_RETURN element                               { $$ = new ReturnSpecialForm($2); }
	| TOK_BREAK                                        { $$ = new BreakSpecialForm(); }
	;

list_of_ids:
	TOK_OPEN_BRACKET ids_sequence TOK_CLOSE_BRACKET  { $$ = $2; }
	;

ids_sequence:
	%empty                                             { $$ = new LinkedList<Identifier>(); }
	| ids_sequence identifier                        { $$ = $1; $1.add($2); }
	;
%%