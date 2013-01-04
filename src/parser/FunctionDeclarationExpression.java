package parser;

import lang.FunctionType;

public class FunctionDeclarationExpression extends ExpressionNode {
	String functionName;
	String[] args;
	BlockStatement statements;
	
	public FunctionDeclarationExpression(String functionName, String[] args, 
			BlockStatement statements) {
		this.functionName = functionName;
		this.args = args;
		this.statements = statements;
	}
	
	@Override
	public Trilogy execute(Context context) {
		value = new FunctionType(functionName, args, statements, context);
		if (functionName != null)
			context._define(functionName, value);
		return new Trilogy(Trilogy.Type.Normal, null, null);
	}

}
