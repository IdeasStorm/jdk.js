package parser;

public class VariableNode extends ExpressionNode {
	protected String name;
	protected boolean isThisKeyWord = false;
	public static VariableNode thisNode;
	{
		thisNode = new VariableNode("this");
		thisNode.isThisKeyWord = true;
	}
	public VariableNode(String name) {
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
