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
	public Trilogy execute(Context context) {
		// Get the boolean value of expression
		if (exprssion.evaluate(context).toBooleanType().toBoolean()) { // if value true
			Context ifStatementContext = new BlockContext(context);
			Trilogy trilogy = ifStatement.execute(ifStatementContext);
			if (trilogy.type != Trilogy.Type.Normal)
				return trilogy;
		} else { // if the value false
			if (elseStatement != null) {
				Context elseStatmentContext = new BlockContext(context);
				Trilogy trilogy = elseStatement.execute(elseStatmentContext);
				if (trilogy.type != Trilogy.Type.Normal)
					return trilogy;
			}
		}
		return new Trilogy(Trilogy.Type.Normal, null, null);
	}

}
