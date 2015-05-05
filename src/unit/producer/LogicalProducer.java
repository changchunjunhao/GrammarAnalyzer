package unit.producer;

import unit.Unit;
import unit.UnitFactory;
import unit.UnitProducer;

public class LogicalProducer extends UnitProducer {

	public LogicalProducer(UnitFactory uf) {
		super(uf);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Unit readChar(char ch) {
		// TODO Auto-generated method stub
		
		if (firstRead) {
			if ('|' == ch || '&' == ch) {
				this.temp = ch;
				this.strAppend(ch);
			} else {
				this.icannotdealit = true;
				return null;
			}
		} else {
			if (ch == temp) {
				this.strAppend(ch);
				
				Unit unit = new Unit();
				unit.setType(Unit.LOGICAL);
				unit.setContent(this.toString());
				return unit;
			} else {
				Unit unit = new Unit();
				unit.setType(Unit.BITWISE);
				unit.setContent(this.toString());
				this.retract();
				return unit;
			}
		}
		firstRead = false;
		return null;
	}

	private char temp;
}
