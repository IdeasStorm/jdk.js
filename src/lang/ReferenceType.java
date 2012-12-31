package lang;

public class ReferenceType {
	protected String name;
	protected ObjectType value;
	protected boolean writable;

	public ReferenceType(String name, ObjectType value, boolean writable) {
		this.name = name;
		this.value = value;
		this.writable = writable;
	}

	public ReferenceType(String name, ObjectType value) {
		this(name, value, true);
	}

	public String getName() {
		return name;
	}

	public ObjectType getValue() {
		return value;
	}

	static class PropertyNotWritableException extends RuntimeException {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8633011999670559344L;
		protected ReferenceType property;

		public PropertyNotWritableException(ReferenceType property) {
			this.property = property;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.format("Propery %s is not accessible",
					this.property.getName());
		}
	}

	public ObjectType get() {
		return value;
	}

	public void set(ObjectType value) {
		if (writable)
			this.value = value;
		else
			throw new PropertyNotWritableException(this);
	}
}