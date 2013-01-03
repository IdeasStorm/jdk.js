package parser;

import lang.ObjectType;

public class ProgramContext extends Context {
	protected ObjectType globalObject;
	public ProgramContext(Context parent) {
		super(parent);
	}
	
	@Override
	public void _define(String name, ObjectType value) {
		globalObject.setProperty(name, value);
	}


	@Override
	public ObjectType _get(String name) {
		return globalObject.getProperty(name);
	}

	@Override
	public ObjectType _getThis() {
		return globalObject;
	}

	@Override
	public void _set(String name, ObjectType value) {
		globalObject.setProperty(name, value);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
