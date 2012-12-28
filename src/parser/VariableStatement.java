package parser;

import java.util.*;

public class VariableStatement extends JavaScriptNode {
	HashMap<String, ExpressionNode> variables;
	
	public VariableStatement(HashMap<String, ExpressionNode> variables) {
		this.variables = variables;
	}
	
	@Override
	public void execute(Context context) {
		// TODO Auto-generated method stub
		// for each variable in Hash
		for(String name : variables.keySet()) {
			// Add variable to context 
			context.defineVariable(name, variables.get(name).evaluate(context));
		}
	}
	

}
