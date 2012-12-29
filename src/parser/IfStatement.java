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
	public void execute(Context context) {
		// Get the boolean value of expression
		if (exprssion.evaluate(context).toBooleanType().toBoolean()) { // if value true
			Context ifStatementContext = new BlockContext(context);
			ifStatement.execute(ifStatementContext);
		} else { // if the value false
			Context elseStatmentContext = new BlockContext(context);
			elseStatement.execute(elseStatmentContext);
		}
	}

}
