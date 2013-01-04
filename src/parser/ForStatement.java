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
		if (firstExprssion != null)
			firstExprssion.execute(forStatementContext);
		if (secondExpression != null) {
			while (secondExpression.evaluate(forStatementContext).toBooleanType().toBoolean()) {
				Trilogy trilogy = statement.execute(forStatementContext);
				if (trilogy.type == Trilogy.Type.Break)
					return new Trilogy(Trilogy.Type.Normal, null, null);
				if (thirdExpression != null)
					thirdExpression.execute(forStatementContext);
			}
		}
		else {
			while (true) {
				Trilogy trilogy = statement.execute(forStatementContext);
				if (trilogy.type == Trilogy.Type.Break)
					return new Trilogy(Trilogy.Type.Normal, null, null);
				if (thirdExpression != null)
					thirdExpression.execute(forStatementContext);
			}
		}
		return new Trilogy(Trilogy.Type.Normal, null, null);
	}

}
