package util;

import unit.Unit;

public class EwordParser {

	public static int ACCESS = 1,             //public private¡£¡£¡£
			STATIC = 2,
			NAME = 3,
			VOID = 4,
			TYPE = 5,
			CLASS = 6,
			ERROR = 7;
	
	public static int what_type(Unit unit) {
		if (unit == null || Unit.EWORD != unit.getType()) {
			return ERROR;
		}
		String word = unit.getContent();
		if (is_access(word))
			return ACCESS;
		if (is_static(word))
			return STATIC;
		if (is_void(word))
			return VOID;
		if (is_class(word))
			return CLASS;
		if (is_type(word))
			return TYPE;
		if (is_name(word))
			return NAME;
		return ERROR;
	}
	
	public static boolean is_name(String word) {
		return !is_access(word) &&
				!is_static(word) &&
				!is_void(word) &&
				!is_type(word) &&
				!is_class(word);
	}
	
	public static boolean is_access(String word) {
		return "public".equals(word) ||
				"private".equals(word) ||
				"protected".equals(word);
	}
	
	public static boolean is_static(String word) {
		return "static".equals(word);
	}
	
	public static boolean is_void(String word) {
		return "void".equals(word);
	}
	
	public static boolean is_type(String word) {
		return "int".equals(word) ||
				"double".equals(word) ||
				"boolean".equals(word) ||
				"float".equals(word) ||
				"char".equals(word) ||
				"byte".equals(word) ||
				is_class_type(word);
	}
	
	public static boolean is_class_type(String word) {
		return Character.isUpperCase(word.charAt(0));
	}
	public static boolean is_class(String word) {
		return "class".equals(word);
	}
	
	public static boolean is_package(String word) {
		return "package".equals(word);
	}
	
	public static boolean is_import(String word) {
		return "import".equals(word);
	}

	public static boolean is_if(String word) {
		return "if".equals(word);
	}
	public static boolean is_while(String word) {
		return "while".equals(word);
	}
	public static boolean is_for(String word) {
		return "for".equals(word);
	}
}
