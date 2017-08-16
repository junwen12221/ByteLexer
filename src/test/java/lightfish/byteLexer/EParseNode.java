package lightfish.byteLexer;
 class EParseNode extends P{  public  int parse(){int c;switch (cc(x)){
case 'n' :{switch (cc(x)){
case 'u' :{{c=cc(x);if(c=='m'){c=cc(x);if (isBlank(c)){t=H.ENUM;return x;}}endId();return x;}}
case 'd' :{{c=cc(x);if(c=='_'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='f'){{c=cc(x);if(c=='_'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='p'){{c=cc(x);if(c=='u'){{c=cc(x);if(c=='t'){c=cc(x);if (isBlank(c)){t=H.END_OF_INPUT;return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='s'){c=cc(x);if (isBlank(c)){t=H.ENDS;return x;}}return x;}}
case 'c' :{{c=cc(x);if(c=='l'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='d'){c=cc(x);if (isBlank(c)){t=H.ENCLOSED;return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'a' :{{c=cc(x);if(c=='b'){{c=cc(x);if(c=='l'){{c=cc(x);if(c=='e'){c=cc(x);if (isBlank(c)){t=H.ENABLE;return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'g' :{{c=cc(x);if(c=='i'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='s'){c=cc(x);if (isBlank(c)){t=H.ENGINES;return x;}}return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
default:endId();return x;
}}
case 'l' :{{c=cc(x);if(c=='s'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='f'){c=cc(x);if (isBlank(c)){t=H.ELSEIF;return x;}}endId();return x;}}return x;}}endId();return x;}}endId();return x;}}
case 'x' :{switch (cc(x)){
case 'e' :{{c=cc(x);if(c=='c'){{c=cc(x);if(c=='u'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='e'){c=cc(x);if (isBlank(c)){t=H.EXECUTE;return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 't' :{{c=cc(x);if(c=='r'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='c'){{c=cc(x);if(c=='t'){c=cc(x);if (isBlank(c)){t=H.EXTRACT;return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='e'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='d'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='d'){c=cc(x);if (isBlank(c)){t=H.EXTENDED;return x;}}endId();return x;}}endId();return x;}}if(c=='t'){{c=cc(x);if(c=='_'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='z'){{c=cc(x);if(c=='e'){c=cc(x);if (isBlank(c)){t=H.EXTENT_SIZE;return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'c' :{{c=cc(x);if(c=='h'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='g'){{c=cc(x);if(c=='e'){c=cc(x);if (isBlank(c)){t=H.EXCHANGE;return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'i' :{{c=cc(x);if(c=='t'){c=cc(x);if (isBlank(c)){t=H.EXIT;return x;}}if(c=='s'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='s'){c=cc(x);if (isBlank(c)){t=H.EXISTS;return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'p' :{{c=cc(x);if(c=='l'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='n'){c=cc(x);if (isBlank(c)){t=H.EXPLAIN;return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='a'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='n'){c=cc(x);if (isBlank(c)){t=H.EXPANSION;return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='i'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='e'){c=cc(x);if (isBlank(c)){t=H.EXPIRE;return x;}}endId();return x;}}endId();return x;}}if(c=='o'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='t'){c=cc(x);if (isBlank(c)){t=H.EXPORT;return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
default:endId();return x;
}}
case 'v' :{{c=cc(x);if(c=='e'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='s'){c=cc(x);if (isBlank(c)){t=H.EVENTS;return x;}}return x;}}endId();return x;}}if(c=='r'){{c=cc(x);if(c=='y'){c=cc(x);if (isBlank(c)){t=H.EVERY;return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 's' :{{c=cc(x);if(c=='c'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='p'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='d'){c=cc(x);if (isBlank(c)){t=H.ESCAPED;return x;}}return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'r' :{{c=cc(x);if(c=='r'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='s'){c=cc(x);if (isBlank(c)){t=H.ERRORS;return x;}}return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'a' :{{c=cc(x);if(c=='c'){{c=cc(x);if(c=='h'){c=cc(x);if (isBlank(c)){t=H.EACH;return x;}}endId();return x;}}endId();return x;}}
default:endId();return x;
}}}