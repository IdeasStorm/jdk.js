package parser;

import lang.ObjectType;

public class Trilogy {

	public enum Type {
		Normal,
		Throw,
		Return,
		Break, 
		Continue
	}
	
	protected Type type;
	protected ObjectType value;
	protected VariableNode identifier;
	
	public Trilogy(Type type, ObjectType value, VariableNode identifier) {
		this.type = type;
		this.value = value;
		this.identifier = identifier;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public void setValue(ObjectType value) {
		this.value = value;
	}
	
	public void setIdentifier(VariableNode identifier) {
		this.identifier = identifier;
	}
	
	public Type getType() {
		return type;
	}
	
	public ObjectType getValue() {
		return value;
	}
	
	public VariableNode getIdentifier() {
		return identifier;
	}
}
