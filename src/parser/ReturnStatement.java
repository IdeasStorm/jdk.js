package parser;

import lang.ObjectType;

public class ReturnStatement extends Statement {
	ExpressionNode expression;

	public ReturnStatement(ExpressionNode expression) {
		this.expression = expression;
	}
	
	@Override
	public Trilogy execute(Context context) {
		//TODO return (enum.return, Object, empty)
		return new Trilogy(Trilogy.Type.Return, expression.evaluate(context), null);
	}

}
