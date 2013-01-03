package parser;

import java.util.*;

public class VariableStatement extends Statement {
	private List<Pair<String, ExpressionNode>> variables;
	
	public VariableStatement(List<Pair<String, ExpressionNode>> variables) {
		this.variables = variables;
	}
	
	@Override
	public Trilogy execute(Context context) {
		// for each variable in Hash
		for(Pair<String, ExpressionNode> pair : variables) {
			// Add variable to context 
			context.defineVariable(pair.getLeft(), pair.getRight().evaluate(context));
		}
		return new Trilogy(Trilogy.Type.Normal, null, null);
	}
	

}
