package unit.producer;

import unit.Unit;
import unit.UnitFactory;
import unit.UnitProducer;

public class CommentProducer extends UnitProducer {

	public CommentProducer(UnitFactory uf) {
		super(uf);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Unit readChar(char ch) {
		// TODO Auto-generated method stub
		if (firstRead) {
			if (ch != '/') {
				this.icannotdealit = true;
				return null;
			}
		}
		else if (ch == '/') {
			Unit unit = new Unit();
			unit.setType(Unit.COMMENT);
			return unit;
		}else {
			Unit unit = new Unit();
			unit.setType(Unit.DIVIDE);
			this.retract();
			return unit;
		}
		firstRead = false;
		return null;
	}

	
}
