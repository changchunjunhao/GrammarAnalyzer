package util;

import unit.Unit;

public class UnitParser {

	public static boolean is_couple_arithmetic_unit(Unit unit) {
		int type = unit.getType();
		return Unit.BITWISE == type ||
				Unit.PLUS == type ||
				Unit.MINUS == type ||
				Unit.STAR == type ||
				Unit.DIVIDE == type;
	}
	
	public static boolean is_single_arithmetic_unit(Unit unit) {
		int type = unit.getType();
		return Unit.PLUSS == type ||
				Unit.MINUSS == type;
	}
	
	public static boolean is_couple_logical_unit(Unit unit) {
		int type = unit.getType();
		return Unit.LOGICAL == type;
	}
	
	public static boolean is_single_logical_unit(Unit unit) {
		int type = unit.getType();
		return Unit.NOT == type;
	}
	
	public static boolean is_return_line(Unit unit) {
		int type = unit.getType();
		return Unit.LINE == type;
	}
	
	public static boolean is_arithmetic_end_tag(Unit unit) {
		int type = unit.getType();
		return Unit.SEMICOLON == type ||
				Unit.RBRACKET == type ||
				Unit.EQUAL == type;
	}

	public static boolean is_logical_clause_tag(Unit unit) {
		int type = unit.getType();
		return Unit.COMPARE == type ||
				Unit.EQUALS == type;
	}

	public static boolean is_logical_end_tag(Unit unit) {
		int type = unit.getType();
		return Unit.COMMA == type ||
				Unit.SEMICOLON == type ||
				Unit.RBRACKET == type;
	}
	
	public static boolean is_logical_word(Unit unit) {
		return false;
	}
}
