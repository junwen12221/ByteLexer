package lightfish.byteLexer;
 class XParseNode extends P{  public  int parse(){int c;switch (cc(x)){
case '5' :{{c=cc(x);if(c=='0'){{c=cc(x);if(c=='9'){t=H.X509;++x;return x;}endId();return x;}}endId();return x;}}
case 'm' :{{c=cc(x);if(c=='l'){t=H.XML;++x;return x;}endId();return x;}}
case 'a' :{t=H.XA;++x;return x;}
case 'i' :{{c=cc(x);if(c=='d'){t=H.XID;++x;return x;}endId();return x;}}
case 'o' :{{c=cc(x);if(c=='r'){t=H.XOR;++x;return x;}endId();return x;}}
default:endId();return x;
}}}