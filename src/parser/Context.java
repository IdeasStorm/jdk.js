package parser;

import java.util.HashMap;

import lang.JavaScriptObject;

public abstract class Context {
	protected Context parent;
	protected HashMap<String, JavaScriptObject> variables;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public abstract void defineVariable(String name, JavaScriptObject value);
	public abstract void defineVariable(String name);
	public abstract JavaScriptObject getVariable(String name);
	public abstract JavaScriptObject getThisValue();
	
}
