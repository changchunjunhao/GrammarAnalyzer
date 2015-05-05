package grammar.struct;

import unit.Unit;
import util.EwordParser;

public class PackageStruct extends Struct {
	
	private static final int EXPECT_PACKAGE = 1,
			EXPECT_NAME = 2,
			EXPECT_SEMICOLON = 3;
	private int status = EXPECT_PACKAGE;
	private Node head;
	private Node currentNode;
	@Override
	protected boolean is_Clause_tag(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean is_end_tag(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean accept(Unit unit) {
		// TODO Auto-generated method stub
		int type = unit.getType();
		if (skip(type)) {
			return true;
		}
		String word = unit.getContent();
		
		switch(status) {
		case EXPECT_PACKAGE:
			if (Unit.EWORD == type &&
					EwordParser.is_package(word)) {
				this.status = EXPECT_NAME;
				head = null;
			} else {
				giveUp();
			}
			break;
		case EXPECT_NAME:
			if (Unit.EWORD == type && 
					(EwordParser.is_name(word)||EwordParser.is_class_type(word))) {
				this.status = EXPECT_SEMICOLON;
				Node node = new Node();
				node.content = word;
				if (head == null) {
					head = node;
					currentNode = node;
				} else {
					currentNode.next = node;
					currentNode = node;
				}
			}else {
				giveUp();
			}
			break;
		case EXPECT_SEMICOLON:
			if (Unit.SEMICOLON == type) {
				this.isCompleted = true;
			} else if (Unit.DOT == type) {
				this.status = EXPECT_NAME;
			} else {
				giveUp();
			}
			break;
		default:
			giveUp();
		}
		
		return !isGiveUp();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.status = EXPECT_PACKAGE;
		this.head = null;
		this.currentNode = null;
	}

	@Override
	public int add(Struct struct) {
		// TODO Auto-generated method stub
		return Struct.NO_CONSUME;
	}

}

class Node {
	public Node next;
	public String content;
}
