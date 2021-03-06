package parser;

import lang.ObjectType;
import lang.ReferenceType;


public abstract class JavaScriptNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public abstract StatementStatus execute(Context context);
	
	protected final static ReferenceType cons(ObjectType obj) {
		return ReferenceType.createConstant(obj);
	}
	
	protected final static ReferenceType ref(ObjectType obj) {
		return new ReferenceType(obj);
	}
	
	protected final static ObjectType deref(ObjectType obj) {
		if (obj instanceof ReferenceType)
			return ((ReferenceType) obj).getValue();
		else
			return obj;
	}
	
	protected final static boolean isref(ObjectType obj) {
		return (obj instanceof ReferenceType);
	}
}
