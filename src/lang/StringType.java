package lang;

import parser.OperatorNode.OperatorType;
import lang.ObjectType;

public class StringType extends ObjectType {
	protected java.lang.String value;
	
	
	public StringType(java.lang.String string) {
		this.value = string;
	}

	@Override
	public lang.ObjectType operator(OperatorType type,
			lang.ObjectType right) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public lang.ObjectType operator(OperatorType type) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(StringType[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public java.lang.String toString() {
		// TODO Auto-generated method stub
		return value;
	}
	@Override
	public BooleanType toBooleanType() {
		// TODO Auto-generated method stub
		return new BooleanType(this.value.length() == 0);
	}
	
	public ObjectType clone() {
		return new StringType(new java.lang.String(value));
	}
}
