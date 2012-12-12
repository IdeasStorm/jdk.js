package lang;

import parser.ExpressionNode;

public abstract class ObjectType {

	public static final ObjectType nullValue = null;
	//TODO add special values for null and undefined

	/**
	 * @param args
	 */
	public static void main(StringType[] args) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("rawtypes")
	public static ObjectType operator(parser.OperatorNode.OperatorType type, ExpressionNode left,
			ExpressionNode right) {
		if (right == null)
			return left.getValue().operator(type);
		else {
			Class result_class = getResultClass(left.getClass(), right.getClass());
			ObjectType left_obj = box(result_class, left.getValue());
			ObjectType right_obj = box(result_class, right.getValue());
			return left_obj.operator(type, right_obj);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static Class getResultClass(Class class1, Class class2) {
		if (class1 == StringType.class || class2 == StringType.class)
			return StringType.class;
		return class1;
	}
	
	@SuppressWarnings("rawtypes")
	public static ObjectType box(Class inst_class, ObjectType obj) {
		//TODO make this code more dynamic 
		if (inst_class.equals(obj.getClass()))
			return obj;
		if (inst_class.equals(StringType.class)) {
			return obj.toJsString();
		}else
			return obj;
	}
	
	public lang.StringType toJsString() {
		return new lang.StringType(this.toString());
	}

	public abstract ObjectType operator(parser.OperatorNode.OperatorType type, ObjectType right);
	
	public abstract ObjectType operator(parser.OperatorNode.OperatorType type);

	public void setProperty(java.lang.String name, ObjectType value) {
		// TODO Auto-generated method stub
		
	}

	public ObjectType getProperty(java.lang.String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract ObjectType clone();

}
