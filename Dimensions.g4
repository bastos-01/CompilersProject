grammar Dimensions;

@parser::header {
import java.util.Map;
import java.util.HashMap;
}

@parser::members {
static protected Map <String,Dimension> dimTable = new HashMap<>();                                          // ( m, Length )
}

program: (stats)* EOF                           #Prog ;          
stats: (declaration| addunit) ';'               #Stat ;             //
declaration: ID  '->' type                   #Declar ;           //ID=grandeza a definir, type=tipo de var e unidades
addunit: ID '-> addUnit' type                #addUn;             //DID=grandeza a definir, type=tipo de var e unidades

type: datatype unit                             #TypeNormal         //declaration:definir grandezas base(que nao tem do mesmo tipo ja definido)     ( integer m/s )
| ID  op =('*'|'/') ID                          #TypeVars           //declaration                                                                   ( Velocidade=Distance/Time )
| conversion                                    #TypeConversions    //addunit:converter ordens de grandeza                                          ( cm=200*m )
;


conversion: ID '=' polynomial;

polynomial : ( sg=SIGN? monomial) (SIGN monomial)*;
monomial : number '*'  ID                        #realMonomial
         | number                                #const;

datatype: dt=('real' | 'integer')                #DTypeCheck ;       //tipos de dados primitivos

unit: '(' ID (op=('*'|'/') ID)*  ')'            #unitCheck ;        //unidades (ex: m, cm, s, m/s, etc)

number: INTEGER | REAL;
SIGN: '+'| '-' ;
REAL: [0-9]+ '.' [0-9]*;                        
INTEGER: [0-9]+;                                               //Obrigar que o nome da dimensao seja comecado por maiuscula e ser mais que uma letra
ID: LETTER ( LETTER | INTEGER )*;
LETTER: [a-zA-Z];

COMMENT:'//' .*? '\n' -> skip;
MULTICOMMENT: '/*' .*? '*/' -> skip;
WS:[ \t\r\n] -> skip;