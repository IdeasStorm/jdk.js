package parser;

import java.util.List;
import lang.FunctionType;

public class FunctionDeclarationStatement extends Statement {
	String functionName;
	List<String> args;
	BlockStatement statements;
	
	public FunctionDeclarationStatement(String functionName, List<String> args, 
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
		context._define(functionName, new FunctionType(functionName, stringArgs, statements, context));
		return new StatementStatus(StatementStatus.Type.Normal, null, null);
	}
}
