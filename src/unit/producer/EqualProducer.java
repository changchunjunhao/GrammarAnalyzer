package unit.producer;

import unit.Unit;
import unit.UnitFactory;
import unit.UnitProducer;

public class EqualProducer extends UnitProducer {

	public EqualProducer(UnitFactory uf) {
		super(uf);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Unit readChar(char ch) {
		// TODO Auto-generated method stub
		
		if (!firstRead && '=' != ch) {
			Unit unit = new Unit();
			unit.setType(Unit.EQUAL);
			this.retract();
			return unit;
		}
		else if (firstRead && ch == '=') {
			
		} 
		else if (!firstRead && ch == '=') {
			Unit unit = new Unit();
			unit.setType(Unit.EQUALS);
			return unit;
		}
		else 
			this.icannotdealit = true;
		
		firstRead = false;
		return null;
	}


}
