package lang;

import java.util.ArrayDeque;

public class ArrayType extends ObjectType {
	protected ArrayDeque<ObjectType> value;
	
	public ArrayType(ArrayDeque<ObjectType> value) {
		this.value = value;
	}
	
	@Override
	public ObjectType clone() {
		return new ArrayType((ArrayDeque<ObjectType>)value.clone());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public StringType toStringType() {
		return new StringType(value.toString());
	}
	
	// host methods
	
	public ObjectType _push(ObjectType obj) {
		value.push(obj);
		return new NumberType(value.size());
	}
	
	public ObjectType _pop() {
		return value.pop();
	}
	
	public ObjectType _length() {
		return new NumberType(value.size());
	}
	
	public ObjectType _shift() {
		return value.poll();
	}
	
	public ObjectType _unshift(ObjectType obj) {
		value.addFirst(obj);
		return new NumberType(value.size());
	}
	
	public ObjectType _foreach(ObjectType obj) {
		FunctionType function;
		if (obj instanceof FunctionType)
			function = (FunctionType) obj;
		else
			throw new RuntimeException("Object is not callable");
		for (ObjectType i : value) {
			function.invoke(undefined, i);
		}
		return undefined;
	}
	
}
