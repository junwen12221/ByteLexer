package lightfish.byteLexer;


import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NLexer extends P{
    public NLexer() {


    }

    /**
     * 分模块
     * 后缀符号解析有问题
     *
     * @return
     */

    public long getTokenType() {
        return t;
    }

    public static void main(String[] args) throws Exception {
        NLexer lexer = new NLexer();
        URI uri=Lexer.class.getResource(".").toURI();
        Files.lines(Paths.get(uri).getParent().getParent().resolve("test.txt"))
                .map((s)->s.toLowerCase().getBytes(StandardCharsets.US_ASCII))
                .forEach((s)->{
                    lexer.init(s);
                    while (lexer.hasMore) {
                        lexer.match();
                        System.out.println(lexer.readString());
                        //  System.out.println(lexer.getTokenType());
                    }
                });
    }


    public NLexer(byte[] r) {
        hasMore = true;
        reader = r;
        size = r.length;
    }

    public void init(byte[] r) {
        hasMore = true;
        reader = r;
        size = r.length;
        x=0;
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
MParseNode mparsenode =new MParseNode();
FULLSTOPParseNode fullstopparsenode =new FULLSTOPParseNode();
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
public void match(){jumpPassSpace();this.start=x;int c=0;if (!hasMore)return;
switch (reader[x]){
case '[' :{leftopenbracketparsenode.init(reader,x);x=leftopenbracketparsenode.parse();t=leftopenbracketparsenode.t;break;}
case ']' :{rightcloasbracketparsenode.init(reader,x);x=rightcloasbracketparsenode.parse();t=rightcloasbracketparsenode.t;break;}
case '_' :{underlineparsenode.init(reader,x);x=underlineparsenode.parse();t=underlineparsenode.t;break;}
case '!' :{exclamationparsenode.init(reader,x);x=exclamationparsenode.parse();t=exclamationparsenode.t;break;}
case 'a' :{aparsenode.init(reader,x);x=aparsenode.parse();t=aparsenode.t;break;}
case 'b' :{bparsenode.init(reader,x);x=bparsenode.parse();t=bparsenode.t;break;}
case 'c' :{cparsenode.init(reader,x);x=cparsenode.parse();t=cparsenode.t;break;}
case 'd' :{dparsenode.init(reader,x);x=dparsenode.parse();t=dparsenode.t;break;}
case '%' :{percentparsenode.init(reader,x);x=percentparsenode.parse();t=percentparsenode.t;break;}
case 'e' :{eparsenode.init(reader,x);x=eparsenode.parse();t=eparsenode.t;break;}
case '&' :{ampersandparsenode.init(reader,x);x=ampersandparsenode.parse();t=ampersandparsenode.t;break;}
case 'f' :{fparsenode.init(reader,x);x=fparsenode.parse();t=fparsenode.t;break;}
case 'g' :{gparsenode.init(reader,x);x=gparsenode.parse();t=gparsenode.t;break;}
case '(' :{leftbracketparsenode.init(reader,x);x=leftbracketparsenode.parse();t=leftbracketparsenode.t;break;}
case 'h' :{hparsenode.init(reader,x);x=hparsenode.parse();t=hparsenode.t;break;}
case ')' :{rightbracketparsenode.init(reader,x);x=rightbracketparsenode.parse();t=rightbracketparsenode.t;break;}
case 'i' :{iparsenode.init(reader,x);x=iparsenode.parse();t=iparsenode.t;break;}
case '*' :{asteriskparsenode.init(reader,x);x=asteriskparsenode.parse();t=asteriskparsenode.t;break;}
case 'j' :{jparsenode.init(reader,x);x=jparsenode.parse();t=jparsenode.t;break;}
case '+' :{plusparsenode.init(reader,x);x=plusparsenode.parse();t=plusparsenode.t;break;}
case 'k' :{kparsenode.init(reader,x);x=kparsenode.parse();t=kparsenode.t;break;}
case ',' :{commaparsenode.init(reader,x);x=commaparsenode.parse();t=commaparsenode.t;break;}
case 'l' :{lparsenode.init(reader,x);x=lparsenode.parse();t=lparsenode.t;break;}
case 'm' :{mparsenode.init(reader,x);x=mparsenode.parse();t=mparsenode.t;break;}
case '.' :{fullstopparsenode.init(reader,x);x=fullstopparsenode.parse();t=fullstopparsenode.t;break;}
case 'n' :{nparsenode.init(reader,x);x=nparsenode.parse();t=nparsenode.t;break;}
case 'o' :{oparsenode.init(reader,x);x=oparsenode.parse();t=oparsenode.t;break;}
case 'p' :{pparsenode.init(reader,x);x=pparsenode.parse();t=pparsenode.t;break;}
case 'q' :{qparsenode.init(reader,x);x=qparsenode.parse();t=qparsenode.t;break;}
case 'r' :{rparsenode.init(reader,x);x=rparsenode.parse();t=rparsenode.t;break;}
case 's' :{sparsenode.init(reader,x);x=sparsenode.parse();t=sparsenode.t;break;}
case 't' :{tparsenode.init(reader,x);x=tparsenode.parse();t=tparsenode.t;break;}
case 'u' :{uparsenode.init(reader,x);x=uparsenode.parse();t=uparsenode.t;break;}
case 'v' :{vparsenode.init(reader,x);x=vparsenode.parse();t=vparsenode.t;break;}
case 'w' :{wparsenode.init(reader,x);x=wparsenode.parse();t=wparsenode.t;break;}
case 'x' :{xparsenode.init(reader,x);x=xparsenode.parse();t=xparsenode.t;break;}
case 'y' :{yparsenode.init(reader,x);x=yparsenode.parse();t=yparsenode.t;break;}
case ':' :{colonparsenode.init(reader,x);x=colonparsenode.parse();t=colonparsenode.t;break;}
case 'z' :{zparsenode.init(reader,x);x=zparsenode.parse();t=zparsenode.t;break;}
case ';' :{semicolonparsenode.init(reader,x);x=semicolonparsenode.parse();t=semicolonparsenode.t;break;}
case '{' :{openbraceparsenode.init(reader,x);x=openbraceparsenode.parse();t=openbraceparsenode.t;break;}
case '<' :{lessthanparsenode.init(reader,x);x=lessthanparsenode.parse();t=lessthanparsenode.t;break;}
case '|' :{verticalparsenode.init(reader,x);x=verticalparsenode.parse();t=verticalparsenode.t;break;}
case '=' :{equalparsenode.init(reader,x);x=equalparsenode.parse();t=equalparsenode.t;break;}
case '}' :{closebraceparsenode.init(reader,x);x=closebraceparsenode.parse();t=closebraceparsenode.t;break;}
case '>' :{greaterthanparsenode.init(reader,x);x=greaterthanparsenode.parse();t=greaterthanparsenode.t;break;}
case '?' :{questionmarkparsenode.init(reader,x);x=questionmarkparsenode.parse();t=questionmarkparsenode.t;break;}
default:id();return;
}
}}