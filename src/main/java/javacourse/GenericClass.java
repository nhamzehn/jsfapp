package javacourse;

public class GenericClass<T> {
	
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public static void main(String[] args) {
		
		GenericClass<String> genericClass1 = new GenericClass<String>();
		GenericClass<Employee> genericClass2 = new GenericClass<Employee>();
		
		// genericClass.setValue(10); The method setValue(String) in the type GenericClass<String> is not applicable for the arguments (int)
		genericClass1.setValue("Generic");
		System.out.println(genericClass1.getValue());
	
		genericClass2.setValue(new Employee(1, "Ali", 1000));
		
	}

}
