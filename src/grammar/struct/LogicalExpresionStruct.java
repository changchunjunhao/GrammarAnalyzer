package grammar.struct;

import unit.Unit;
import util.UnitParser;

public class LogicalExpresionStruct extends Struct {

	@Override
	protected boolean is_Clause_tag(Unit unit) {
		// TODO Auto-generated method stub
		return UnitParser.is_logical_clause_tag(unit);
	}

	@Override
	protected boolean is_end_tag(Unit unit) {
		// TODO Auto-generated method stub
		return UnitParser.is_logical_end_tag(unit);
	}

	@Override
	public boolean accept(Unit unit) {
		// TODO Auto-generated method stub
		
		int type = unit.getType();
		String word = unit.getContent();
		switch (status) {
		case NONE:
			if (UnitParser.is_logical_word(unit)) {
				this.status = EXPECT_END;
			}
			else if (this.is_Clause_tag(unit)) {
				return false;
			}
			else 
				giveUp();
			break;
		case EXPECT_NUM_OPERATOR:
			
			break;
		case EXPECT_OPERATOR:
			break;
		case EXPECT_NUM:
			break;
		case EXPECT_END:
			break;
		}
		
		return !isGiveUp();
	}

	@Override
	protected void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public int add(Struct struct) {
		// TODO Auto-generated method stub
		if (struct instanceof )
		
		return Struct.NO_CONSUME;
	}
	
	
	private static final int NONE = 1,
			EXPECT_NUM_OPERATOR = 2,
			EXPECT_OPERATOR = 3,
			EXPECT_NUM = 4,
			EXPECT_END = 5;
	private int status = NONE;
	
}
