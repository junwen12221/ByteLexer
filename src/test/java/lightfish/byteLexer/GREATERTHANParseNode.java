package lightfish.byteLexer;
class GREATERTHANParseNode extends P{public  int parse(){int c;if(x<size){c=cc(x);if(c=='='){++x;return x;}return x;}return x;};}