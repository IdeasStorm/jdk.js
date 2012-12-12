package parser;

import java.util.HashMap;

import lang.ObjectType;

public abstract class Context {
	protected Context parent;
	protected HashMap<String, ObjectType> variables;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public abstract void defineVariable(String name, ObjectType value);
	public abstract void defineVariable(String name);
	public abstract ObjectType getVariable(String name);
	public abstract ObjectType getThisValue();
	
}
