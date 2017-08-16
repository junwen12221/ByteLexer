package lightfish.byteLexer;
 class XParseNode extends P{  public  int parse(){int c;switch (cc(x)){
case '5' :{{c=cc(x);if(c=='0'){{c=cc(x);if(c=='9'){c=cc(x);if (isBlank(c)){t=H.X509;return x;}}endId();return x;}}endId();return x;}}
case 'm' :{{c=cc(x);if(c=='l'){c=cc(x);if (isBlank(c)){t=H.XML;return x;}}endId();return x;}}
case 'a' :{c=cc(x);if (isBlank(c)){t=H.XA;return x;}}
case 'i' :{{c=cc(x);if(c=='d'){c=cc(x);if (isBlank(c)){t=H.XID;return x;}}endId();return x;}}
case 'o' :{{c=cc(x);if(c=='r'){c=cc(x);if (isBlank(c)){t=H.XOR;return x;}}endId();return x;}}
default:endId();return x;
}}}