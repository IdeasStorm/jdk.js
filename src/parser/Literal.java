package parser;

import lang.JavaScriptObject;
import lang.Number;

public class Literal extends Expression {

	public Literal(JavaScriptObject obj) {
		this.value = obj;
	}
	
	@Override
	public void execute(Context context) {
		// nothing to do 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Literal createFromNumberLiteral(String image) {
		return new Literal(new Number(image));
	}
	
	public static Literal createFromStringLiteral(String image) {
		return new Literal(new lang.String(image));
	}
}
