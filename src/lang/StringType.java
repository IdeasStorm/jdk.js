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
		ObjectType result = new ObjectType();
		switch (type) {
		case Add:
			result = new StringType(this.value.concat(right.toStringType().value));
			break;
		case Equals:
			if (this.value.compareTo(right.toStringType().value) == 0)
				result = new BooleanType(true);
			else
				result = new BooleanType(false);
			break;
		case NotEquals:
			if (this.value.compareTo(right.toStringType().value) != 0)
				result = new BooleanType(true);
			else
				result = new BooleanType(false);
			break;
		case Greater:
			if (this.value.compareTo(right.toStringType().value) > 0)
				result = new BooleanType(true);
			else
				result = new BooleanType(false);
			break;
		case GreaterOrEqual:
			if (this.value.compareTo(right.toStringType().value) >= 0)
				result = new BooleanType(true);
			else
				result = new BooleanType(false);
			break;
		case Less:
			if (this.value.compareTo(right.toStringType().value) < 0)
				result = new BooleanType(true);
			else
				result = new BooleanType(false);
			break;
		case LessOrEqual:
			if (this.value.compareTo(right.toStringType().value) <= 0)
				result = new BooleanType(true);
			else
				result = new BooleanType(false);
			break;
		default:
			throw new RuntimeException("object doesn't support such operator");
		}
		return result;
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
