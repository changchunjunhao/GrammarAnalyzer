package unit.producer;

import unit.Unit;
import unit.UnitFactory;
import unit.UnitProducer;

public class RBracketProducer extends UnitProducer {

	public RBracketProducer(UnitFactory uf) {
		super(uf);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Unit readChar(char ch) {
		// TODO Auto-generated method stub
		if (ch == ')') {
			Unit unit = new Unit();
			unit.setType(Unit.RBRACKET);
			unit.setContent("RBRACKET");
			return unit;
		}
		this.icannotdealit = true;
		return null;
	}

}
