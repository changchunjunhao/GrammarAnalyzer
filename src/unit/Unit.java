package unit;

public class Unit {

	//types
	public static final int DOT = 0,    //.
			SEMICOLON = 1, 				//;
			COMMA = 2,					//,
			LBRACE = 3,					//{
			RBRACE = 4,					//}
			STRING = 5,					//"abc"
			LBRACKET = 6,				//(
			RBRACKET = 7,				//)
			CHAR = 8,					//'c'
			EWORD = 9,					//abc123
			NUM = 10,					//123
			LINE = 11,					//'\n'
			COMMENT = 12,				// //
			LCOMMENT = 13,				// /*
			RCOMMENT = 14,				// */
			BLANK = 15,					//' '
			EQUAL = 16,                 //'='
			EQUALS = 17, 				//"=="
			COMPARE = 18,				//"<" ">" <= >=
			STAR = 19,                  //*
			LOGICAL = 20,				// || &&
			NOT = 21,					// !
			BITWISE = 22,				// | &
			PLUS = 23,					//+
			PLUSS = 24,					//++
			MINUS = 25,					//-
			MINUSS = 26,				//--
			DIVIDE = 27,				// /
			OTHER = 28					//& % $ ...
			;					
	private int type;
	private String content;
	
	public String symbol() {
		switch (type) {
		case DOT:
			return "DOT";
		case SEMICOLON:
			return "SEMICOLON";
		case COMMA:
			return "COMMA";
		case LBRACE:
			return "LBRACE";
		case RBRACE:
			return "RBRACE";
		case STRING:
			return "STRING";
		case LBRACKET:
			return "LBRACKET";
		case RBRACKET:
			return "RBRACKET";
		case CHAR:
			return "CHAR";
		case EWORD:
			return "EWORD";
		case NUM:
			return "NUM";
		case LINE:
			return "LINE";
		case COMMENT:
			return "COMMENT";
		case LCOMMENT:
			return "LCOMMENT";
		case RCOMMENT:
			return "RCOMMENT";
		case BLANK:
			return "BLANK";
		case EQUAL:
			return "EQUAL";
		case OTHER:
		default:
			return "OTHER";
		}
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
