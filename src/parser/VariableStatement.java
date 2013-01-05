package parser;

import java.util.*;

import lang.ArrayType;
import lang.ObjectType;

public class VariableStatement extends Statement {
	private List<Pair> variables;
	
	public VariableStatement(List<Pair> variables) {
		this.variables = variables;
	}
	
	@Override
	public StatementStatus execute(Context context) {
		// for each variable in Hash
		for(Pair pair : variables) {
			// Add variable to context
			context.defineVariable(pair.getLeft(), deref(pair.getRight().evaluate(context)));
			//TODO add to left object properties from right one
			//context.getVariable(pair.getLeft()).setProperty(pair.getRight().evaluate(context));
		}
		return new StatementStatus(StatementStatus.Type.Normal, null, null);
	}
	

}
