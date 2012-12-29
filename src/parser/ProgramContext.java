package parser;

import lang.ObjectType;

public class ProgramContext extends Context {
	protected ObjectType globalObject;
	public ProgramContext(Context parent) {
		this.parent = parent;
	}
	
	@Override
	public void defineVariable(String name, ObjectType value) {
		globalObject.setProperty(name, value);
	}

	@Override
	public void defineVariable(String name) {
		globalObject.setProperty(name, ObjectType.nullRef);
	}

	@Override
	public ObjectType getVariable(String name) {
		return globalObject.getProperty(name);
	}

	@Override
	public ObjectType getThisValue() {
		return globalObject;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
