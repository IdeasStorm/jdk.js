package parser;

public class DebugStatement extends Statement {
	ExpressionNode exp;
	
	public DebugStatement(ExpressionNode e) {
		this.exp = e;
	}
	@Override
	public StatementStatus execute(Context context) {
		if (exp !=null)
			System.out.println(exp.evaluate(context).toStringType().toString());
		return new StatementStatus(StatementStatus.Type.Normal, null, null);
	}

}
