package mstar.ast;

import org.antlr.v4.runtime.Token;

public class StringLiteral extends Expression {
    public String unescape_string;
    public String string;

    private String escape(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = string.length();
        for(int i = 0; i < length; i++) {
            char c = string.charAt(i);
            if(c == '\\') {
                char nc = string.charAt(i + 1);
                switch(nc) {
                    case 'n':
                        stringBuilder.append('\n');
                        break;
                    case 't':
                        stringBuilder.append('\t');
                        break;
                    case '\\':
                        stringBuilder.append('\\');
                        break;
                    case '"':
                        stringBuilder.append('"');
                        break;
                    default:
                        stringBuilder.append(nc);
                }
                i++;
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
    public StringLiteral(Token token) {
        this.unescape_string = token.getText();
        this.string = escape(unescape_string);
        this.location = new TokenLocation(token);
    }

    @Override public void accept(IAstVisitor visitor) { visitor.visit(this); }

    @Override
    public String toFString(String indent) {
        return unescape_string;
    }
}
