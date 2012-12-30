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
	public Trilogy execute(Context context) {
		BlockContext forStatementContext = new BlockContext(context); 
		frExprssion.execute(forStatementContext);
		while (sdExpression.evaluate(context).toBooleanType().toBoolean()) {
			Trilogy trilogy = statement.execute(forStatementContext);
			thdExpression.execute(forStatementContext);
			if (trilogy.type == Trilogy.Type.Break)
				//TODO V=stmt.value 
				return new Trilogy(Trilogy.Type.Normal, null, null);
		}
		return new Trilogy(Trilogy.Type.Normal, null, null);
	}

}
