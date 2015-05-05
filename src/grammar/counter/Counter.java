package grammar.counter;
import unit.Unit;


public abstract class Counter {
	
	private int count = 0;
	
	public abstract void count(Unit unit);
	
	public void add1() {
		count ++;
	}
	
	public int getCount() {
		return count;
	}
}
