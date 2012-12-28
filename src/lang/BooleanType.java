package lang;

public class BooleanType extends ObjectType {
	protected boolean value;
	
	public BooleanType(String value) {
		this.value = Boolean.parseBoolean(value);
	}
	
	@Override
	public StringType toStringType() {
		// TODO Auto-generated method stub
		return new StringType(Boolean.toString(value));
	}
	
	//TODO override operators
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
