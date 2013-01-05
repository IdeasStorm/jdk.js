package parser;

public class IfStatement extends Statement {
	
	private ExpressionNode exprssion;
	private Statement ifStatement;
	private Statement elseStatement;

	public IfStatement(ExpressionNode exprssion, Statement ifStatement, 
			Statement elseStatement) {
		this.exprssion = exprssion;
		this.ifStatement = ifStatement;
		this.elseStatement = elseStatement;
	}
	
	@Override
	public StatementStatus execute(Context context) {
		// Get the boolean value of expression
		if (exprssion.evaluate(context).toBooleanType().toBoolean()) { // if value true
			Context ifStatementContext = new BlockContext(context);
			StatementStatus statementStatus = ifStatement.execute(ifStatementContext);
			if (statementStatus.type != StatementStatus.Type.Normal)
				return statementStatus;
		} else { // if the value false
			if (elseStatement != null) {
				Context elseStatmentContext = new BlockContext(context);
				StatementStatus statementStatus = elseStatement.execute(elseStatmentContext);
				if (statementStatus.type != StatementStatus.Type.Normal)
					return statementStatus;
			}
		}
		return new StatementStatus(StatementStatus.Type.Normal, null, null);
	}

}
