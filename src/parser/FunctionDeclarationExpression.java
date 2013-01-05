package parser;

import java.util.List;

import lang.FunctionType;

public class FunctionDeclarationExpression extends ExpressionNode {
	String functionName;
	List<String> args;
	BlockStatement statements;
	
	public FunctionDeclarationExpression(String functionName, List<String> args, 
			BlockStatement statements) {
		this.functionName = functionName;
		this.args = args;
		this.statements = statements;
	}
	
	@Override
	public StatementStatus execute(Context context) {
		String[] stringArgs = new String[args.size()];
		for(int i=0; i<args.size(); i++)
			stringArgs[i] = args.get(i);
		value = new FunctionType(functionName, stringArgs, statements, context);
		if (functionName != null)
			context._define(functionName, value);
		return new StatementStatus(StatementStatus.Type.Normal, null, null);
	}

}
