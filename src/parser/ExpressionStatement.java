package parser;

public class ExpressionStatement extends Statement {
	ExpressionNode expression;
	
	public ExpressionStatement(ExpressionNode expression) {
		this.expression = expression;
	}
	
	@Override
	public void execute(Context context) {
		expression.execute(context);
	}
	
}
