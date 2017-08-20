package lightfish.byteLexer;
class XParseNode extends P{public  int parse(){int c;switch (c=cc()){
case '5' :{{return FIVE();}}
case 'm' :{{return m();}}
case 'a' :{{return a();}}
case 'i' :{{return i();}}
case 'o' :{{return o();}}
default:endId(c);return x;
}};private int FIVE(){int c;if(x<size){c=cc();if(c=='0'){if(x<size){c=cc();if(c=='9'){return endBlank(H.X509);}endId(c);return x;}return x;}endId(c);return x;}return x;}private int a(){int c;return endBlank(H.XA);}private int i(){int c;if(x<size){c=cc();if(c=='d'){return endBlank(H.XID);}endId(c);return x;}return x;}private int m(){int c;if(x<size){c=cc();if(c=='l'){return endBlank(H.XML);}endId(c);return x;}return x;}private int o(){int c;if(x<size){c=cc();if(c=='r'){return endBlank(H.XOR);}endId(c);return x;}return x;}}