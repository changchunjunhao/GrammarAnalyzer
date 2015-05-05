package grammar.struct;

import java.util.ArrayList;

import unit.Unit;
import util.EwordParser;
import util.UnitParser;

public class ArithmeticExpresionStruct extends Struct {

	@Override
	protected boolean is_Clause_tag(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean is_end_tag(Unit unit) {
		// TODO Auto-generated method stub
		return UnitParser.is_arithmetic_end_tag(unit);
	}

	@Override
	public boolean accept(Unit unit) {
		// TODO Auto-generated method stub
		int type = unit.getType();
		String word = unit.getContent();
		switch(status) {
		case NONE:
			if (Unit.MINUS == type ||
				UnitParser.is_couple_arithmetic_unit(unit)) {
				this.status = EXPECT_NUM;
				this.addUnit(unit);
			} 
			else if (Unit.NUM == type ||
					EwordParser.is_name(word)) {
				this.status = EXPECT_END;
				this.addUnit(unit);
			} 
			else {
				this.giveUp();
			}
			break;
		case EXPECT_NUM:
			if (Unit.NUM == type ||
					EwordParser.is_name(word)) {
				this.status = EXPECT_END;
				this.addUnit(unit);
			}
			else {
				this.giveUp();
			}
			break;
		case EXPECT_END:
			if (this.is_end_tag(unit)) {
				return false;
			} 
			else if (UnitParser.is_couple_arithmetic_unit(unit)) {
				this.addUnit(unit);
			} 
			else if (UnitParser.is_single_arithmetic_unit(unit)) {
				this.status = EXPECT_NUM;
				this.addUnit(unit);
			}
			else {
				this.giveUp();
			}
			break;
		}
		return !isGiveUp();
	}

	@Override
	protected void reset() {
		// TODO Auto-generated method stub
		if (units != null) {
			units.clear();
		}
		this.status = NONE;
	}

	@Override
	public int add(Struct struct) {
		// TODO Auto-generated method stub
		if (struct instanceof LogicalExpresionStruct) {
			int result = struct.add(this);
			if (result == Struct.CONSUME) {
				return Struct.DECONSUME;
			}
		}
		return Struct.NO_CONSUME;
	}
	
	private void addUnit(Unit unit) {
		if (units == null) {
			units = new ArrayList<Unit>();
		}
		units.add(unit);
	}
	private static final int NONE = 1,
			EXPECT_NUM = 2,
			EXPECT_END = 3;
	private int status;
	private ArrayList<Unit> units;
}
