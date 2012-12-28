package parser;

public class VariableNode extends ExpressionNode {
	protected String name;
	protected boolean isThisKeyWord = false;
	public static VariableNode thisNode = new VariableNode("this");

	public VariableNode(String name) {
		if (name.equals("this"))
			this.isThisKeyWord = true;
		this.name = name;
	}
	
	
	@Override
	public void execute(Context context) {
		if (!isThisKeyWord)
			value = context.getVariable(name);
		else
			value = context.getThisValue();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
