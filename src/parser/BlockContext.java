package parser;

import lang.ObjectType;

public class BlockContext extends Context {
	protected ObjectType blockObject;
	
	public BlockContext(Context parent) {
		this.parent = parent;
	}
	
	@Override
	public void defineVariable(String name, ObjectType value) {
		blockObject.setProperty(name, value);
	}

	@Override
	public void defineVariable(String name) {
		blockObject.setProperty(name, ObjectType.nullRef);
	}

	@Override
	public ObjectType getVariable(String name) {
		return blockObject.getProperty(name);
	}

	@Override
	public ObjectType getThisValue() {
		return blockObject;
	}

}
