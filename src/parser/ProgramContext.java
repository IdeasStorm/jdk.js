package parser;

import lang.JavaScriptObject;

public class ProgramContext extends Context {
	protected JavaScriptObject globalObject;
	public ProgramContext(Context parent) {
		this.parent = parent;
	}
	
	@Override
	public void defineVariable(String name, JavaScriptObject value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void defineVariable(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public JavaScriptObject getVariable(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaScriptObject getThisValue() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
