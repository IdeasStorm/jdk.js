package parser;

import lang.*;

public class LiteralNode extends ExpressionNode {

	protected LiteralNode(ObjectType obj) {
		this.value = obj;
	}
	
	@Override
	public StatementStatus execute(Context context) {
		// nothing to do
		return new StatementStatus(null, null, null);
	}

	@Override
	public ObjectType evaluate(Context context) {
		ObjectType res = super.evaluate(context);
		if (!res.isUndefined())
			return res.clone();
		else
			return res; 
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
