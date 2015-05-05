package unit;


public abstract class UnitProducer {

	private StringBuffer strB;
	protected boolean firstRead = true;
	private UnitProducer next;
	private UnitProducer pro;
	protected boolean icannotdealit = false;
	
	private UnitFactory unitFactory;
	
	
	/**
	 * for retract
	 * @param uf
	 */
	public UnitProducer(UnitFactory uf) {
		this.unitFactory = uf;
	}
	
	//the order means priority
	public  Unit getUnit(char ch) {
		
		Unit unit = null;
		if (!icannotdealit) 
			unit = readChar(ch);
		if (unit == null && next != null) 
			unit = next.getUnit(ch);
		
		/**
		 * this method below will make the bottom producer run the reset function over times
		 * think about the double recursion
		 * 
		 * however it make the caller less responsible for reseting
		 * and the layer of producer is no more than 20 
		 * so I think it's worthwhile
		 * @author zheng 2015/05/03
		 */
		if (unit != null) {
			this.reset();
		}
		return unit;
	}
	
	protected abstract Unit readChar(char ch);

	public void reset() {
		if (strB != null) 
			strB = null;
		this.firstRead = true;
		this.icannotdealit = false;
		if (next != null)
			next.reset();
	}

	public void retract() {
		if (unitFactory != null)
			unitFactory.needRetract();
	}
	
	
	protected boolean is_non_alphanumeric(char ch) {
		return !is_alphanumeric(ch);
	}
	
	protected boolean is_numeric(char ch) {
		return '0' <= ch && ch <= '9';
	}
	
	protected boolean is_alphanumeric(char ch) {
		return is_numeric(ch) ||
				('a' <= ch && ch <= 'z') ||
				('A' <= ch && ch <= 'Z');
	}
	
	
	private void setPro (UnitProducer pro) {
		this.pro = pro;
	}
	
	public UnitProducer getPro () {
		return pro;
	}
	
	public void setNext(UnitProducer next) {
		this.next = next;
		next.setPro(this);
	}
	
	public boolean isGivenUp() {
		return this.icannotdealit;
	}
	
	
	protected void strAppend(char ch) {
		if (strB == null)
			strB = new StringBuffer();
		strB.append(ch);
	}
	
	protected String getString() {
		
		if (strB != null)
			return strB.toString();
		return null;
	}


}
