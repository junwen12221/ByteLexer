package lightfish.byteLexer;
 class EXCLAMATIONParseNode extends P{  public  int parse(){int c;{c=cc(x);if(c=='>'){++x;return x;}if(c=='='){++x;return x;}if(c=='<'){++x;return x;}endId();return x;}}}