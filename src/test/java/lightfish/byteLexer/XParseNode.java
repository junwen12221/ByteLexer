package lightfish.byteLexer;
class XParseNode extends P{public  int parse(){int c;switch (cc(x)){
case '5' :{{return FIVE();}}
case 'm' :{{return m();}}
case 'a' :{{return a();}}
case 'i' :{{return i();}}
case 'o' :{{return o();}}
default:endId();return x;
}};private int FIVE(){int c;if(x<size){c=cc(x);if(c=='0'){if(x<size){c=cc(x);if(c=='9'){if(x<size){c=cc(x);if (isBlank(c)){t=H.X509;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}endId();return x;}return x;}private int a(){int c;if(x<size){c=cc(x);if (isBlank(c)){t=H.XA;return x;}else{endId();return x;}}else{return x;}}private int i(){int c;if(x<size){c=cc(x);if(c=='d'){if(x<size){c=cc(x);if (isBlank(c)){t=H.XID;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}private int m(){int c;if(x<size){c=cc(x);if(c=='l'){if(x<size){c=cc(x);if (isBlank(c)){t=H.XML;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}private int o(){int c;if(x<size){c=cc(x);if(c=='r'){if(x<size){c=cc(x);if (isBlank(c)){t=H.XOR;return x;}else{endId();return x;}}else{return x;}}endId();return x;}return x;}}