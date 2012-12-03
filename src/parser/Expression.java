package parser;

import lang.JavaScriptObject;

public abstract class Expression extends JavaScriptStatement {
	protected JavaScriptObject value;
	public abstract JavaScriptObject getValue();
	
}
