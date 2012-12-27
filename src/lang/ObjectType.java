package lang;

import java.util.HashMap;

import parser.ExpressionNode;
import parser.OperatorNode.OperatorType;

public class ObjectType {
	protected boolean extensible = true;
	
	protected static class Property {
		protected String name;
		protected ObjectType value;
		protected boolean writable;

		public Property(String name, ObjectType value, boolean writable) {
			this.name = name;
			this.value = value;
			this.writable = writable;
		}
		
		public Property(String name, ObjectType value) {
			this(name,value,true);
		}
		
		public String getName() {
			return name;
		}
		
		public ObjectType getValue() {
			return value;
		}
		
		static class PropertyNotWritableException extends RuntimeException {
			/**
			 * 
			 */
			private static final long serialVersionUID = -8633011999670559344L;
			protected Property property;
			public PropertyNotWritableException(Property property) {
				this.property = property;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return String.format("Propery %s is not accessible", this.property.getName());
			}
		}
		
		public ObjectType get() {
			return value;
		}
		
		public void set(ObjectType value) {
			if (writable)
				this.value = value;
			else
				throw new PropertyNotWritableException(this);
		}
	}
	
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
		
	}
	
	public static final ObjectType nullValue = null;
	public static final ObjectType undefined = new Undefined();
	//TODO add special values for null and undefined
	
	protected HashMap<String, Property> attributes;
	
	public ObjectType getAttribute(String name) {
		return attributes.get(name).getValue();
	}
	
	public void setAttribute(String name, ObjectType value) {
		if (!attributes.containsKey(name) && ! this.extensible)
			return;
		//TODO strict mode
		attributes.put(name, new Property(name, value));
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectType obj = new ObjectType();
		
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
			return obj.toStringType();
		}else
			return obj;
	}
	
	public StringType toStringType() {
		//TODO return dynamic name (if exists) 
		return new StringType("[object Object]");
	}

	public ObjectType operator(parser.OperatorNode.OperatorType type, ObjectType right) {
		return this.toStringType().operator(type, right);
	}
	
	public ObjectType operator(parser.OperatorNode.OperatorType type) {
		throw new RuntimeException("Invalid left-hand side expression in postfix operation");
	}

	public void setProperty(java.lang.String name, ObjectType value) {
		// TODO Auto-generated method stub
		
	}

	public ObjectType getProperty(java.lang.String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public ObjectType clone() {
		ObjectType cloned = new ObjectType();
		cloned.attributes = (HashMap<String, Property>) attributes.clone();
		return cloned;
	}

}
