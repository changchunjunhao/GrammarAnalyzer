package unit.producer;

import unit.Unit;
import unit.UnitFactory;
import unit.UnitProducer;

public class LineProducer extends UnitProducer {

	public LineProducer(UnitFactory uf) {
		super(uf);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Unit readChar(char ch) {
		// TODO Auto-generated method stub
		if (ch == '\r') {
		}
		else if (ch == '\n') {
			Unit unit = new Unit();
			unit.setType(Unit.LINE);
			unit.setContent("LINE");
			return unit;
		}
		else {
			this.icannotdealit = true;
		}
		return null;
	}

}
