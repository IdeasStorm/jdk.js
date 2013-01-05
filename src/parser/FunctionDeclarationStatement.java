package parser;

import lang.FunctionType;

public class FunctionDeclarationStatement extends Statement {
	String functionName;
	String[] args;
	BlockStatement statements;
	
	public FunctionDeclarationStatement(String functionName, String[] args, 
			BlockStatement statements) {
		this.functionName = functionName;
		this.args = args;
		this.statements = statements;
	}
	
	@Override
	public StatementStatus execute(Context context) {
		context._define(functionName, new FunctionType(functionName, args, statements, context));
		return new StatementStatus(StatementStatus.Type.Normal, null, null);
	}
}
