package parser;

import lang.JavaScriptObject;

public class ProgramContext extends Context {
	protected JavaScriptObject globalObject;
	public ProgramContext(Context parent) {
		this.parent = parent;
	}
	
	@Override
	public void defineVariable(String name, JavaScriptObject value) {
		globalObject.setProperty(name, value);
	}

	@Override
	public void defineVariable(String name) {
		globalObject.setProperty(name, JavaScriptObject.nullValue);
	}

	@Override
	public JavaScriptObject getVariable(String name) {
		return globalObject.getProperty(name);
	}

	@Override
	public JavaScriptObject getThisValue() {
		return globalObject;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
