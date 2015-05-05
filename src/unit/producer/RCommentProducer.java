package unit.producer;

import unit.Unit;
import unit.UnitFactory;
import unit.UnitProducer;

public class RCommentProducer extends UnitProducer {

	public RCommentProducer(UnitFactory uf) {
		super(uf);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Unit readChar(char ch) {
		// TODO Auto-generated method stub
		if ('*' == ch) {
		}
		else if (!firstRead && '/' == ch) {
			Unit unit = new Unit();
			unit.setType(Unit.RCOMMENT);
			return unit;
		} 
		else {
			this.icannotdealit = true;
			return null;
		}
		firstRead = false;
		return null;
	}

}
