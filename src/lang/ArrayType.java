package lang;

import java.util.ArrayDeque;
import java.util.Map.Entry;

public class ArrayType extends ObjectType {
	protected int length;
	
	public ArrayType(ArrayDeque<ObjectType> value) {
		this.length = 0;
		for (ObjectType i : value) {
			_push(i);
		}
		
	}
	
	public ArrayType() {
		length = 0;	
	}

	@Override
	public ObjectType clone() {
		ArrayType cloned = (ArrayType) super.clone();
		cloned.length = this.length;
		return super.clone();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public StringType toStringType() {
		StringBuffer s = new StringBuffer();
		s.append("[");
		for (int i = 0; i < length ; i++) {
			// TODO optimize loop
			if (i != 0)
				s.append(", ");
			ObjectType item = getProperty(Integer.toString(i));
			if (!item.isUndefined())
				s.append(item.toStringType().toString());
		}
		s.append("]");
		return new StringType(s.toString());
	}
	
	
	@Override
	public void setProperty(ObjectType name, ObjectType value) {
		if (name instanceof NumberType) {
			_set((NumberType) name,value);
			updateLength(((NumberType) name).toInt());
		}
		else {
			super.setProperty(name, value);
		}
	}
	
	protected void updateLength(int index) {
		if (index > length-1)
			length = index + 1;
	}
	// host methods
	
	public ObjectType _push(ObjectType obj) {
		setProperty(Integer.toString(length), obj);
		length++;
		return new NumberType(length);
	}
	
	public ObjectType _pop() {
		ObjectType res = getProperty(Double.toString(length-1));
		if (!res.isUndefined())
			this.attributes.remove(Double.toString(length-1));
		length--;
		return res;
	}
	
	public ObjectType _length() {
		return new NumberType(length);
	}
	
	public ObjectType _shift() {
		//TODO implement shift
		throw new RuntimeException("not implemented yet");
	}
	
	public ObjectType _unshift(ObjectType obj) {
		//TODO implement unshift
		throw new RuntimeException("not implemented yet");
	}
	
	
	private void _set(NumberType indexObj, ObjectType value) {
		int index = indexObj.toInt();
		updateLength(index);
		super.setProperty(indexObj.toStringType(), value);
	}
	
	public ObjectType _foreach(ObjectType obj) {
		FunctionType function;
		if (obj instanceof FunctionType)
			function = (FunctionType) obj;
		else
			throw new RuntimeException("Object is not callable");
		for (Entry<String, ReferenceType> e : attributes.entrySet()) {
			// passing by value
			function.invoke(undefined, new StringType(e.getKey()),e.getValue().getValue());
		}
		return undefined;
	}
	
	
}
