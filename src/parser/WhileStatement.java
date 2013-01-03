package parser;

public class WhileStatement extends Statement {
	ExpressionNode exprssion;
	Statement whileStatement;
	
	public WhileStatement(ExpressionNode exprssion, Statement whileStatement) {
		this.exprssion = exprssion;
		this.whileStatement = whileStatement;
	}
	
	@Override
	public Trilogy execute(Context context) {
		Context whileStatementContext = new BlockContext(context);
		while (exprssion.evaluate(context).toBooleanType().toBoolean()) {
			Trilogy trilogy = whileStatement.execute(whileStatementContext);
			if (trilogy.type == Trilogy.Type.Break)
				return new Trilogy(Trilogy.Type.Normal, null, null);
		}
		return new Trilogy(Trilogy.Type.Normal, null, null);		
	}

}
