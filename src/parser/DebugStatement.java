package parser;

public class DebugStatement extends Statement {
	ExpressionNode exp;
	
	public DebugStatement(ExpressionNode e) {
		this.exp = e;
	}
	@Override
	public Trilogy execute(Context context) {
		System.out.println(exp.evaluate(context).toStringType().toString());
		return new Trilogy(Trilogy.Type.Normal, null, null);
	}

}
