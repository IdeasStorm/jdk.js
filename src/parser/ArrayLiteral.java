package parser;

import java.util.ArrayDeque;
import java.util.List;

import lang.ArrayType;
import lang.ObjectType;

public class ArrayLiteral extends ExpressionNode {
	List<ExpressionNode> expressions;
	
	public ArrayLiteral(List<ExpressionNode> expressions) {
		this.expressions = expressions;
	}
	
	@Override
	public Trilogy execute(Context context) {
		ArrayType objects = new ArrayType();
		for(ExpressionNode exp : expressions)
			objects._push(exp.evaluate(context));
		value = objects;
		return null;
	}

}
