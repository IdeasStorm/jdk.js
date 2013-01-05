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
	public StatementStatus execute(Context context) {
		BlockContext forStatementContext = new BlockContext(context);
		if (firstExprssion != null)
			firstExprssion.execute(forStatementContext);
		if (secondExpression != null) {
			while (secondExpression.evaluate(forStatementContext).toBooleanType().toBoolean()) {
				StatementStatus statementStatus = statement.execute(forStatementContext);
				if (statementStatus.type == StatementStatus.Type.Break)
					return new StatementStatus(StatementStatus.Type.Normal, null, null);
				if (thirdExpression != null)
					thirdExpression.execute(forStatementContext);
			}
		}
		else {
			while (true) {
				StatementStatus statementStatus = statement.execute(forStatementContext);
				if (statementStatus.type == StatementStatus.Type.Break)
					return new StatementStatus(StatementStatus.Type.Normal, null, null);
				if (thirdExpression != null)
					thirdExpression.execute(forStatementContext);
			}
		}
		return new StatementStatus(StatementStatus.Type.Normal, null, null);
	}

}
