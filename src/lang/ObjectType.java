package lang;

import java.lang.reflect.Method;
import java.util.HashMap;

import parser.ExpressionNode;
import parser.OperatorNode.OperatorType;

public class ObjectType {
	protected boolean extensible = true;

	public static class Undefined extends ObjectType {

		protected Undefined() {

		}

		@Override
		public ObjectType operator(OperatorType type, ObjectType right) {
			return NumberType.NaN.operator(type, right);
		}

		@Override
		public ObjectType operator(OperatorType type) {
			return NumberType.NaN.operator(type);
		}

		@Override
		public ObjectType clone() {
			throw new RuntimeException("cannot clone undefined object");
		}

		@Override
		public StringType toStringType() {
			return new StringType("undefined");
		}

		@Override
		public BooleanType toBooleanType() {
			// TODO Auto-generated method stub
			return new BooleanType(false);
		}

	}

	public static class Null extends ObjectType {

		protected Null() {

		}

		@Override
		public ObjectType operator(OperatorType type, ObjectType right) {
			// TODO implement a real conversion
			return new NumberType(0.0).operator(type, right);
		}

		@Override
		public ObjectType operator(OperatorType type) {
			// TODO implement a real conversion
			return new NumberType(0.0).operator(type);
		}

		@Override
		public ObjectType clone() {
			throw new RuntimeException("cannot call clone of null ");
		}

		@Override
		public StringType toStringType() {
			return new StringType("null");
		}

		@Override
		public BooleanType toBooleanType() {
			// TODO Auto-generated method stub
			return new BooleanType(false);
		}

	}

	public static final ObjectType nullRef = new Null();
	public static final ObjectType undefined = new Undefined();
	// TODO add special values for null and undefined

	protected HashMap<String, ReferenceType> attributes = new HashMap<String, ReferenceType>();

	public ObjectType(String[] keys, ObjectType[] values) throws Exception {
		try {
			for (int i = 0; i < keys.length; i++) {
				if (i < values.length)
					setAttribute(keys[i], values[i]);
				else
					setAttribute(keys[i], ObjectType.undefined);
			}	
		} catch (Exception e) {
			throw new Exception("incompatible keys/values");
		}
	}
	
	public ObjectType() {
		//TODO check initialization
	}

	protected ObjectType getAttribute(String name) {
		return attributes.get(name);
	}

	protected void setAttribute(String name, ObjectType value) {
		if (!attributes.containsKey(name) && !this.extensible)
			return;
		// TODO strict mode
		if (value instanceof ReferenceType)
			value = ((ReferenceType) value).getValue();
		// TODO make better dereferencing
		attributes.put(name, new ReferenceType(name, value));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectType obj = new ObjectType();
		
		System.out.println(obj.callHostedMethod("_","toString",new StringType("s")).toString());
	}

	@SuppressWarnings("rawtypes")
	public static ObjectType operator(parser.OperatorNode.OperatorType type,
			ExpressionNode left, ExpressionNode right) {
		if (right == null)
			return left.getValue().operator(type);
		else {
			Class result_class = getResultClass(left.getClass(),
					right.getClass());
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
		// TODO make this code more dynamic
		if (inst_class.equals(obj.getClass()))
			return obj;
		if (inst_class.equals(StringType.class)) {
			return obj.toStringType();
		} else
			return obj;
	}

	// Conversions Section

	public StringType toStringType() {
		// TODO return dynamic name (if exists)
		return new StringType("[object Object]");
	}

	public BooleanType toBooleanType() {
		return new BooleanType(true);
	}

	// End of Conversions Section

	public ObjectType operator(parser.OperatorNode.OperatorType type,
			ObjectType right) {
		return this.toStringType().operator(type, right);
	}

	public ObjectType operator(parser.OperatorNode.OperatorType type, boolean prefix) {
		return this.toBooleanType().operator(type, prefix);
	}
	
	public ObjectType operator(parser.OperatorNode.OperatorType type) {
		return operator(type, false);
	}

	public void setProperty(java.lang.String name, ObjectType value) {
		setAttribute(name, value);
	}

	public ObjectType getProperty(java.lang.String name) {
		try {
			return getAttribute(name);
		} catch (Exception e) {
			return undefined;
		}
		
	}

	@SuppressWarnings("unchecked")
	public ObjectType clone() {
		ObjectType cloned = new ObjectType();
		cloned.attributes = (HashMap<String, ReferenceType>) attributes.clone();
		return cloned;
	}
	
	// methods
	
	/**
	 * calls a member function
	 * @param methodName Member Name
	 * @param args Arguments to pass
	 * @return the return value of the execution
	 */
	public ObjectType callMethod(String methodName, ObjectType... args) {
		FunctionType function;
		// getting the member
		ObjectType member = getProperty(methodName);
		//check if exists
		if (member == undefined)
			//call hosted one instead if not exist
			return callHostedMethod("_", methodName, args);
		
		// trying to cast the property to function
		try {
			function = (FunctionType) member;
		} catch (Exception e) {
			throw new RuntimeException(String.format("ReferenceType %s is not a function", methodName));
		}
		
		//calling the function
		return function.invoke(this, args);
	}
	
	/**
	 * calls a java method (using reflection)
	 * @param prefix the prefix of the wanted method (e.g _toString)
	 * @param methodName Method Name
	 * @param args Arguments
	 * @return
	 */
	protected ObjectType callHostedMethod(String prefix, String methodName, ObjectType... args) {
		try {
			Method m = this.getClass().getMethod(prefix + methodName, objectsToClasses(args));
			return (ObjectType)m.invoke(this,(Object[]) args);
		} catch (NoSuchMethodError e) {
			throw new RuntimeException(String.format("Object has no method named %s", methodName));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("rawtypes")
	/**
	 * Get the class of each object as a list
	 * @param objects
	 * @return the list of classes
	 */
	public static Class[] objectsToClasses(ObjectType... objects) {
		Class[] classes = new Class[objects.length];
		
		for (int i = 0; i < classes.length; i++) {
			classes[i] = objects[i].getClass();
		}
		return classes;
	}
	
	public ObjectType _toString(StringType s) {
		return toStringType();
	}
}
