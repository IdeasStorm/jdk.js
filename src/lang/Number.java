package lang;

import parser.Operator.*;

public class Number extends JavaScriptObject {
	protected double value;
	
	public Number(String value) {
		this.value = Double.parseDouble(value);
	}
	
	public Number(Double value) {
		this.value = value;
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
		default:
			break;
		}
		return result;
	}

	@Override
	public JavaScriptObject operator(OperatorType type) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
