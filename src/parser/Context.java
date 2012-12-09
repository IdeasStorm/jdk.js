package parser;

import lang.JavaScriptObject;

public abstract class Context {

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
