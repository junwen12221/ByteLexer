package lightfish.byteLexer;
class TParseNode extends P{public  int parse(){int c;switch (cc(x)){
case 'i' :{{return i();}}
case 'y' :{{return y();}}
case 'h' :{{return h();}}
case 'e' :{{return e();}}
case 'r' :{{return r();}}
case 'a' :{{return a();}}
case 'o' :{{return o();}}
default:endId();return x;
}};private int a(){int c;if(x<size){c=cc(x);if(c=='b'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='_'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='m'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TABLE_NAME;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='r'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='f'){if(x<size){c=cc(x);if(c=='_'){if(x<size){c=cc(x);if(c=='p'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='y'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TABLE_REF_PRIORITY;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='c'){if(x<size){c=cc(x);if(c=='h'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='c'){if(x<size){c=cc(x);if(c=='k'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if(c=='u'){if(x<size){c=cc(x);if(c=='m'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TABLE_CHECKSUM;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='s'){if(x<size){c=cc(x);if(c=='p'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='c'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TABLESPACE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}return x;}return x;}return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}private int e(){int c;if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='m'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='d'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TERMINATED;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='m'){if(x<size){c=cc(x);if(c=='p'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='b'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TEMPTABLE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='o'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='y'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TEMPORARY;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='x'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TEXT;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}private int h(){int c;if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='d'){if(x<size){c=cc(x);if(c=='p'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if (isBlank(c)){t=H.THREADPOOL;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='a'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if (isBlank(c)){t=H.THAN;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}if(c=='e'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if (isBlank(c)){t=H.THEN;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}private int i(){int c;if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='y'){if(x<size){c=cc(x);if(c=='b'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='b'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TINYBLOB;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='i'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TINYINT;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}if(c=='t'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='x'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TINYTEXT;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='m'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='m'){if(x<size){c=cc(x);if(c=='p'){if(x<size){c=cc(x);if(c=='_'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='d'){if(x<size){c=cc(x);if(c=='d'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TIMESTAMP_ADD;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}if(c=='d'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='f'){if(x<size){c=cc(x);if(c=='f'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TIMESTAMP_DIFF;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}private int o(){int c;if(x<size){c=cc(x);if (isBlank(c)){t=H.TO;return x;}else{endId();return x;}}else{return x;}}private int r(){int c;if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='c'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TRANSACTION;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='i'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='g'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TRAILING;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='i'){if(x<size){c=cc(x);if(c=='m'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TRIM;return x;}else{endId();return x;}}else{return x;}}if(c=='g'){if(x<size){c=cc(x);if(c=='g'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TRIGGERS;return x;}else{endId();return x;}}else{return x;}}return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='u'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='c'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TRUNCATE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TRUE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}private int y(){int c;if(x<size){c=cc(x);if(c=='p'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if (isBlank(c)){t=H.TYPES;return x;}else{endId();return x;}}else{return x;}}return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}}