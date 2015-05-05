package grammar.struct.producer;

import unit.*;
import grammar.struct.*;
public abstract class StructProducer {

	protected Struct struct;
	
	public StructProducer() {
		renewStruct();
	}
	
	public boolean accept(Unit unit) {
		return struct.accept(unit);
	}
	
	/**
	 * 
	 * e.g.  return new DefinationStruct()
	 * 
	 */
	protected abstract Struct getNewStruct ();
	
	public Struct outputStruct() {
		return struct;
	}
	
	public void clear() {
		struct.clear();
	}

	public boolean meetEndTag(Unit unit) {
		// TODO Auto-generated method stub
		//struct must be completed
		return struct.meetEndTag(unit);
	}

	public boolean meetClause(Unit unit) {
		// TODO Auto-generated method stub
		return struct.meetClause(unit);
	}

	public boolean isCompleted() {
		// TODO Auto-generated method stub
		return struct.isCompleted();
	}

	public  void renewStruct() {
		struct = this.getNewStruct();
	}
	
	public boolean isGiveUp() {
		return struct.isGiveUp();
	}
}
