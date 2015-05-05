package grammar.struct;

import java.util.ArrayList;

import unit.Unit;
import util.EwordParser;

public class DefinationStruct extends Struct{

	@Override
	public boolean accept(Unit unit) {
		// TODO Auto-generated method stub
		int type = unit.getType();
		if (skip(type)) {
			return true;
		}
		String content = unit.getContent();
		
		switch(status) {
		case EXPECT_TYPE:
			if (Unit.EWORD == type
				&& EwordParser.is_type(content)){
				this.type = content;
				this.status = EXPECT_NAME;
			} else {
				this.giveUp();
			}
			break;
		case EXPECT_NAME:
			if (Unit.EWORD == type
				&& EwordParser.is_name(content)) {
				this.status = EXPECT_EQUAL;
				var = new Variable();
				var.name = content;
			} else {
				this.giveUp();
			}
			break;
		case EXPECT_EQUAL:
			if (Unit.EQUAL == type) {
				this.status = EXPECT_VALUE;
			}
			else if (Unit.COMMA == type) {
				this.status = EXPECT_NAME;
				this.variableList.add(var);
			}
			else if (Unit.SEMICOLON == type) {
				this.variableList.add(var);
				this.isCompleted = true;
			}
			else {
				this.giveUp();
			}
			break;
		case EXPECT_VALUE:
			break;
		case EXPECT_SEMICOLON:
			if (Unit.SEMICOLON == type) {
				this.isCompleted = true;
			} 
			else if (Unit.COMMA == type) {
				this.status = EXPECT_NAME;
				this.variableList.add(var);
			} else 
				giveUp();
			break;
		default:
			giveUp();
		}
		return !isGiveUp();
	}
	
	
	@Override
	protected boolean is_Clause_tag(Unit unit) {
		// TODO Auto-generated method stub
		return Unit.EQUAL == unit.getType();
	}
	@Override
	protected boolean is_end_tag(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		if (variableList != null)
			variableList.clear();
		status = EXPECT_TYPE;
		type = null;
		var = null;
	}
	@Override
	public int add(Struct struct) {
		// TODO Auto-generated method stub
		if (struct instanceof ArithmeticExpresionStruct
				&& status == EXPECT_VALUE) {
			
			var.value = (ArithmeticExpresionStruct) struct;
			status = EXPECT_SEMICOLON;
			return Struct.CONSUME;
			
		}
		return Struct.NO_CONSUME;
	}
	
	
	

	
	public void addVariable(Variable variable) {
		if (variableList == null)
			variableList = new ArrayList<Variable>();
		variableList.add(variable);
	}
	public int size() {
		if (variableList == null)
			return 0;
		return variableList.size();
	}
	public Variable getVariable (int index) {
		if (variableList == null)
			return null;
		if (index >= 0 && index < size())
			return variableList.get(index);
		return null;
	}
	public String getType() {
		return type;
	}

	private static final int EXPECT_TYPE = 1,
			EXPECT_NAME = 2,
			EXPECT_EQUAL = 3,
			EXPECT_VALUE = 4,
			EXPECT_SEMICOLON = 5;
	private int status = EXPECT_TYPE;
	private Variable var;
	private String type;
	private ArrayList<Variable> variableList;
	
}

class Variable {
	public String name;
	public ArithmeticExpresionStruct value;
}