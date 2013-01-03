package parser;

import java.util.LinkedList;
import java.util.List;
import lang.FunctionType;
import lang.ObjectType;

public class FunctionCallExpression extends ExpressionNode {
	String functionName;
	List<ExpressionNode> args;
	
	public FunctionCallExpression(String fuctionName, List<ExpressionNode> args) {
		this.functionName = fuctionName;
		this.args = args;
	}
	
	@Override
	public Trilogy execute(Context context) {
		List<ObjectType> objectArgs = new LinkedList<ObjectType>();
		for(ExpressionNode exp : args)
			objectArgs.add(exp.evaluate(context));
		ObjectType returnedObject = ((FunctionType)(context._get(functionName)))
				.invoke(ObjectType.undefined, ((ObjectType[])objectArgs.toArray()));
		return new Trilogy(Trilogy.Type.Return, returnedObject, null);
	}
}
