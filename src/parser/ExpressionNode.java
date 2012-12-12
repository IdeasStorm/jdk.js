package parser;

import lang.ObjectType;

public abstract class ExpressionNode extends JavaScriptNode {
	protected ObjectType value;
	public ObjectType getValue() {
		return value;
	}
	
	public ObjectType evaluate(Context context) {
		this.execute(context);
		return value;
	}
}
