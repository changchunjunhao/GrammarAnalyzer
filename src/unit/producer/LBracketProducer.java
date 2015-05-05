package unit.producer;

import unit.Unit;
import unit.UnitFactory;
import unit.UnitProducer;

public class LBracketProducer extends UnitProducer {

	public LBracketProducer(UnitFactory uf) {
		super(uf);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Unit readChar(char ch) {
		// TODO Auto-generated method stub
		if (ch == '(') {
			Unit unit = new Unit();
			unit.setType(Unit.LBRACKET);
			unit.setContent("LBRACKET");
			return unit;
		}
		this.icannotdealit = true;
		return null;
	}

}
