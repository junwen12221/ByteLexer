package lightfish.byteLexer;
class DParseNode extends P{public  int parse(){int c;switch (cc(x)){
case 'i' :{{return i();}}
case 'y' :{{return y();}}
case 'e' :{{return e();}}
case 'u' :{{return u();}}
case 'b' :{{return b();}}
case 'r' :{{return r();}}
case 'a' :{{return a();}}
case 'o' :{{return o();}}
default:endId();return x;
}};private int a(){int c;if(x<size){c=cc(x);if(c=='y'){if(x<size){c=cc(x);if(c=='_'){if(x<size){c=cc(x);if(c=='m'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='u'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DAY_MINUTE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='c'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='c'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='d'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DAY_MICROSECOND;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='h'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='u'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DAY_HOUR;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='s'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='c'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='d'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DAY_SECOND;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='o'){if(x<size){c=cc(x);if(c=='f'){if(x<size){c=cc(x);if(c=='m'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='h'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DAYOFMONTH;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}return x;}return x;}if(c=='t'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='f'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DATAFILE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='n'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='d'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DATANODE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='s'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='u'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='c'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DATASOURCE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='b'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DATABASES;return x;}else{endId();return x;}}else{return x;}}return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}return x;}return x;}if(c=='e'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='m'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DATETIME;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='_'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='d'){if(x<size){c=cc(x);if(c=='d'){if(x<size){c=cc(x);if(c=='_'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='v'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DATE_ADD_INTERVAL;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='s'){if(x<size){c=cc(x);if(c=='u'){if(x<size){c=cc(x);if(c=='b'){if(x<size){c=cc(x);if(c=='_'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='v'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DATE_SUB_INTERVAL;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}private int b(){int c;if(x<size){c=cc(x);if(c=='_'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='y'){if(x<size){c=cc(x);if(c=='p'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DB_TYPE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}private int e(){int c;switch (cc(x)){
case 'f' :{if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='u'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='_'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='u'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='h'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DEFAULT_AUTH;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='i'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DEFINER;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}
case 'l' :{if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='y'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='d'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DELAYED;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}if(c=='_'){if(x<size){c=cc(x);if(c=='k'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='y'){if(x<size){c=cc(x);if(c=='_'){if(x<size){c=cc(x);if(c=='w'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DELAY_KEY_WRITE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='e'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DELETE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}
case 't' :{if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DETAIL;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}if(c=='e'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='m'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='c'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DETERMINISTIC;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}
case 'c' :{if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='m'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='_'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='u'){if(x<size){c=cc(x);if(c=='m'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DECIMAL_NUM;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='l'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DECLARE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}return x;}return x;}
case 's' :{if(x<size){c=cc(x);if(c=='_'){if(x<size){c=cc(x);if(c=='k'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='y'){if(x<size){c=cc(x);if(c=='_'){if(x<size){c=cc(x);if(c=='f'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DES_KEY_FILE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='c'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='b'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DESCRIBE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}return x;}return x;}endId();return x;}return x;}
case 'a' :{if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='c'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DEALLOCATE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}
default:endId();return x;
}}private int i(){int c;if(x<size){c=cc(x);if(c=='v'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DIV;return x;}else{endId();return x;}}else{return x;}}if(c=='s'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='c'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='w'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DISTINCTROW;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='c'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='d'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DISCARD;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='k'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DISK;return x;}else{endId();return x;}}else{return x;}}if(c=='a'){if(x<size){c=cc(x);if(c=='b'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DISABLE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='r'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='c'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='y'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DIRECTORY;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='a'){if(x<size){c=cc(x);if(c=='g'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='c'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DIAGNOSTICS;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}private int o(){int c;if(x<size){c=cc(x);if(c=='u'){if(x<size){c=cc(x);if(c=='b'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DOUBLE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}return x;}return x;}private int r(){int c;if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='p'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DROP;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}private int u(){int c;if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DUAL;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}if(c=='m'){if(x<size){c=cc(x);if(c=='p'){if(x<size){c=cc(x);if(c=='f'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DUMPFILE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='p'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='c'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DUPLICATE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}private int y(){int c;if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='m'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='c'){if(x<size){c=cc(x);if (isBlank(c)){t=H.DYNAMIC;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}}