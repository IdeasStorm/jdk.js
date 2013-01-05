package parser;

import lang.ObjectType;

public class ReturnStatement extends Statement {
	ExpressionNode expression;

	public ReturnStatement() {
	}
	
	public ReturnStatement(ExpressionNode expression) {
		this.expression = expression;
	}
	
	@Override
	public StatementStatus execute(Context context) {
		return new StatementStatus(StatementStatus.Type.Return, expression.evaluate(context), null);
	}

}
