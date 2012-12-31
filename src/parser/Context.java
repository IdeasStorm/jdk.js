package parser;

import lang.ObjectType;

public abstract class Context {
	protected Context parent;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public final void defineVariable(String name, ObjectType value) {
		_define(name,value);
	}
	
	public final void defineVariable(String name) {
		_define(name, ObjectType.undefined);
	}
	
	public final void setVariable(String name, ObjectType value) {
		ObjectType ref = _get(name); 
		if ( ref == ObjectType.undefined)
			parent.setVariable(name, value);
		else
			_set(name, value);
	}
	
	public final ObjectType getVariable(String name) {
		ObjectType ref = _get(name);
		if (ref != ObjectType.undefined)
			return ref;
		else
			return parent.getVariable(name);
	}
	
	public final ObjectType getThisValue() {
		ObjectType ref = _getThis();
		if (ref != ObjectType.undefined)
			return ref;
		else
			return parent.getThisValue(); 
	}
	
	public abstract void _define(String name, ObjectType value);
	public abstract ObjectType _get(String name);
	public abstract void _set(String name, ObjectType value);
	public abstract ObjectType _getThis();
	
}
