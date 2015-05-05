package unit.producer;

import unit.Unit;
import unit.UnitFactory;
import unit.UnitProducer;

public class CompareProducer extends UnitProducer {

	public CompareProducer(UnitFactory uf) {
		super(uf);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Unit readChar(char ch) {
		// TODO Auto-generated method stub
		
		if (firstRead) {
			if ('>' == ch || '<' == ch) {
				this.strAppend(ch);
			} else {
				this.icannotdealit = true;
				return null;
			}
		} else {
			if('=' == ch) {
				this.strAppend(ch);
				Unit unit = new Unit();
				unit.setType(Unit.COMPARE);
				unit.setContent(this.toString());
				return unit;
			} else {
				Unit unit = new Unit();
				unit.setType(Unit.COMPARE);
				unit.setContent(this.toString());
				this.retract();
				return unit;
			}
		}
		firstRead = false;
		return null;
	}

}
