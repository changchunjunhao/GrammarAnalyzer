package grammar.struct;

import unit.Unit;
import util.EwordParser;

public class If_ClauseStruct extends Struct {

	@Override
	protected boolean is_Clause_tag(Unit unit) {
		// TODO Auto-generated method stub
		return Unit.LBRACE == unit.getType() ||
				Unit.LBRACKET == unit.getType();
	}

	@Override
	protected boolean is_end_tag(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean accept(Unit unit) {
		// TODO Auto-generated method stub
		int type = unit.getType();
		String word = unit.getContent();
		
		if (skip(type)) {
			return true;
		}
		
		switch (status) {
		case EXPECT_IF:
			if (Unit.EWORD == type && EwordParser.is_if(word)) {
				this.status = EXPECT_LBRACKET;
			} else {
				giveUp();
			}
			break;
		case EXPECT_LBRACKET:
			if (Unit.LBRACKET == type) {
				this.status = EXPECT_JUDGEMENT;
			} else {
				giveUp();
			}
			break;
		case EXPECT_JUDGEMENT:
			break;
		case EXPECT_RBRACKET:
			if (Unit.RBRACKET == type) {
				this.status = EXPECT_LBRACE;
			} else {
				giveUp();
			}
			break;
		case EXPECT_LBRACE:
			if (Unit.LBRACE == type) {
				this.status = EXPECT_RBRACE;
			} else {
				giveUp();
			}
			break;
		case EXPECT_RBRACE:
			if (Unit.RBRACE == type) {
				this.isCompleted = true;
			} else {
				giveUp();
			}
			break;
		default:
			giveUp();
		}
		return !isGiveUp();
	}

	@Override
	protected void reset() {
		// TODO Auto-generated method stub
		status = EXPECT_IF;
	}

	@Override
	public int add(Struct struct) {
		// TODO Auto-generated method stub
		if (status == EXPECT_JUDGEMENT ) {
			status = EXPECT_RBRACKET;
		}
	}
	
	private static final int EXPECT_IF = 1,
			EXPECT_LBRACKET = 2,
			EXPECT_JUDGEMENT = 3,
			EXPECT_RBRACKET = 4,
			EXPECT_LBRACE = 5,
			EXPECT_RBRACE = 6;
	private int status = EXPECT_IF;
}
