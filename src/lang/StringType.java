package lang;

import parser.OperatorNode.OperatorType;
import lang.ObjectType;

public class StringType extends ObjectType {
	protected java.lang.String value;
	
	
	public StringType(java.lang.String string) {
		this.extensible = false;
		this.value = string;
	}

	@Override
	public lang.ObjectType operator(OperatorType type,
			lang.ObjectType right) {
		if (type == OperatorType.Add)
			return new StringType(this.value.concat(right.toStringType().value));
		else
			throw new RuntimeException("object doesn't support such operator");
	}

	@Override
	public lang.ObjectType operator(OperatorType type) {
		throw new RuntimeException("ReferenceError: Invalid left-hand side expression in postfix operation");
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
	
	@Override
	public StringType toStringType() {
		// TODO Auto-generated method stub
		return this;
	}
	
	@Override
	public boolean isPrimitive() {
		return true;
	}
	
	@Override
	public NumberType toNumber() {
		return new NumberType(this);
	}
}
