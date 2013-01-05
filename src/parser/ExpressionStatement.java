package parser;

public class ExpressionStatement extends Statement {
	ExpressionNode expression;
	
	public ExpressionStatement(ExpressionNode expression) {
		this.expression = expression;
	}
	
	@Override
	public StatementStatus execute(Context context) {
		return expression.execute(context);
	}
	
}
