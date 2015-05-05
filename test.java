package unit;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import unit.dealer.*;

public class UnitFactory {

	private boolean needRetract = false;
	private UnitProducer unitProducer;
	private ArrayList<Unit> unitList = new ArrayList<Unit>();
	
	public ArrayList<Unit> getUnitList(InputStream in) throws IOException {
		
		unitList.clear();
		
		Unit unit;
		char temp = ' ';
		while (in.available() > 0) {
			if (needRetract)
				needRetract = false;
			else {
				temp = (char) in.read();
			}
			
			unit = unitProducer.getUnit(temp);
			if (unit != null) {
				unitList.add(unit);
			}
		}
		return unitList;
	}
	
	public void needRetract() {
		this.needRetract = true;
	}
	
	public void setUnitProducer(UnitProducer up) {
		this.unitProducer = up;
	}
	
	public UnitFactory() {
		
		/**
		 * register the producer here
		 * and here is the default priority
		 * longer or more accurate get higher priority
		 */
		UnitProducer dot = new DotProducer(this);
		UnitProducer semicolon = new SemicolonProducer(this);
		UnitProducer comma = new CommaProducer(this);
		UnitProducer lBrace = new LBraceProducer(this);
		UnitProducer rBrace = new RBraceProducer(this);
		UnitProducer string = new StringProducer(this);
		UnitProducer lBracket = new LBracketProducer(this);
		UnitProducer rBracket = new RBracketProducer(this);
		UnitProducer charP = new CharProducer(this);
		UnitProducer eword = new EwordProducer(this);
		UnitProducer num = new NumProducer(this);
		UnitProducer line = new LineProducer(this);
		UnitProducer comment = new CommentProducer(this);
		UnitProducer lComment = new LCommentProducer(this);
		UnitProducer rComment = new RCommentProducer(this);
		UnitProducer blank = new BlankProducer(this);
		UnitProducer other = new OtherProducer(this);
		UnitProducer equal = new EqualProducer(this);
		
		//head
		this.setUnitProducer(string);
		
		
		string.setNext(num);
		num.setNext(eword);
		
		eword.setNext(dot);
		
		//single char
		dot.setNext(semicolon);
		semicolon.setNext(lBrace);
		lBrace.setNext(rBrace);
		rBrace.setNext(line);
		line.setNext(blank);
		blank.setNext(lBracket);
		lBracket.setNext(rBracket);
		rBracket.setNext(equal);
		equal.setNext(comma);

		comma.setNext(comment);
		
		//double chars
		comment.setNext(lComment);
		lComment.setNext(rComment);
		rComment.setNext(charP);
		
		charP.setNext(other);
	}
}
