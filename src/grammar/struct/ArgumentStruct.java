package grammar.struct;

import java.util.ArrayList;

import unit.Unit;
import util.EwordParser;


public class ArgumentStruct extends Struct {
	
	
	@Override
	protected boolean is_Clause_tag(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean is_end_tag(Unit unit) {
		// TODO Auto-generated method stub
		return Unit.RBRACKET == unit.getType();
	}

	@Override
	public boolean accept(Unit unit) {
		// TODO Auto-generated method stub
		int type = unit.getType();
		String word = unit.getContent();
		
		if (skip(type)) {
			return true;
		}
		
		switch(status) {
		case EXPECT_TYPE:
			if (Unit.EWORD == type
				&& EwordParser.is_type(word)) {
				arg = new Argument();
				arg.type = word;
				
				status = EXPECT_NAME;
			} else {
				this.giveUp();
			}
			break;
		case EXPECT_NAME:
			if (Unit.EWORD == type
				&& EwordParser.is_name(word)) {
				this.status = EXPECT_END;
				arg.name = word;
				
				if (head == null || current == null) {
					head = arg;
					current = arg;
				} else {
					current.next = arg;
					current = arg;
				}
			} else {
				this.giveUp();
			}
			break;
		case EXPECT_END:
			if (Unit.COMMA == type) {
				this.status = EXPECT_TYPE;
				arg = null;
			} else if (is_end_tag(unit)) {
				this.isCompleted = true;
				return false;
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
		head = null;
		current = null;
		arg = null;
		status = EXPECT_TYPE;
	}

	@Override
	public int add(Struct struct) {
		// TODO Auto-generated method stub
		return;
	}
	
	private Argument arg;
	private Argument head;
	private Argument current;
	
	private int status;
	private static final int EXPECT_TYPE = 1,
			EXPECT_NAME = 2,
			EXPECT_END = 3;

}

class Argument {
	public String type;
	public String name;
	
	public Argument next;
}
