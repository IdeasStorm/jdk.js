package parser;

public class WhileStatement extends ExpressionNode {
	ExpressionNode exprssion;
	Statement whileStatement;
	
	public WhileStatement(ExpressionNode exprssion, Statement whileStatement) {
		this.exprssion = exprssion;
		this.whileStatement = whileStatement;
	}
	
	@Override
	public void execute(Context context) {
		Context whileStatementContext = new BlockContext(context);
		while (exprssion.evaluate(context).toBooleanType().toBoolean()) {
			whileStatement.execute(whileStatementContext);
		}
	}

}
