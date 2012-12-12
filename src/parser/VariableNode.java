package parser;

public class VariableNode extends ExpressionNode {
	protected String name;
	public VariableNode(String name) {
		this.name = name;
	}
	
	@Override
	public void execute(Context context) {
		value = context.getVariable(name);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
