package parser;

import java.util.List;

import lang.ObjectType;

public class InstantiationExpression extends ExpressionNode {

	ExpressionNode expression;
	List<ExpressionNode> args;
	
	public InstantiationExpression(ExpressionNode expression, List<ExpressionNode> args) {
		this.expression = expression;
		this.args = args;
	}
	
	@Override
	public StatementStatus execute(Context context) {
		ObjectType temp = new ObjectType();
		ObjectType[] objectArgs = new ObjectType[args.size()];
		for (int i=0; i<args.size(); i++)
			objectArgs[i] = args.get(i).evaluate(context);
		expression.evaluate(context).invoke(temp, objectArgs);
		value = temp;
		return new StatementStatus(StatementStatus.Type.Normal, null, null);
	}

}
