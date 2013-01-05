package parser;

public class WhileStatement extends Statement {
	ExpressionNode exprssion;
	Statement whileStatement;
	
	public WhileStatement(ExpressionNode exprssion, Statement whileStatement) {
		this.exprssion = exprssion;
		this.whileStatement = whileStatement;
	}
	
	@Override
	public StatementStatus execute(Context context) {
		Context whileStatementContext = new BlockContext(context);
		while (exprssion.evaluate(context).toBooleanType().toBoolean()) {
			StatementStatus statementStatus = whileStatement.execute(whileStatementContext);
			if (statementStatus.type == StatementStatus.Type.Break)
				return new StatementStatus(StatementStatus.Type.Normal, null, null);
		}
		return new StatementStatus(StatementStatus.Type.Normal, null, null);		
	}

}
