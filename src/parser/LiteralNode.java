package parser;

import lang.ObjectType;
import lang.NumberType;

public class LiteralNode extends ExpressionNode {

	public LiteralNode(ObjectType obj) {
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
	
	public static LiteralNode createFromNumberLiteral(String image) {
		return new LiteralNode(new NumberType(image));
	}
	
	public static LiteralNode createFromStringLiteral(String image) {
		return new LiteralNode(new lang.StringType(image));
	}
}
