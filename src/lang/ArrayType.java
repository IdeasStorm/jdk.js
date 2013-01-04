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
	
	
	@Override
	public ObjectType getProperty(ObjectType name) {
		if (name instanceof NumberType) {
			return _get((NumberType) name);
		}
		else {
			return super.getProperty(name.toStringType().toString());
		}
	}
	
	@Override
	public void setProperty(ObjectType name, ObjectType value) {
		if (name instanceof NumberType) {
			_set((NumberType) name,value);
		}
		else {
			super.setProperty(name, value);
		}
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
	
	public ObjectType _get(NumberType i) {
		int index = 0 ,ii = i.toInt();
		if (ii < 0 || ii >= value.size())
			throw new IndexOutOfBoundsException();
		for (ObjectType v : value) {
			if (index == ii)
				return v;
		}
		return undefined;
	}
	
	private void _set(NumberType name, ObjectType value) {
		// TODO Auto-generated method stub
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
