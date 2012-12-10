package parser;

import lang.JavaScriptObject;

public abstract class Expression extends JavaScriptNode {
	protected JavaScriptObject value;
	public JavaScriptObject getValue() {
		return value;
	}
	
	public JavaScriptObject evaluate(Context context) {
		this.execute(context);
		return value;
	}
}
