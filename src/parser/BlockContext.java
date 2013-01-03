package parser;

import lang.ObjectType;

public class BlockContext extends Context {
	protected ObjectType blockObject;
	
	public BlockContext(Context parent) {
		super(parent);
		this.blockObject = new ObjectType();
	}
	
	@Override
	public void _define(String name, ObjectType value) {
		blockObject.setProperty(name, value);
	}

	@Override
	public ObjectType _get(String name) {
		return blockObject.getProperty(name);
	}
	
	@Override
	public void _set(String name, ObjectType value) {
		blockObject.setProperty(name, value);
	}

	@Override
	public ObjectType _getThis() {
		return ObjectType.undefined;
	}

}
