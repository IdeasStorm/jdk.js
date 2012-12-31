package parser;

import lang.ObjectType;

public abstract class Context {
	protected Context parent;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public final void defineVariable(String name, ObjectType value) {
		if (_define(name, value) == ObjectType.undefined) {
			parent.defineVariable(name,value);
		}
	}
	public abstract void defineVariable(String name);
	public abstract ObjectType getVariable(String name);
	public abstract ObjectType getThisValue();
	
	public abstract ObjectType _define(String name, ObjectType value);
	public abstract ObjectType _get(String name);
	
}
