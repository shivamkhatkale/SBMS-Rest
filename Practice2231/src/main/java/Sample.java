class Animal {

	Animal() {
		System.out.println("Eating ... 1");
	}

}

class Dog extends Animal {
	Dog() {
		super();
		System.out.println("Dog is created....");
	}

}

public class Sample {

	public static void main(String[] args) {

		Dog d2 = new Dog();

	}

}
