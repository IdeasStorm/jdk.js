package parser;

import lang.ArrayType;

public class CallArrayExpression extends ExpressionNode {
	ExpressionNode name;
	ExpressionNode index;
	
	public CallArrayExpression(ExpressionNode name, ExpressionNode index) {
		this.name = name;
		this.index = index;
	}
	
	@Override
	public Trilogy execute(Context context) {
		value = deref(name.evaluate(context)).getProperty(index.evaluate(context));
		return new Trilogy(Trilogy.Type.Normal, null, null);
	}

}
