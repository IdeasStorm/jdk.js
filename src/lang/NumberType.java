package lang;

import parser.OperatorNode.*;

public class NumberType extends ObjectType {
	protected double value;
	
	public NumberType(StringType value) {
		this.value = Double.parseDouble(value.toString());
	}
	
	public NumberType(Double value) {
		this.value = value;
	}
	
	public NumberType(java.lang.String value) {
		this.value = Double.parseDouble(value);
	}
	
	public double Value() {
		return value;
	}
	
	@Override
	public ObjectType operator(OperatorType type, ObjectType right) {
		ObjectType result = null;
		switch (type) {
		case Add:
			result = new NumberType(value + ((NumberType)right).value);
			break;
		case Subtract:
			result = new NumberType(value - ((NumberType)right).value);
			break;
		case Multiply:
			result = new NumberType(value * ((NumberType)right).value);
			break;
		case Division:
			result = new NumberType(value / ((NumberType)right).value);
			break;
		case MultiplyBy:
			this.value = value * ((NumberType)right).value;
			result = this;
			break;
		case DivideBy:
			this.value = value / ((NumberType)right).value;
			result = this;
			break;
		case AddBy:
			this.value = value + ((NumberType)right).value;
			result = this;
			break;
		case SubtractBy:
			this.value = value - ((NumberType)right).value;
			result = this;
			break;
			
			
		default:
			break;
		}
		return result;
	}

	@Override
	public ObjectType operator(OperatorType type) {
		//TODO add post and pre inc operators
		ObjectType result = null;
		switch (type) {
		case PreIncrement:
			this.value++;
			result = this;
			break;
		case PreDecrement:
			this.value--;
			result = this;
			break;
		case PostDecrement:
			result = this.clone();
			this.value--;
			break;
		case PostIncrement:
			result = this.clone();
			this.value++;
			break;
		
		default:
			break;
		}
		return result;
	}
	
	public ObjectType clone() {
		return new NumberType(this.value);
	}

	/**
	 * @param args
	 */
	public static void main(StringType[] args) {
		// TODO Auto-generated method stub

	}

}