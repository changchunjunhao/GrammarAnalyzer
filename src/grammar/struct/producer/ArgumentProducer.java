package grammar.struct.producer;

import grammar.struct.ArgumentStruct;
import grammar.struct.Struct;

public class ArgumentProducer extends StructProducer {

	@Override
	protected Struct getNewStruct() {
		// TODO Auto-generated method stub
		return new ArgumentStruct();
	}

}
