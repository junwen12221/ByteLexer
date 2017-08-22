package lightfish.byteLexer;


import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NLexer extends P {
    public NLexer() {


    }


    public static void main(String[] args) throws Exception {
        NLexer lexer = new NLexer();
        URI uri = NLexer.class.getResource(".").toURI();
        Files.lines(Paths.get(uri).getParent().getParent().resolve("test.txt"))
                .map((s) -> s.toLowerCase().trim().concat(" ").getBytes(StandardCharsets.US_ASCII))
                .forEach((s) -> {
                    lexer.init(s, 0);
                    while (lexer.hasMore) {
                        lexer.parse();
                        switch (lexer.getTokenType()) {
                            case H.FROM: {
                                while (lexer.hasMore) {
                                    lexer.parse();
                                    int type = lexer.getTokenType();
                                    if (type == H.IDENTIFIED) {
                                        System.out.println(lexer.readString());
                                    } else if (type == H.COMMA) {
                                        continue;
                                    }
                                }
                            }
                            default:
                                continue;
                        }
                        //  System.out.println(lexer.getTokenType());
                    }
                });
    }


    public NLexer(byte[] r) {
        init(r, 0);
    }

    LEFTOPENBRACKETParseNode leftopenbracketparsenode =new LEFTOPENBRACKETParseNode();
RIGHTCLOASBRACKETParseNode rightcloasbracketparsenode =new RIGHTCLOASBRACKETParseNode();
UNDERLINEParseNode underlineparsenode =new UNDERLINEParseNode();
EXCLAMATIONParseNode exclamationparsenode =new EXCLAMATIONParseNode();
AParseNode aparsenode =new AParseNode();
BParseNode bparsenode =new BParseNode();
CParseNode cparsenode =new CParseNode();
DParseNode dparsenode =new DParseNode();
PERCENTParseNode percentparsenode =new PERCENTParseNode();
EParseNode eparsenode =new EParseNode();
AMPERSANDParseNode ampersandparsenode =new AMPERSANDParseNode();
FParseNode fparsenode =new FParseNode();
GParseNode gparsenode =new GParseNode();
LEFTBRACKETParseNode leftbracketparsenode =new LEFTBRACKETParseNode();
HParseNode hparsenode =new HParseNode();
RIGHTBRACKETParseNode rightbracketparsenode =new RIGHTBRACKETParseNode();
IParseNode iparsenode =new IParseNode();
ASTERISKParseNode asteriskparsenode =new ASTERISKParseNode();
JParseNode jparsenode =new JParseNode();
PLUSParseNode plusparsenode =new PLUSParseNode();
KParseNode kparsenode =new KParseNode();
COMMAParseNode commaparsenode =new COMMAParseNode();
LParseNode lparsenode =new LParseNode();
MINUSParseNode minusparsenode =new MINUSParseNode();
MParseNode mparsenode =new MParseNode();
DOTParseNode dotparsenode =new DOTParseNode();
NParseNode nparsenode =new NParseNode();
OParseNode oparsenode =new OParseNode();
PParseNode pparsenode =new PParseNode();
QParseNode qparsenode =new QParseNode();
RParseNode rparsenode =new RParseNode();
SParseNode sparsenode =new SParseNode();
TParseNode tparsenode =new TParseNode();
UParseNode uparsenode =new UParseNode();
VParseNode vparsenode =new VParseNode();
WParseNode wparsenode =new WParseNode();
XParseNode xparsenode =new XParseNode();
YParseNode yparsenode =new YParseNode();
COLONParseNode colonparsenode =new COLONParseNode();
ZParseNode zparsenode =new ZParseNode();
SEMICOLONParseNode semicolonparsenode =new SEMICOLONParseNode();
OPENBRACEParseNode openbraceparsenode =new OPENBRACEParseNode();
LESSTHANParseNode lessthanparsenode =new LESSTHANParseNode();
VERTICALParseNode verticalparsenode =new VERTICALParseNode();
EQUALParseNode equalparsenode =new EQUALParseNode();
CLOSEBRACEParseNode closebraceparsenode =new CLOSEBRACEParseNode();
GREATERTHANParseNode greaterthanparsenode =new GREATERTHANParseNode();
QUESTIONMARKParseNode questionmarkparsenode =new QUESTIONMARKParseNode();
public int parse(){jumpPassSpace();this.start=x;int c=0;if (!hasMore)return x;
switch (c=reader[x]){
case '[' :{leftopenbracketparsenode.init(reader,x);x=leftopenbracketparsenode.parse();t=leftopenbracketparsenode.t;return x;}
case ']' :{rightcloasbracketparsenode.init(reader,x);x=rightcloasbracketparsenode.parse();t=rightcloasbracketparsenode.t;return x;}
case '_' :{underlineparsenode.init(reader,x);x=underlineparsenode.parse();t=underlineparsenode.t;return x;}
case '!' :{exclamationparsenode.init(reader,x);x=exclamationparsenode.parse();t=exclamationparsenode.t;return x;}
case 'a' :{aparsenode.init(reader,x);x=aparsenode.parse();t=aparsenode.t;return x;}
case 'b' :{bparsenode.init(reader,x);x=bparsenode.parse();t=bparsenode.t;return x;}
case 'c' :{cparsenode.init(reader,x);x=cparsenode.parse();t=cparsenode.t;return x;}
case 'd' :{dparsenode.init(reader,x);x=dparsenode.parse();t=dparsenode.t;return x;}
case '%' :{percentparsenode.init(reader,x);x=percentparsenode.parse();t=percentparsenode.t;return x;}
case 'e' :{eparsenode.init(reader,x);x=eparsenode.parse();t=eparsenode.t;return x;}
case '&' :{ampersandparsenode.init(reader,x);x=ampersandparsenode.parse();t=ampersandparsenode.t;return x;}
case 'f' :{fparsenode.init(reader,x);x=fparsenode.parse();t=fparsenode.t;return x;}
case 'g' :{gparsenode.init(reader,x);x=gparsenode.parse();t=gparsenode.t;return x;}
case '(' :{leftbracketparsenode.init(reader,x);x=leftbracketparsenode.parse();t=leftbracketparsenode.t;return x;}
case 'h' :{hparsenode.init(reader,x);x=hparsenode.parse();t=hparsenode.t;return x;}
case ')' :{rightbracketparsenode.init(reader,x);x=rightbracketparsenode.parse();t=rightbracketparsenode.t;return x;}
case 'i' :{iparsenode.init(reader,x);x=iparsenode.parse();t=iparsenode.t;return x;}
case '*' :{asteriskparsenode.init(reader,x);x=asteriskparsenode.parse();t=asteriskparsenode.t;return x;}
case 'j' :{jparsenode.init(reader,x);x=jparsenode.parse();t=jparsenode.t;return x;}
case '+' :{plusparsenode.init(reader,x);x=plusparsenode.parse();t=plusparsenode.t;return x;}
case 'k' :{kparsenode.init(reader,x);x=kparsenode.parse();t=kparsenode.t;return x;}
case ',' :{commaparsenode.init(reader,x);x=commaparsenode.parse();t=commaparsenode.t;return x;}
case 'l' :{lparsenode.init(reader,x);x=lparsenode.parse();t=lparsenode.t;return x;}
case '-' :{minusparsenode.init(reader,x);x=minusparsenode.parse();t=minusparsenode.t;return x;}
case 'm' :{mparsenode.init(reader,x);x=mparsenode.parse();t=mparsenode.t;return x;}
case '.' :{dotparsenode.init(reader,x);x=dotparsenode.parse();t=dotparsenode.t;return x;}
case 'n' :{nparsenode.init(reader,x);x=nparsenode.parse();t=nparsenode.t;return x;}
case 'o' :{oparsenode.init(reader,x);x=oparsenode.parse();t=oparsenode.t;return x;}
case 'p' :{pparsenode.init(reader,x);x=pparsenode.parse();t=pparsenode.t;return x;}
case 'q' :{qparsenode.init(reader,x);x=qparsenode.parse();t=qparsenode.t;return x;}
case 'r' :{rparsenode.init(reader,x);x=rparsenode.parse();t=rparsenode.t;return x;}
case 's' :{sparsenode.init(reader,x);x=sparsenode.parse();t=sparsenode.t;return x;}
case 't' :{tparsenode.init(reader,x);x=tparsenode.parse();t=tparsenode.t;return x;}
case 'u' :{uparsenode.init(reader,x);x=uparsenode.parse();t=uparsenode.t;return x;}
case 'v' :{vparsenode.init(reader,x);x=vparsenode.parse();t=vparsenode.t;return x;}
case 'w' :{wparsenode.init(reader,x);x=wparsenode.parse();t=wparsenode.t;return x;}
case 'x' :{xparsenode.init(reader,x);x=xparsenode.parse();t=xparsenode.t;return x;}
case 'y' :{yparsenode.init(reader,x);x=yparsenode.parse();t=yparsenode.t;return x;}
case ':' :{colonparsenode.init(reader,x);x=colonparsenode.parse();t=colonparsenode.t;return x;}
case 'z' :{zparsenode.init(reader,x);x=zparsenode.parse();t=zparsenode.t;return x;}
case ';' :{semicolonparsenode.init(reader,x);x=semicolonparsenode.parse();t=semicolonparsenode.t;return x;}
case '{' :{openbraceparsenode.init(reader,x);x=openbraceparsenode.parse();t=openbraceparsenode.t;return x;}
case '<' :{lessthanparsenode.init(reader,x);x=lessthanparsenode.parse();t=lessthanparsenode.t;return x;}
case '|' :{verticalparsenode.init(reader,x);x=verticalparsenode.parse();t=verticalparsenode.t;return x;}
case '=' :{equalparsenode.init(reader,x);x=equalparsenode.parse();t=equalparsenode.t;return x;}
case '}' :{closebraceparsenode.init(reader,x);x=closebraceparsenode.parse();t=closebraceparsenode.t;return x;}
case '>' :{greaterthanparsenode.init(reader,x);x=greaterthanparsenode.parse();t=greaterthanparsenode.t;return x;}
case '?' :{questionmarkparsenode.init(reader,x);x=questionmarkparsenode.parse();t=questionmarkparsenode.t;return x;}
default:id(c);return x;
}
}}