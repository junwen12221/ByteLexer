package lightfish.byteLexer;

class AParseNode extends P {
    public int parse() {
        int c;
        switch (cc(x)) {
            case 'n': {
                {
                    return n();
                }
            }
            case 'l': {
                {
                    return l();
                }
            }
            case 'g': {
                {
                    return g();
                }
            }
            case 'f': {
                {
                    return f();
                }
            }
            case 'v': {
                {
                    return v();
                }
            }
            case 'u': {
                {
                    return u();
                }
            }
            case 'd': {
                {
                    return d();
                }
            }
            case 't': {
                {
                    return t();
                }
            }
            case 'c': {
                {
                    return c();
                }
            }
            case 's': {
                {
                    return s();
                }
            }
            default:
                endId();
                return x;
        }
    }

    ;

    private int c() {
        int c;
        if (x < size) {
            c = cc(x);
            if (c == 't') {
                if (x < size) {
                    c = cc(x);
                    if (c == 'i') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 'o') {
                                if (x < size) {
                                    c = cc(x);
                                    if (c == 'n') {
                                        if (x < size) {
                                            c = cc(x);
                                            if (isBlank(c)) {
                                                t = H.ACTION;
                                                return x;
                                            } else {
                                                endId();
                                                return x;
                                            }
                                        } else {
                                            return x;
                                        }
                                    }
                                    endId();
                                    return x;
                                }
                                return x;
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    endId();
                    return x;
                }
                return x;
            }
            if (c == 'c') {
                if (x < size) {
                    c = cc(x);
                    if (c == 'e') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 's') {
                                if (x < size) {
                                    c = cc(x);
                                    if (c == 's') {
                                        if (x < size) {
                                            c = cc(x);
                                            if (c == 'i') {
                                                if (x < size) {
                                                    c = cc(x);
                                                    if (c == 'b') {
                                                        if (x < size) {
                                                            c = cc(x);
                                                            if (c == 'l') {
                                                                if (x < size) {
                                                                    c = cc(x);
                                                                    if (c == 'e') {
                                                                        if (x < size) {
                                                                            c = cc(x);
                                                                            if (isBlank(c)) {
                                                                                t = H.ACCESSIBLE;
                                                                                return x;
                                                                            } else {
                                                                                endId();
                                                                                return x;
                                                                            }
                                                                        } else {
                                                                            return x;
                                                                        }
                                                                    }
                                                                    endId();
                                                                    return x;
                                                                }
                                                                return x;
                                                            }
                                                            endId();
                                                            return x;
                                                        }
                                                        return x;
                                                    }
                                                    endId();
                                                    return x;
                                                }
                                                return x;
                                            }
                                            endId();
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId();
                                    return x;
                                }
                                return x;
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    if (c == 'o') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 'u') {
                                if (x < size) {
                                    c = cc(x);
                                    if (c == 'n') {
                                        if (x < size) {
                                            c = cc(x);
                                            if (c == 't') {
                                                if (x < size) {
                                                    c = cc(x);
                                                    if (isBlank(c)) {
                                                        t = H.ACCOUNT;
                                                        return x;
                                                    } else {
                                                        endId();
                                                        return x;
                                                    }
                                                } else {
                                                    return x;
                                                }
                                            }
                                            endId();
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId();
                                    return x;
                                }
                                return x;
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    endId();
                    return x;
                }
                return x;
            }
            endId();
            return x;
        }
        return x;
    }

    private int d() {
        int c;
        if (x < size) {
            c = cc(x);
            if (c == 'd') {
                if (x < size) {
                    c = cc(x);
                    if (c == 'd') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 'a') {
                                if (x < size) {
                                    c = cc(x);
                                    if (c == 't') {
                                        if (x < size) {
                                            c = cc(x);
                                            if (c == 'e') {
                                                if (x < size) {
                                                    c = cc(x);
                                                    if (isBlank(c)) {
                                                        t = H.ADDDATE;
                                                        return x;
                                                    } else {
                                                        endId();
                                                        return x;
                                                    }
                                                } else {
                                                    return x;
                                                }
                                            }
                                            endId();
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId();
                                    return x;
                                }
                                return x;
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    return x;
                }
                return x;
            }
            endId();
            return x;
        }
        return x;
    }

    private int f() {
        int c;
        if (x < size) {
            c = cc(x);
            if (c == 't') {
                if (x < size) {
                    c = cc(x);
                    if (c == 'e') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 'r') {
                                if (x < size) {
                                    c = cc(x);
                                    if (isBlank(c)) {
                                        t = H.AFTER;
                                        return x;
                                    } else {
                                        endId();
                                        return x;
                                    }
                                } else {
                                    return x;
                                }
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    endId();
                    return x;
                }
                return x;
            }
            endId();
            return x;
        }
        return x;
    }

    private int g() {
        int c;
        if (x < size) {
            c = cc(x);
            if (c == 'a') {
                if (x < size) {
                    c = cc(x);
                    if (c == 'i') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 'n') {
                                if (x < size) {
                                    c = cc(x);
                                    if (c == 's') {
                                        if (x < size) {
                                            c = cc(x);
                                            if (c == 't') {
                                                if (x < size) {
                                                    c = cc(x);
                                                    if (isBlank(c)) {
                                                        t = H.AGAINST;
                                                        return x;
                                                    } else {
                                                        endId();
                                                        return x;
                                                    }
                                                } else {
                                                    return x;
                                                }
                                            }
                                            endId();
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId();
                                    return x;
                                }
                                return x;
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    endId();
                    return x;
                }
                return x;
            }
            if (c == 'g') {
                if (x < size) {
                    c = cc(x);
                    if (c == 'r') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 'e') {
                                if (x < size) {
                                    c = cc(x);
                                    if (c == 'g') {
                                        if (x < size) {
                                            c = cc(x);
                                            if (c == 'a') {
                                                if (x < size) {
                                                    c = cc(x);
                                                    if (c == 't') {
                                                        if (x < size) {
                                                            c = cc(x);
                                                            if (c == 'e') {
                                                                if (x < size) {
                                                                    c = cc(x);
                                                                    if (isBlank(c)) {
                                                                        t = H.AGGREGATE;
                                                                        return x;
                                                                    } else {
                                                                        endId();
                                                                        return x;
                                                                    }
                                                                } else {
                                                                    return x;
                                                                }
                                                            }
                                                            endId();
                                                            return x;
                                                        }
                                                        return x;
                                                    }
                                                    endId();
                                                    return x;
                                                }
                                                return x;
                                            }
                                            endId();
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId();
                                    return x;
                                }
                                return x;
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    endId();
                    return x;
                }
                return x;
            }
            endId();
            return x;
        }
        return x;
    }

    private int l() {
        int c;
        if (x < size) {
            c = cc(x);
            if (c == 'l') {
                if (x < size) {
                    c = cc(x);
                    if (isBlank(c)) {
                        t = H.ALL;
                        return x;
                    } else {
                        endId();
                        return x;
                    }
                } else {
                    return x;
                }
            }
            if (c == 't') {
                if (x < size) {
                    c = cc(x);
                    if (c == 'e') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 'r') {
                                if (x < size) {
                                    c = cc(x);
                                    if (isBlank(c)) {
                                        t = H.ALTER;
                                        return x;
                                    } else {
                                        endId();
                                        return x;
                                    }
                                } else {
                                    return x;
                                }
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    endId();
                    return x;
                }
                return x;
            }
            if (c == 'g') {
                if (x < size) {
                    c = cc(x);
                    if (c == 'o') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 'r') {
                                if (x < size) {
                                    c = cc(x);
                                    if (c == 'i') {
                                        if (x < size) {
                                            c = cc(x);
                                            if (c == 't') {
                                                if (x < size) {
                                                    c = cc(x);
                                                    if (c == 'h') {
                                                        if (x < size) {
                                                            c = cc(x);
                                                            if (c == 'm') {
                                                                if (x < size) {
                                                                    c = cc(x);
                                                                    if (isBlank(c)) {
                                                                        t = H.ALGORITHM;
                                                                        return x;
                                                                    } else {
                                                                        endId();
                                                                        return x;
                                                                    }
                                                                } else {
                                                                    return x;
                                                                }
                                                            }
                                                            endId();
                                                            return x;
                                                        }
                                                        return x;
                                                    }
                                                    endId();
                                                    return x;
                                                }
                                                return x;
                                            }
                                            endId();
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId();
                                    return x;
                                }
                                return x;
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    endId();
                    return x;
                }
                return x;
            }
            if (c == 'w') {
                if (x < size) {
                    c = cc(x);
                    if (c == 'a') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 'y') {
                                if (x < size) {
                                    c = cc(x);
                                    if (c == 's') {
                                        if (x < size) {
                                            c = cc(x);
                                            if (isBlank(c)) {
                                                t = H.ALWAYS;
                                                return x;
                                            } else {
                                                endId();
                                                return x;
                                            }
                                        } else {
                                            return x;
                                        }
                                    }
                                    endId();
                                    return x;
                                }
                                return x;
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    endId();
                    return x;
                }
                return x;
            }
            endId();
            return x;
        }
        return x;
    }

    private int n() {
        int c;
        if (x < size) {
            c = cc(x);
            if (c == 'a') {
                if (x < size) {
                    c = cc(x);
                    if (c == 'l') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 'y') {
                                if (x < size) {
                                    c = cc(x);
                                    if (c == 'z') {
                                        if (x < size) {
                                            c = cc(x);
                                            if (c == 'e') {
                                                if (x < size) {
                                                    c = cc(x);
                                                    if (isBlank(c)) {
                                                        t = H.ANALYZE;
                                                        return x;
                                                    } else {
                                                        endId();
                                                        return x;
                                                    }
                                                } else {
                                                    return x;
                                                }
                                            }
                                            endId();
                                            return x;
                                        }
                                        return x;
                                    }
                                    if (c == 's') {
                                        if (x < size) {
                                            c = cc(x);
                                            if (c == 'e') {
                                                if (x < size) {
                                                    c = cc(x);
                                                    if (isBlank(c)) {
                                                        t = H.ANALYSE;
                                                        return x;
                                                    } else {
                                                        endId();
                                                        return x;
                                                    }
                                                } else {
                                                    return x;
                                                }
                                            }
                                            endId();
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId();
                                    return x;
                                }
                                return x;
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    endId();
                    return x;
                }
                return x;
            }
            if (c == 'y') {
                if (x < size) {
                    c = cc(x);
                    if (isBlank(c)) {
                        t = H.ANY;
                        return x;
                    } else {
                        endId();
                        return x;
                    }
                } else {
                    return x;
                }
            }
            if (c == 'd') {
                if (x < size) {
                    c = cc(x);
                    if (isBlank(c)) {
                        t = H.AND;
                        return x;
                    } else {
                        endId();
                        return x;
                    }
                } else {
                    return x;
                }
            }
            endId();
            return x;
        }
        return x;
    }

    private int s() {
        int c;
        if (x < size) {
            c = cc(x);
            if (c == 'e') {
                if (x < size) {
                    c = cc(x);
                    if (c == 'n') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 's') {
                                if (x < size) {
                                    c = cc(x);
                                    if (c == 'i') {
                                        if (x < size) {
                                            c = cc(x);
                                            if (c == 't') {
                                                if (x < size) {
                                                    c = cc(x);
                                                    if (c == 'i') {
                                                        if (x < size) {
                                                            c = cc(x);
                                                            if (c == 'v') {
                                                                if (x < size) {
                                                                    c = cc(x);
                                                                    if (c == 'e') {
                                                                        if (x < size) {
                                                                            c = cc(x);
                                                                            if (isBlank(c)) {
                                                                                t = H.ASENSITIVE;
                                                                                return x;
                                                                            } else {
                                                                                endId();
                                                                                return x;
                                                                            }
                                                                        } else {
                                                                            return x;
                                                                        }
                                                                    }
                                                                    endId();
                                                                    return x;
                                                                }
                                                                return x;
                                                            }
                                                            endId();
                                                            return x;
                                                        }
                                                        return x;
                                                    }
                                                    endId();
                                                    return x;
                                                }
                                                return x;
                                            }
                                            endId();
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId();
                                    return x;
                                }
                                return x;
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    endId();
                    return x;
                }
                return x;
            }
            if (c == 'c') {
                if (x < size) {
                    c = cc(x);
                    if (c == 'i') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 'i') {
                                if (x < size) {
                                    c = cc(x);
                                    if (isBlank(c)) {
                                        t = H.ASCII;
                                        return x;
                                    } else {
                                        endId();
                                        return x;
                                    }
                                } else {
                                    return x;
                                }
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    return x;
                }
                return x;
            }
            return x;
        }
        return x;
    }

    private int t() {
        int c;
        if (x < size) {
            c = cc(x);
            if (isBlank(c)) {
                t = H.AT;
                return x;
            } else {
                endId();
                return x;
            }
        } else {
            return x;
        }
    }

    private int u() {
        int c;
        if (x < size) {
            c = cc(x);
            if (c == 't') {
                if (x < size) {
                    c = cc(x);
                    if (c == 'h') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 'o') {
                                if (x < size) {
                                    c = cc(x);
                                    if (c == 'r') {
                                        if (x < size) {
                                            c = cc(x);
                                            if (c == 's') {
                                                if (x < size) {
                                                    c = cc(x);
                                                    if (isBlank(c)) {
                                                        t = H.AUTHORS;
                                                        return x;
                                                    } else {
                                                        endId();
                                                        return x;
                                                    }
                                                } else {
                                                    return x;
                                                }
                                            }
                                            endId();
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId();
                                    return x;
                                }
                                return x;
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    if (c == 'o') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 'e') {
                                if (x < size) {
                                    c = cc(x);
                                    if (c == 'x') {
                                        if (x < size) {
                                            c = cc(x);
                                            if (c == 't') {
                                                if (x < size) {
                                                    c = cc(x);
                                                    if (c == 'e') {
                                                        if (x < size) {
                                                            c = cc(x);
                                                            if (c == 'n') {
                                                                if (x < size) {
                                                                    c = cc(x);
                                                                    if (c == 'd') {
                                                                        if (x < size) {
                                                                            c = cc(x);
                                                                            if (c == '_') {
                                                                                if (x < size) {
                                                                                    c = cc(x);
                                                                                    if (c == 's') {
                                                                                        if (x < size) {
                                                                                            c = cc(x);
                                                                                            if (c == 'i') {
                                                                                                if (x < size) {
                                                                                                    c = cc(x);
                                                                                                    if (c == 'z') {
                                                                                                        if (x < size) {
                                                                                                            c = cc(x);
                                                                                                            if (c == 'e') {
                                                                                                                if (x < size) {
                                                                                                                    c = cc(x);
                                                                                                                    if (isBlank(c)) {
                                                                                                                        t = H.AUTOEXTEND_SIZE;
                                                                                                                        return x;
                                                                                                                    } else {
                                                                                                                        endId();
                                                                                                                        return x;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    return x;
                                                                                                                }
                                                                                                            }
                                                                                                            endId();
                                                                                                            return x;
                                                                                                        }
                                                                                                        return x;
                                                                                                    }
                                                                                                    endId();
                                                                                                    return x;
                                                                                                }
                                                                                                return x;
                                                                                            }
                                                                                            endId();
                                                                                            return x;
                                                                                        }
                                                                                        return x;
                                                                                    }
                                                                                    endId();
                                                                                    return x;
                                                                                }
                                                                                return x;
                                                                            }
                                                                            endId();
                                                                            return x;
                                                                        }
                                                                        return x;
                                                                    }
                                                                    endId();
                                                                    return x;
                                                                }
                                                                return x;
                                                            }
                                                            endId();
                                                            return x;
                                                        }
                                                        return x;
                                                    }
                                                    endId();
                                                    return x;
                                                }
                                                return x;
                                            }
                                            endId();
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId();
                                    return x;
                                }
                                return x;
                            }
                            if (c == '_') {
                                if (x < size) {
                                    c = cc(x);
                                    if (c == 'i') {
                                        if (x < size) {
                                            c = cc(x);
                                            if (c == 'n') {
                                                if (x < size) {
                                                    c = cc(x);
                                                    if (c == 'c') {
                                                        if (x < size) {
                                                            c = cc(x);
                                                            if (c == 'r') {
                                                                if (x < size) {
                                                                    c = cc(x);
                                                                    if (c == 'e') {
                                                                        if (x < size) {
                                                                            c = cc(x);
                                                                            if (c == 'm') {
                                                                                if (x < size) {
                                                                                    c = cc(x);
                                                                                    if (c == 'e') {
                                                                                        if (x < size) {
                                                                                            c = cc(x);
                                                                                            if (c == 'n') {
                                                                                                if (x < size) {
                                                                                                    c = cc(x);
                                                                                                    if (c == 't') {
                                                                                                        if (x < size) {
                                                                                                            c = cc(x);
                                                                                                            if (isBlank(c)) {
                                                                                                                t = H.AUTO_INCREMENT;
                                                                                                                return x;
                                                                                                            } else {
                                                                                                                endId();
                                                                                                                return x;
                                                                                                            }
                                                                                                        } else {
                                                                                                            return x;
                                                                                                        }
                                                                                                    }
                                                                                                    endId();
                                                                                                    return x;
                                                                                                }
                                                                                                return x;
                                                                                            }
                                                                                            endId();
                                                                                            return x;
                                                                                        }
                                                                                        return x;
                                                                                    }
                                                                                    endId();
                                                                                    return x;
                                                                                }
                                                                                return x;
                                                                            }
                                                                            endId();
                                                                            return x;
                                                                        }
                                                                        return x;
                                                                    }
                                                                    endId();
                                                                    return x;
                                                                }
                                                                return x;
                                                            }
                                                            endId();
                                                            return x;
                                                        }
                                                        return x;
                                                    }
                                                    endId();
                                                    return x;
                                                }
                                                return x;
                                            }
                                            endId();
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId();
                                    return x;
                                }
                                return x;
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    endId();
                    return x;
                }
                return x;
            }
            endId();
            return x;
        }
        return x;
    }

    private int v() {
        int c;
        if (x < size) {
            c = cc(x);
            if (c == 'g') {
                if (x < size) {
                    c = cc(x);
                    if (c == '_') {
                        if (x < size) {
                            c = cc(x);
                            if (c == 'r') {
                                if (x < size) {
                                    c = cc(x);
                                    if (c == 'o') {
                                        if (x < size) {
                                            c = cc(x);
                                            if (c == 'w') {
                                                if (x < size) {
                                                    c = cc(x);
                                                    if (c == '_') {
                                                        if (x < size) {
                                                            c = cc(x);
                                                            if (c == 'l') {
                                                                if (x < size) {
                                                                    c = cc(x);
                                                                    if (c == 'e') {
                                                                        if (x < size) {
                                                                            c = cc(x);
                                                                            if (c == 'n') {
                                                                                if (x < size) {
                                                                                    c = cc(x);
                                                                                    if (c == 'g') {
                                                                                        if (x < size) {
                                                                                            c = cc(x);
                                                                                            if (c == 't') {
                                                                                                if (x < size) {
                                                                                                    c = cc(x);
                                                                                                    if (c == 'h') {
                                                                                                        if (x < size) {
                                                                                                            c = cc(x);
                                                                                                            if (isBlank(c)) {
                                                                                                                t = H.AVG_ROW_LENGTH;
                                                                                                                return x;
                                                                                                            } else {
                                                                                                                endId();
                                                                                                                return x;
                                                                                                            }
                                                                                                        } else {
                                                                                                            return x;
                                                                                                        }
                                                                                                    }
                                                                                                    endId();
                                                                                                    return x;
                                                                                                }
                                                                                                return x;
                                                                                            }
                                                                                            endId();
                                                                                            return x;
                                                                                        }
                                                                                        return x;
                                                                                    }
                                                                                    endId();
                                                                                    return x;
                                                                                }
                                                                                return x;
                                                                            }
                                                                            endId();
                                                                            return x;
                                                                        }
                                                                        return x;
                                                                    }
                                                                    endId();
                                                                    return x;
                                                                }
                                                                return x;
                                                            }
                                                            endId();
                                                            return x;
                                                        }
                                                        return x;
                                                    }
                                                    endId();
                                                    return x;
                                                }
                                                return x;
                                            }
                                            endId();
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId();
                                    return x;
                                }
                                return x;
                            }
                            endId();
                            return x;
                        }
                        return x;
                    }
                    return x;
                }
                return x;
            }
            endId();
            return x;
        }
        return x;
    }
}