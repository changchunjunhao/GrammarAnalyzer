package grammar.struct;

import unit.Unit;

public class ClassStruct extends Struct{

	@Override
	protected boolean is_Clause_tag(Unit unit) {
		// TODO Auto-generated method stub
		return Unit.LBRACE == unit.getType();
	}

	@Override
	protected boolean is_end_tag(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean accept(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int add(Struct struct) {
		// TODO Auto-generated method stub
		
	}

}
