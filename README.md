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

**The Result of Lexical Analysis:**

<img width="339" alt="image" src="https://user-images.githubusercontent.com/69860125/153572931-6962a017-da9b-430d-9941-2446d8bb6508.png">


## Syntax Analyzer

<img width="443" alt="image" src="https://user-images.githubusercontent.com/69860125/153606722-1bc5718e-87d2-4904-88e0-6fa6f21c623d.png">

For automated parser generation we used Bison.

**Implementation technique:** Bottom-up parsing – from source tokens to grammar rules; the algorithm tries to reduce token sequences to more common non-terminal grammar symbols.

<img width="854" alt="image" src="https://user-images.githubusercontent.com/69860125/153608201-112b4329-ea9d-4c27-81c1-0dc9d49ac44f.png">

**The Result of Syntax Analysis:**

<img width="483" alt="image" src="https://user-images.githubusercontent.com/69860125/153606843-a5ab460f-33a3-4991-bc84-fcb058ba4dfc.png">



