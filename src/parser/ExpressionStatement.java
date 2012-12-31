package parser;

public class ExpressionStatement extends Statement {
	ExpressionNode expression;
	
	public ExpressionStatement(ExpressionNode expression) {
		this.expression = expression;
	}
	
	@Override
	public Trilogy execute(Context context) {
		expression.execute(context);
		return new Trilogy(Trilogy.Type.Normal, null, null);
	}
	
}
