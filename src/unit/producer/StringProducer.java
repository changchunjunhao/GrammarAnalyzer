package unit.producer;

import unit.Unit;
import unit.UnitFactory;
import unit.UnitProducer;

public class StringProducer extends UnitProducer{

	public StringProducer(UnitFactory uf) {
		super(uf);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Unit readChar(char ch) {
		// TODO Auto-generated method stub
		if (ch == '"') {
			this.strAppend(ch);
			if (!firstRead) {
				Unit unit = new Unit();
				unit.setType(Unit.STRING);
				unit.setContent(this.getString());
				return unit;
			}
		} else if (!firstRead) {
			this.strAppend(ch);
		} else {
			this.icannotdealit = true;
			return null;
		}

		firstRead = false;
		return null;
	}

	
}
