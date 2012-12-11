package parser;

import lang.JavaScriptObject;

public class Operator extends Expression {
	protected Expression left;
	protected Expression right;
	protected OperatorType type;
	public enum OperatorType {
		Add,
		Increment,
		Subtract,
		Decrement,
		Equals,
		Assignment,
		Greater,
		Less,
		GreaterOrEqual,
		LessOrEqual,
		Multiply,
		Division,
		AddBy,
		SubtractBy,
		MultiplyBy,
		DivideBy
	}
	
	public Operator(OperatorType type, Expression left, Expression right) {
		this.type = type;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Variable left = new Variable("a");
		Literal right = Literal.createFromNumberLiteral("3.5");
		Operator op = new Operator(OperatorType.Add, left, right);
	}
	
	
	public void execute(Context context) {
		value = JavaScriptObject.operator(type,left,right);
	}
	

}
