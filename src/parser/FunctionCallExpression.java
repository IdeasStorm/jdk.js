package parser;

import java.util.LinkedList;
import java.util.List;
import lang.FunctionType;
import lang.ObjectType;

public class FunctionCallExpression extends ExpressionNode {
	ExpressionNode function;
	List<ExpressionNode> args;
	
	public FunctionCallExpression(ExpressionNode function, List<ExpressionNode> args) {
		this.function = function;
		this.args = args;
	}
	
	@Override
	public Trilogy execute(Context context) {
		List<ObjectType> objectArgs = new LinkedList<ObjectType>();
		for(ExpressionNode exp : args)
			objectArgs.add(exp.evaluate(context));
		ObjectType func = function.evaluate(context);
		ObjectType returnedObject = new ObjectType();
		if (func instanceof FunctionType)
			returnedObject = ((FunctionType) func).invoke(ObjectType.undefined, ((ObjectType[])objectArgs.toArray()));
		return new Trilogy(Trilogy.Type.Return, returnedObject, null);
	}
}
