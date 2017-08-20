package lightfish.byteLexer;

class LESSTHANParseNode extends P {
    public int parse() {
        int c;
        if (x < size) {
            c = cc(x);
            if (c == '>') {
                t = H.NOTEQUAL2;
                ++x;
                return x;
            }
            if (c == '=') {
                t = H.GREATER_OR_EQUAL_TO;
                ++x;
                return x;
            }
            t = H.LESSTHAN;
            return x;
        }
        return x;
    }

    ;
}