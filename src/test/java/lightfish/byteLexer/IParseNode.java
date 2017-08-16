package lightfish.byteLexer;
 class IParseNode extends P{  public  int parse(){int c;switch (cc(x)){
case 'n' :{switch (cc(x)){
case 'n' :{{c=cc(x);if(c=='e'){{c=cc(x);if(c=='r'){t=H.INNER;++x;return x;}endId();return x;}}if(c=='o'){{c=cc(x);if(c=='d'){{c=cc(x);if(c=='b'){t=H.INNODB;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}
case 'i' :{{c=cc(x);if(c=='t'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='l'){{c=cc(x);if(c=='_'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='z'){{c=cc(x);if(c=='e'){t=H.INITIAL_SIZE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'f' :{{c=cc(x);if(c=='i'){{c=cc(x);if(c=='l'){{c=cc(x);if(c=='e'){t=H.INFILE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}
case 'v' :{{c=cc(x);if(c=='o'){{c=cc(x);if(c=='k'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='r'){t=H.INVOKER;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'd' :{{c=cc(x);if(c=='e'){{c=cc(x);if(c=='x'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='s'){t=H.INDEXES;++x;return x;}endId();return x;}}return x;}}endId();return x;}}endId();return x;}}
case 't' :{switch (cc(x)){
case '8' :{t=H.INT8;++x;return x;}
case 'e' :{{c=cc(x);if(c=='r'){{c=cc(x);if(c=='v'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='l'){t=H.INTERVAL;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='g'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='r'){t=H.INTEGER;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}
case '4' :{t=H.INT4;++x;return x;}
case '3' :{t=H.INT3;++x;return x;}
case '2' :{t=H.INT2;++x;return x;}
case '1' :{t=H.INT1;++x;return x;}
case 'o' :{t=H.INTO;++x;return x;}
default:endId();return x;
}}
case 's' :{{c=cc(x);if(c=='e'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='v'){{c=cc(x);if(c=='e'){t=H.INSENSITIVE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='r'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='_'){{c=cc(x);if(c=='m'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='h'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='d'){t=H.INSERT_METHOD;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}return x;}}endId();return x;}}endId();return x;}}if(c=='t'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='l'){{c=cc(x);if(c=='l'){t=H.INSTALL;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'o' :{{c=cc(x);if(c=='u'){{c=cc(x);if(c=='t'){t=H.INOUT;++x;return x;}endId();return x;}}endId();return x;}}
default:endId();return x;
}}
case 'm' :{{c=cc(x);if(c=='p'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='t'){t=H.IMPORT;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'g' :{{c=cc(x);if(c=='n'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='_'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='v'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='_'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='d'){{c=cc(x);if(c=='s'){t=H.IGNORE_SERVER_IDS;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'f' :{t=H.IF;++x;return x;}
case 'd' :{{c=cc(x);if(c=='e'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='f'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='d'){t=H.IDENTIFIED;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}return x;}}
case 't' :{{c=cc(x);if(c=='e'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='e'){t=H.ITERATE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 's' :{{c=cc(x);if(c=='o'){{c=cc(x);if(c=='l'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='n'){t=H.ISOLATION;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='s'){{c=cc(x);if(c=='u'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='r'){t=H.ISSUER;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}return x;}}
case 'p' :{{c=cc(x);if(c=='c'){t=H.IPC;++x;return x;}endId();return x;}}
case 'o' :{{c=cc(x);if(c=='_'){{c=cc(x);if(c=='b'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='f'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='_'){{c=cc(x);if(c=='g'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='d'){{c=cc(x);if(c=='s'){t=H.IO_BEFORE_GTIDS;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='a'){{c=cc(x);if(c=='f'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='_'){{c=cc(x);if(c=='g'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='d'){{c=cc(x);if(c=='s'){t=H.IO_AFTER_GTIDS;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='t'){{c=cc(x);if(c=='h'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='d'){t=H.IO_THREAD;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}return x;}}
default:endId();return x;
}}}