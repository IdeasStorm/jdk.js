package lang;

import parser.BlockStatement;
import parser.Context;
import parser.FunctionContext;
import parser.StatementStatus;
 
public class FunctionType extends ObjectType {
	protected String[] signature;
	protected String name;
	BlockStatement body;
	Context c;
	public FunctionType(String name,String[] args, BlockStatement b, Context c) {
		this.signature= args;
		this.name = name;
		this.body = b;
		this.c = c;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public ObjectType invoke(ObjectType obj, ObjectType...args) {
		StatementStatus status;
		Context functionContext = new FunctionContext(obj,new ObjectType(signature, args),c);
		status = body.execute(functionContext);
		if(status.getType() != parser.StatementStatus.Type.Normal && status.getType() != parser.StatementStatus.Type.Return)
			throw new RuntimeException("SytaxError "+ status.getType() + " statement");
		return status.getValue();			
			
	}
	
	@Override
	public StringType toStringType() {
		return new StringType(String.format("[%s Function]", this.name));
	}
	
	class ArgumentException extends RuntimeException {
		private static final long serialVersionUID = -3362984216014226874L;
		protected String message;
		public ArgumentException(String message) {
			this.message = message; 
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.format("Argument Error: %s", this.message);
		}
	}
}
