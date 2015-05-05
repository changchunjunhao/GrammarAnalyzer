package unit.producer;

import unit.Unit;
import unit.UnitFactory;
import unit.UnitProducer;

public class OtherProducer extends UnitProducer{

	public OtherProducer(UnitFactory uf) {
		super(uf);
		// TODO Auto-generated constructor stub
	}

	/**
	 * this will output when every one is "i cannot deal it"
	 */
	@Override
	protected Unit readChar(char ch) {
		// TODO Auto-generated method stub
		this.strAppend(ch);
		UnitProducer current = this.getPro();
		while(current != null) {
			if (!current.isGivenUp()) {
				return null;
			}
			current = current.getPro();
		}
		Unit unit = new Unit();
		unit.setType(Unit.OTHER);
		unit.setContent(this.getString());
		return unit;
	}

}
