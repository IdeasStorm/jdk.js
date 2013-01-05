package parser;

public class MemberExpression extends ExpressionNode {
	ExpressionNode expression;
	String propertyName;
	
	public MemberExpression(ExpressionNode expression, String propertyName) {
		this.expression = expression;
		this.propertyName = propertyName;
		
	}
	
	@Override
	public StatementStatus execute(Context context) {
		value =  expression.evaluate(context).getProperty(propertyName);
		return new StatementStatus(StatementStatus.Type.Normal, null, null);
	}
}