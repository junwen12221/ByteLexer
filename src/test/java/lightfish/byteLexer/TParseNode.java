package lightfish.byteLexer;
 class TParseNode extends P{  public  int parse(){int c;switch (cc(x)){
case 'i' :{{c=cc(x);if(c=='n'){{c=cc(x);if(c=='y'){{c=cc(x);if(c=='b'){{c=cc(x);if(c=='l'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='b'){t=H.TINYBLOB;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='i'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='t'){t=H.TINYINT;++x;return x;}endId();return x;}}endId();return x;}}if(c=='t'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='x'){{c=cc(x);if(c=='t'){t=H.TINYTEXT;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='m'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='m'){{c=cc(x);if(c=='p'){{c=cc(x);if(c=='_'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='d'){{c=cc(x);if(c=='d'){t=H.TIMESTAMP_ADD;++x;return x;}endId();return x;}}endId();return x;}}if(c=='d'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='f'){{c=cc(x);if(c=='f'){t=H.TIMESTAMP_DIFF;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}return x;}}endId();return x;}}endId();return x;}}
case 'y' :{{c=cc(x);if(c=='p'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='s'){t=H.TYPES;++x;return x;}return x;}}endId();return x;}}endId();return x;}}
case 'h' :{{c=cc(x);if(c=='r'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='d'){{c=cc(x);if(c=='p'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='l'){t=H.THREADPOOL;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='a'){{c=cc(x);if(c=='n'){t=H.THAN;++x;return x;}endId();return x;}}if(c=='e'){{c=cc(x);if(c=='n'){t=H.THEN;++x;return x;}endId();return x;}}endId();return x;}}
case 'e' :{{c=cc(x);if(c=='r'){{c=cc(x);if(c=='m'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='d'){t=H.TERMINATED;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='m'){{c=cc(x);if(c=='p'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='b'){{c=cc(x);if(c=='l'){{c=cc(x);if(c=='e'){t=H.TEMPTABLE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='o'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='y'){t=H.TEMPORARY;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='x'){{c=cc(x);if(c=='t'){t=H.TEXT;++x;return x;}endId();return x;}}endId();return x;}}
case 'r' :{{c=cc(x);if(c=='a'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='c'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='n'){t=H.TRANSACTION;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='i'){{c=cc(x);if(c=='l'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='g'){t=H.TRAILING;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='i'){{c=cc(x);if(c=='m'){t=H.TRIM;++x;return x;}if(c=='g'){{c=cc(x);if(c=='g'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='s'){t=H.TRIGGERS;++x;return x;}return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='u'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='c'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='e'){t=H.TRUNCATE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='e'){t=H.TRUE;++x;return x;}endId();return x;}}endId();return x;}}
case 'a' :{{c=cc(x);if(c=='b'){{c=cc(x);if(c=='l'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='_'){{c=cc(x);if(c=='n'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='m'){{c=cc(x);if(c=='e'){t=H.TABLE_NAME;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='r'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='f'){{c=cc(x);if(c=='_'){{c=cc(x);if(c=='p'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='o'){{c=cc(x);if(c=='r'){{c=cc(x);if(c=='i'){{c=cc(x);if(c=='t'){{c=cc(x);if(c=='y'){t=H.TABLE_REF_PRIORITY;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='c'){{c=cc(x);if(c=='h'){{c=cc(x);if(c=='e'){{c=cc(x);if(c=='c'){{c=cc(x);if(c=='k'){{c=cc(x);if(c=='s'){{c=cc(x);if(c=='u'){{c=cc(x);if(c=='m'){t=H.TABLE_CHECKSUM;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}endId();return x;}}if(c=='s'){{c=cc(x);if(c=='p'){{c=cc(x);if(c=='a'){{c=cc(x);if(c=='c'){{c=cc(x);if(c=='e'){t=H.TABLESPACE;++x;return x;}endId();return x;}}endId();return x;}}endId();return x;}}return x;}}return x;}}endId();return x;}}endId();return x;}}endId();return x;}}
case 'o' :{t=H.TO;++x;return x;}
default:endId();return x;
}}}