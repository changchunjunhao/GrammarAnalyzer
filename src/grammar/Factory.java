package grammar;

import java.util.ArrayList;
import java.util.Stack;

import unit.*;
import grammar.struct.Struct;
import grammar.struct.producer.*;

public class Factory {

	private Stack<Struct> stack = new Stack<Struct>();
	private ArrayList<StructProducer> list = new ArrayList<StructProducer>();
	
	public Factory() {
		StructProducer defination = new DefinationProducer();
		list.add(defination);
	}
	
	public void accept(ArrayList<Unit> uList) {
		if (uList == null) {
			return;
		}
		
		int size = uList.size();
		for (int i = 0; i < size; i++) {
			Unit unit = uList.get(i);
			boolean isdeal = accept(unit);
			if (!isdeal) {
				Struct struct = stack.pop();
				struct.accept(unit);
				delivertostack(struct);
			}
		}
	}
	
	
	/**
	 * 
	 * @param unit
	 * @return whether this unit is accepted(deal)
	 *	and the output will be done here when it is the right time
	 * 
	 */
	public boolean accept(Unit unit) {
		int size = list.size();
		boolean has_accepted = false;
		for (int i = 0; i < size; i++) {
			StructProducer producer = list.get(i);
			if (producer.isGiveUp())
				continue;
			if (producer.accept(unit)) {
				
				has_accepted = true;
			}
			
			if (producer.isCompleted() ||
				producer.meetClause(unit)) {
				
				chulu(producer);
				return true;
			}
			
			if (producer.meetEndTag(unit)) {
				chulu(producer);		
				return false;
			}
		}
		return has_accepted;
		
	}
	
	//³öÂ¯¡£¡£¡£¡£
	private void chulu(StructProducer producer) {
		Struct struct = 
				producer.outputStruct();
		delivertostack(struct);
		producer.renewStruct();
		renewProducerList();
	}
	
	private void delivertostack(Struct struct) {
		
		/*
		if (struct.isCompleted()) {
			this.stackTopAcceptIt(struct);
		} else {
			stack.push(struct);
		}
		*/
		this.stackTopAcceptIt(struct);
		
	}
	
	private boolean stackTopAcceptIt(Struct child) {
		
		/**
		Struct father = stack.pop();
		if (father == null) {
			parse_completed();
			stack.push(child);
			return;
		}
		father.add(child);
		if (father.isCompleted()) {
			stackTopAcceptIt(father);
		} else {
			stack.push(father);
		}
		**/
		
		Struct father = stack.pop();
		if (father == null) {
			stack.push(child);
			return true;
		}
		int result = father.add(child);
		switch (result) {
		case Struct.CONSUME:
			stackTopAcceptIt(father);
			return true;
		case Struct.DECONSUME:
			stackTopAcceptIt(child);
			return true;
		case Struct.NO_CONSUME:
			stack.push(child);
			return false;
		}
		
		return false;
		
	}
	
	/**
	 * please be sure of having stored before renew
	 */
	private void renewProducerList() {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			list.get(i).clear();
		}
	}
	
	private void parse_completed() {
		// notice the watcher
	}
}
