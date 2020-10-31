grammar MainGram;

@parser::header {
import java.util.Map;
import java.util.HashMap;
}

@parser::members {
static protected Map<String,Symbol> symbolTable = new HashMap<>();
}

main: (importDims)* statList EOF;

statList: (stat ';')*;                //lista de stats

stat: print                           //tipo de expressoes possiveis
    | assignment
    | declaration
    | conditionalstat
    | increment
    | dimensioninfo
    ;

print: 'println' '(' expr ')'  ;                                                         //esrever texto ou variaveis




importDims: 'import' ID ';'  #importDimensionFile;                                          // dá import a File com as Dimensions

declaration: type idList;                                                          // tipo e nome da variavel a ser declarada
assignment
: declaration '=' expr  #decAssign                                                //declarar variavel e atribuir o valor
          | ID '=' expr      #Assign                                                    //caso a variavel ja exista alterar valor
            ;


idList: ID (',' ID)* ;                                                                       //nome da variavel a que se quer atribuir valor
conditionalstat: conditional                                                                // definição if  e else 
               | forloop                                                                    // definição do for
               | whileloop                                                                  // definição do while
               ;

conditional: 'if' '('  expr  ')' '{' trueSL=statList '}' ( 'else'  falseSL=elseif )?  ;      //condição if
elseif: conditional |  '{' statList '}'  ;                                                   // condição else
 
forloop: 'for' '(' assignment ';' expr ';' expr ')' '{' trueSL=statList '}'   #forCond ;     //for loop

whileloop: 'while' '(' expr ')' '{' trueSL=statList '}'   #whileCond ;   //condição while


input:  'scan''('  STRING ',' type ')'  ;                                                //ler dados do utilizador

increment: (ID incre=( '++' | '--')) ;                                                        //incrementar ou decrementar uma variavel por 1

type returns[Type res]:                                                                       //diferentes tipos primitivos aceites pela linguagem, de futuro implementar o tipo Dimensão
     'integer' {$res = new IntegerType();}   #typeInt
   | 'real'    {$res = new RealType();}      #typeReal
   | 'boolean' {$res = new BooleanType();}   #typeBool
   | 'string' {$res = new StringType();}    #typeStr
   | ID     #DimensionType              
   ;

expr returns[Type eType, String varName, String dim, String uni]:                                                     //expressoes possiveis(operacoes, comparacoes ou respetivos tipos de variavel)
     <assoc=right> e1=expr '^' e2=expr              #powExpr
    | sign=('+'|'-') e=expr                         #signExpr
    | '!' e=expr                                    #notExpr 
    | e1=expr op=('*'| '/'| '%' ) e2=expr                #multDivExpr
    | e1=expr op=('+' | '-') e2=expr                #addSubExpr
    | e1=expr op=('==' | '!=') e2=expr              #equalComparisonExpr
    | e1=expr op=('>=' | '<=' | '>' | '<') e2=expr  #greatLowComparisonExpr
    |e1=expr op=('&&' | '||') e2=expr               #andOrExpr
    | '(' e=expr ')'                                #parenExpr
    | input                                         #inputExpr
    |increment                                      #increExpr
    | ID                                            #idExpr
    | REAL   unit?                                   #realExpr
    | INTEGER unit?                                  #integerExpr
    | BOOLEAN                                       #booleanExpr
    | STRING                                        #strExpr
    ;

unit: '(' ID (op=('*'|'/') ID)*  ')'            #unitCheck ;  

dimensioninfo : '(' expr ').dimensionInfo'  #dimInfo ;

BOOLEAN: 'true' | 'false';                      //tipo boolean
ID: LETTER ( LETTER | INTEGER )*;                    //nomes variaveis 
LETTER: [a-zA-Z_];                              
REAL: [0-9]+ '.' [0-9]*;                        //tipo real
INTEGER: [0-9]+;                                //tipo integer
COMMENT:'//' .*? '\n' -> skip;                  //comentario apenas para uma linha
MULTICOMMENT: '/*' .*? '*/' -> skip;            //comentario multilinha 
WS:[ \t\r\n]+ -> skip;                          // ignora espaços, tabs, e mudança de linha
STRING: '"' .*? '"';                            //tipo primitivo string 

