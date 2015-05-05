package grammar.counter;

import unit.Unit;

public class LineCounter extends Counter {

	@Override
	public void count(Unit unit) {
		// TODO Auto-generated method stub
		if (Unit.LINE == unit.getType())
			this.add1();
	}

}
