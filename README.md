# FropInterpreter

Our team creates an interpreter for the F language. It is a functional language, which can be considered as a reduced version of Lisp with some simplifications 
and modifications. 

**Technology Stack:**
We decided to choose Java for writing an interpreter. Also, we are using Bison for automated parser generation.

A language interpreter has two parts:  <br />
**Parsing:** This component takes an input program as a sequence of characters, verifies it according to the language syntactic rules, and translates the program into an internal representation (a tree structure often called an abstract syntax tree) that shows the nested structure of statements or expressions in the program.  <br />
We separated parsing into two parts: _lexical analysis_, in which the input character string is broken up into a sequence of tokens, and _syntactic analysis_, in which the tokens are assembled into an abstract syntax tree.  <br />
**Execution:** The internal representation is then processed according to the semantic rules of the language, thereby carrying out the interpretation.  <br />

**Our Work Process Stages:**
* Lexical Analysis
* Syntax analysis
* Semantic Analysis
* Optimization

## Lexical Analysis
<img width="820" alt="image" src="https://user-images.githubusercontent.com/69860125/153569094-29ce52bb-4979-4485-b0c2-8407703d1f16.png">

**Token representation:** structure with a set of attributes.  <br />
**Interaction with other compiler components:** lexical analyzer passes the current token “on demand”.  <br />

Our tokens:
```
public enum Tokens {
    DELIMETER,

    FUNCTION,

    IDENTIFIER,

    SPECIAL_FORM,

    LIST_BRACKET,

    LITERAL,

    INVALID,
}
```
```
public class Span {
    private int lineNum;
    private int posBegin, posEnd;

    public Span(int lineNum, int posBegin, int posEnd) {
        this.lineNum = lineNum;
        this.posBegin = posBegin;
        this.posEnd = posEnd;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public int getPosBegin() {
        return posBegin;
    }

    public void setPosBegin(int posBegin) {
        this.posBegin = posBegin;
    }

    public int getPosEnd() {
        return posEnd;
    }

    public void setPosEnd(int posEnd) {
        this.posEnd = posEnd;
    }
}
```

The result of the Lexical analysis:
<img width="339" alt="image" src="https://user-images.githubusercontent.com/69860125/153572931-6962a017-da9b-430d-9941-2446d8bb6508.png">


