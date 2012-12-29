package parser;

public class ForStatement extends Statement {
	ExpressionNode frExprssion;
	ExpressionNode sdExpression; 
	ExpressionNode thdExpression;
	Statement statement;
	
	public ForStatement(ExpressionNode frExprssion, ExpressionNode sdExpression, 
			ExpressionNode thdExpression, Statement statement) {
		this.frExprssion = frExprssion;
		this.sdExpression = sdExpression;
		this.thdExpression = thdExpression;
		this.statement = statement;
	}
	
	@Override
	public void execute(Context context) {
		BlockContext forStatementContext = new BlockContext(context); 
		frExprssion.execute(forStatementContext);
		while (sdExpression.evaluate(context).toBooleanType().toBoolean()) {
			statement.execute(forStatementContext);
			thdExpression.execute(forStatementContext);
		}
	}

}
