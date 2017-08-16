package lightfish.byteLexer;
 class EParseNode extends P{  public  int parse(){int c;switch (cc(x)){
case 'n' :{switch (cc(x)){
case 'u' :{{c=cc(x);if(c=='m'){t=H.ENUM;++x;return x;}endId();return x;}}
case 'd' :{{c=cc(x);if(c=='_'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='f'){{c=cc(x);if(c=='_'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='p'){{c=cc(x);if(c=='u'){{c=cc(x);if(c=='t'){t=H.END_OF_INPUT;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='s'){t=H.ENDS;++x;return x;}return x;}}
case 'c' :{{c=cc(x);if(c=='l'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='d'){t=H.ENCLOSED;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'a' :{{c=cc(x);if(c=='b'){{c=cc(x);if(c=='l'){{c=cc(x);if(c=='e'){t=H.ENABLE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}
case 'g' :{{c=cc(x);if(c=='i'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='s'){t=H.ENGINES;++x;return x;}return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
default:endId();return x;
}}
case 'l' :{{c=cc(x);if(c=='s'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='f'){t=H.ELSEIF;++x;return x;}endId();return x;}}return x;}}endId();return x;}}endId();return x;}}
case 'x' :{switch (cc(x)){
case 'e' :{{c=cc(x);if(c=='c'){{c=cc(x);if(c=='u'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='e'){t=H.EXECUTE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 't' :{{c=cc(x);if(c=='r'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='c'){{c=cc(x);if(c=='t'){t=H.EXTRACT;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='e'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='d'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='d'){t=H.EXTENDED;++x;return x;}endId();return x;}}endId();return x;}}if(c=='t'){{c=cc(x);if(c=='_'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='z'){{c=cc(x);if(c=='e'){t=H.EXTENT_SIZE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'c' :{{c=cc(x);if(c=='h'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='g'){{c=cc(x);if(c=='e'){t=H.EXCHANGE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'i' :{{c=cc(x);if(c=='t'){t=H.EXIT;++x;return x;}if(c=='s'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='s'){t=H.EXISTS;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}
case 'p' :{{c=cc(x);if(c=='l'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='n'){t=H.EXPLAIN;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='a'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='n'){t=H.EXPANSION;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='i'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='e'){t=H.EXPIRE;++x;return x;}endId();return x;}}endId();return x;}}if(c=='o'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='t'){t=H.EXPORT;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}
default:endId();return x;
}}
case 'v' :{{c=cc(x);if(c=='e'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='s'){t=H.EVENTS;++x;return x;}return x;}}endId();return x;}}if(c=='r'){{c=cc(x);if(c=='y'){t=H.EVERY;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}
case 's' :{{c=cc(x);if(c=='c'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='p'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='d'){t=H.ESCAPED;++x;return x;}return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'r' :{{c=cc(x);if(c=='r'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='s'){t=H.ERRORS;++x;return x;}return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'a' :{{c=cc(x);if(c=='c'){{c=cc(x);if(c=='h'){t=H.EACH;++x;return x;}endId();return x;}}endId();return x;}}
default:endId();return x;
}}}