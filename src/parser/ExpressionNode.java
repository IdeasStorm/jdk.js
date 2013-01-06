package parser;

import lang.ObjectType;

public abstract class ExpressionNode extends JavaScriptNode {
	protected ObjectType value;
	public ObjectType getValue() {
		return value;
	}
	
	public ObjectType evaluate(Context context) {
		StatementStatus status = this.execute(context);
		if (status.getType() != StatementStatus.Type.Normal)
			throw new RuntimeException("SyntaxError "+ status.getType() + " statement");
		return value;
	}
}
