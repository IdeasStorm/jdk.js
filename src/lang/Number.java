package lang;

import parser.Expression;
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
	public JavaScriptObject operator(OperatorType type, Expression right) {
		
		switch (type) {
		case Add:
			return new Number(value + right.getValue().castTo(this.getClass()).Value());			
			break;

		default:
			break;
		}
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
