package parser;

import java.util.List;

public class VariableExpression extends ExpressionNode {
	private List<Pair> variables;
	
	public VariableExpression(List<Pair> variables) {
		this.variables = variables;
	}
	
	@Override
	public StatementStatus execute(Context context) {
		// for each variable in Hash
		for(Pair pair : variables) {
			// Add variable to context 
			context.defineVariable(pair.getLeft(), deref(pair.getRight().evaluate(context)));
		}
		return new StatementStatus(StatementStatus.Type.Normal, null, null);
	}

}
