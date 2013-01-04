package parser;

public class ForStatement extends Statement {
	ExpressionNode firstExprssion;
	ExpressionNode secondExpression; 
	ExpressionNode thirdExpression;
	Statement statement;
	
	public ForStatement(ExpressionNode frExprssion, ExpressionNode sdExpression, 
			ExpressionNode thdExpression, Statement statement) {
		this.firstExprssion = frExprssion;
		this.secondExpression = sdExpression;
		this.thirdExpression = thdExpression;
		this.statement = statement;
	}
	
	@Override
	public Trilogy execute(Context context) {
		BlockContext forStatementContext = new BlockContext(context);
		firstExprssion.execute(forStatementContext);
		while (secondExpression.evaluate(forStatementContext).toBooleanType().toBoolean()) {
			Trilogy trilogy = statement.execute(forStatementContext);
			if (trilogy.type == Trilogy.Type.Break)
				return new Trilogy(Trilogy.Type.Normal, null, null);
			thirdExpression.execute(forStatementContext);
		}
		return new Trilogy(Trilogy.Type.Normal, null, null);
	}

}
