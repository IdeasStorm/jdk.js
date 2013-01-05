package parser;

import java.util.HashSet;
import java.util.Set;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NumberType;

import lang.BooleanType;
import lang.ObjectType;

public class OperatorNode extends ExpressionNode {
	protected ExpressionNode left;
	protected ExpressionNode right;
	protected OperatorType type;
	
	protected Set<OperatorType> numberLeftHandSet = new HashSet<OperatorType>() {{
	    add(OperatorType.PostDecrement);
	    add(OperatorType.PostIncrement);
	}};
	
	protected Set<OperatorType> numberRightHandSet = new HashSet<OperatorType>() {{
	    add(OperatorType.PreDecrement);
	    add(OperatorType.PreIncrement);
	}};
	
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
	
	public StatementStatus execute(Context context) {
		// WARNING DONT dereference ON LEFT SIDE
		if (type == OperatorType.Assignment) {
			ObjectType leftVal = left.evaluate(context);
			if (isref(leftVal))
				ObjectType.operator(type,leftVal,deref(right.evaluate(context)));
			else if ((left == null) && (right != null))
				BooleanType.operator(type, null, right.evaluate(context));
			else
				throw new RuntimeException("ReferenceError: Invalid left-hand side in assignment");
			value = leftVal;
		}
		else if (left == null) {
			value = ObjectType.operator(type, null, deref(right.evaluate(context)));
		}
		else if (right == null) {
			value = ObjectType.operator(type, deref(left.evaluate(context)), null);
		}
		else
			value = ObjectType.operator(type,deref(left.evaluate(context)),deref(right.evaluate(context)));
		return new StatementStatus(null, null, null);
	}
	

}
