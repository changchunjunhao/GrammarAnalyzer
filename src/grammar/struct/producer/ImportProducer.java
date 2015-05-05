package grammar.struct.producer;

import grammar.struct.ImportStruct;
import grammar.struct.Struct;

public class ImportProducer extends StructProducer {

	@Override
	protected Struct getNewStruct() {
		// TODO Auto-generated method stub
		return new ImportStruct();
	}

}
