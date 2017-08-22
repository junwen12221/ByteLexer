package lightfish.byteLexer;

class FParseNode extends P {
    public int parse() {
        int c;
        switch (c = cc()) {
            case 'l': {
                {
                    return l();
                }
            }
            case 'i': {
                {
                    return i();
                }
            }
            case 'e': {
                {
                    return e();
                }
            }
            case 'u': {
                {
                    return u();
                }
            }
            case 'r': {
                {
                    return r();
                }
            }
            case 'a': {
                {
                    return a();
                }
            }
            case 'o': {
                {
                    return o();
                }
            }
            default:
                endId(c);
                return x;
        }
    }

    ;

    private int a() {
        int c;
        if (x < size) {
            c = cc();
            if (c == 'u') {
                if (x < size) {
                    c = cc();
                    if (c == 'l') {
                        if (x < size) {
                            c = cc();
                            if (c == 't') {
                                if (x < size) {
                                    c = cc();
                                    if (c == 's') {
                                        return endBlank(H.FAULTS);
                                    }
                                    endId(c);
                                    return x;
                                }
                                return x;
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            if (c == 'l') {
                if (x < size) {
                    c = cc();
                    if (c == 's') {
                        if (x < size) {
                            c = cc();
                            if (c == 'e') {
                                return endBlank(H.FALSE);
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            if (c == 's') {
                if (x < size) {
                    c = cc();
                    if (c == 't') {
                        return endBlank(H.FAST);
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            endId(c);
            return x;
        }
        return x;
    }

    private int e() {
        int c;
        if (x < size) {
            c = cc();
            if (c == 't') {
                if (x < size) {
                    c = cc();
                    if (c == 'c') {
                        if (x < size) {
                            c = cc();
                            if (c == 'h') {
                                return endBlank(H.FETCH);
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            endId(c);
            return x;
        }
        return x;
    }

    private int i() {
        int c;
        if (x < size) {
            c = cc();
            if (c == 'e') {
                if (x < size) {
                    c = cc();
                    if (c == 'l') {
                        if (x < size) {
                            c = cc();
                            if (c == 'd') {
                                if (x < size) {
                                    c = cc();
                                    if (c == 's') {
                                        return endBlank(H.FIELDS);
                                    }
                                    endId(c);
                                    return x;
                                }
                                return x;
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            if (c == 'l') {
                if (x < size) {
                    c = cc();
                    if (c == 'e') {
                        if (x < size) {
                            c = cc();
                            if (c == '_') {
                                if (x < size) {
                                    c = cc();
                                    if (c == 'b') {
                                        if (x < size) {
                                            c = cc();
                                            if (c == 'l') {
                                                if (x < size) {
                                                    c = cc();
                                                    if (c == 'o') {
                                                        if (x < size) {
                                                            c = cc();
                                                            if (c == 'c') {
                                                                if (x < size) {
                                                                    c = cc();
                                                                    if (c == 'k') {
                                                                        if (x < size) {
                                                                            c = cc();
                                                                            if (c == '_') {
                                                                                if (x < size) {
                                                                                    c = cc();
                                                                                    if (c == 's') {
                                                                                        if (x < size) {
                                                                                            c = cc();
                                                                                            if (c == 'i') {
                                                                                                if (x < size) {
                                                                                                    c = cc();
                                                                                                    if (c == 'z') {
                                                                                                        if (x < size) {
                                                                                                            c = cc();
                                                                                                            if (c == 'e') {
                                                                                                                return endBlank(H.FILE_BLOCK_SIZE);
                                                                                                            }
                                                                                                            endId(c);
                                                                                                            return x;
                                                                                                        }
                                                                                                        return x;
                                                                                                    }
                                                                                                    endId(c);
                                                                                                    return x;
                                                                                                }
                                                                                                return x;
                                                                                            }
                                                                                            endId(c);
                                                                                            return x;
                                                                                        }
                                                                                        return x;
                                                                                    }
                                                                                    endId(c);
                                                                                    return x;
                                                                                }
                                                                                return x;
                                                                            }
                                                                            endId(c);
                                                                            return x;
                                                                        }
                                                                        return x;
                                                                    }
                                                                    endId(c);
                                                                    return x;
                                                                }
                                                                return x;
                                                            }
                                                            endId(c);
                                                            return x;
                                                        }
                                                        return x;
                                                    }
                                                    endId(c);
                                                    return x;
                                                }
                                                return x;
                                            }
                                            endId(c);
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId(c);
                                    return x;
                                }
                                return x;
                            }
                            t = H.FILE;
                            return x;
                        }
                        return x;
                    }
                    if (c == 't') {
                        if (x < size) {
                            c = cc();
                            if (c == 'e') {
                                if (x < size) {
                                    c = cc();
                                    if (c == 'r') {
                                        return endBlank(H.FILTER);
                                    }
                                    endId(c);
                                    return x;
                                }
                                return x;
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            if (c == 'r') {
                if (x < size) {
                    c = cc();
                    if (c == 's') {
                        if (x < size) {
                            c = cc();
                            if (c == 't') {
                                return endBlank(H.FIRST);
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            if (c == 'x') {
                if (x < size) {
                    c = cc();
                    if (c == 'e') {
                        if (x < size) {
                            c = cc();
                            if (c == 'd') {
                                return endBlank(H.FIXED);
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            endId(c);
            return x;
        }
        return x;
    }

    private int l() {
        int c;
        if (x < size) {
            c = cc();
            if (c == 'u') {
                if (x < size) {
                    c = cc();
                    if (c == 's') {
                        if (x < size) {
                            c = cc();
                            if (c == 'h') {
                                return endBlank(H.FLUSH);
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            if (c == 'o') {
                if (x < size) {
                    c = cc();
                    if (c == 'a') {
                        if (x < size) {
                            c = cc();
                            if (c == 't') {
                                if (x < size) {
                                    c = cc();
                                    if (c == '4') {
                                        return endBlank(H.FLOAT4);
                                    }
                                    if (c == '8') {
                                        return endBlank(H.FLOAT8);
                                    }
                                    t = H.FLOAT;
                                    return x;
                                }
                                return x;
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            endId(c);
            return x;
        }
        return x;
    }

    private int o() {
        int c;
        if (x < size) {
            c = cc();
            if (c == 'r') {
                if (x < size) {
                    c = cc();
                    if (c == 'e') {
                        if (x < size) {
                            c = cc();
                            if (c == 'i') {
                                if (x < size) {
                                    c = cc();
                                    if (c == 'g') {
                                        if (x < size) {
                                            c = cc();
                                            if (c == 'n') {
                                                return endBlank(H.FOREIGN);
                                            }
                                            endId(c);
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId(c);
                                    return x;
                                }
                                return x;
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    if (c == 'm') {
                        if (x < size) {
                            c = cc();
                            if (c == 'a') {
                                if (x < size) {
                                    c = cc();
                                    if (c == 't') {
                                        return endBlank(H.FORMAT);
                                    }
                                    endId(c);
                                    return x;
                                }
                                return x;
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    if (c == 'c') {
                        if (x < size) {
                            c = cc();
                            if (c == 'e') {
                                return endBlank(H.FORCE);
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    t = H.FOR;
                    return x;
                }
                return x;
            }
            if (c == 'u') {
                if (x < size) {
                    c = cc();
                    if (c == 'n') {
                        if (x < size) {
                            c = cc();
                            if (c == 'd') {
                                return endBlank(H.FOUND);
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            if (c == 'l') {
                if (x < size) {
                    c = cc();
                    if (c == 'l') {
                        if (x < size) {
                            c = cc();
                            if (c == 'o') {
                                if (x < size) {
                                    c = cc();
                                    if (c == 'w') {
                                        if (x < size) {
                                            c = cc();
                                            if (c == 's') {
                                                return endBlank(H.FOLLOWS);
                                            }
                                            endId(c);
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId(c);
                                    return x;
                                }
                                return x;
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            endId(c);
            return x;
        }
        return x;
    }

    private int r() {
        int c;
        if (x < size) {
            c = cc();
            if (c == 'a') {
                if (x < size) {
                    c = cc();
                    if (c == 'c') {
                        if (x < size) {
                            c = cc();
                            if (c == '_') {
                                if (x < size) {
                                    c = cc();
                                    if (c == 's') {
                                        if (x < size) {
                                            c = cc();
                                            if (c == 'e') {
                                                if (x < size) {
                                                    c = cc();
                                                    if (c == 'c') {
                                                        if (x < size) {
                                                            c = cc();
                                                            if (c == 'o') {
                                                                if (x < size) {
                                                                    c = cc();
                                                                    if (c == 'n') {
                                                                        if (x < size) {
                                                                            c = cc();
                                                                            if (c == 'd') {
                                                                                return endBlank(H.FRAC_SECOND);
                                                                            }
                                                                            endId(c);
                                                                            return x;
                                                                        }
                                                                        return x;
                                                                    }
                                                                    endId(c);
                                                                    return x;
                                                                }
                                                                return x;
                                                            }
                                                            endId(c);
                                                            return x;
                                                        }
                                                        return x;
                                                    }
                                                    endId(c);
                                                    return x;
                                                }
                                                return x;
                                            }
                                            endId(c);
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId(c);
                                    return x;
                                }
                                return x;
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            if (c == 'o') {
                if (x < size) {
                    c = cc();
                    if (c == 'm') {
                        return endBlank(H.FROM);
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            endId(c);
            return x;
        }
        return x;
    }

    private int u() {
        int c;
        if (x < size) {
            c = cc();
            if (c == 'n') {
                if (x < size) {
                    c = cc();
                    if (c == 'c') {
                        if (x < size) {
                            c = cc();
                            if (c == 't') {
                                if (x < size) {
                                    c = cc();
                                    if (c == 'i') {
                                        if (x < size) {
                                            c = cc();
                                            if (c == 'o') {
                                                if (x < size) {
                                                    c = cc();
                                                    if (c == 'n') {
                                                        return endBlank(H.FUNCTION);
                                                    }
                                                    endId(c);
                                                    return x;
                                                }
                                                return x;
                                            }
                                            endId(c);
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId(c);
                                    return x;
                                }
                                return x;
                            }
                            endId(c);
                            return x;
                        }
                        return x;
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            if (c == 'l') {
                if (x < size) {
                    c = cc();
                    if (c == 'l') {
                        if (x < size) {
                            c = cc();
                            if (c == 't') {
                                if (x < size) {
                                    c = cc();
                                    if (c == 'e') {
                                        if (x < size) {
                                            c = cc();
                                            if (c == 'x') {
                                                if (x < size) {
                                                    c = cc();
                                                    if (c == 't') {
                                                        return endBlank(H.FULLTEXT);
                                                    }
                                                    endId(c);
                                                    return x;
                                                }
                                                return x;
                                            }
                                            endId(c);
                                            return x;
                                        }
                                        return x;
                                    }
                                    endId(c);
                                    return x;
                                }
                                return x;
                            }
                            t = H.FULL;
                            return x;
                        }
                        return x;
                    }
                    endId(c);
                    return x;
                }
                return x;
            }
            endId(c);
            return x;
        }
        return x;
    }
}