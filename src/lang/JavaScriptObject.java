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
			return left.getValue().operator(type, right.getValue());
	}
	
	@SuppressWarnings("rawtypes")
	public static Class getResultClass(Class class1, Class class2) {
		if (class1 == String.class || class2 == String.class)
			return String.class;
		return class1;
	}
	
	public abstract JavaScriptObject operator(parser.Operator.OperatorType type, JavaScriptObject right);
	
	public abstract JavaScriptObject operator(parser.Operator.OperatorType type);

}
