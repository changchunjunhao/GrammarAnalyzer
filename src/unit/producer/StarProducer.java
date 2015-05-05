package unit.producer;

import unit.Unit;
import unit.UnitFactory;
import unit.UnitProducer;

public class StarProducer extends UnitProducer{
	
	public StarProducer(UnitFactory uf) {
		super(uf);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Unit readChar(char ch) {
		// TODO Auto-generated method stub
		if (ch == '*') {
			Unit unit = new Unit();
			unit.setType(Unit.STAR);
			unit.setContent("BLANK");
			return unit;
		}
		
		this.icannotdealit = true;
		return null;
	}

	
	
}
