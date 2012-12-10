package lang;

import parser.Operator.OperatorType;
import lang.JavaScriptObject;

public class String extends JavaScriptObject {
	java.lang.String value;
	
	
	
	public String(java.lang.String string) {
		this.value = string;
	}

	@Override
	public lang.JavaScriptObject operator(OperatorType type,
			lang.JavaScriptObject right) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public lang.JavaScriptObject operator(OperatorType type) {
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
