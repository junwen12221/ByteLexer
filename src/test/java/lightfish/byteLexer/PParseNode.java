package lightfish.byteLexer;
 class PParseNode extends P{  public  int parse(){int c;switch (cc(x)){
case 'u' :{{c=cc(x);if(c=='r'){{c=cc(x);if(c=='g'){{c=cc(x);if(c=='e'){t=H.PURGE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}
case 'l' :{{c=cc(x);if(c=='u'){{c=cc(x);if(c=='g'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='_'){{c=cc(x);if(c=='d'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='r'){t=H.PLUGIN_DIR;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='s'){t=H.PLUGINS;++x;return x;}return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'r' :{{c=cc(x);if(c=='e'){{c=cc(x);if(c=='v'){t=H.PREV;++x;return x;}if(c=='c'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='d'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='s'){t=H.PRECEDES;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='i'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='n'){t=H.PRECISION;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='s'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='v'){{c=cc(x);if(c=='e'){t=H.PRESERVE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='p'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='e'){t=H.PREPARE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='i'){{c=cc(x);if(c=='v'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='l'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='g'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='s'){t=H.PRIVILEGES;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='m'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='y'){t=H.PRIMARY;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='o'){{c=cc(x);if(c=='f'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='l'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='s'){t=H.PROFILES;++x;return x;}return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='x'){{c=cc(x);if(c=='y'){t=H.PROXY;++x;return x;}endId();return x;}}if(c=='c'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='d'){{c=cc(x);if(c=='u'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='e'){t=H.PROCEDURE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='s'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='l'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='t'){t=H.PROCESSLIST;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='o'){{c=cc(x);if(c=='r'){t=H.PROCESSOR;++x;return x;}endId();return x;}}return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'a' :{{c=cc(x);if(c=='c'){{c=cc(x);if(c=='k'){{c=cc(x);if(c=='_'){{c=cc(x);if(c=='k'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='y'){{c=cc(x);if(c=='s'){t=H.PACK_KEYS;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='s'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='w'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='d'){t=H.PASSWORD;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='r'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='l'){t=H.PARTIAL;++x;return x;}endId();return x;}}if(c=='t'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='g'){t=H.PARTITIONING;++x;return x;}endId();return x;}}endId();return x;}}if(c=='s'){t=H.PARTITIONS;++x;return x;}return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='s'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='r'){t=H.PARSER;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='g'){{c=cc(x);if(c=='e'){t=H.PAGE;++x;return x;}endId();return x;}}endId();return x;}}
case 'h' :{{c=cc(x);if(c=='a'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='e'){t=H.PHASE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}
case 'o' :{{c=cc(x);if(c=='l'){{c=cc(x);if(c=='y'){{c=cc(x);if(c=='g'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='n'){t=H.POLYGON;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='s'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='n'){t=H.POSITION;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='r'){{c=cc(x);if(c=='t'){t=H.PORT;++x;return x;}endId();return x;}}if(c=='i'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='t'){t=H.POINT;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}
default:endId();return x;
}}}