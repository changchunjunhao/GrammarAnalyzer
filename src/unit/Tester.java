package unit;

import java.io.*;
import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) throws IOException {
		
		UnitFactory factory = new UnitFactory();
		InputStream in = new FileInputStream("test.java");
		ArrayList<Unit> list = factory.getUnitList(in);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			Unit unit = list.get(i);
			System.out.printf("%s",unit.symbol());
			if (Unit.LINE == unit.getType()) {
				System.out.println();
			} else if (Unit.EWORD == unit.getType() ||
					Unit.CHAR == unit.getType()) {
				System.out.printf("(%s) ", unit.getContent());
			} else 
				System.out.print(" ");
		}
		System.out.println("-------------------");
		System.out.println("done");
		System.out.printf("size is %d\n", size);
	}
}
