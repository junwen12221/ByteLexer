package lightfish.byteLexer;
class OParseNode extends P{public  int parse(){int c;switch (c=cc(x)){
case 'n' :{{return n();}}
case 'l' :{{return l();}}
case 'w' :{{return w();}}
case 'f' :{{return f();}}
case 'u' :{{return u();}}
case 'r' :{{return r();}}
case 'p' :{{return p();}}
default:endId();return x;
}};private int f(){int c;if(x<size){c=cc(x);if(c=='f'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.OFFLINE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='s'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if (isBlank(c)){t=H.OFFSET;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}private int l(){int c;if(x<size){c=cc(x);if(c=='d'){if(x<size){c=cc(x);if(c=='_'){if(x<size){c=cc(x);if(c=='p'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if(c=='w'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='d'){if(x<size){c=cc(x);if (isBlank(c)){t=H.OLD_PASSWORD;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}private int n(){int c;if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='_'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if(c=='h'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if (isBlank(c)){t=H.ONE_SHOT;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}t=H.ONE;return x;}return x;}if(c=='l'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.ONLINE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}if(c=='y'){if(x<size){c=cc(x);if (isBlank(c)){t=H.ONLY;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}t=H.ON;return x;}return x;}private int p(){int c;if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if (isBlank(c)){t=H.OPEN;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}if(c=='t'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='m'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='z'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if(c=='_'){if(x<size){c=cc(x);if(c=='c'){if(x<size){c=cc(x);if(c=='o'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='s'){if(x<size){c=cc(x);if (isBlank(c)){t=H.OPTIMIZER_COSTS;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}t=H.OPTIMIZE;return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='o'){if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='a'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='y'){if(x<size){c=cc(x);if (isBlank(c)){t=H.OPTIONALLY;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='s'){if(x<size){c=cc(x);if (isBlank(c)){t=H.OPTIONS;return x;}else{endId();return x;}}else{return x;}}t=H.OPTION;return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}private int r(){int c;if(x<size){c=cc(x);if(c=='d'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if (isBlank(c)){t=H.ORDER;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}t=H.OR;return x;}return x;}private int u(){int c;if(x<size){c=cc(x);if(c=='t'){if(x<size){c=cc(x);if(c=='f'){if(x<size){c=cc(x);if(c=='i'){if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if (isBlank(c)){t=H.OUTFILE;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}if(c=='e'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if (isBlank(c)){t=H.OUTER;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}t=H.OUT;return x;}return x;}endId();return x;}return x;}private int w(){int c;if(x<size){c=cc(x);if(c=='n'){if(x<size){c=cc(x);if(c=='e'){if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if (isBlank(c)){t=H.OWNER;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}endId();return x;}return x;}}