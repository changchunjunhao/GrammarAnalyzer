package unit.producer;

import unit.Unit;
import unit.UnitFactory;
import unit.UnitProducer;

/**
 * including decimal
 * @author Administrator
 *
 */
public class NumProducer extends UnitProducer {

	public NumProducer(UnitFactory uf) {
		super(uf);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Unit readChar(char ch) {
		// TODO Auto-generated method stub
		if (is_numeric(ch)) {
			this.strAppend(ch);
		} 
		else if (!firstRead && '.' == ch) {
			this.strAppend(ch);
		}
		else if (!firstRead && is_non_alphanumeric(ch)) {
			Unit unit = new Unit();
			unit.setType(Unit.NUM);
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
