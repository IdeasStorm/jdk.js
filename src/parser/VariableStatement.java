package parser;

import java.util.*;

public class VariableStatement extends Statement {
	private HashMap<String, ExpressionNode> variables;
	
	public VariableStatement(HashMap<String, ExpressionNode> variables) {
		this.variables = variables;
	}
	
	@Override
	public Trilogy execute(Context context) {
		// TODO Auto-generated method stub
		// for each variable in Hash
		for(String name : variables.keySet()) {
			// Add variable to context 
			context.defineVariable(name, variables.get(name).evaluate(context));
		}
		return new Trilogy(Trilogy.Type.Normal, null, null);
	}
	

}
