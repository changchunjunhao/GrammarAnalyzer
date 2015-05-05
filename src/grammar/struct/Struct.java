package grammar.struct;
import unit.Unit;

public abstract class Struct {

	
	
	public boolean isGiveUp() {
		return is_give_up;
	}
	protected void giveUp() {
		is_give_up = true;
	}
	
	protected abstract boolean is_Clause_tag(Unit unit);
	
	protected abstract boolean is_end_tag(Unit unit);
	
	public boolean meetClause(Unit unit) {
		
		boolean temp = is_Clause_tag(unit);
		if (temp) {
			//do something here
		}
		return temp;
	}
	
	public boolean meetEndTag(Unit unit) {
		boolean temp = is_end_tag(unit);
		
		if (temp) {
			this.isCompleted = true;
		}
		return temp;
	}
	
	/**
	 * 
	 * @param unit
	 * @return true when just when this unit is part of this mode
	 */
	public abstract boolean accept(Unit unit);
	
	public void clear() {
		this.is_give_up = false;
		this.isCompleted = false;
		reset();
	}
	
	protected abstract void reset();

	public boolean isCompleted() {
		return isCompleted;
	}
	
	/**
	 * make your own store area
	 * CONSUME will happen if and only if the CONSUMER is COMPLETED!
	 * @param struct
	 * @return 1 when this add struct CONSUME
	 * 			0 when they are no ready NO_YET
	 * 			-1 when struct add this DECONSUME
	 */
	public abstract int add(Struct struct);
	
	public boolean skip(int type) {
		if (Unit.BLANK == type ||
				Unit.LINE == type)
			return true;
		return false;
	}
	
	protected boolean isCompleted = false;
	
	public static final int DEFINATION = 1,
			CLASS = 2,
			FUNCTION = 3, 
			IF_CLAUSE = 4,
			FOR_CLAUSE = 5,
			ASIGN = 6;
	
	private boolean is_give_up = false;
	
	public static final int CONSUME = 1,
			DECONSUME = -1,
			NO_CONSUME = 0;
}
