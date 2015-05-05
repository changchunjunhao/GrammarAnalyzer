package unit.producer;

import unit.Unit;
import unit.UnitFactory;
import unit.UnitProducer;

public class EwordProducer extends UnitProducer {

	public EwordProducer(UnitFactory uf) {
		super(uf);
		// TODO Auto-generated constructor stub
	}

	protected Unit readChar(char ch) {
		// TODO Auto-generated method stub
		
		if (is_alphanumeric(ch) || '_' == ch) {
			this.strAppend(ch);
		} else if (is_non_alphanumeric(ch) && !firstRead) {
			
			this.retract();
			Unit unit = new Unit();
			unit.setType(Unit.EWORD);
			unit.setContent(this.getString());
			return unit;
		} else {
			this.icannotdealit = true;
			return null;
		}

		firstRead = false;
		return null;
	}
	
	
}
