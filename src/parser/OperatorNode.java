package parser;

import lang.ObjectType;

public class OperatorNode extends ExpressionNode {
	protected ExpressionNode left;
	protected ExpressionNode right;
	protected OperatorType type;
	public enum OperatorType {
		Add, //+
		PostIncrement, // i++
		Subtract, // -
		PostDecrement, // i--
		PreIncrement, //++i
		PreDecrement, // --i
		Equals, // ==
		NotEquals, // !=
		Assignment, // =
		Greater, // >
		Less, // <
		GreaterOrEqual, // >=
		LessOrEqual, // <=
		Multiply, // *
		Division, // /
		AddBy, // +=
		SubtractBy, // -=
		MultiplyBy, // *= 
		DivideBy, // -=
		ModBy, // %=
		Not,// !
		Mod, // %
		INSTANCEOF, 
		In,
		And, // &&
		Or, // ||
		BitWiseAnd, // &
		BitWiseOr, // |
		BitWiseXor, //^
		BitWiseNot
	}
	
	public OperatorNode(OperatorType type, ExpressionNode left, ExpressionNode right) {
		this.type = type;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProgramContext p = new ProgramContext(null);
		//VariableNode left = new VariableNode("a");
		LiteralNode right = LiteralNode.createNumberLiteral("3.5");
		LiteralNode left = LiteralNode.createNumberLiteral("1");
		OperatorNode op = new OperatorNode(OperatorType.Add, left, right);
		System.out.println(op.evaluate(p).toStringType().toString());
	}
	
	
	public Trilogy execute(Context context) {
		// WARNING DONT dereference ON LEFT SIDE
		if (type == OperatorType.Assignment) {
			ObjectType leftVal = left.evaluate(context);
			if (isref(leftVal))
				ObjectType.operator(type,leftVal,deref(right.evaluate(context)));
			else
				throw new RuntimeException("ReferenceError: Invalid left-hand side in assignment");
			value = leftVal;
		}
		else 
			value = ObjectType.operator(type,deref(left.evaluate(context)),deref(right.evaluate(context)));
		return new Trilogy(null, null, null);
	}
	

}
