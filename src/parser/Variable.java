package parser;

public class Variable extends Expression {
	protected String name;
	public Variable(String name) {
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
