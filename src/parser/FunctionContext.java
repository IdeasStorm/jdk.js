package parser;

import lang.ObjectType;

public class FunctionContext extends Context {
	protected ObjectType thisObj;
	protected ObjectType argsObj;
	
	public FunctionContext(ObjectType obj, ObjectType args, Context parent) {
		super(parent);
		this.thisObj = obj;
		this.argsObj = args;
		this.parent = parent; 
	}
	
	@Override
	public void _set(String name, ObjectType value) {
		// TODO check me
		// overriding arguments
		_define(name, value);
	}
	
	@Override
	public ObjectType _get(String name) {
		return argsObj.getProperty(name);
	}
	
	@Override
	public void _define(String name, ObjectType value) {
		throw new RuntimeException("this should not happen");
	}
	
	@Override
	public ObjectType _getThis() {
		return thisObj;
	}
}
