package parser;

import lang.JavaScriptObject;

public abstract class Expression extends JavaScriptNode {
	protected JavaScriptObject value;
	public abstract JavaScriptObject getValue();
	
}
