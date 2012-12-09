package lang;

import parser.Expression;

public abstract class JavaScriptObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static JavaScriptObject operator(parser.Operator.OperatorType type, Expression left,
			Expression right) {
		if (right == null)
			return left.getValue().operator(type);
		else
			return left.getValue().operator(type, right);
	}
	
	public abstract JavaScriptObject operator(parser.Operator.OperatorType type, Expression right);
	
	public abstract JavaScriptObject operator(parser.Operator.OperatorType type);

}
