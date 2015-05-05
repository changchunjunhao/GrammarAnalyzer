package grammar.struct.producer;

import unit.Unit;
import grammar.struct.DefinationStruct;
import grammar.struct.Struct;


public class DefinationProducer extends StructProducer{
	
	@Override
	protected Struct getNewStruct() {
		// TODO Auto-generated method stub
		return new DefinationStruct();
	}
	
}
