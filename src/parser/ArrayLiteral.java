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
		ArrayDeque<ObjectType> objects = new ArrayDeque<ObjectType>();
		for(ExpressionNode exp : expressions)
			objects.push(exp.evaluate(context));
		value = new ArrayType(objects);
		return null;
	}

}
