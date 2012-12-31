package lang;

import parser.OperatorNode.*;

public class NumberType extends ObjectType {
	protected double value;
	public static final NaNType NaN = new NaNType();
	public static class NaNType extends NumberType {
		protected NaNType() {
			this.value = Double.NaN;
		}
	}
	
	private void init() {
		this.extensible = false;
	}
	
	public NumberType() {
		value = 0;
	}
	
	public NumberType(StringType value) {
		init();
		this.value = Double.parseDouble(value.toString());
	}
	
	public NumberType(Double value) {
		init();
		this.value = value;
	}
	
	public NumberType(java.lang.String value) {
		init();
		this.value = Double.parseDouble(value);
	}
	
	public NumberType(int value) {
		this.value = value;
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
	
	@Override
	public StringType toStringType() {
		return new StringType(String.format("%f", value));
	}
	
	@Override
	public BooleanType toBooleanType() {
		// TODO Auto-generated method stub
		return new BooleanType(this.value != 0);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberType a = new NumberType(2.0);
		System.out.println(a.toStringType().toString());
	}
	
}
