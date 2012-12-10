package lang;

import parser.Expression;

public abstract class JavaScriptObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("rawtypes")
	public static JavaScriptObject operator(parser.Operator.OperatorType type, Expression left,
			Expression right) {
		if (right == null)
			return left.getValue().operator(type);
		else {
			Class result_class = getResultClass(left.getClass(), right.getClass());
			JavaScriptObject left_obj = box(result_class, left.getValue());
			JavaScriptObject right_obj = box(result_class, right.getValue());
			return left_obj.operator(type, right_obj);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static Class getResultClass(Class class1, Class class2) {
		if (class1 == String.class || class2 == String.class)
			return String.class;
		return class1;
	}
	
	@SuppressWarnings("rawtypes")
	public static JavaScriptObject box(Class inst_class, JavaScriptObject obj) {
		//TODO make this code more dynamic 
		if (inst_class.equals(obj.getClass()))
			return obj;
		if (inst_class.equals(String.class)) {
			return obj.toJsString();
		}else
			return obj;
	}
	
	public lang.String toJsString() {
		return new lang.String(this.toString());
	}

	public abstract JavaScriptObject operator(parser.Operator.OperatorType type, JavaScriptObject right);
	
	public abstract JavaScriptObject operator(parser.Operator.OperatorType type);

}
