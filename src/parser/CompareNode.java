package parser;

import lang.ObjectType;
import parser.OperatorNode.OperatorType;

public class CompareNode extends ExpressionNode {
	protected ExpressionNode left;
	protected ExpressionNode right;
	protected OperatorType type;
	
	public CompareNode(OperatorType type, ExpressionNode left, ExpressionNode right) {
		this.type = type;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public void execute(Context context) {
		value = ObjectType.operator(type, left, right);
	}

}
