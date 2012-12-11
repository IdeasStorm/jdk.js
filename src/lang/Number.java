package lang;

import parser.Operator.*;

public class Number extends JavaScriptObject {
	protected double value;
	
	public Number(String value) {
		this.value = Double.parseDouble(value.toString());
	}
	
	public Number(Double value) {
		this.value = value;
	}
	
	public Number(java.lang.String value) {
		this.value = Double.parseDouble(value);
	}
	
	public double Value() {
		return value;
	}
	
	@Override
	public JavaScriptObject operator(OperatorType type, JavaScriptObject right) {
		JavaScriptObject result = null;
		switch (type) {
		case Add:
			result = new Number(value + ((Number)right).value);
			break;
		case Subtract:
			result = new Number(value - ((Number)right).value);
			break;
		case Multiply:
			result = new Number(value * ((Number)right).value);
			break;
		case Division:
			result = new Number(value / ((Number)right).value);
			break;
		case MultiplyBy:
			this.value = value * ((Number)right).value;
			result = this;
			break;
		case DivideBy:
			this.value = value / ((Number)right).value;
			result = this;
			break;
		case AddBy:
			this.value = value + ((Number)right).value;
			result = this;
			break;
		case SubtractBy:
			this.value = value - ((Number)right).value;
			result = this;
			break;
			
			
		default:
			break;
		}
		return result;
	}

	@Override
	public JavaScriptObject operator(OperatorType type) {
		//TODO add post and pre inc operators
		JavaScriptObject result = null;
		switch (type) {
		case Increment:
			this.value++;
			result = this;
			break;
		case Decrement:
			this.value--;
			result = this;
			break;
		
		default:
			break;
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
