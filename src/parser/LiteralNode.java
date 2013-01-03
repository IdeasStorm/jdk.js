package parser;

import lang.*;

public class LiteralNode extends ExpressionNode {

	protected LiteralNode(ObjectType obj) {
		this.value = obj;
	}
	
	@Override
	public Trilogy execute(Context context) {
		// nothing to do
		return new Trilogy(null, null, null);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static LiteralNode createNumberLiteral(String image) {
		return new LiteralNode(new NumberType(image));
	}
	
	public static LiteralNode createStringLiteral(String image) {
		return new LiteralNode(new lang.StringType(image));
	}
	
	public static LiteralNode createBooleanLiteral(String image) {
		return new LiteralNode(new lang.BooleanType(image));
	}
	
	public static LiteralNode createNullLiteral() {
		return new LiteralNode(ObjectType.nullRef);
	}
	
	public static LiteralNode createUndefinedLiteral() {
		return new LiteralNode(ObjectType.undefined);
	}
}
