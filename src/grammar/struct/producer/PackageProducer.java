package grammar.struct.producer;

import grammar.struct.PackageStruct;
import grammar.struct.Struct;

public class PackageProducer extends StructProducer{

	@Override
	protected Struct getNewStruct() {
		// TODO Auto-generated method stub
		return new PackageStruct();
	}

}
